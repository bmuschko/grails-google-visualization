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
 * Organizational Chart configuration options
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum OrgChartConfigOption {
    ALLOW_COLLAPSE("allowCollapse", [DataType.BOOLEAN]),
    ALLOW_HTML("allowHtml", [DataType.BOOLEAN]),
    NODE_CLASS("nodeClass", [DataType.STRING]),
    SELECTED_NODE_CLASS("selectedNodeClass", [DataType.STRING]),
    SIZE("size", [DataType.STRING])

    static final Map configOptions

    static {
        configOptions = [:]

        values().each { configOption ->
            configOptions.put(configOption.name, configOption)
        }
    }

    private final name
    private final types

    OrgChartConfigOption(name, types) {
        this.name = name
        this.types = types
    }

    @Override
    String toString() {
        "OrgChartConfigOption{name='${name}', types='${types}'}"
    }
}