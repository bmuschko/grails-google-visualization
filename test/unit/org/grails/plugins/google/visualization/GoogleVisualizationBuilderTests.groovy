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
import org.grails.plugins.google.visualization.util.DateUtil

/**
 * Google visualization builder tests
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class GoogleVisualizationBuilderTests extends GrailsUnitTestCase {
    def googleVisualizationBuilder

    protected void setUp() {
        super.setUp()
        googleVisualizationBuilder = new GoogleVisualizationBuilder()
    }

    protected void tearDown() {
        googleVisualizationBuilder = null
        super.tearDown()
    }

    void testCreateNewVisualizationData() {
        googleVisualizationBuilder.createNewVisualizationData(['a':1, 'b': 2], GoogleVisualization.PIE_CHART)
        assertEquals 2, googleVisualizationBuilder.attrs.size()
        assertEquals 1, googleVisualizationBuilder.attrs['a']
        assertEquals 2, googleVisualizationBuilder.attrs['b']
        assertEquals GoogleVisualization.PIE_CHART, googleVisualizationBuilder.visualizationData.visualization
    }

    void testBuildNameForGivenName() {
        googleVisualizationBuilder.createNewVisualizationData(['name':'test'], GoogleVisualization.PIE_CHART)
        assertEquals 'test', googleVisualizationBuilder.buildName()
    }

    void testBuildNameForDefaultName() {
        googleVisualizationBuilder.createNewVisualizationData([], GoogleVisualization.PIE_CHART)
        assertEquals 'visualization', googleVisualizationBuilder.buildName()
    }

    void testBuildElementId() {
        googleVisualizationBuilder.createNewVisualizationData(['elementId':'someElementId'], GoogleVisualization.PIE_CHART)
        assertEquals 'someElementId', googleVisualizationBuilder.buildElementId()
    }

    void testBuildLanguageForSetLanguage() {
        googleVisualizationBuilder.createNewVisualizationData(['language':'fr'], GoogleVisualization.PIE_CHART)
        assertEquals 'fr', googleVisualizationBuilder.buildLanguage()
    }

    void testBuildLanguageNoLanguageSet() {
        googleVisualizationBuilder.createNewVisualizationData([], GoogleVisualization.PIE_CHART)
        assertNull googleVisualizationBuilder.buildLanguage()
    }

    void testBuildOptionsForNoOptions() {
        googleVisualizationBuilder.createNewVisualizationData([], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildOptions()
        assertEquals "{}", googleVisualizationBuilder.visualizationData.options
    }

    void testBuildOptionsForMultipleOptions() {
        googleVisualizationBuilder.createNewVisualizationData(['title':'My Daily Activities', 'width':400, 'height':240, 'is3D':true], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildOptions()
        assertEquals "{title: 'My Daily Activities', width: 400, height: 240, is3D: true}", googleVisualizationBuilder.visualizationData.options
    }

    void testBuildColumns() {
        googleVisualizationBuilder.createNewVisualizationData(['columns':[['string', 'Name'], ['string', 'Salary'], ['boolean', 'Full Time Employee']]], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildColumns()
        assertEquals 3, googleVisualizationBuilder.visualizationData.columns.size()
        assertEquals 'string', googleVisualizationBuilder.visualizationData.columns.get(0).get(0)
        assertEquals 'Name', googleVisualizationBuilder.visualizationData.columns.get(0).get(1)
        assertEquals 'string', googleVisualizationBuilder.visualizationData.columns.get(1).get(0)
        assertEquals 'Salary', googleVisualizationBuilder.visualizationData.columns.get(1).get(1)
        assertEquals 'boolean', googleVisualizationBuilder.visualizationData.columns.get(2).get(0)
        assertEquals 'Full Time Employee', googleVisualizationBuilder.visualizationData.columns.get(2).get(1)
    }

    void testBuildRowSize() {
        googleVisualizationBuilder.createNewVisualizationData(['data':[['Memory', 80], ['CPU', 55], ['Network', 68]]], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildRowSize()
        assertEquals 3, googleVisualizationBuilder.visualizationData.rowSize
    }

    void testBuildRowsForStringDataType() {
        googleVisualizationBuilder.createNewVisualizationData(['columns':[['string', 'Task'], ['number', 'Hours per Day']], 'data':[['Work', 11], [null, 2]]], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildRows()
        assertEquals 4, googleVisualizationBuilder.visualizationData.rows.size()
        assertEquals "0, 0, 'Work'", googleVisualizationBuilder.visualizationData.rows.get(0)
        assertEquals "0, 1, 11", googleVisualizationBuilder.visualizationData.rows.get(1)
        assertEquals "1, 0, undefined", googleVisualizationBuilder.visualizationData.rows.get(2)
        assertEquals "1, 1, 2", googleVisualizationBuilder.visualizationData.rows.get(3)
    }

    void testBuildRowsForDateDataType() {
        googleVisualizationBuilder.createNewVisualizationData(['columns':[['date', 'Date'], ['number', 'Hours per Day']], 'data':[[DateUtil.createDate(2008, Calendar.MARCH, 1), 11], [null, 2]]], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildRows()
        assertEquals 4, googleVisualizationBuilder.visualizationData.rows.size()
        assertEquals "0, 0, new Date(2008, 2, 1)", googleVisualizationBuilder.visualizationData.rows.get(0)
        assertEquals "0, 1, 11", googleVisualizationBuilder.visualizationData.rows.get(1)
        assertEquals "1, 0, undefined", googleVisualizationBuilder.visualizationData.rows.get(2)
        assertEquals "1, 1, 2", googleVisualizationBuilder.visualizationData.rows.get(3)
    }

    void testBuildRowsForDateDataTimeType() {
        googleVisualizationBuilder.createNewVisualizationData(['columns':[['datetime', 'DateTime'], ['number', 'Hours per Day']], 'data':[[DateUtil.createDate(2008, Calendar.MARCH, 1, 1, 2, 3, 4), 11], [null, 2]]], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildRows()
        assertEquals 4, googleVisualizationBuilder.visualizationData.rows.size()
        assertEquals "0, 0, new Date(2008, 2, 1, 1, 2, 3, 4)", googleVisualizationBuilder.visualizationData.rows.get(0)
        assertEquals "0, 1, 11", googleVisualizationBuilder.visualizationData.rows.get(1)
        assertEquals "1, 0, undefined", googleVisualizationBuilder.visualizationData.rows.get(2)
        assertEquals "1, 1, 2", googleVisualizationBuilder.visualizationData.rows.get(3)
    }

    void testBuildRowsForDateTimeOfDayType() {
        googleVisualizationBuilder.createNewVisualizationData(['columns':[['timeofday', 'TimeOfDay'], ['number', 'Hours per Day']], 'data':[[DateUtil.createDate(2008, Calendar.MARCH, 1, 1, 2, 3, 4), 11], [null, 2]]], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildRows()
        assertEquals 4, googleVisualizationBuilder.visualizationData.rows.size()
        assertEquals "0, 0, [1, 2, 3, 4]", googleVisualizationBuilder.visualizationData.rows.get(0)
        assertEquals "0, 1, 11", googleVisualizationBuilder.visualizationData.rows.get(1)
        assertEquals "1, 0, undefined", googleVisualizationBuilder.visualizationData.rows.get(2)
        assertEquals "1, 1, 2", googleVisualizationBuilder.visualizationData.rows.get(3)
    }

    void testBuildEvents() {
        googleVisualizationBuilder.createNewVisualizationData(['select':'selectHandler', 'ready':'readyHandler'], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildEvents()
        assertEquals 2, googleVisualizationBuilder.visualizationData.events.size()
        assertEquals 'selectHandler', googleVisualizationBuilder.visualizationData.events['select']
        assertEquals 'readyHandler', googleVisualizationBuilder.visualizationData.events['ready']
    }
}
