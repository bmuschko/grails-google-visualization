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
 * Geo Map configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum GeoMapConfigOption {
    REGION("region", [DataType.STRING]),
    DATA_MODE("dataMode", [DataType.STRING]),
    WIDTH("width", [DataType.NUMBER, DataType.STRING]),
    HEIGHT("height", [DataType.NUMBER, DataType.STRING]),
    COLORS("colors", [DataType.ARRAY]),
    LEGEND("legend", [DataType.STRING]),
    SHOW_LEGEND("showLegend", [DataType.BOOLEAN]),
    SHOW_ZOOM_OUT("showZoomOut", [DataType.BOOLEAN]),
    ZOOM_OUT_LABEL("zoomOutLabel", [DataType.STRING])

    static final Map configOptions

    static {
        configOptions = [:]

        values().each { configOption ->
            configOptions.put(configOption.name, configOption)
        }
    }

    private final name
    private final types

    GeoMapConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    String toString() {
        "GeoMapConfigOption{name='${name}', types='${types}'}"
    }
}