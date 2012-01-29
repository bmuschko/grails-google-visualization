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
package org.grails.plugins.google.visualization.event

import org.apache.commons.logging.LogFactory
import org.apache.commons.logging.Log

/**
 * Available events for visualization "Organizational Chart"
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum OrgChartEvent {
    COLLAPSE('collapse'), ONMOUSEOVER('onmouseover'), ONMOUSEOUT('onmouseout'), READY('ready'), SELECT('select')

    static final Log log = LogFactory.getLog(OrgChartEvent)
    static final Map events

    static {
        events = [:]

        values().each { event ->
            events.put(event.name, event)
        }
    }

    private final name

    private OrgChartEvent(name) {
        this.name = name
    }

    @Override
    String toString() {
        "OrgChartEvent{name='${name}'}"
    }
}