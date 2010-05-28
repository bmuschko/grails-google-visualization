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
package org.grails.plugins.google.visualization.util

import org.apache.commons.lang.StringEscapeUtils
import org.apache.commons.lang.StringUtils
import org.grails.plugins.google.visualization.option.GoogleVisualizationConfigOptionType

/**
 * Configuration option render utility
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
@Singleton
final class ConfigOptionRendererUtil {
    /**
     * Render configuration option
     *
     * @param configOption Configuration option
     * @param value Value
     * @return Resolved configuration option
     */
    static render(configOption, value) {
        def allowedTypes = configOption.types
        def resolvedConfigOption = resolveConfigOption(value)

        if(!allowedTypes.contains(resolvedConfigOption.type)) {
            throw new IllegalArgumentException("Unsupported configuration type '${resolvedConfigOption.type}'. Allowed types: ${allowedTypes}")
        }

        resolvedConfigOption
    }

    /**
     * Resolves configuration option
     *
     * @param value Value
     * @return Configuration option
     */
    static resolveConfigOption(value) {
        if(value instanceof String) {
            new ResolvedConfigOption(GoogleVisualizationConfigOptionType.STRING, renderStringValue(value))
        }
        else if(value instanceof Number) {
            new ResolvedConfigOption(GoogleVisualizationConfigOptionType.NUMBER, renderNumberOrBooleanValue(value))
        }
        else if(value instanceof Boolean) {
            new ResolvedConfigOption(GoogleVisualizationConfigOptionType.BOOLEAN, renderNumberOrBooleanValue(value))
        }
        else if(value instanceof Date) {
            new ResolvedConfigOption(GoogleVisualizationConfigOptionType.DATE, renderDateValue(value))
        }
        else if(value instanceof Collection || value instanceof Object[]) {
            new ResolvedConfigOption(GoogleVisualizationConfigOptionType.ARRAY, renderArrayValue(value))
        }
        else if(value instanceof Map) {
            new ResolvedConfigOption(GoogleVisualizationConfigOptionType.MAP, renderMapValue(value))
        }
        else {
            new ResolvedConfigOption(GoogleVisualizationConfigOptionType.OBJECT, renderObjectValue(value))
        }
    }

    /**
     * Renders String value
     *
     * @param value Value
     * @return Rendered value
     */
    static renderStringValue(value) {
        "'${StringEscapeUtils.escapeJavaScript(value)}'"
    }

    /**
     * Renders number or boolean value
     *
     * @param value Value
     * @return Rendered value
     */
    static renderNumberOrBooleanValue(value) {
        value
    }

    /**
     * Renders date value
     *
     * @param value
     * @return Rendered value
     */
    static renderDateValue(value) {
        DateUtil.createDateTimeJavaScriptObject(value)
    }

    /**
     * Renders array value
     *
     * @param value Value
     * @return Rendered value
     */
    static renderArrayValue(value) {
        def arrayValues = []

        value.each { arrayValue ->
            arrayValues << resolveConfigOption(arrayValue).value
        }

        "[${StringUtils.join(arrayValues, ', ')}]"
    }


    /**
     * Renders map value
     *
     * @param value Value
     * @return Rendered value
     */
    static renderMapValue(value) {
        def mapValues = []

        value.each { mapKey, mapValue ->
            mapValues << "${resolveConfigOption(mapKey).value}: ${resolveConfigOption(mapValue).value}"
        }

        "{${StringUtils.join(mapValues, ', ')}}"
    }

    /**
     * Renders object value
     *
     * @param value Value
     * @return Rendered value
     */
    static renderObjectValue(value) {
        def objectValues = []

        value.properties.each { propertyKey, propertyValue ->
            // Only use class fields
            if(propertyKey != 'class' || propertyKey != 'metaClass') {
                objectValues << "${propertyKey}: ${resolveConfigOption(propertyValue).value}"
            }
        }

        "{${StringUtils.join(objectValues, ', ')}}"
    }
}
