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
 * Table configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum TableConfigOption {
    ALLOW_HTML("allowHtml", [DataType.BOOLEAN]),
    ALTERNATING_ROW_STYLE("alternatingRowStyle", [DataType.BOOLEAN]),
    CSS_CLASS_NAME("cssClassNames", [DataType.OBJECT]),
    FIRST_ROW_NUMBER("firstRowNumber", [DataType.NUMBER]),
    HEIGHT("height", [DataType.NUMBER, DataType.STRING]),
    PAGE("page", [DataType.STRING]),
    PAGE_SIZE("pageSize", [DataType.NUMBER]),
    RTL_TABLE("rtlTable", [DataType.BOOLEAN]),
    SCROLL_LEFT_START_POSITION("scrollLeftStartPosition", [DataType.NUMBER]),
    SHOW_ROW_NUMBER("showRowNumber", [DataType.BOOLEAN]),
    SORT("sort", [DataType.STRING]),
    SORT_ASCENDING("sortAscending", [DataType.BOOLEAN]),
    SORT_COLUMN("sortColumn", [DataType.NUMBER]),
    START_PAGE("startPage", [DataType.NUMBER]),
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

    TableConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    String toString() {
        "TableConfigOption{name='${name}', types='${types}'}"
    }
}