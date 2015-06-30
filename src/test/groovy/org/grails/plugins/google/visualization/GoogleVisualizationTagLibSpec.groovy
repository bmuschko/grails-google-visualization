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

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.web.GroovyPageUnitTestMixin
import spock.lang.Specification

/**
 * Google org.grails.plugins.google.visualization taglib tests
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
@TestMixin(GroovyPageUnitTestMixin)
@TestFor(GoogleVisualizationTagLib)
class GoogleVisualizationTagLibSpec extends Specification {

    void "test pieChart tag"() {
        expect:
        tagLib.pieChart(createPieChartAttributes())
    }

    void testValidateAttributesForOptionalAttributes() {
        setup:
        def attrs = ['name': 'testName', 'elementId': 'testElementId', 'columns': [1, 2, 3, 4], 'data': [5, 6, 7, 8], 'someValue': 'hello']

        expect:
        tagLib.validateAttributes(attrs, GoogleVisualization.PIE_CHART, ['someValue', 'test'])
    }

    void testValidateAttributesForOptionalAttributesForUnknownAttribute() {
        setup:
        def attrs = ['name': 'testName', 'elementId': 'testElementId', 'columns': [1, 2, 3, 4], 'data': [5, 6, 7, 8], 'someValue': 'hello']

        when:
        tagLib.validateAttributes(attrs, GoogleVisualization.PIE_CHART, ['xxx', 'yyy'])

        then:
        thrown(IllegalArgumentException)
    }

    void testIsValidAttributeForBasicAttributeName() {
        expect:
        tagLib.isValidAttribute('name', GoogleVisualization.PIE_CHART)
    }

    void testIsValidAttributeForBasicAttributeElementId() {
        expect:
        tagLib.isValidAttribute('elementId', GoogleVisualization.PIE_CHART)
    }

    void testIsValidAttributeForBasicAttributeLanguage() {
        expect:
        tagLib.isValidAttribute('language', GoogleVisualization.PIE_CHART)
    }

    void testIsValidAttributeForBasicAttributeColumns() {
        expect:
        tagLib.isValidAttribute('columns', GoogleVisualization.PIE_CHART)
    }

    void testIsValidAttributeForBasicAttributeData() {
        expect:
        tagLib.isValidAttribute('data', GoogleVisualization.PIE_CHART)
    }

    void testIsValidAttributeForOptionalAttribute() {
        expect:
        tagLib.isValidAttribute('xxx', GoogleVisualization.PIE_CHART, ['yyy', 'xxx', 'zzz'])
    }

    void testGetInvalidOptionExceptionMessage() {
        expect:
        tagLib.getInvalidOptionExceptionMessage('bla', GoogleVisualization.PIE_CHART).toString() == "Attribute 'bla' is not a valid option for Google Visualization 'google.visualization.PieChart'!"
    }

    void testRenderVisualization() {
        expect:
        tagLib.renderVisualization(createPieChartAttributes(), GoogleVisualization.PIE_CHART)
    }

    def createPieChartAttributes() {
        ['title': 'My Daily Activities', 'width': 400, 'height': 240, 'is3D': true, 'columns': [['string', 'Name'], ['number', 'Salary'], ['boolean', 'Full Time Employee']], 'data': [['Memory', 80], ['CPU', 55], ['Network', 68]]]
    }
}
