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

import org.grails.plugins.google.visualization.data.renderer.DataTypeValueRenderer

/**
 * Configuration option render utility
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
final class ConfigOptionRendererUtil {
    private ConfigOptionRendererUtil() {}

    /**
     * Render configuration option
     *
     * @param configOption Configuration option
     * @param value Value
     * @return Resolved configuration option
     */
    static render(configOption, value) {
        def allowedTypes = configOption.types
        def resolvedConfigOption = DataTypeValueRenderer.instance.render(value)

        if(!allowedTypes.contains(resolvedConfigOption.type)) {
            throw new IllegalArgumentException("Unsupported configuration type '${resolvedConfigOption.type}'. Allowed types: ${allowedTypes}")
        }

        resolvedConfigOption
    }
}
