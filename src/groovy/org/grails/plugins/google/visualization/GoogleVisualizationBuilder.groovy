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

import org.apache.commons.lang.StringUtils
import org.grails.plugins.google.visualization.util.ConfigOptionRendererUtil
import org.grails.plugins.google.visualization.util.DateUtil

/**
 * Google visualization builder. Takes in all passed in taglib attributes and knows how to prepare/render the data
 * for the visualization.
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class GoogleVisualizationBuilder extends VisualizationBuilder {
    final DEFAULT_NAME = 'visualization'

    @Override
    def buildName() {
        visualizationData.name = attrs.name ? attrs.name : DEFAULT_NAME
    }

    @Override
    def buildElementId() {
        visualizationData.elementId = attrs.elementId
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

    @Override
    def buildRowSize() {
        visualizationData.rowSize = attrs.data.size()
    }

    /**
     * Builds rows
     * Allowed data types are 'string', 'number', 'boolean', 'date', 'datetime' or 'timeofday'.
     *
     * @return Row data
     */
    @Override
    def buildRows() {
        def rowsData = []

        attrs.data.eachWithIndex { it, dataIndex ->
            it.toList().eachWithIndex { row, rowIndex ->
                def dataType = attrs.columns[rowIndex][0]
                def param

                if(row != null) {
                    if(dataType == GoogleVisualizationColumnType.STRING.toString().toLowerCase()) {
                        param = "'${row}'"
                    }
                    else if(dataType == GoogleVisualizationColumnType.DATE.toString().toLowerCase()) {
                        param = DateUtil.createDateJavaScriptObject(row)
                    }
                    else if(dataType == GoogleVisualizationColumnType.DATETIME.toString().toLowerCase()) {
                        param = DateUtil.createDateTimeJavaScriptObject(row)
                    }
                    else if(dataType == GoogleVisualizationColumnType.TIMEOFDAY.toString().toLowerCase()) {
                        param = DateUtil.createTimeOfDayJavaScriptObject(row)
                    }
                    else {
                        param = row
                    }
                }
                else {
                    param = 'undefined'
                }

                rowsData << "${dataIndex}, ${rowIndex}, ${param}"
            }
        }

        visualizationData.rows = rowsData
    }

    @Override
    def buildEvents() {
        def events = [:]

        attrs.each() { key, value ->
            // Attribute is a event
            if(visualizationData.visualization.events.containsKey(key)) {
                events[key] = value
            }
        }

        visualizationData.events = events
    }

    @Override
    def buildFormatters() {
        visualizationData.formatters = attrs.formatters 
    }
}