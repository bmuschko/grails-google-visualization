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
 * @see <a href="https://developers.google.com/chart/interactive/docs/gallery/piechart#Configuration_Options">Configuration Options</a>
 */
enum PieCoreChartConfigOption {
    BACKGROUND_COLOR("backgroundColor", [DataType.STRING, DataType.OBJECT, DataType.MAP]),
    CHART_AREA("chartArea", [DataType.OBJECT, DataType.MAP]),
    COLORS("colors", [DataType.ARRAY]),
    ENABLE_INTERACTIVITY("enableInteractivity", [DataType.BOOLEAN]),
    FONT_SIZE("fontSize", [DataType.NUMBER]),
    FONT_NAME("fontName", [DataType.STRING]),
    FORCE_IFRAME("forceIFrame", [DataType.BOOLEAN]),
    HEIGHT("height", [DataType.NUMBER, DataType.STRING]),
    IS_3D("is3D", [DataType.BOOLEAN]),
    LEGEND("legend", [DataType.STRING, DataType.OBJECT, DataType.MAP]),
    PIE_HOLE("pieHole", [DataType.NUMBER]),
    PIE_SLICE_BORDER_COLOR("pieSliceBorderColor", [DataType.STRING]),
    PIE_SLICE_TEXT("pieSliceText", [DataType.STRING]),
    PIE_SLICE_TEXT_STYLE("pieSliceTextStyle", [DataType.OBJECT, DataType.MAP]),
    PIE_START_ANGLE("pieStartAngle", [DataType.OBJECT, DataType.MAP]),
    PIE_RESIDUE_SLICE_COLOR("pieResidueSliceColor", [DataType.STRING]),
    PIE_RESIDUE_SLICE_LABEL("pieResidueSliceLabel", [DataType.STRING]),
    REVERSE_CATEGORIES("reverseCategories", [DataType.BOOLEAN]),
    SLICES("slices", [DataType.ARRAY, DataType.OBJECT, DataType.MAP]),
    SLICE_VISIBILITY_THRESHOLD("sliceVisibilityThreshold", [DataType.NUMBER]),
    TITLE("title", [DataType.STRING]),
    TITLE_TEXT_STYLE("titleTextStyle", [DataType.OBJECT, DataType.MAP]),
    TOOLTIP("tooltip", [DataType.OBJECT, DataType.MAP]),
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

    private PieCoreChartConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    String toString() {
        "PieCoreChartConfigOption{name='${name}', types='${types}'}"
    }
}