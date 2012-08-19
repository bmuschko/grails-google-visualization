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
 * Geo Chart configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum GeoChartConfigOption {
    BACKGROUND_COLOR("backgroundColor", [DataType.STRING, DataType.OBJECT]),
    COLOR_AXIS("colorAxis", [DataType.OBJECT]),
    DATALESS_REGION_COLOR("datalessRegionColor", [DataType.STRING]),
    DISPLAY_MODE("displayMode", [DataType.STRING]),
    ENABLE_REGION_INTERACTIVITY("enableRegionInteractivity", [DataType.BOOLEAN]),
    HEIGHT("height", [DataType.NUMBER, DataType.STRING]),
    KEEP_ASPECT_RATIO("keepAspectRatio", [DataType.BOOLEAN]),
    LEGEND("legend", [DataType.OBJECT]),
    REGION("region", [DataType.STRING]),
    MAGNIFYING_GLASS("magnifyingGlass", [DataType.OBJECT]),
    MARKER_OPACITY("markerOpacity", [DataType.NUMBER]),
    RESOLUTION("resolution", [DataType.STRING]),
    SIZE_AXIS("sizeAxis", [DataType.OBJECT]),
    TOOLTIP("tooltip", [DataType.OBJECT]),
    WIDTH("width", [DataType.NUMBER, DataType.STRING]),
    FORCEIFRAME("forceIFrame", [DataType.BOOLEAN])

    static final Map configOptions

    static {
        configOptions = [:]

        values().each { configOption ->
            configOptions.put(configOption.name, configOption)
        }
    }

    private final name
    private final types

    GeoChartConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    String toString() {
        "GeoChartConfigOption{name='${name}', types='${types}'}"
    }
}
