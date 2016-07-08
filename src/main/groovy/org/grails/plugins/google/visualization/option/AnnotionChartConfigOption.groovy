/* Copyright 2016 the original author or authors.
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
 * Annotion Chart configuration options
 *
 * @author <a href='mailto:robertoschwald@gmail.com'>Robert Oschwald</a>
 * @see <a href="https://developers.google.com/chart/interactive/docs/gallery/annotationchart#configuration-options">Configuration Options</a>
 */
enum AnnotionChartConfigOption {
    ALLOW_HTML("allowHtml", [DataType.BOOLEAN]),
    ALL_VALUES_SUFFIX("allValuesSuffix", [DataType.STRING]),
    ANNOTATATIONS_WIDTH("annotationsWidth", [DataType.NUMBER]),
    COLORS("colors", [DataType.ARRAY]),
    DATE_FORMAT("dateFormat", [DataType.STRING]),
    DISPLAY_ANNOTATIONS("displayAnnotations", [DataType.BOOLEAN]),
    DISPLAY_ANNOTATIONS_FILTER("displayAnnotationsFilter", [DataType.BOOLEAN]),
    DISPLAY_DATE_BAR_SEPARATOR("displayDateBarSeparator", [DataType.BOOLEAN]),
    DISPLAY_EXACT_VALUES("displayExactValues", [DataType.BOOLEAN]),
    DISPLAY_LEGEND_DOTS("displayLegendDots", [DataType.BOOLEAN]),
    DISPLAY_LEGEND_VALUES("displayLegendValues", [DataType.BOOLEAN]),
    DISPLAY_RANGE_SELECTOR("displayRangeSelector", [DataType.BOOLEAN]),
    DISPLAY_ZOOM_BUTTONS("displayZoomButtons", [DataType.BOOLEAN]),
    FILL("fill", [DataType.NUMBER]),
    LEGEND_POSITION("legendPosition", [DataType.STRING]),
    MAX("max", [DataType.NUMBER]),
    MIN("min", [DataType.NUMBER]),
    NUMBER_FORMATS("numberFormats", [DataType.STRING, DataType.MAP]),
    SCALE_COLUMNS("scaleColumns", [DataType.ARRAY]),
    SCALE_FORMAT("scaleFormat", [DataType.STRING]),
    SCALE_TYPE("scaleType", [DataType.STRING]),
    TABLE("table", [DataType.OBJECT]),
    TABLE_SORT_ASCENDENDING("table.sortAscending", [DataType.BOOLEAN]),
    TABLE_SORT_COLUMN("table.sortColumn", [DataType.NUMBER]),
    THICKNESS("thickness", [DataType.NUMBER]),
    ZOOM_END_TIME("zoomEndTime", [DataType.DATE]),
    ZOOM_START_TIME("zoomStartTime", [DataType.DATE])

    static final Map configOptions

    static {
        configOptions = [:]

        values().each { configOption ->
            configOptions.put(configOption.name, configOption)
        }
    }

    private final name
    private final types

    AnnotionChartConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    String toString() {
        "AnnotionChartConfigOption{name='${name}', types='${types}'}"
    }
}