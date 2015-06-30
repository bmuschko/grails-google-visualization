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
 * Column Core Chart configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 * @see <a href="https://developers.google.com/chart/interactive/docs/gallery/columnchart#Configuration_Options">Configuration Options</a>
 */
enum ColumnCoreChartConfigOption {
    ANIMATION("animation", [DataType.OBJECT, DataType.MAP]),
    ANNOTATIONS("annotations", [DataType.OBJECT, DataType.MAP]),
    AXIS_TITLES_POSITION("axisTitlesPosition", [DataType.STRING]),
    BACKGROUND_COLOR("backgroundColor", [DataType.STRING, DataType.OBJECT, DataType.MAP]),
    BAR("bar", [DataType.OBJECT,DataType.MAP]),
    BARS("bars", [DataType.STRING]),
    CHART_AREA("chartArea", [DataType.OBJECT, DataType.MAP]),
    CHART("chart", [DataType.OBJECT, DataType.MAP]),
    COLORS("colors", [DataType.ARRAY]),
    DATA_OPACITY("dataOpacity", [DataType.NUMBER]),
    ENABLE_INTERACTIVITY("enableInteractivity", [DataType.BOOLEAN]),
    FOCUS_TARGET("focusTarget", [DataType.STRING]),
    FONT_SIZE("fontSize", [DataType.NUMBER]),
    FONT_NAME("fontName", [DataType.STRING]),
    FORCE_IFRAME("forceIFrame", [DataType.BOOLEAN]),
    H_AXIS("hAxis", [DataType.OBJECT, DataType.MAP]),
    HEIGHT("height", [DataType.NUMBER, DataType.STRING]),
    IS_STACKED("isStacked", [DataType.BOOLEAN]),
    LEGEND("legend", [DataType.STRING, DataType.OBJECT, DataType.MAP]),
    ORIENTATION("orientation", [DataType.STRING]),
    REVERSE_CATEGORIES("reverseCategories", [DataType.BOOLEAN]),
    SERIES("series", [DataType.ARRAY, DataType.OBJECT, DataType.MAP]),
    THEME("theme", [DataType.STRING]),
    TITLE("title", [DataType.STRING]),
    TITLE_POSITION("titlePosition", [DataType.STRING]),
    TITLE_TEXT_STYLE("titleTextStyle", [DataType.OBJECT, DataType.MAP]),
    TOOLTIP("tooltip", [DataType.OBJECT, DataType.MAP]),
    TRENDLINES("trendlines", [DataType.OBJECT, DataType.MAP]),
    V_AXES("vAxes", [DataType.ARRAY, DataType.OBJECT, DataType.MAP]),
    V_AXIS("vAxis", [DataType.OBJECT, DataType.MAP]),
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

    private ColumnCoreChartConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    String toString() {
        "ColumnCoreChartConfigOption{name='${name}', types='${types}'}"
    }
}
