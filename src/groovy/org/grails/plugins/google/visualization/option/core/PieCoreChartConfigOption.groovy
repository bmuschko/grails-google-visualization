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
    BACKGROUND_COLOR("backgroundColor", [DataType.STRING, DataType.OBJECT]),
    CHART_AREA("chartArea", [DataType.OBJECT]),
    COLORS("colors", [DataType.ARRAY]),
    FONT_SIZE("fontSize", [DataType.NUMBER]),
    FONT_NAME("fontName", [DataType.STRING]),
    HEIGHT("height", [DataType.NUMBER, DataType.STRING]),
    IS_3D("is3D", [DataType.BOOLEAN]),
    LEGEND("legend", [DataType.STRING]),
    LEGEND_TEXT_STYLE("legendTextStyle", [DataType.OBJECT]),
    PIE_SLICE_TEXT("pieSliceText", [DataType.STRING]),
    PIE_SLICE_TEXT_STYLE("pieSliceTextStyle", [DataType.OBJECT]),
    REVERSE_CATEGORIES("reverseCategories", [DataType.BOOLEAN]),
    SLICE_VISIBILITY_THRESHOLD("sliceVisibilityThreshold", [DataType.NUMBER]),
    PIE_RESIDUE_SLICE_COLOR("pieResidueSliceColor", [DataType.STRING]),
    PIE_RESIDUE_SLICE_LABEL("pieResidueSliceLabel", [DataType.STRING]),
    TITLE("title", [DataType.STRING]),
    TITLE_TEXT_STYLE("titleTextStyle", [DataType.OBJECT]),
    TOOLTIP_TEXT("tooltipText", [DataType.STRING]),
    TOOLTIP_TEXT_STYLE("tooltipTextStyle", [DataType.OBJECT]),
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

    private PieCoreChartConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    String toString() {
        "PieCoreChartConfigOption{name='${name}', types='${types}'}"
    }
}