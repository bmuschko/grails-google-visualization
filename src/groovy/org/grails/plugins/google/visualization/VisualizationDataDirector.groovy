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
 * Visualization data director. Hides building details.
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class VisualizationDataDirector {
    def visualizationBuilder

    def setVisualizationDataBuilder(visualizationBuilder) {
        this.visualizationBuilder = visualizationBuilder
    }

    def constructVisualizationData(attrs, visualization) {
        visualizationBuilder.createNewVisualizationData(attrs, visualization)
        visualizationBuilder.buildName()
        visualizationBuilder.buildCallback()
        visualizationBuilder.buildVersion()
        visualizationBuilder.buildElementId()
        visualizationBuilder.buildDynamicLoading()
        visualizationBuilder.buildLanguage()
        visualizationBuilder.buildOptions()
        visualizationBuilder.buildColumns()
        visualizationBuilder.buildRows()
        visualizationBuilder.buildEvents()
        visualizationBuilder.buildFormatters()
    }

    def getVisualizationData() {
        visualizationBuilder.visualizationData
    }
}