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
package org.grails.plugins.google.visualization

/**
 * Taglib for rendering the data based on the visualization type
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class GoogleVisualizationDataRendererTagLib {
    static namespace = "gvisualizationinternal"
    final CELL_PACKAGE_NAMES = [GoogleVisualization.TABLE.packageName, GoogleVisualization.MAP.packageName, GoogleVisualization.ANNOTATED_TIME_LINE.packageName] as Set

    def renderData = { attrs, body ->
        if(isCellSetter(attrs.packageName)) {
            out << "data.setCell(${attrs.row});"
        }
        else {
            out << "data.setValue(${attrs.row});"
        }
    }

    def isCellSetter(packageName) {
        CELL_PACKAGE_NAMES.contains(packageName) ? true : false
    }
}
