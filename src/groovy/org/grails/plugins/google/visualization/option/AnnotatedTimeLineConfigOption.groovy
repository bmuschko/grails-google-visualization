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
 * Annotated Time Line configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum AnnotatedTimeLineConfigOption {
    ALLOW_HTML("allowHtml", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    ALLOW_REDRAW("allowRedraw", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    ALL_VALUES_SUFFIX("allValuesSuffix", [GoogleVisualizationConfigOptionType.STRING]),
    ANNOTATATIONS_WIDTH("annotationsWidth", [GoogleVisualizationConfigOptionType.NUMBER]),
    COLORS("colors", [GoogleVisualizationConfigOptionType.ARRAY]),
    DATE_FORMAT("dateFormat", [GoogleVisualizationConfigOptionType.STRING]),
    DISPLAY_ANNOTATIONS("displayAnnotations", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    DISPLAY_ANNOTATIONS_FILTER("displayAnnotationsFilter", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    DISPLAY_DATE_BAR_SEPARATOR("displayDateBarSeparator", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    DISPLAY_EXACT_VALUES("displayExactValues", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    DISPLAY_LEGEND_DOTS("displayLegendDots", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    DISPLAY_LEGEND_VALUES("displayLegendValues", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    DISPLAY_RANGE_SELECTOR("displayRangeSelector", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    DISPLAY_ZOOM_BUTTONS("displayZoomButtons", [GoogleVisualizationConfigOptionType.BOOLEAN]),
    FILL("fill", [GoogleVisualizationConfigOptionType.NUMBER]),
    HIGHLIGHT_DOT("highlightDot", [GoogleVisualizationConfigOptionType.STRING]),
    LEGEND_POSITION("legendPosition", [GoogleVisualizationConfigOptionType.STRING]),
    MAX("max", [GoogleVisualizationConfigOptionType.NUMBER]),
    MIN("min", [GoogleVisualizationConfigOptionType.NUMBER]),
    NUMBER_FORMATS("numberFormats", [GoogleVisualizationConfigOptionType.STRING, GoogleVisualizationConfigOptionType.MAP]),
    SCALE_COLUMNS("scaleColumns", [GoogleVisualizationConfigOptionType.ARRAY]),
    SCALE_TYPE("scaleType", [GoogleVisualizationConfigOptionType.STRING]),
    THICKNESS("thickness", [GoogleVisualizationConfigOptionType.NUMBER]),
    WMODE("wmode", [GoogleVisualizationConfigOptionType.STRING]),
    ZOOM_END_TIME("zoomEndTime", [GoogleVisualizationConfigOptionType.DATE]),
    ZOOM_START_TIME("zoomStartTime", [GoogleVisualizationConfigOptionType.DATE])

    static final Map configOptions

    static {
        configOptions = [:]

        values().each { configOption ->
            configOptions.put(configOption.name, configOption)
        }
    }

    private final name
    private final types

    AnnotatedTimeLineConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    public String toString() {
        "AnnotatedTimeLineConfigOption{name='${name}', types='${types}'}"
    }
}