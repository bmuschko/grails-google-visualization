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
package org.grails.plugins.google.visualization.data.renderer

import grails.test.GrailsUnitTestCase
import org.grails.plugins.google.visualization.data.DataType
import org.grails.plugins.google.visualization.util.DateUtil

/**
 * Data type value renderer tests
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class DataTypeValueRendererTests extends GrailsUnitTestCase {
    void testRenderForString() {
        def renderedValue = DataTypeValueRenderer.instance.render('bla')
        assertEquals DataType.STRING, renderedValue.type
        assertEquals "'bla'", renderedValue.value
    }

    void testRenderForNumber() {
        def renderedValue = DataTypeValueRenderer.instance.render(123)
        assertEquals DataType.NUMBER, renderedValue.type
        assertEquals 123, renderedValue.value
    }

    void testRenderForBooleanTrue() {
        def renderedValue = DataTypeValueRenderer.instance.render(true)
        assertEquals DataType.BOOLEAN, renderedValue.type
        assertEquals true, renderedValue.value
    }

    void testRenderForBooleanFalse() {
        def renderedValue = DataTypeValueRenderer.instance.render(false)
        assertEquals DataType.BOOLEAN, renderedValue.type
        assertEquals false, renderedValue.value
    }

    void testRenderForDate() {
        def date = DateUtil.removeTime(DateUtil.createDate(1995, Calendar.NOVEMBER, 29))
        def renderedValue = DataTypeValueRenderer.instance.render(date)
        assertEquals DataType.DATE, renderedValue.type
        assertEquals "new Date(1995, 10, 29, 0, 0, 0, 0)", renderedValue.value
    }

    void testRenderForList() {
        def renderedValue = DataTypeValueRenderer.instance.render(['a', 1, true] as List)
        assertEquals DataType.ARRAY, renderedValue.type
        assertEquals "['a', 1, true]", renderedValue.value
    }

    void testRenderForObjectArray() {
        def renderedValue = DataTypeValueRenderer.instance.render(['a', 1, true] as Object[])
        assertEquals DataType.ARRAY, renderedValue.type
        assertEquals "['a', 1, true]", renderedValue.value
    }

    void testRenderForObject() {
        def renderedValue = DataTypeValueRenderer.instance.render(new Expando(stroke:'black', fill:'#eee', strokeSize: 1))
        assertEquals DataType.OBJECT, renderedValue.type
        assertEquals "{stroke: 'black', fill: '#eee', strokeSize: 1}", renderedValue.value
    }

    void testRenderForMap() {
        def renderedValue = DataTypeValueRenderer.instance.render([1: 'value1', 2: 'value2', 3: 'value3'])
        assertEquals DataType.MAP, renderedValue.type
        assertEquals "{1: 'value1', 2: 'value2', 3: 'value3'}", renderedValue.value
    }
}
