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
 * Bar Chart configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum BarChartConfigOption {
    AXIS_COLOR("axisColor", [GoogleVisualizationConfigOptionType.STRING, GoogleVisualizationConfigOptionType.OBJECT]),
    AXIS_BACKGROUND_COLOR("axisBackgroundColor", [GoogleVisualizationConfigOptionType.STRING, GoogleVisualizationConfigOptionType.OBJECT]),
    AXIS_FONT_SIZE("axisFontSize", [GoogleVisualizationConfigOptionType.NUMBER]),
    BACKGROUND_COLOR("backgroundColor", [GoogleVisualizationConfigOptionType.STRING, GoogleVisualizationConfigOptionType.OBJECT]),
    BORDER_COLOR("borderColor", [GoogleVisualizationConfigOptionType.STRING, GoogleVisualizationConfigOptionType.OBJECT]),
    COLORS("colors", [GoogleVisualizationConfigOptionType.ARRAY]),
    ENABLE_TOOLTIP("enableTooltip", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    FOCUS_BORDER_COLOR("focusBorderColor", [GoogleVisualizationConfigOptionType.STRING, GoogleVisualizationConfigOptionType.OBJECT]),
    HEIGHT("height", [GoogleVisualizationConfigOptionType.NUMBER]),
    IS_3D("is3D", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    IS_STACKED("isStacked", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    LEGEND("legend", [GoogleVisualizationConfigOptionType.STRING]),
    LEGEND_BACKGROUND_COLOR("legendBackgroundColor", [GoogleVisualizationConfigOptionType.STRING, GoogleVisualizationConfigOptionType.OBJECT]),
    LEGEND_FONT_SIZE("legendFontSize", [GoogleVisualizationConfigOptionType.NUMBER]),
    LEGEND_TEXT_COLOR("legendTextColor", [GoogleVisualizationConfigOptionType.STRING, GoogleVisualizationConfigOptionType.OBJECT]),
    LOG_SCALE("logScale", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    MAX("max", [GoogleVisualizationConfigOptionType.NUMBER]),
    MIN("min", [GoogleVisualizationConfigOptionType.NUMBER]),
    REVERSE_AXIS("reverseAxis", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    SHOW_CATEGORIES("showCategories", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    TITLE("title", [GoogleVisualizationConfigOptionType.STRING]),
    TITLE_X("titleX", [GoogleVisualizationConfigOptionType.STRING]),
    TITLE_Y("titleY", [GoogleVisualizationConfigOptionType.STRING]),
    TITLE_COLOR("titleColor", [GoogleVisualizationConfigOptionType.STRING, GoogleVisualizationConfigOptionType.OBJECT]),
    TITLE_FONT_SIZE("titleFontSize", [GoogleVisualizationConfigOptionType.NUMBER]),
    TOOLTIP_FONT_SIZE("tooltipFontSize", [GoogleVisualizationConfigOptionType.NUMBER]),
    TOOLTIP_HEIGHT("tooltipHeight", [GoogleVisualizationConfigOptionType.NUMBER]),
    TOOLTIP_WIDTH("tooltipWidth", [GoogleVisualizationConfigOptionType.NUMBER]),
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

    BarChartConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    public String toString() {
        "BarChartConfigOption{name='${name}', types='${types}'}"
    }
}
