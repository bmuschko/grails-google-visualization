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
package org.grails.plugins.google.visualization.option

import org.grails.plugins.google.visualization.data.DataType

/**
 * Annotated Time Line configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum TimeLineConfigOption {
    AVOID_OVERLAPPING_GRID_LINES("avoidOverlappingGridLines", [DataType.BOOLEAN]),
    BACKGROUND_COLOR("backgroundColor", [DataType.STRING, DataType.OBJECT]),
    COLORS("colors", [DataType.ARRAY]),
    ENABLE_INTERACTIVITY("enableInteractivity", [DataType.BOOLEAN]),
    HEIGHT("height", [DataType.NUMBER, DataType.STRING]),
    TIMELINE("timeline", [DataType.OBJECT]),
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

    TimeLineConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    String toString() {
        "TimeLineConfigOption{name='${name}', types='${types}'}"
    }
}