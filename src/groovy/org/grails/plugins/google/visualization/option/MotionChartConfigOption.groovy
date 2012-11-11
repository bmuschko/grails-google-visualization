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
 * Motion Chart configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum MotionChartConfigOption {
    HEIGHT("height", [DataType.NUMBER, DataType.STRING]),
    WIDTH("width", [DataType.NUMBER, DataType.STRING]),
    STATE("state", [DataType.STRING]),
    SHOW_CHART_BUTTON("showChartButtons", [DataType.BOOLEAN]),
    SHOW_HEADER("showHeader", [DataType.BOOLEAN]),
    SHOW_SELECT_LIST_COMPONENT("showSelectListComponent", [DataType.BOOLEAN]),
    SHOW_SIDE_PANEL("showSidePanel", [DataType.BOOLEAN]),
    SHOW_X_METRIC_PANEL("showXMetricPicker", [DataType.BOOLEAN]),
    SHOW_Y_METRIC_PANEL("showYMetricPicker", [DataType.BOOLEAN]),
    SHOW_X_SCALE_PICKER("showXScalePicker", [DataType.BOOLEAN]),
    SHOW_Y_SCALE_PICKER("showYScalePicker", [DataType.BOOLEAN]),
    SHOW_ADVANCED_PANEL("showAdvancedPanel", [DataType.BOOLEAN])

    static final Map configOptions

    static {
        configOptions = [:]

        values().each { configOption ->
            configOptions.put(configOption.name, configOption)
        }
    }

    private final name
    private final types

    MotionChartConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    String toString() {
        "MotionChartConfigOption{name='${name}', types='${types}'}"
    }
}