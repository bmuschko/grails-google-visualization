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

import org.grails.plugins.google.visualization.option.GoogleVisualizationConfigOptionType

/**
 * Area Core Chart configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum AreaCoreChartConfigOption {
    BACKGROUND_COLOR("backgroundColor", [GoogleVisualizationConfigOptionType.STRING]),
    COLORS("colors", [GoogleVisualizationConfigOptionType.ARRAY]),
    FONT_SIZE("fontSize", [GoogleVisualizationConfigOptionType.NUMBER]),
    H_AXIS("hAxis", [GoogleVisualizationConfigOptionType.OBJECT]),
    HEIGHT("height", [GoogleVisualizationConfigOptionType.NUMBER]),
    IS_STACKED("isStacked", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    LEGEND("legend", [GoogleVisualizationConfigOptionType.STRING]),
    LEGEND_FONT_SIZE("legendFontSize", [GoogleVisualizationConfigOptionType.NUMBER]),
    LEGEND_TEXT_COLOR("legendTextColor", [GoogleVisualizationConfigOptionType.STRING]),
    LINE_WIDTH("lineWidth", [GoogleVisualizationConfigOptionType.NUMBER]),
    POINT_SIZE("pointSize", [GoogleVisualizationConfigOptionType.NUMBER]),
    REVERSE_CATEGORIES("reverseCategories", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    TITLE("title", [GoogleVisualizationConfigOptionType.STRING]),
    TITLE_COLOR("titleColor", [GoogleVisualizationConfigOptionType.STRING]),
    TITLE_FONT_SIZE("titleFontSize", [GoogleVisualizationConfigOptionType.NUMBER]),
    TOOLTIP_FONT_SIZE("tooltipFontSize", [GoogleVisualizationConfigOptionType.NUMBER]),
    V_AXIS("vAxis", [GoogleVisualizationConfigOptionType.OBJECT]),
    WIDTH("width", [GoogleVisualizationConfigOptionType.NUMBER])

    static final Map configOptions

    static {
        configOptions = [:]

        values().each { configOption ->
            configOptions.put(configOption.name, configOption)
        }
    }

    private final name
    private final types

    AreaCoreChartConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    public String toString() {
        "AreaCoreChartConfigOption{name='${name}', types='${types}'}"
    }
}