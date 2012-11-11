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
package org.grails.plugins.google.visualization.option.deprecated

import org.grails.plugins.google.visualization.data.DataType

/**
 * Scatter Chart configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum ScatterChartConfigOption {
    AXIS_COLOR("axisColor", [DataType.STRING, DataType.OBJECT]),
    AXIS_BACKGROUND_COLOR("axisBackgroundColor", [DataType.STRING, DataType.OBJECT]),
    AXIS_FONT_SIZE("axisFontSize", [DataType.NUMBER]),
    BACKGROUND_COLOR("backgroundColor", [DataType.STRING, DataType.OBJECT]),
    BORDER_COLOR("borderColor", [DataType.STRING, DataType.OBJECT]),
    COLORS("colors", [DataType.ARRAY]),
    ENABLE_TOOLTIP("enableTooltip", [DataType.BOOLEAN]),
    FOCUS_BORDER_COLOR("focusBorderColor", [DataType.STRING, DataType.OBJECT]),
    HEIGHT("height", [DataType.NUMBER, DataType.STRING]),
    LEGEND("legend", [DataType.STRING]),
    LEGEND_BACKGROUND_COLOR("legendBackgroundColor", [DataType.STRING, DataType.OBJECT]),
    LEGEND_FONT_SIZE("legendFontSize", [DataType.NUMBER]),
    LEGEND_TEXT_COLOR("legendTextColor", [DataType.STRING, DataType.OBJECT]),
    LINE_SIZE("lineSize", [DataType.NUMBER]),
    LOG_SCALE("logScale", [DataType.BOOLEAN]),
    LOG_SCALE_X("logScaleX", [DataType.BOOLEAN]),
    MAX("max", [DataType.NUMBER]),
    MIN("min", [DataType.NUMBER]),
    POINT_SIZE("pointSize", [DataType.NUMBER]),
    TITLE("title", [DataType.STRING]),
    TITLE_X("titleX", [DataType.STRING]),
    TITLE_Y("titleY", [DataType.STRING]),
    TITLE_COLOR("titleColor", [DataType.STRING, DataType.OBJECT]),
    TITLE_FONT_SIZE("titleFontSize", [DataType.NUMBER]),
    TOOLTIP_FONT_SIZE("tooltipFontSize", [DataType.NUMBER]),
    TOOLTIP_HEIGHT("tooltipHeight", [DataType.NUMBER]),
    TOOLTIP_WIDTH("tooltipWidth", [DataType.NUMBER]),
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

    ScatterChartConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    String toString() {
        "ScatterChartConfigOption{name='${name}', types='${types}'}"
    }
}