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

import grails.test.GrailsUnitTestCase

/**
 * Visualization data director tests
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class VisualizationDataDirectorTests extends GrailsUnitTestCase {
    def visualizationDataDirector

    protected void setUp() {
        super.setUp()
        visualizationDataDirector = new VisualizationDataDirector()
    }

    protected void tearDown() {
        visualizationDataDirector = null
        super.tearDown()
    }

    void testSetVisualizationDataBuilder() {
        def googleVisualizationBuilder = new GoogleVisualizationBuilder()
        visualizationDataDirector.setVisualizationDataBuilder(googleVisualizationBuilder)
        assertEquals googleVisualizationBuilder, visualizationDataDirector.visualizationBuilder
    }

    void testConstructVisualizationData() {
        def attrs = ['callback':'testcallback', 'elementId':'piechart', 'title':'My Daily Activities', 'width':400, 'height':240, 'is3D':true, 'columns':[['string', 'Task'], ['number', 'Hours per Day']], 'data':[['Work', 11], ['Eat', 2], ['Commute', 2], ['Watch TV', 2], ['Sleep', 7]], 'select':'selectHandler']
        def googleVisualizationBuilder = new GoogleVisualizationBuilder()
        visualizationDataDirector.setVisualizationDataBuilder(googleVisualizationBuilder)
        visualizationDataDirector.constructVisualizationData(attrs, GoogleVisualization.PIE_CHART)
        assertEquals 'visualization', visualizationDataDirector.getVisualizationData().name
        assertEquals 'testcallback', visualizationDataDirector.getVisualizationData().callback
        assertEquals 'piechart', visualizationDataDirector.getVisualizationData().elementId
        assertEquals "{title: 'My Daily Activities', width: 400, height: 240, is3D: true}", visualizationDataDirector.getVisualizationData().options.toString()
        assertEquals 5, visualizationDataDirector.getVisualizationData().rows.size()
        assertEquals "['Work', 11]", visualizationDataDirector.getVisualizationData().rows.get(0).toString()
        assertEquals "['Eat', 2]", visualizationDataDirector.getVisualizationData().rows.get(1).toString()
        assertEquals "['Commute', 2]", visualizationDataDirector.getVisualizationData().rows.get(2).toString()
        assertEquals "['Watch TV', 2]", visualizationDataDirector.getVisualizationData().rows.get(3).toString()
        assertEquals "['Sleep', 7]", visualizationDataDirector.getVisualizationData().rows.get(4).toString()
        assertEquals 0, visualizationDataDirector.getVisualizationData().beforeDrawEvents.size()
        assertEquals 1, visualizationDataDirector.getVisualizationData().afterDrawEvents.size()
        assertEquals 'selectHandler', visualizationDataDirector.getVisualizationData().afterDrawEvents['select']
    }
}
