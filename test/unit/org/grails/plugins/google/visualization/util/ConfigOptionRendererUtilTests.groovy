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
import org.grails.plugins.google.visualization.data.DataType
import org.grails.plugins.google.visualization.option.deprecated.PieChartConfigOption

/**
 * Configuration option renderer utility tests
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class ConfigOptionRendererUtilTests extends GrailsUnitTestCase {
    void testRenderForSingleAllowedType() {
        def resolvedConfigOption = ConfigOptionRendererUtil.render(PieChartConfigOption.TITLE, 'bla')
        assertEquals DataType.STRING, resolvedConfigOption.type
        assertEquals "'bla'", resolvedConfigOption.value
    }

    void testRenderForMultipleAllowedTypes() {
        def resolvedConfigOption = ConfigOptionRendererUtil.render(PieChartConfigOption.BACKGROUND_COLOR, '#004411')
        assertEquals DataType.STRING, resolvedConfigOption.type
        assertEquals "'#004411'", resolvedConfigOption.value
    }

    void testRenderForUnsupportedType() {
        try
        {
            ConfigOptionRendererUtil.render(PieChartConfigOption.BACKGROUND_COLOR, 123)
            fail "Unsupported data types have to throw an exception!"
        }
        catch(IllegalArgumentException e)
        {
            assertEquals "Unsupported configuration type 'NUMBER'. Allowed types: [STRING, OBJECT]", e.message 
        }
    }
}
