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

import org.grails.plugins.google.visualization.data.DataType
import org.grails.plugins.google.visualization.util.DateUtil
import spock.lang.Specification

/**
 * Data type value renderer tests
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class DataTypeValueRendererSpec extends Specification {
    void testRenderForString() {
        when:
        def renderedValue = DataTypeValueRenderer.instance.render('bla')
        then:
        renderedValue.type == DataType.STRING
        renderedValue.value.toString() == "'bla'"
    }

    void testRenderForNumber() {
        when:
        def renderedValue = DataTypeValueRenderer.instance.render(123)
        then:
        renderedValue.type == DataType.NUMBER
        renderedValue.value == 123
    }

    void testRenderForBooleanTrue() {
        when:
        def renderedValue = DataTypeValueRenderer.instance.render(true)
        then:
        renderedValue.type == DataType.BOOLEAN
        renderedValue.value
    }

    void testRenderForBooleanFalse() {
        when:
        def renderedValue = DataTypeValueRenderer.instance.render(false)
        then:
        renderedValue.type == DataType.BOOLEAN
        !renderedValue.value
    }

    void testRenderForDate() {
        given:
        def date = DateUtil.removeTime(DateUtil.createDate(1995, Calendar.NOVEMBER, 29))
        when:
        def renderedValue = DataTypeValueRenderer.instance.render(date)
        then:
        renderedValue.type == DataType.DATE
        renderedValue.value.toString() == "new Date(1995, 10, 29, 0, 0, 0, 0)"
    }

    void testRenderForList() {
        when:
        def renderedValue = DataTypeValueRenderer.instance.render(['a', 1, true] as List)
        then:
        renderedValue.type == DataType.ARRAY
        renderedValue.value.toString() == "['a', 1, true]"
    }

    void testRenderForObjectArray() {
        when:
        def renderedValue = DataTypeValueRenderer.instance.render(['a', 1, true] as Object[])
        then:
        renderedValue.type == DataType.ARRAY
        renderedValue.value.toString() == "['a', 1, true]"
    }

    void testRenderForObject() {
        when:
        def renderedValue = DataTypeValueRenderer.instance.render(new Expando(stroke: 'black', fill: '#eee', strokeSize: 1))
        then:
        renderedValue.type == DataType.OBJECT
        renderedValue.value.toString() == "{stroke: 'black', fill: '#eee', strokeSize: 1}"
    }

    void testRenderForMap() {
        when:
        def renderedValue = DataTypeValueRenderer.instance.render([1: 'value1', 2: 'value2', 3: 'value3'])
        then:
        renderedValue.type == DataType.MAP
        renderedValue.value.toString() == "{1: 'value1', 2: 'value2', 3: 'value3'}"
    }
}
