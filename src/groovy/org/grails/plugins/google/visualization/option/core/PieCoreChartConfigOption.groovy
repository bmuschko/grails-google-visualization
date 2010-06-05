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
package org.grails.plugins.google.visualization.option.core

import org.grails.plugins.google.visualization.data.DataType

/**
 * Pie Core Chart configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum PieCoreChartConfigOption {
    BACKGROUND_COLOR("backgroundColor", [DataType.STRING]),
    COLORS("colors", [DataType.ARRAY]),
    FONT_SIZE("fontSize", [DataType.NUMBER]),
    HEIGHT("height", [DataType.NUMBER]),
    LEGEND("legend", [DataType.STRING]),
    LEGEND_FONT_SIZE("legendFontSize", [DataType.NUMBER]),
    LEGEND_TEXT_COLOR("legendTextColor", [DataType.STRING]),
    REVERSE_CATEGORIES("reverseCategories", [DataType.BOOLEAN]),
    TITLE("title", [DataType.STRING]),
    TITLE_COLOR("titleColor", [DataType.STRING]),
    TITLE_FONT_SIZE("titleFontSize", [DataType.NUMBER]),
    TOOLTIP_FONT_SIZE("tooltipFontSize", [DataType.NUMBER]),
    WIDTH("width", [DataType.NUMBER])

    static final Map configOptions

    static {
        configOptions = [:]

        values().each { configOption ->
            configOptions.put(configOption.name, configOption)
        }
    }

    private final name
    private final types

    PieCoreChartConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    public String toString() {
        "PieCoreChartConfigOption{name='${name}', types='${types}'}"
    }
}