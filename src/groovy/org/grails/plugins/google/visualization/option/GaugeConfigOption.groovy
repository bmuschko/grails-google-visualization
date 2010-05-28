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
 * Gauge configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum GaugeConfigOption {
    GREEN_FROM("greenFrom", [GoogleVisualizationConfigOptionType.NUMBER]),
    GREEN_TO("greenTo", [GoogleVisualizationConfigOptionType.NUMBER]),
    HEIGHT("height", [GoogleVisualizationConfigOptionType.NUMBER]),
    MAJOR_TICKS("majorTicks", [GoogleVisualizationConfigOptionType.ARRAY]),
    MAX("max", [GoogleVisualizationConfigOptionType.NUMBER]),
    MIN("min", [GoogleVisualizationConfigOptionType.NUMBER]),
    MINOR_TICKS("minorTicks", [GoogleVisualizationConfigOptionType.NUMBER]),
    RED_FROM("redFrom", [GoogleVisualizationConfigOptionType.NUMBER]),
    RED_TO("redTo", [GoogleVisualizationConfigOptionType.NUMBER]),
    WIDTH("width", [GoogleVisualizationConfigOptionType.NUMBER]),
    YELLOW_FROM("yellowFrom", [GoogleVisualizationConfigOptionType.NUMBER]),
    YELLOW_TO("yellowTo", [GoogleVisualizationConfigOptionType.NUMBER])

    static final Map configOptions

    static {
        configOptions = [:]

        values().each { configOption ->
            configOptions.put(configOption.name, configOption)
        }
    }

    private final name
    private final types

    GaugeConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    public String toString() {
        "GaugeConfigOption{name='${name}', types='${types}'}"
    }
}