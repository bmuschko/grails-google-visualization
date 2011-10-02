/* Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.grails.plugins.google.visualization

import org.apache.commons.lang.StringEscapeUtils
import org.apache.commons.lang.StringUtils
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.grails.plugins.google.visualization.data.Cell
import org.grails.plugins.google.visualization.data.renderer.MapRenderer
import org.grails.plugins.google.visualization.util.ConfigOptionRendererUtil
import org.grails.plugins.google.visualization.util.DateUtil

/**
 * Google visualization builder. Takes in all passed in taglib attributes and knows how to prepare/render the data
 * for the visualization.
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class GoogleVisualizationBuilder extends VisualizationBuilder {
    static final Log log = LogFactory.getLog(GoogleVisualizationBuilder)
    final DEFAULT_NAME = 'visualization'
    final DEFAULT_VERSION = '1'

    @Override
    def buildName() {
        visualizationData.name = attrs.name ?: DEFAULT_NAME
    }

    @Override
    def buildVersion() {
        visualizationData.version = attrs.version ?: DEFAULT_VERSION
    }

    @Override
    def buildElementId() {
        visualizationData.elementId = attrs.elementId
    }

    @Override
    def buildDynamicLoading() {
        visualizationData.dynamicLoading = attrs.dynamicLoading ?: false
    }

    @Override
    def buildLanguage() {
        if(attrs.language) {
            visualizationData.language = attrs.language 
        }
    }

    @Override
    def buildOptions() {
        def visualizationOptions = []

        attrs.each() { key, value ->
            // Attribute is a configuration option
            if(visualizationData.visualization.configOptions.containsKey(key)) {
                def configOption = visualizationData.visualization.configOptions.get(key)
                def resolvedConfigOption = ConfigOptionRendererUtil.render(configOption, value)
                visualizationOptions << "${key}: ${resolvedConfigOption.value}"
            }
        }

        def visualizationOptionsString = (visualizationOptions.size() == 0) ? '{}' : "{${StringUtils.join(visualizationOptions, ', ')}}"
        visualizationData.options = visualizationOptionsString
    }

    @Override
    def buildColumns() {
        visualizationData.columns = attrs.columns
    }

    /**
     * Builds rows
     *
     * @return Row data
     */
    @Override
    def buildRows() {
        def rowsData = []

        attrs.data.eachWithIndex { it, dataIndex ->
            def rowValues = []

            it.toList().eachWithIndex { row, rowIndex ->
                def dataType = attrs.columns[rowIndex][0]
                def param

                if(row != null) {
                    // Render cell object if provided; otherwise render based on data type
                    param = (row instanceof Cell) ? renderCellValue(dataType, row) : renderParam(dataType, row)
                }
                else {
                    param = 'undefined'
                }

                rowValues << param
            }

            // Each row the same amount of row values as columns; separated by comma; in square brackets
            // Examples: ['Shoes', 10700] or ['Sports', {v: -7.3, f: '-7.3%'}]
            rowsData << "[${StringUtils.join(rowValues, ', ')}]"
        }

        visualizationData.rows = rowsData
    }

    /**
     * Renders parameter based on the provided data type.
     * Allowed data types are 'string', 'number', 'boolean', 'date', 'datetime' or 'timeofday'.
     *
     * @param dataType Data type
     * @param value Value
     * @return Rendered parameter value
     */
    def renderParam(dataType, value) {
        def param

        if(dataType == GoogleVisualizationColumnType.STRING.toString()) {
            if(value instanceof String) {
                value = StringEscapeUtils.escapeJavaScript(value)
            }
            else {
                log.warn "You are assigning a value to the data type 'string' that actually isn't of type String: ${value}"
            }

            param = "'${value}'"
        }
        else if(dataType == GoogleVisualizationColumnType.DATE.toString()) {
            param = DateUtil.createDateJavaScriptObject(value)
        }
        else if(dataType == GoogleVisualizationColumnType.DATETIME.toString()) {
            param = DateUtil.createDateTimeJavaScriptObject(value)
        }
        else if(dataType == GoogleVisualizationColumnType.TIMEOFDAY.toString()) {
            param = DateUtil.createTimeOfDayJavaScriptObject(value)
        }
        else {
            param = value
        }

        param
    }

    /**
     * Renders cell value
     *
     * @param dataType Data type
     * @param cell Cell
     * @return Rendered value
     * @see <a href="http://code.google.com/apis/visualization/documentation/reference.html#cell_object">Google Cell Object</a>
     */
    def renderCellValue(dataType, cell) {
        def cellProperties = []

        if(cell.value != null) {
            cellProperties << "v: ${renderParam(dataType, cell.value)}"
        }

        if(cell.label != null) {
            cellProperties << "f: '${StringEscapeUtils.escapeJavaScript(cell.label)}'"
        }

        if(cell.customValues != null) {
            cellProperties << "p: ${MapRenderer.instance.renderValue(cell.customValues)}"
        }

        "{${StringUtils.join(cellProperties, ', ')}}"
    }

    @Override
    def buildEvents() {
        def beforeDrawEvents = [:]
        def afterDrawEvents = [:]

        attrs.each() { key, value ->
            // Attribute is a event
            if(visualizationData.visualization.events.containsKey(key)) {
                if(key == 'ready') {
                    beforeDrawEvents[key] = value
                }
                else {
                    afterDrawEvents[key] = value
                }
            }
        }

        visualizationData.beforeDrawEvents = beforeDrawEvents
        visualizationData.afterDrawEvents = afterDrawEvents
    }

    @Override
    def buildFormatters() {
        visualizationData.formatters = attrs.formatters 
    }
}