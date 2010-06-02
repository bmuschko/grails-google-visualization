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

/**
 * Tree Map configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum TreeMapConfigOption {
    HEADER_COLOR("headerColor", [GoogleVisualizationConfigOptionType.STRING]),
    HEADER_HEIGHT("headerHeight", [GoogleVisualizationConfigOptionType.NUMBER]),
    HEADER_HIGHLIGHT_COLOR("headerHighlightColor", [GoogleVisualizationConfigOptionType.STRING]),
    MAX_COLOR("maxColor", [GoogleVisualizationConfigOptionType.STRING]),
    MAX_DEPTH("maxDepth", [GoogleVisualizationConfigOptionType.NUMBER]),
    MAX_HIGHLIGHT_COLOR("maxHighlightColor", [GoogleVisualizationConfigOptionType.STRING]),
    MAX_POST_DEPTH("maxPostDepth", [GoogleVisualizationConfigOptionType.NUMBER]),
    MAX_COLOR_VALUE("maxColorValue", [GoogleVisualizationConfigOptionType.NUMBER]),
    MID_COLOR("midColor", [GoogleVisualizationConfigOptionType.STRING]),
    MID_HIGHLIGHT_COLOR("midHighlightColor", [GoogleVisualizationConfigOptionType.STRING]),
    MIN_COLOR("minColor", [GoogleVisualizationConfigOptionType.STRING]),
    MIN_HIGHLIGHT_COLOR("minHighlightColor", [GoogleVisualizationConfigOptionType.STRING]),
    MIN_COLOR_VALUE("minColorValue", [GoogleVisualizationConfigOptionType.NUMBER]),
    NO_COLOR("noColor", [GoogleVisualizationConfigOptionType.STRING]),
    NO_HIGHLIGHT_COLOR("noHighlightColor", [GoogleVisualizationConfigOptionType.STRING]),
    SHOW_SCALE("showScale", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    FONT_COLOR("fontColor", [GoogleVisualizationConfigOptionType.STRING]),
    FONT_FAMILY("fontFamily", [GoogleVisualizationConfigOptionType.STRING]),
    FONT_SIZE("fontSize", [GoogleVisualizationConfigOptionType.NUMBER])

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
    public String toString() {
        "TreeMapConfigOption{name='${name}', types='${types}'}"
    }
}
