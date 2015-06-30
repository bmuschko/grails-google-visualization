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

import org.grails.plugins.google.visualization.data.DataType
import org.grails.plugins.google.visualization.option.deprecated.PieChartConfigOption
import spock.lang.Specification

/**
 * Configuration option renderer utility tests
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class ConfigOptionRendererUtilSpec extends Specification {
    void testRenderForSingleAllowedType() {
        when:
        def resolvedConfigOption = ConfigOptionRendererUtil.render(PieChartConfigOption.TITLE, 'bla')

        then:
        DataType.STRING == resolvedConfigOption.type
        "'bla'" == resolvedConfigOption.value.toString()
    }

    void testRenderForMultipleAllowedTypes() {
        when:
        def resolvedConfigOption = ConfigOptionRendererUtil.render(PieChartConfigOption.BACKGROUND_COLOR, '#004411')

        then:
        DataType.STRING == resolvedConfigOption.type
        "'#004411'" == resolvedConfigOption.value.toString()
    }

    void testRenderForUnsupportedType() {
        when:
        ConfigOptionRendererUtil.render(PieChartConfigOption.BACKGROUND_COLOR, 123)

        then:
        thrown(IllegalArgumentException)
    }
}
