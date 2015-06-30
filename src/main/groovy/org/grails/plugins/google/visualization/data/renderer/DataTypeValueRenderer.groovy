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
package org.grails.plugins.google.visualization.data.renderer

import org.grails.plugins.google.visualization.data.DataType

/**
 * Data type value renderer
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
@Singleton
class DataTypeValueRenderer {
    /**
     * Renders configuration option
     *
     * @param value Value
     * @return Configuration option
     */
    def render(value) {
        if(value instanceof String) {
            new RenderedValue(DataType.STRING, StringRenderer.instance.renderValue(value))
        }
        else if(value instanceof Number) {
            new RenderedValue(DataType.NUMBER, NumberAndBooleanRenderer.instance.renderValue(value))
        }
        else if(value instanceof Boolean) {
            new RenderedValue(DataType.BOOLEAN, NumberAndBooleanRenderer.instance.renderValue(value))
        }
        else if(value instanceof Date) {
            new RenderedValue(DataType.DATE, DateRenderer.instance.renderValue(value))
        }
        else if(value instanceof Collection || value instanceof Object[]) {
            new RenderedValue(DataType.ARRAY, ArrayRenderer.instance.renderValue(value))
        }
        else if(value instanceof Map) {
            new RenderedValue(DataType.MAP, MapRenderer.instance.renderValue(value))
        }
        else {
            new RenderedValue(DataType.OBJECT, ObjectRenderer.instance.renderValue(value))
        }
    }
}
