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
import org.grails.plugins.google.visualization.data.Cell

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

    void testBuildCallbackForGivenCallback() {
        googleVisualizationBuilder.createNewVisualizationData(['callback':'test'], GoogleVisualization.PIE_CHART)
        assertEquals 'test', googleVisualizationBuilder.buildCallback()
    }

    void testBuildCallbackForDefaultCallback() {
        googleVisualizationBuilder.createNewVisualizationData([], GoogleVisualization.PIE_CHART)
        assertEquals null, googleVisualizationBuilder.buildCallback()
    }

    void testBuildElementId() {
        googleVisualizationBuilder.createNewVisualizationData(['elementId':'someElementId'], GoogleVisualization.PIE_CHART)
        assertEquals 'someElementId', googleVisualizationBuilder.buildElementId()
    }

    void testBuildDynamicLoadingForValueTrue() {
        googleVisualizationBuilder.createNewVisualizationData(['dynamicLoading': true], GoogleVisualization.PIE_CHART)
        assertTrue googleVisualizationBuilder.buildDynamicLoading()
    }

    void testBuildDynamicLoadingForValueFalse() {
        googleVisualizationBuilder.createNewVisualizationData(['dynamicLoading': false], GoogleVisualization.PIE_CHART)
        assertFalse googleVisualizationBuilder.buildDynamicLoading()
    }

    void testBuildDynamicLoadingForNoSetValue() {
        googleVisualizationBuilder.createNewVisualizationData([], GoogleVisualization.PIE_CHART)
        assertFalse googleVisualizationBuilder.buildDynamicLoading()
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
        assertEquals "{title: 'My Daily Activities', width: 400, height: 240, is3D: true}", googleVisualizationBuilder.visualizationData.options.toString()
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

    void testBuildRowsForStringDataType() {
        googleVisualizationBuilder.createNewVisualizationData(['columns':[['string', 'Task'], ['number', 'Hours per Day']], 'data':[['Work', 11], [null, 2]]], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildRows()
        assertEquals 2, googleVisualizationBuilder.visualizationData.rows.size()
        assertEquals "['Work', 11]", googleVisualizationBuilder.visualizationData.rows.get(0).toString()
        assertEquals "[undefined, 2]", googleVisualizationBuilder.visualizationData.rows.get(1).toString()
    }

    void testBuildRowsForDateDataType() {
        googleVisualizationBuilder.createNewVisualizationData(['columns':[['date', 'Date'], ['number', 'Hours per Day']], 'data':[[DateUtil.createDate(2008, Calendar.MARCH, 1), 11], [null, 2]]], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildRows()
        assertEquals 2, googleVisualizationBuilder.visualizationData.rows.size()
        assertEquals "[new Date(2008, 2, 1), 11]", googleVisualizationBuilder.visualizationData.rows.get(0).toString()
        assertEquals "[undefined, 2]", googleVisualizationBuilder.visualizationData.rows.get(1).toString()
    }

    void testBuildRowsForDateDataTimeType() {
        googleVisualizationBuilder.createNewVisualizationData(['columns':[['datetime', 'DateTime'], ['number', 'Hours per Day']], 'data':[[DateUtil.createDate(2008, Calendar.MARCH, 1, 1, 2, 3, 4), 11], [null, 2]]], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildRows()
        assertEquals 2, googleVisualizationBuilder.visualizationData.rows.size()
        assertEquals "[new Date(2008, 2, 1, 1, 2, 3, 4), 11]", googleVisualizationBuilder.visualizationData.rows.get(0).toString()
        assertEquals "[undefined, 2]", googleVisualizationBuilder.visualizationData.rows.get(1).toString()
    }

    void testBuildRowsForDateTimeOfDayType() {
        googleVisualizationBuilder.createNewVisualizationData(['columns':[['timeofday', 'TimeOfDay'], ['number', 'Hours per Day']], 'data':[[DateUtil.createDate(2008, Calendar.MARCH, 1, 1, 2, 3, 4), 11], [null, 2]]], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildRows()
        assertEquals 2, googleVisualizationBuilder.visualizationData.rows.size()
        assertEquals "[[1, 2, 3, 4], 11]", googleVisualizationBuilder.visualizationData.rows.get(0).toString()
        assertEquals "[undefined, 2]", googleVisualizationBuilder.visualizationData.rows.get(1).toString()
    }

    void testRenderParamForStringDataTypeWithStringValue() {
        def renderedParam = googleVisualizationBuilder.renderParam('string', "test ' 12")
        assertEquals "'test \\' 12'", renderedParam.toString()
    }

    void testRenderParamForStringDataTypeWithIntegerValue() {
        def renderedParam = googleVisualizationBuilder.renderParam('string', 1)
        assertEquals "'1'", renderedParam.toString()
    }

    void testRenderParamForStringDataTypeWithFloatValue() {
        def renderedParam = googleVisualizationBuilder.renderParam('string', 1.1f)
        assertEquals "'1.1'", renderedParam.toString()
    }

    void testRenderParamForNumberDataTypeWithIntegerValue() {
        def renderedParam = googleVisualizationBuilder.renderParam('number', 11)
        assertEquals 11, renderedParam
    }

    void testRenderParamForBooleanDataTypeWithBooleanValue() {
        def renderedParam = googleVisualizationBuilder.renderParam('boolean', true)
        assertEquals true, renderedParam
    }

    void testRenderParamForDateDataTypeWithDateValue() {
        def renderedParam = googleVisualizationBuilder.renderParam('date', DateUtil.createDate(2008, Calendar.MARCH, 1, 1, 2, 3, 4))
        assertEquals "new Date(2008, 2, 1)", renderedParam.toString()
    }

    void testRenderParamForDateTimeDataTypeWithDateValue() {
        def renderedParam = googleVisualizationBuilder.renderParam('datetime', DateUtil.createDate(2008, Calendar.MARCH, 1, 1, 2, 3, 4))
        assertEquals "new Date(2008, 2, 1, 1, 2, 3, 4)", renderedParam.toString()
    }

    void testRenderParamForTimeOfDayDataTypeWithDateValue() {
        def renderedParam = googleVisualizationBuilder.renderParam('timeofday', DateUtil.createDate(2008, Calendar.MARCH, 1, 1, 2, 3, 4))
        assertEquals "[1, 2, 3, 4]", renderedParam.toString()
    }

    void testRenderCellValueForValueOnly() {
        def renderedCellValue = googleVisualizationBuilder.renderCellValue(GoogleVisualizationColumnType.BOOLEAN.toString(), new Cell(value: true))
        assertEquals "{v: true}", renderedCellValue.toString()
    }

    void testRenderCellValueForValueAndLabelOfTypeString() {
        def renderedCellValue = googleVisualizationBuilder.renderCellValue(GoogleVisualizationColumnType.STRING.toString(), new Cell(value: 'bla', label: 'test'))
        assertEquals "{v: 'bla', f: 'test'}", renderedCellValue.toString()
    }

    void testRenderCellValueForValueAndLabelOfTypeInteger() {
        def renderedCellValue = googleVisualizationBuilder.renderCellValue(GoogleVisualizationColumnType.STRING.toString(), new Cell(value: 'bla', label: 123))
        assertEquals "{v: 'bla', f: '123'}", renderedCellValue.toString()
    }

    void testRenderCellValueForValueLabelAndCustomValues() {
        def renderedCellValue = googleVisualizationBuilder.renderCellValue(GoogleVisualizationColumnType.NUMBER.toString(), new Cell(value: 1, label: 'hello', customValues: [style:'border: 1px solid green;', test:'hello: next;']))
        assertEquals "{v: 1, f: 'hello', p: {style: 'border: 1px solid green;', test: 'hello: next;'}}", renderedCellValue.toString()
    }

    void testBuildEvents() {
        googleVisualizationBuilder.createNewVisualizationData(['select':'selectHandler', 'ready':'readyHandler'], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildEvents()
        assertEquals 1, googleVisualizationBuilder.visualizationData.beforeDrawEvents.size()
        assertEquals 'readyHandler', googleVisualizationBuilder.visualizationData.beforeDrawEvents['ready']
        assertEquals 1, googleVisualizationBuilder.visualizationData.afterDrawEvents.size()
        assertEquals 'selectHandler', googleVisualizationBuilder.visualizationData.afterDrawEvents['select']
    }
}
