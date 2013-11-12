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

import org.apache.commons.lang.StringUtils

/**
 * Object renderer
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
@Singleton
class ObjectRenderer implements DataTypeRenderer {
    @Override
    def renderValue(value) {
        def objectValues = []

        value.properties.each { propertyKey, propertyValue ->
            // Only use class fields
            if(propertyKey != 'class' && propertyKey != 'metaClass') {
                objectValues << "${propertyKey}: ${DataTypeValueRenderer.instance.render(propertyValue).value}"
            }
        }

        "{${StringUtils.join(objectValues, ', ')}}"
    }
}
