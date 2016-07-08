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

import spock.lang.Specification

/**
 * Google org.grails.plugins.google.visualization tests
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
class GoogleVisualizationSpec extends Specification {
    void testGetGoogleVisualizationForPackageNameKnown() {
        expect:
        GoogleVisualization.getGoogleVisualizationForPackageName('piechart') == GoogleVisualization.PIE_CHART
        GoogleVisualization.getGoogleVisualizationForPackageName('barchart') == GoogleVisualization.BAR_CHART
        GoogleVisualization.getGoogleVisualizationForPackageName('columnchart') == GoogleVisualization.COLUMN_CHART
        GoogleVisualization.getGoogleVisualizationForPackageName('areachart') == GoogleVisualization.AREA_CHART
        GoogleVisualization.getGoogleVisualizationForPackageName('scatterchart') == GoogleVisualization.SCATTER_CHART
        GoogleVisualization.getGoogleVisualizationForPackageName('gauge') == GoogleVisualization.GAUGE
        GoogleVisualization.getGoogleVisualizationForPackageName('linechart') == GoogleVisualization.LINE_CHART
        GoogleVisualization.getGoogleVisualizationForPackageName('table') == GoogleVisualization.TABLE
        GoogleVisualization.getGoogleVisualizationForPackageName('map') == GoogleVisualization.MAP
        GoogleVisualization.getGoogleVisualizationForPackageName('annotatedtimeline') == GoogleVisualization.ANNOTATED_TIME_LINE
        GoogleVisualization.getGoogleVisualizationForPackageName('annotationChart') == GoogleVisualization.ANNOTATION_CHART
        GoogleVisualization.getGoogleVisualizationForPackageName('orgchart') == GoogleVisualization.ORG_CHART
        GoogleVisualization.getGoogleVisualizationForPackageName('intensitymap') == GoogleVisualization.INTENSITY_MAP
        GoogleVisualization.getGoogleVisualizationForPackageName('geomap') == GoogleVisualization.GEO_MAP
        GoogleVisualization.getGoogleVisualizationForPackageName('motionchart') == GoogleVisualization.MOTION_CHART
    }

    void testGetGoogleVisualizationForPackageNameUnknown() {
        when:
        GoogleVisualization.getGoogleVisualizationForPackageName('unknown')
        then:
        thrown(IllegalArgumentException)
    }

    void testToString() {
        setup:
        def expected = "GoogleVisualization{packageName='piechart', object='google.visualization.PieChart', configOptions='[backgroundColor:PieChartConfigOption{name='backgroundColor', types='[STRING, OBJECT, MAP]'}, borderColor:PieChartConfigOption{name='borderColor', types='[STRING, OBJECT, MAP]'}, colors:PieChartConfigOption{name='colors', types='[ARRAY]'}, enableTooltip:PieChartConfigOption{name='enableTooltip', types='[BOOLEAN]'}, focusBorderColor:PieChartConfigOption{name='focusBorderColor', types='[STRING, OBJECT, MAP]'}, height:PieChartConfigOption{name='height', types='[NUMBER, STRING]'}, is3D:PieChartConfigOption{name='is3D', types='[BOOLEAN]'}, legend:PieChartConfigOption{name='legend', types='[STRING]'}, legendBackgroundColor:PieChartConfigOption{name='legendBackgroundColor', types='[STRING, OBJECT, MAP]'}, legendFontSize:PieChartConfigOption{name='legendFontSize', types='[NUMBER]'}, legendTextColor:PieChartConfigOption{name='legendTextColor', types='[STRING, OBJECT, MAP]'}, pieJoinAngle:PieChartConfigOption{name='pieJoinAngle', types='[NUMBER]'}, pieMinimalAngle:PieChartConfigOption{name='pieMinimalAngle', types='[NUMBER]'}, title:PieChartConfigOption{name='title', types='[STRING]'}, titleColor:PieChartConfigOption{name='titleColor', types='[STRING, OBJECT, MAP]'}, titleFontSize:PieChartConfigOption{name='titleFontSize', types='[NUMBER]'}, tooltipFontSize:PieChartConfigOption{name='tooltipFontSize', types='[NUMBER]'}, tooltipHeight:PieChartConfigOption{name='tooltipHeight', types='[NUMBER]'}, tooltipWidth:PieChartConfigOption{name='tooltipWidth', types='[NUMBER]'}, width:PieChartConfigOption{name='width', types='[NUMBER, STRING]'}]', events='[error:DefaultEvent{name='error'}, onmouseover:DefaultEvent{name='onmouseover'}, onmouseout:DefaultEvent{name='onmouseout'}, ready:DefaultEvent{name='ready'}, select:DefaultEvent{name='select'}]'}"
        expect:
        GoogleVisualization.PIE_CHART.toString() == expected
    }
}
