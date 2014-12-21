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
 * Tree Map configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 * @see <a href="https://developers.google.com/chart/interactive/docs/gallery/treemap#Configuration_Options">Configuration Options</a>
 */
enum TreeMapConfigOption {
    FONT_COLOR("fontColor", [DataType.STRING]),
    FONT_FAMILY("fontFamily", [DataType.STRING]),
    FONT_SIZE("fontSize", [DataType.NUMBER]),
    FORCE_IFRAME("forceIFrame", [DataType.BOOLEAN]),
    HEADER_COLOR("headerColor", [DataType.STRING]),
    HEADER_HEIGHT("headerHeight", [DataType.NUMBER]),
    HEADER_HIGHLIGHT_COLOR("headerHighlightColor", [DataType.STRING]),
    HINT_OPACITY("hintOpacity", [DataType.NUMBER]),
    MAX_COLOR("maxColor", [DataType.STRING]),
    MAX_DEPTH("maxDepth", [DataType.NUMBER]),
    MAX_HIGHLIGHT_COLOR("maxHighlightColor", [DataType.STRING]),
    MAX_POST_DEPTH("maxPostDepth", [DataType.NUMBER]),
    MAX_COLOR_VALUE("maxColorValue", [DataType.NUMBER]),
    MID_COLOR("midColor", [DataType.STRING]),
    MID_HIGHLIGHT_COLOR("midHighlightColor", [DataType.STRING]),
    MIN_COLOR("minColor", [DataType.STRING]),
    MIN_HIGHLIGHT_COLOR("minHighlightColor", [DataType.STRING]),
    MIN_COLOR_VALUE("minColorValue", [DataType.NUMBER]),
    NO_COLOR("noColor", [DataType.STRING]),
    NO_HIGHLIGHT_COLOR("noHighlightColor", [DataType.STRING]),
    SHOW_SCALE("showScale", [DataType.BOOLEAN]),
    SHOW_TOOLTIPS("showTooltips", [DataType.BOOLEAN]),
    TEXT_STYLE("textStyle", [DataType.OBJECT, DataType.MAP]),
    TITLE("title", [DataType.STRING]),
    TITLE_TEXT_STYLE("titleTextStyle", [DataType.OBJECT, DataType.MAP]),
    USE_WEIGHTED_AVERAGE_FOR_AGGREGATION("useWeightedAverageForAggregation", [DataType.BOOLEAN])


    static final Map configOptions

    static {
        configOptions = [:]

        values().each { configOption ->
            configOptions.put(configOption.name, configOption)
        }
    }

    private final name
    private final types

    TreeMapConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    String toString() {
        "TreeMapConfigOption{name='${name}', types='${types}'}"
    }
}
