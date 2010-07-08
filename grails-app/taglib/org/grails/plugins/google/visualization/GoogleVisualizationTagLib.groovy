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

/**
 * Taglib for rendering Google visualizations
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class GoogleVisualizationTagLib {
    static namespace = "gvisualization"
    static final PLUGIN_NAME = 'google-visualization'
    static final VISUALIZATION_JAVASCRIPT_TEMPLATE = '/visualization_javascript'
    final BASIC_ATTRIBUTES = ['name', 'elementId', 'dynamicLoading', 'language', 'columns', 'data'] as Set

    def pieChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.PIE_CHART)
    }

    def barChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.BAR_CHART)
    }

    def columnChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.COLUMN_CHART)
    }

    def areaChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.AREA_CHART)
    }

    def lineChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.LINE_CHART)
    }

    def scatterChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.SCATTER_CHART)
    }

    def gauge = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.GAUGE)
    }

    def table = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.TABLE, ['formatters'])
    }

    def map = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.MAP)
    }

    def annotatedTimeLine = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.ANNOTATED_TIME_LINE)
    }

    def orgChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.ORG_CHART)
    }

    def intensityMap = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.INTENSITY_MAP)
    }

    def geoMap = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.GEO_MAP)
    }

    def motionChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.MOTION_CHART)
    }

    def pieCoreChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.PIE_CORE_CHART)
    }

    def barCoreChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.BAR_CORE_CHART)
    }

    def columnCoreChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.COLUMN_CORE_CHART)
    }

    def areaCoreChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.AREA_CORE_CHART)
    }

    def lineCoreChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.LINE_CORE_CHART)
    }

    def scatterCoreChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.SCATTER_CORE_CHART)
    }

    def treeMap = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.TREE_MAP)
    }

    def imageAreaChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.IMAGE_AREA_CHART)
    }

    def imageBarChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.IMAGE_BAR_CHART)
    }

    def imageLineChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.IMAGE_LINE_CHART)
    }

    def imagePieChart = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.IMAGE_PIE_CHART)
    }

    def imageSparkLine = { attrs, body ->
        validateAndRender(attrs, GoogleVisualization.IMAGE_SPARK_LINE)
    }

    private validateAndRender(attrs, googleVisualization) {
        validateAttributes(attrs, googleVisualization)
        renderVisualization(attrs, googleVisualization)
    }

    private validateAndRender(attrs, googleVisualization, optionalAttributes) {
        validateAttributes(attrs, googleVisualization, optionalAttributes)
        renderVisualization(attrs, googleVisualization)
    }

    private validateAttributes(attrs, googleVisualization) {
        attrs.each { key, value ->
            if(!isValidAttribute(key, googleVisualization)) {
                throw new IllegalArgumentException(getInvalidOptionExceptionMessage(key, googleVisualization)) 
            }
        }
    }

    def validateAttributes(attrs, googleVisualization, optionalAttributes) {
        attrs.each { key, value ->
            if(!isValidAttribute(key, googleVisualization, optionalAttributes)) {
                throw new IllegalArgumentException(getInvalidOptionExceptionMessage(key, googleVisualization))
            }
        }
    }

    private isValidAttribute(key, googleVisualization) {
        def valid = true

        if(!BASIC_ATTRIBUTES.contains(key) && !googleVisualization.configOptions.containsKey(key)
               && !googleVisualization.events.containsKey(key)) {
            valid = false
        }

        valid
    }

    private isValidAttribute(key, googleVisualization, optionalAttributes) {
        isValidAttribute(key, googleVisualization) || optionalAttributes.contains(key)
    }

    private getInvalidOptionExceptionMessage(key, googleVisualization) {
        "Attribute '${key}' is not a valid option for Google Visualization '${googleVisualization.object}'!"
    }

    private renderVisualization(attrs, googleVisualization) {
        def visualizationDataDirector = new VisualizationDataDirector()
        visualizationDataDirector.setVisualizationBuilder(new GoogleVisualizationBuilder())
        visualizationDataDirector.constructVisualizationData(attrs, googleVisualization)
        def visualizationData = visualizationDataDirector.getVisualizationData()
        out << render(template: VISUALIZATION_JAVASCRIPT_TEMPLATE, model: [visualizationData: visualizationData], plugin: PLUGIN_NAME)
    }
}