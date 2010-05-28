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

import grails.test.*

/**
 * Google visualization data renderer taglib tests
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class GoogleVisualizationDataRendererTagLibTests extends TagLibUnitTestCase {
    void testRenderDataForPieChart() {
        tagLib.renderData(['packageName':GoogleVisualization.PIE_CHART.packageName, 'row':'someRow']) { }
        assertEquals 'data.setValue(someRow);', tagLib.out.toString()
    }

    void testRenderDataForBarChart() {
        tagLib.renderData(['packageName':GoogleVisualization.BAR_CHART.packageName, 'row':'someRow']) { }
        assertEquals 'data.setValue(someRow);', tagLib.out.toString()
    }

    void testRenderDataForColumnChart() {
        tagLib.renderData(['packageName':GoogleVisualization.COLUMN_CHART.packageName, 'row':'someRow']) { }
        assertEquals 'data.setValue(someRow);', tagLib.out.toString()
    }

    void testRenderDataForAreaChart() {
        tagLib.renderData(['packageName':GoogleVisualization.AREA_CHART.packageName, 'row':'someRow']) { }
        assertEquals 'data.setValue(someRow);', tagLib.out.toString()
    }

    void testRenderDataForScatterChart() {
        tagLib.renderData(['packageName':GoogleVisualization.SCATTER_CHART.packageName, 'row':'someRow']) { }
        assertEquals 'data.setValue(someRow);', tagLib.out.toString()
    }

    void testRenderDataForGauge() {
        tagLib.renderData(['packageName':GoogleVisualization.GAUGE.packageName, 'row':'someRow']) { }
        assertEquals 'data.setValue(someRow);', tagLib.out.toString()
    }

    void testRenderDataForLineChart() {
        tagLib.renderData(['packageName':GoogleVisualization.LINE_CHART.packageName, 'row':'someRow']) { }
        assertEquals 'data.setValue(someRow);', tagLib.out.toString()
    }

    void testRenderDataForTable() {
        tagLib.renderData(['packageName':GoogleVisualization.TABLE.packageName, 'row':'someRow']) { }
        assertEquals 'data.setCell(someRow);', tagLib.out.toString()
    }

    void testRenderDataForMap() {
        tagLib.renderData(['packageName':GoogleVisualization.MAP.packageName, 'row':'someRow']) { }
        assertEquals 'data.setCell(someRow);', tagLib.out.toString()
    }

    void testRenderDataForAnnotatedTimeLine() {
        tagLib.renderData(['packageName':GoogleVisualization.ANNOTATED_TIME_LINE.packageName, 'row':'someRow']) { }
        assertEquals 'data.setCell(someRow);', tagLib.out.toString()
    }

    void testRenderDataForOrgChart() {
        tagLib.renderData(['packageName':GoogleVisualization.ORG_CHART.packageName, 'row':'someRow']) { }
        assertEquals 'data.setValue(someRow);', tagLib.out.toString()
    }

    void testRenderDataForIntensityMap() {
        tagLib.renderData(['packageName':GoogleVisualization.INTENSITY_MAP.packageName, 'row':'someRow']) { }
        assertEquals 'data.setValue(someRow);', tagLib.out.toString()
    }

    void testRenderDataForGeoMap() {
        tagLib.renderData(['packageName':GoogleVisualization.GEO_MAP.packageName, 'row':'someRow']) { }
        assertEquals 'data.setValue(someRow);', tagLib.out.toString()
    }

    void testRenderDataForMotionChart() {
        tagLib.renderData(['packageName':GoogleVisualization.MOTION_CHART.packageName, 'row':'someRow']) { }
        assertEquals 'data.setValue(someRow);', tagLib.out.toString()
    }
}
