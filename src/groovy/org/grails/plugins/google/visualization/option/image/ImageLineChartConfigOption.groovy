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
package org.grails.plugins.google.visualization.option.image

import org.grails.plugins.google.visualization.option.GoogleVisualizationConfigOptionType

/**
 * Image Line Chart configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum ImageLineChartConfigOption {
    BACKGROUND_COLOR("backgroundColor", [GoogleVisualizationConfigOptionType.STRING]),
    COLORS("colors", [GoogleVisualizationConfigOptionType.ARRAY]),
    ENABLE_EVENTS("enableEvents", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    HEIGHT("height", [GoogleVisualizationConfigOptionType.NUMBER]),
    LEGEND("legend", [GoogleVisualizationConfigOptionType.STRING]),
    MAX("max", [GoogleVisualizationConfigOptionType.NUMBER]),
    MIN("min", [GoogleVisualizationConfigOptionType.NUMBER]),
    SHOW_AXIS_LINES("showAxisLines", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    SHOW_CATEGORY_LABELS("showCategoryLabels", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    SHOW_VALUE_LABELS("showValueLabels", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    TITLE("title", [GoogleVisualizationConfigOptionType.STRING]),
    VALUE_LABELS_INTERVAL("valueLabelsInterval", [GoogleVisualizationConfigOptionType.NUMBER]),
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

    ImageLineChartConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    public String toString() {
        "ImageLineChartConfigOption{name='${name}', types='${types}'}"
    }
}