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
 * Image Pie Chart configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum ImagePieChartConfigOption {
    BACKGROUND_COLOR("backgroundColor", [DataType.STRING]),
    COLOR("color", [DataType.STRING]),
    COLORS("colors", [DataType.ARRAY]),
    ENABLE_EVENTS("enableEvents", [DataType.BOOLEAN]),
    HEIGHT("height", [DataType.NUMBER, DataType.STRING]),
    IS_3D("is3D", [DataType.BOOLEAN]),
    LABELS("labels", [DataType.STRING]),
    LEGEND("legend", [DataType.STRING]),
    TITLE("title", [DataType.STRING]),
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

    ImagePieChartConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    String toString() {
        "ImagePieChartConfigOption{name='${name}', types='${types}'}"
    }
}