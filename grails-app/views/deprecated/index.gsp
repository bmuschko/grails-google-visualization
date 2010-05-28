<%@ page import="org.grails.plugins.google.visualization.formatter.PatternFormatter; org.grails.plugins.google.visualization.formatter.NumberFormatter; org.grails.plugins.google.visualization.formatter.DateFormatter; org.grails.plugins.google.visualization.formatter.ColorRange; org.grails.plugins.google.visualization.formatter.ColorFormatter; org.grails.plugins.google.visualization.formatter.BarFormatter; org.grails.plugins.google.visualization.formatter.ArrowFormatter; org.grails.plugins.google.visualization.util.DateUtil" %>

<html>
    <head>
        <title>Google Visualization API plugin</title>
		<meta name="layout" content="main" />
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    </head>
       <body>
       <%
          def myDailyActivitiesColumns = [['string', 'Task'], ['number', 'Hours per Day']]
          def myDailyActivitiesData = [['Work', 11], ['Eat', 2], ['Commute', 2], ['Watch TV', 2], ['Sleep', 7]]
          def companyPerformanceColumns = [['string', 'Year'], ['number', 'Sales'], ['number', 'Expenses']]
          def companyPerformanceData = [['2004', 1000, 400], ['2005', 1170, 460], ['2006', 660, 1120], ['2007', 1030, 540]]
          def weightByAgeColumns = [['number', 'Age'], ['number', 'Weight']]
          def weightByAgeData = [[8, 12], [4, 5.5], [11, 14], [4, 5], [3, 3.5], [6.5, 7]]
       %>
       <h2>Deprecated Chart Examples</h2>
       <gvisualization:pieChart elementId="piechart" title="My Daily Activities" width="${400}" height="${240}" is3D="${true}" columns="${myDailyActivitiesColumns}" data="${myDailyActivitiesData}" />
       <gvisualization:barChart elementId="barchart" title="Company Performance" width="${400}" height="${240}" is3D="${true}" columns="${companyPerformanceColumns}" data="${companyPerformanceData}" />
       <gvisualization:columnChart elementId="columnchart" title="Company Performance" width="${400}" height="${240}" is3D="${true}" columns="${companyPerformanceColumns}" data="${companyPerformanceData}" />
       <gvisualization:areaChart elementId="areachart" title="Company Performance" width="${400}" height="${240}" legend="bottom" columns="${companyPerformanceColumns}" data="${companyPerformanceData}" />
       <gvisualization:lineChart elementId="linechart" width="${400}" height="${240}" title="Company Performance" legend="bottom" columns="${companyPerformanceColumns}" data="${companyPerformanceData}" />
       <gvisualization:scatterChart elementId="scatterchart" width="${400}" height="${240}" titleX="Age" titleY="Weight" legend="none" pointSize="${5}" columns="${weightByAgeColumns}" data="${weightByAgeData}" />
       <table cellpadding="2" cellspacing="0">
          <tr>
             <td>
                <a href="http://code.google.com/apis/visualization/documentation/gallery/piechart_old.html">Pie Chart</a>
             </td>
             <td>
                <div id="piechart"></div>
             </td>
          </tr>
          <tr>
             <td>
                <a href="http://code.google.com/apis/visualization/documentation/gallery/barchart_old.html">Bar Chart</a>
             </td>
             <td>
                <div id="barchart"></div>
             </td>
          </tr>
          <tr>
             <td>
                <a href="http://code.google.com/apis/visualization/documentation/gallery/columnchart_old.html">Column Chart</a>
             </td>
             <td>
                <div id="columnchart"></div>
             </td>
          </tr>
          <tr>
             <td>
                <a href="http://code.google.com/apis/visualization/documentation/gallery/areachart_old.html">Area Chart</a>
             </td>
             <td>
                <div id="areachart"></div>
             </td>
          </tr>
          <tr>
             <td>
                <a href="http://code.google.com/apis/visualization/documentation/gallery/linechart_old.html">Line Chart</a>
             </td>
             <td>
                <div id="linechart"></div>
             </td>
          </tr>
          <tr>
             <td>
                <a href="http://code.google.com/apis/visualization/documentation/gallery/scatterchart_old.html">Scatter Chart</a>
             </td>
             <td>
                <div id="scatterchart"></div>
             </td>
          </tr>
       </table>
    </body>
</html>