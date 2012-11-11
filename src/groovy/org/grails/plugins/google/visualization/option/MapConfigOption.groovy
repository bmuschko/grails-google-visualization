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
 * Map configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum MapConfigOption {
    ENABLE_SCROLL_WHEEL("enableScrollWheel", [DataType.BOOLEAN]),
    SHOW_TIP("showTip", [DataType.BOOLEAN]),
    SHOW_LINE("showLine", [DataType.BOOLEAN]),
    LINE_COLOR("lineColor", [DataType.STRING]),
    LINE_WIDTH("lineWidth", [DataType.NUMBER]),
    MAP_TYPE("mapType", [DataType.STRING]),
    USE_MAP_TYPE_CONTROL("useMapTypeControl", [DataType.BOOLEAN]),
    ZOOM_LEVEL("zoomLevel", [DataType.NUMBER])

    static final Map configOptions

    static {
        configOptions = [:]

        values().each { configOption ->
            configOptions.put(configOption.name, configOption)
        }
    }

    private final name
    private final types

    MapConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    String toString() {
        "MapConfigOption{name='${name}', types='${types}'}"
    }
}