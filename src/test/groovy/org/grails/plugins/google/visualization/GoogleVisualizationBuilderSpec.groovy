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

import org.grails.plugins.google.visualization.data.Cell
import org.grails.plugins.google.visualization.util.DateUtil
import spock.lang.Specification

/**
 * Google org.grails.plugins.google.visualization builder tests
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class GoogleVisualizationBuilderSpec extends Specification {
    GoogleVisualizationBuilder googleVisualizationBuilder

    protected void setup() {
        googleVisualizationBuilder = new GoogleVisualizationBuilder()
    }

    protected void cleanup() {
        googleVisualizationBuilder = null
    }

    void testCreateNewVisualizationData() {
        when:
        googleVisualizationBuilder.createNewVisualizationData(['a': 1, 'b': 2], GoogleVisualization.PIE_CHART)

        then:
        2 == googleVisualizationBuilder.attrs.size()
        1 == googleVisualizationBuilder.attrs['a']
        2 == googleVisualizationBuilder.attrs['b']
        GoogleVisualization.PIE_CHART == googleVisualizationBuilder.visualizationData.visualization
    }

    void testBuildNameForGivenName() {
        when:
        googleVisualizationBuilder.createNewVisualizationData(['name': 'test'], GoogleVisualization.PIE_CHART)

        then:
        'test' == googleVisualizationBuilder.buildName()
    }

    void testBuildNameForDefaultName() {
        when:
        googleVisualizationBuilder.createNewVisualizationData([], GoogleVisualization.PIE_CHART)

        then:
        'org.grails.plugins.google.visualization' == googleVisualizationBuilder.buildName()
    }

    void testBuildElementId() {
        when:
        googleVisualizationBuilder.createNewVisualizationData(['elementId': 'someElementId'], GoogleVisualization.PIE_CHART)

        then:
        'someElementId' == googleVisualizationBuilder.buildElementId()
    }

    void testBuildDynamicLoadingForValueTrue() {
        when:
        googleVisualizationBuilder.createNewVisualizationData(['dynamicLoading': true], GoogleVisualization.PIE_CHART)

        then:
        googleVisualizationBuilder.buildDynamicLoading()
    }

    void testBuildDynamicLoadingForValueFalse() {
        when:
        googleVisualizationBuilder.createNewVisualizationData(['dynamicLoading': false], GoogleVisualization.PIE_CHART)

        then:
        !googleVisualizationBuilder.buildDynamicLoading()
    }

    void testBuildDynamicLoadingForNoSetValue() {
        when:
        googleVisualizationBuilder.createNewVisualizationData([], GoogleVisualization.PIE_CHART)

        then:
        !googleVisualizationBuilder.buildDynamicLoading()
    }

    void testBuildLanguageForSetLanguage() {
        when:
        googleVisualizationBuilder.createNewVisualizationData(['language': 'fr'], GoogleVisualization.PIE_CHART)

        then:
        'fr' == googleVisualizationBuilder.buildLanguage()
    }

    void testBuildLanguageNoLanguageSet() {
        when:
        googleVisualizationBuilder.createNewVisualizationData([], GoogleVisualization.PIE_CHART)

        then:
        !googleVisualizationBuilder.buildLanguage()
    }

    void testBuildOptionsForNoOptions() {
        when:
        googleVisualizationBuilder.createNewVisualizationData([], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildOptions()

        then:
        "{}" == googleVisualizationBuilder.visualizationData.options
    }

    void testBuildOptionsForMultipleOptions() {
        when:
        googleVisualizationBuilder.createNewVisualizationData(['title': 'My Daily Activities', 'width': 400, 'height': 240, 'is3D': true], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildOptions()

        then:
        "{title: 'My Daily Activities', width: 400, height: 240, is3D: true}" == googleVisualizationBuilder.visualizationData.options.toString()
    }

    void testBuildColumns() {
        when:
        googleVisualizationBuilder.createNewVisualizationData(['columns': [['string', 'Name'], ['string', 'Salary'], ['boolean', 'Full Time Employee']]], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildColumns()

        then:
        3 == googleVisualizationBuilder.visualizationData.columns.size()
        'string' == googleVisualizationBuilder.visualizationData.columns.get(0).get(0)
        'Name' == googleVisualizationBuilder.visualizationData.columns.get(0).get(1)
        'string' == googleVisualizationBuilder.visualizationData.columns.get(1).get(0)
        'Salary' == googleVisualizationBuilder.visualizationData.columns.get(1).get(1)
        'boolean' == googleVisualizationBuilder.visualizationData.columns.get(2).get(0)
        'Full Time Employee' == googleVisualizationBuilder.visualizationData.columns.get(2).get(1)
    }

    void testBuildRowsForStringDataType() {
        when:
        googleVisualizationBuilder.createNewVisualizationData(['columns': [['string', 'Task'], ['number', 'Hours per Day']], 'data': [['Work', 11], [null, 2]]], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildRows()

        then:
        2 == googleVisualizationBuilder.visualizationData.rows.size()
        "['Work', 11]" == googleVisualizationBuilder.visualizationData.rows.get(0).toString()
        "[undefined, 2]" == googleVisualizationBuilder.visualizationData.rows.get(1).toString()
    }

    void testBuildRowsForDateDataType() {
        when:
        googleVisualizationBuilder.createNewVisualizationData(['columns': [['date', 'Date'], ['number', 'Hours per Day']], 'data': [[DateUtil.createDate(2008, Calendar.MARCH, 1), 11], [null, 2]]], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildRows()

        then:
        2 == googleVisualizationBuilder.visualizationData.rows.size()
        "[new Date(2008, 2, 1), 11]" == googleVisualizationBuilder.visualizationData.rows.get(0).toString()
        "[undefined, 2]" == googleVisualizationBuilder.visualizationData.rows.get(1).toString()
    }

    void testBuildRowsForDateDataTimeType() {
        when:
        googleVisualizationBuilder.createNewVisualizationData(['columns': [['datetime', 'DateTime'], ['number', 'Hours per Day']], 'data': [[DateUtil.createDate(2008, Calendar.MARCH, 1, 1, 2, 3, 4), 11], [null, 2]]], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildRows()

        then:
        2 == googleVisualizationBuilder.visualizationData.rows.size()
        "[new Date(2008, 2, 1, 1, 2, 3, 4), 11]" == googleVisualizationBuilder.visualizationData.rows.get(0).toString()
        "[undefined, 2]" == googleVisualizationBuilder.visualizationData.rows.get(1).toString()
    }

    void testBuildRowsForDateTimeOfDayType() {
        when:
        googleVisualizationBuilder.createNewVisualizationData(['columns': [['timeofday', 'TimeOfDay'], ['number', 'Hours per Day']], 'data': [[DateUtil.createDate(2008, Calendar.MARCH, 1, 1, 2, 3, 4), 11], [null, 2]]], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildRows()

        then:
        2 == googleVisualizationBuilder.visualizationData.rows.size()
        "[[1, 2, 3, 4], 11]" == googleVisualizationBuilder.visualizationData.rows.get(0).toString()
        "[undefined, 2]" == googleVisualizationBuilder.visualizationData.rows.get(1).toString()
    }

    void testBuildColumnsForGraphUsingDataTableRoles() {
        setup:
        def columns = [
                ['string', 'Month'],
                ['number', 'Sales'],
                [type: 'number', role: 'interval'],
                [type: 'number', role: 'interval'],
                [type: 'string', role: 'annotation'],
                [type: 'string', role: 'annotationText'],
                [type: 'boolean', role: 'certainty']
        ]

        def data = [
                ['April', 1000, 900, 1100, 'A', 'Stolen data', true],
                ['May', 1170, 1000, 1200, 'B', 'Coffee spill', true],
                ['June', 660, 550, 800, 'C', 'Wumpus attack', true],
                ['July', 1030, null, null, null, null, false]
        ]

        when:
        googleVisualizationBuilder.createNewVisualizationData([columns: columns, data: data], GoogleVisualization.LINE_CORE_CHART)
        googleVisualizationBuilder.buildColumns()
        def builderColumns = googleVisualizationBuilder.visualizationData.columns

        then:
        7 == builderColumns.size()
        builderColumns[0] instanceof List
        builderColumns[2] instanceof Map
        ['string', 'Month'] == builderColumns[0]
        [type: 'number', role: 'interval'] == builderColumns[2]
    }

    void testBuildRowsForGraphUsingDataTableRoles() {
        setup:
        def columns = [
                ['string', 'Month'],
                ['number', 'Sales'],
                [type: 'number', role: 'interval'],
                [type: 'number', role: 'interval'],
                [type: 'string', role: 'annotation'],
                [type: 'string', role: 'annotationText'],
                [type: 'boolean', role: 'certainty']
        ]

        def data = [
                ['April', 1000, 900, 1100, 'A', 'Stolen data', true],
                ['May', 1170, 1000, 1200, 'B', 'Coffee spill', true],
                ['June', 660, 550, 800, 'C', 'Wumpus attack', true],
                ['July', 1030, null, null, null, null, false]
        ]

        when:
        googleVisualizationBuilder.createNewVisualizationData([columns: columns, data: data], GoogleVisualization.LINE_CORE_CHART)
        googleVisualizationBuilder.buildRows()
        def builderRows = googleVisualizationBuilder.visualizationData.rows

        then:
        4 == builderRows.size()
        "['April', 1000, 900, 1100, 'A', 'Stolen data', true]" == builderRows[0].toString()
        "['July', 1030, undefined, undefined, undefined, undefined, false]" == builderRows[3].toString()
    }

    void testRenderParamForStringDataTypeWithStringValue() {
        when:
        def renderedParam = googleVisualizationBuilder.renderParam('string', "test ' 12")

        then:
        "'test \\' 12'" == renderedParam.toString()
    }

    void testRenderParamForStringDataTypeWithIntegerValue() {
        when:
        def renderedParam = googleVisualizationBuilder.renderParam('string', 1)

        then:
        "'1'" == renderedParam.toString()
    }

    void testRenderParamForStringDataTypeWithFloatValue() {
        when:
        def renderedParam = googleVisualizationBuilder.renderParam('string', 1.1f)

        then:
        "'1.1'" == renderedParam.toString()
    }

    void testRenderParamForNumberDataTypeWithIntegerValue() {
        when:
        def renderedParam = googleVisualizationBuilder.renderParam('number', 11)

        then:
        11 == renderedParam
    }

    void testRenderParamForBooleanDataTypeWithBooleanValue() {
        when:
        def renderedParam = googleVisualizationBuilder.renderParam('boolean', true)

        then:
        true == renderedParam
    }

    void testRenderParamForDateDataTypeWithDateValue() {
        when:
        def renderedParam = googleVisualizationBuilder.renderParam('date', DateUtil.createDate(2008, Calendar.MARCH, 1, 1, 2, 3, 4))

        then:
        "new Date(2008, 2, 1)" == renderedParam.toString()
    }

    void testRenderParamForDateTimeDataTypeWithDateValue() {
        when:
        def renderedParam = googleVisualizationBuilder.renderParam('datetime', DateUtil.createDate(2008, Calendar.MARCH, 1, 1, 2, 3, 4))

        then:
        "new Date(2008, 2, 1, 1, 2, 3, 4)" == renderedParam.toString()
    }

    void testRenderParamForTimeOfDayDataTypeWithDateValue() {
        when:
        def renderedParam = googleVisualizationBuilder.renderParam('timeofday', DateUtil.createDate(2008, Calendar.MARCH, 1, 1, 2, 3, 4))

        then:
        "[1, 2, 3, 4]" == renderedParam.toString()
    }

    void testRenderCellValueForValueOnly() {
        when:
        def renderedCellValue = googleVisualizationBuilder.renderCellValue(GoogleVisualizationColumnType.BOOLEAN.toString(), new Cell(value: true))

        then:
        "{v: true}" == renderedCellValue.toString()
    }

    void testRenderCellValueForValueAndLabelOfTypeString() {
        when:
        def renderedCellValue = googleVisualizationBuilder.renderCellValue(GoogleVisualizationColumnType.STRING.toString(), new Cell(value: 'bla', label: 'test'))

        then:
        "{v: 'bla', f: 'test'}" == renderedCellValue.toString()
    }

    void testRenderCellValueForValueAndLabelOfTypeInteger() {
        when:
        def renderedCellValue = googleVisualizationBuilder.renderCellValue(GoogleVisualizationColumnType.STRING.toString(), new Cell(value: 'bla', label: 123))

        then:
        "{v: 'bla', f: '123'}" == renderedCellValue.toString()
    }

    void testRenderCellValueForValueLabelAndCustomValues() {
        when:
        def renderedCellValue = googleVisualizationBuilder.renderCellValue(GoogleVisualizationColumnType.NUMBER.toString(), new Cell(value: 1, label: 'hello', customValues: [style: 'border: 1px solid green;', test: 'hello: next;']))

        then:
        "{v: 1, f: 'hello', p: {style: 'border: 1px solid green;', test: 'hello: next;'}}" == renderedCellValue.toString()
    }

    void testBuildEvents() {
        when:
        googleVisualizationBuilder.createNewVisualizationData(['select': 'selectHandler', 'ready': 'readyHandler'], GoogleVisualization.PIE_CHART)
        googleVisualizationBuilder.buildEvents()

        then:
        1 == googleVisualizationBuilder.visualizationData.beforeDrawEvents.size()
        'readyHandler' == googleVisualizationBuilder.visualizationData.beforeDrawEvents['ready']
        1 == googleVisualizationBuilder.visualizationData.afterDrawEvents.size()
        'selectHandler' == googleVisualizationBuilder.visualizationData.afterDrawEvents['select']
    }
}
