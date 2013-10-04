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

import grails.test.TagLibUnitTestCase

/**
 * Google visualization taglib tests
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class GoogleVisualizationTagLibTests extends TagLibUnitTestCase {
    void testPieChart() {
        tagLib.pieChart(createPieChartAttributes()) { }
        assertNotNull tagLib.out.toString()
    }

    void testValidateAttributesForOptionalAttributes() {
        def attrs = ['name':'testName', 'elementId':'testElementId', 'columns':[1, 2, 3, 4], 'data':[5, 6, 7, 8], 'someValue':'hello']
        tagLib.validateAttributes(attrs, GoogleVisualization.PIE_CHART, ['someValue', 'test'])
    }

    void testValidateAttributesForOptionalAttributesForUnknownAttribute() {
        def attrs = ['name':'testName', 'elementId':'testElementId', 'columns':[1, 2, 3, 4], 'data':[5, 6, 7, 8], 'someValue':'hello']

        try {
            tagLib.validateAttributes(attrs, GoogleVisualization.PIE_CHART, ['xxx', 'yyy'])
            fail("Unknown attributes have to throw an exception!")
        }
        catch(IllegalArgumentException e) {
            assertEquals "Attribute 'someValue' is not a valid option for Google Visualization 'google.visualization.PieChart'!", e.message
        }
    }

    void testRenderApiImportWithoutCallbackAndWithoutKey() {
        def attrs = []
        tagLib.apiImport(attrs, "")
        assertEquals "<script type=\"text/javascript\" src=\"//www.google.com/jsapi\"></script>", tagLib.out.toString()
    }

    void testRenderApiImportWithCallbackAndWithoutKey() {
        def attrs = ["callback":"foo"]
        tagLib.apiImport(attrs, "")
        assertEquals "<script type=\"text/javascript\" src=\"//www.google.com/jsapi?callback=foo\"></script>", tagLib.out.toString()
    }

    void testRenderApiImportWithoutCallbackAndWithKey() {
        def attrs = ["key":"bar"]
        tagLib.apiImport(attrs, "")
        assertEquals "<script type=\"text/javascript\" src=\"//www.google.com/jsapi?key=bar\"></script>", tagLib.out.toString()
    }

    void testRenderApiImportWithCallbackAndWithKey() {
        def attrs = ["callback":"foo", "key":"bar"]
        tagLib.apiImport(attrs, "")
        assertEquals "<script type=\"text/javascript\" src=\"//www.google.com/jsapi?key=bar&callback=foo\"></script>", tagLib.out.toString()
    }

    void testIsValidAttributeForBasicAttributeCallback() {
        assertTrue tagLib.isValidAttribute('callback', GoogleVisualization.PIE_CHART)
    }

    void testIsValidAttributeForBasicAttributeName() {
        assertTrue tagLib.isValidAttribute('name', GoogleVisualization.PIE_CHART)
    }

    void testIsValidAttributeForBasicAttributeElementId() {
        assertTrue tagLib.isValidAttribute('elementId', GoogleVisualization.PIE_CHART)
    }

    void testIsValidAttributeForBasicAttributeLanguage() {
        assertTrue tagLib.isValidAttribute('language', GoogleVisualization.PIE_CHART)
    }

    void testIsValidAttributeForBasicAttributeColumns() {
        assertTrue tagLib.isValidAttribute('columns', GoogleVisualization.PIE_CHART)
    }

    void testIsValidAttributeForBasicAttributeData() {
        assertTrue tagLib.isValidAttribute('data', GoogleVisualization.PIE_CHART)
    }

    void testIsValidAttributeForOptionalAttribute() {
        assertTrue tagLib.isValidAttribute('xxx', GoogleVisualization.PIE_CHART, ['yyy', 'xxx', 'zzz'])
    }

    void testGetInvalidOptionExceptionMessage() {
        assertEquals "Attribute 'bla' is not a valid option for Google Visualization 'google.visualization.PieChart'!", tagLib.getInvalidOptionExceptionMessage('bla', GoogleVisualization.PIE_CHART).toString()
    }

    void testRenderVisualization() {
        tagLib.renderVisualization(createPieChartAttributes(), GoogleVisualization.PIE_CHART)
        assertNotNull tagLib.out.toString()
    }

    def createPieChartAttributes() {
        ['title':'My Daily Activities', 'width':400, 'height':240, 'is3D':true, 'columns':[['string', 'Name'], ['number', 'Salary'], ['boolean', 'Full Time Employee']], 'data':[['Memory', 80], ['CPU', 55], ['Network', 68]]]
    }
}
