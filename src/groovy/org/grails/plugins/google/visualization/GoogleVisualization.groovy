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

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.grails.plugins.google.visualization.event.*
import org.grails.plugins.google.visualization.option.*
import org.grails.plugins.google.visualization.option.core.*
import org.grails.plugins.google.visualization.option.deprecated.*
import org.grails.plugins.google.visualization.option.image.*

/**
 * Google visualizations
 *
 * @author <a href='mailto:benjamin.muschko@gmail.com'>Benjamin Muschko</a>
 */
enum GoogleVisualization {
    PIE_CHART('piechart', 'google.visualization.PieChart', PieChartConfigOption.configOptions, DefaultEvent.events),
    BAR_CHART('barchart', 'google.visualization.BarChart', BarChartConfigOption.configOptions, DefaultEvent.events),
    COLUMN_CHART('columnchart', 'google.visualization.ColumnChart', ColumnChartConfigOption.configOptions, DefaultEvent.events),
    AREA_CHART('areachart', 'google.visualization.AreaChart', AreaChartConfigOption.configOptions, DefaultEvent.events),
    SCATTER_CHART('scatterchart', 'google.visualization.ScatterChart', ScatterChartConfigOption.configOptions, DefaultEvent.events),
    GAUGE('gauge', 'google.visualization.Gauge', GaugeConfigOption.configOptions, [:]),
    LINE_CHART('linechart', 'google.visualization.LineChart', LineChartConfigOption.configOptions, DefaultEvent.events),
    TABLE('table', 'google.visualization.Table', TableConfigOption.configOptions, TableEvent.events),
    MAP('map', 'google.visualization.Map', MapConfigOption.configOptions, MapEvent.events),
    ANNOTATED_TIME_LINE('annotatedtimeline', 'google.visualization.AnnotatedTimeLine', AnnotatedTimeLineConfigOption.configOptions, AnnotatedTimeLineEvent.events),
    ORG_CHART('orgchart', 'google.visualization.OrgChart', OrgChartConfigOption.configOptions, OrgChartEvent.events),
    INTENSITY_MAP('intensitymap', 'google.visualization.IntensityMap', IntensityMapConfigOption.configOptions, IntensityMapEvent.events),
    GEO_MAP('geomap', 'google.visualization.GeoMap', GeoMapConfigOption.configOptions, GeoMapEvent.events),
    GEO_CHART('geochart', 'google.visualization.GeoChart', GeoChartConfigOption.configOptions, GeoChartEvent.events),
    MOTION_CHART('motionchart', 'google.visualization.MotionChart', MotionChartConfigOption.configOptions, MotionChartEvent.events),
    PIE_CORE_CHART('corechart', 'google.visualization.PieChart', PieCoreChartConfigOption.configOptions, ErrorAwareDefaultEvent.events),
    BAR_CORE_CHART('corechart', 'google.visualization.BarChart', BarCoreChartConfigOption.configOptions, ErrorAwareDefaultEvent.events),
    COLUMN_CORE_CHART('corechart', 'google.visualization.ColumnChart', ColumnCoreChartConfigOption.configOptions, ErrorAwareDefaultEvent.events),
    AREA_CORE_CHART('corechart', 'google.visualization.AreaChart', AreaCoreChartConfigOption.configOptions, ErrorAwareDefaultEvent.events),
    LINE_CORE_CHART('corechart', 'google.visualization.LineChart', LineCoreChartConfigOption.configOptions, DefaultEvent.events),
    SCATTER_CORE_CHART('corechart', 'google.visualization.ScatterChart', ScatterCoreChartConfigOption.configOptions, DefaultEvent.events),
    CANDLESTICK_CORE_CHART('corechart', 'google.visualization.CandlestickChart', CandlestickCoreChartConfigOption.configOptions, DefaultEvent.events),
    COMBO_CORE_CHART('corechart', 'google.visualization.ComboChart', ComboCoreChartConfigOption.configOptions, DefaultEvent.events),
    TREE_MAP('treemap', 'google.visualization.TreeMap', TreeMapConfigOption.configOptions, TreeMapEvent.events),
    STEPPED_AREA_CORE_CHART('corechart', 'google.visualization.SteppedAreaChart', SteppedAreaCoreChartConfigOption.configOptions, SteppedAreaChartEvent.events),
    BUBBLE_CORE_CHART('corechart', 'google.visualization.BubbleChart', BubbleCoreChartConfigOption.configOptions, BubbleChartEvent.events),
    IMAGE_AREA_CHART('imageareachart', 'google.visualization.ImageAreaChart', ImageAreaChartConfigOption.configOptions, GenericImageChartEvent.events),
    IMAGE_BAR_CHART('imagebarchart', 'google.visualization.ImageBarChart', ImageBarChartConfigOption.configOptions, GenericImageChartEvent.events),
    IMAGE_LINE_CHART('imagelinechart', 'google.visualization.ImageLineChart', ImageLineChartConfigOption.configOptions, GenericImageChartEvent.events),
    IMAGE_PIE_CHART('imagepiechart', 'google.visualization.ImagePieChart', ImagePieChartConfigOption.configOptions, GenericImageChartEvent.events),
    IMAGE_SPARK_LINE('imagesparkline', 'google.visualization.ImageSparkLine', ImageSparkLineConfigOption.configOptions, ImageSparkLineEvent.events),
    IMAGE_CANDLESTICK_CHART('imagechart', 'google.visualization.ImageCandlestickChart', GenericImageChartConfigOption.configOptions.plus(ImageCandlestickChartConfigOption.configOptions), GenericImageChartEvent.events),
    TIME_LINE('timeline', 'google.visualization.Timeline', TimeLineConfigOption.configOptions, DefaultEvent.events),
    CALENDAR_CHART('calendar', 'google.visualization.Calendar', CalendarChartConfigOption.configOptions, DefaultEvent.events)

    static final Log log = LogFactory.getLog(GoogleVisualization)
    static final Map googleVisualizations

    static {
        googleVisualizations = [:]

        values().each { googleVisualization ->
            googleVisualizations.put(googleVisualization.packageName, googleVisualization)
        }
    }

    private final packageName
    private final object
    private final configOptions
    private final events

    private GoogleVisualization(packageName, object, configOptions, events) {
        this.packageName = packageName
        this.object = object
        this.configOptions = configOptions
        this.events = events
    }

    static getGoogleVisualizationForPackageName(packageName) {
        def googleVisualization = googleVisualizations[packageName]

        if(googleVisualization == null) {
            log.error "Unknown Google visualization: ${packageName}"
            throw new IllegalArgumentException('Unknown Google visualization')
        }

        googleVisualization
    }

    @Override
    String toString() {
        "GoogleVisualization{packageName='${packageName}', object='${object}', configOptions='${configOptions}', events='${events}'}"
    }
}