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

import spock.lang.Specification

/**
 * Visualization data director tests
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class VisualizationDataDirectorSpec extends Specification {
    VisualizationDataDirector visualizationDataDirector

    protected void setup() {
        visualizationDataDirector = new VisualizationDataDirector()
    }

    protected void cleanup() {
        visualizationDataDirector = null
    }

    void testSetVisualizationDataBuilder() {
        setup:
        def googleVisualizationBuilder = new GoogleVisualizationBuilder()
        when:
        visualizationDataDirector.setVisualizationDataBuilder(googleVisualizationBuilder)
        then:
        visualizationDataDirector.visualizationBuilder == googleVisualizationBuilder
    }

    void testConstructVisualizationData() {
        setup :
        
        def attrs = ['elementId':'piechart', 'title':'My Daily Activities', 'width':400, 'height':240, 'is3D':true, 'columns':[['string', 'Task'], ['number', 'Hours per Day']], 'data':[['Work', 11], ['Eat', 2], ['Commute', 2], ['Watch TV', 2], ['Sleep', 7]], 'select':'selectHandler']
        def googleVisualizationBuilder = new GoogleVisualizationBuilder()
        
        when:
        visualizationDataDirector.setVisualizationDataBuilder(googleVisualizationBuilder)
        visualizationDataDirector.constructVisualizationData(attrs, GoogleVisualization.PIE_CHART)
        
        then : 
        visualizationDataDirector.getVisualizationData().name == 'visualization'
        visualizationDataDirector.getVisualizationData().elementId== 'piechart'
        visualizationDataDirector.getVisualizationData().options.toString() == "{title: 'My Daily Activities', width: 400, height: 240, is3D: true}"
        visualizationDataDirector.getVisualizationData().rows.size() == 5
        visualizationDataDirector.getVisualizationData().rows.get(0).toString() == "['Work', 11]"
        visualizationDataDirector.getVisualizationData().rows.get(1).toString()=="['Eat', 2]"
        visualizationDataDirector.getVisualizationData().rows.get(2).toString()== "['Commute', 2]"
        visualizationDataDirector.getVisualizationData().rows.get(3).toString()== "['Watch TV', 2]"
        visualizationDataDirector.getVisualizationData().rows.get(4).toString() =="['Sleep', 7]"
        visualizationDataDirector.getVisualizationData().beforeDrawEvents.size() == 0
        visualizationDataDirector.getVisualizationData().afterDrawEvents.size()==1
        visualizationDataDirector.getVisualizationData().afterDrawEvents['select']== 'selectHandler'
    }
}
