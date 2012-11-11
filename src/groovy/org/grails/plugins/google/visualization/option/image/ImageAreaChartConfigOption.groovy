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
package org.grails.plugins.google.visualization.option.image

import org.grails.plugins.google.visualization.data.DataType

/**
 * Image Area Chart configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum ImageAreaChartConfigOption {
    BACKGROUND_COLOR("backgroundColor", [DataType.STRING]),
    COLORS("colors", [DataType.ARRAY]),
    ENABLE_EVENTS("enableEvents", [DataType.BOOLEAN]),
    HEIGHT("height", [DataType.NUMBER, DataType.STRING]),
    LEGEND("legend", [DataType.STRING]),
    MAX("max", [DataType.NUMBER]),
    MIN("min", [DataType.NUMBER]),
    SHOW_CATEGORY_LABELS("showCategoryLabels", [DataType.BOOLEAN]),
    SHOW_VALUE_LABELS("showValueLabels", [DataType.BOOLEAN]),
    TITLE("title", [DataType.STRING]),
    VALUE_LABELS_INTERVAL("valueLabelsInterval", [DataType.NUMBER]),
    WIDTH("width", [DataType.NUMBER, DataType.STRING])

    static final Map configOptions

    static {
        configOptions = [:]

        values().each { configOption ->
            configOptions.put(configOption.name, configOption)
        }
    }

    private final name
    private final types

    ImageAreaChartConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    String toString() {
        "ImageAreaChartConfigOption{name='${name}', types='${types}'}"
    }
}
