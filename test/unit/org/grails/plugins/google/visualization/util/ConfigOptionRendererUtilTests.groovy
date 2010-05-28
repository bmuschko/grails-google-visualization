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
package org.grails.plugins.google.visualization.util

import grails.test.GrailsUnitTestCase
import org.grails.plugins.google.visualization.option.GoogleVisualizationConfigOptionType

/**
 * Configuration option renderer utility tests
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class ConfigOptionRendererUtilTests extends GrailsUnitTestCase {
    void testResolveConfigOptionForString() {
        def resolvedConfigOption = ConfigOptionRendererUtil.resolveConfigOption('bla')
        assertEquals GoogleVisualizationConfigOptionType.STRING, resolvedConfigOption.type
        assertEquals "'bla'", resolvedConfigOption.value
    }

    void testResolveConfigOptionForNumber() {
        def resolvedConfigOption = ConfigOptionRendererUtil.resolveConfigOption(123)
        assertEquals GoogleVisualizationConfigOptionType.NUMBER, resolvedConfigOption.type
        assertEquals 123, resolvedConfigOption.value
    }

    void testResolveConfigOptionForBooleanTrue() {
        def resolvedConfigOption = ConfigOptionRendererUtil.resolveConfigOption(true)
        assertEquals GoogleVisualizationConfigOptionType.BOOLEAN, resolvedConfigOption.type
        assertEquals true, resolvedConfigOption.value
    }

    void testResolveConfigOptionForBooleanFalse() {
        def resolvedConfigOption = ConfigOptionRendererUtil.resolveConfigOption(false)
        assertEquals GoogleVisualizationConfigOptionType.BOOLEAN, resolvedConfigOption.type
        assertEquals false, resolvedConfigOption.value
    }

    void testResolveConfigOptionForList() {
        def resolvedConfigOption = ConfigOptionRendererUtil.resolveConfigOption(['a', 1, true] as List)
        assertEquals GoogleVisualizationConfigOptionType.ARRAY, resolvedConfigOption.type
        assertEquals "['a', 1, true]", resolvedConfigOption.value
    }

    void testResolveConfigOptionForObjectArray() {
        def resolvedConfigOption = ConfigOptionRendererUtil.resolveConfigOption(['a', 1, true] as Object[])
        assertEquals GoogleVisualizationConfigOptionType.ARRAY, resolvedConfigOption.type
        assertEquals "['a', 1, true]", resolvedConfigOption.value
    }

    void testResolveConfigOptionForObject() {
        def resolvedConfigOption = ConfigOptionRendererUtil.resolveConfigOption(new Expando(stroke:'black', fill:'#eee', strokeSize: 1))
        assertEquals GoogleVisualizationConfigOptionType.OBJECT, resolvedConfigOption.type
        assertEquals "{stroke: 'black', fill: '#eee', strokeSize: 1}", resolvedConfigOption.value
    }

    void testResolveConfigOptionForMap() {
        def resolvedConfigOption = ConfigOptionRendererUtil.resolveConfigOption([1: 'value1', 2: 'value2', 3: 'value3'])
        assertEquals GoogleVisualizationConfigOptionType.MAP, resolvedConfigOption.type
        assertEquals "{1: 'value1', 2: 'value2', 3: 'value3'}", resolvedConfigOption.value
    }

    void testRenderStringValueUnescaped() {
        assertEquals "'test'", ConfigOptionRendererUtil.renderStringValue('test')
    }

    void testRenderStringValueEscaped() {
        assertEquals "'Jack\\'s parameter'", ConfigOptionRendererUtil.renderStringValue("Jack's parameter")
    }

    void testRenderNumberOrBooleanValueForNumber() {
        assertEquals 123, ConfigOptionRendererUtil.renderNumberOrBooleanValue(123)
    }

    void testRenderNumberOrBooleanValueForBoolean() {
        assertEquals true, ConfigOptionRendererUtil.renderNumberOrBooleanValue(true)
    }

    void testRenderObjectValue() {
        assertEquals "{stroke: 'black', fill: '#eee', strokeSize: 1}", ConfigOptionRendererUtil.renderObjectValue(new Expando(stroke:'black', fill:'#eee', strokeSize: 1))
    }

    void testRenderArrayValue() {
        assertEquals "['a', 1, true]", ConfigOptionRendererUtil.renderArrayValue(['a', 1, true])
    }

    void testRenderMapValue() {
        assertEquals "{1: 'value1', 2: 'value2', 3: 'value3'}", ConfigOptionRendererUtil.renderMapValue([1: 'value1', 2: 'value2', 3: 'value3'])
    }

    void testRenderObjectArrayValue() {
        assertEquals "[{color: '#FF0000', darker: '#680000'}, {color: 'cyan', darker: 'deepskyblue'}]", ConfigOptionRendererUtil.renderArrayValue([new Expando(color:'#FF0000', darker:'#680000'), new Expando(color:'cyan', darker:'deepskyblue')])
    }
}
