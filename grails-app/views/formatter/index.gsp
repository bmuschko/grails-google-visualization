<%@ page import="org.grails.plugins.google.visualization.data.Cell; org.grails.plugins.google.visualization.formatter.PatternFormatter; org.grails.plugins.google.visualization.formatter.NumberFormatter; org.grails.plugins.google.visualization.formatter.DateFormatter; org.grails.plugins.google.visualization.formatter.ColorRange; org.grails.plugins.google.visualization.formatter.ColorFormatter; org.grails.plugins.google.visualization.formatter.BarFormatter; org.grails.plugins.google.visualization.formatter.ArrowFormatter; org.grails.plugins.google.visualization.util.DateUtil" %>

<html>
    <head>
        <title>Google Visualization API plugin</title>
		<meta name="layout" content="main" />
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
    </head>
       <body>
       <% 
          def departmentRevenueChangeColumns = [['string', 'Department'], ['number', 'Revenues Change']]
          def departmentRevenueChangeData = [['Shoes', new Cell(value: 12, label: '12.0%')], ['Sports', new Cell(value: -7.3, label: '-7.3%')], ['Toys', new Cell(value: 0, label: '0%')], ['Electronics', new Cell(value: -2.1, label: '-2.1%')], ['Food', new Cell(value: 22, label: '22.0%')]]
          def departmentRevenueColumns = [['string', 'Department'], ['number', 'Revenues']]
          def departmentRevenueData = [['Shoes', 10700], ['Sports', -15400], ['Toys', 12500], ['Electronics', -2100], ['Food', 22600], ['Art', 1100]]
          def employeeDatesColumns = [['string', 'Employee Name'], ['date', 'Start Date (Long)'], ['date', 'Start Date (Medium)'], ['date', 'Start Date (Short)']]
          def employeeDatesData = [['Mike', DateUtil.createDate(2008, 1, 28, 0, 31, 26, 0), DateUtil.createDate(2008, 1, 28, 0, 31, 26, 0), DateUtil.createDate(2008, 1, 28, 0, 31, 26, 0)], ['Bob', DateUtil.createDate(2007, 5, 1), DateUtil.createDate(2007, 5, 1), DateUtil.createDate(2007, 5, 1)], ['Alice', DateUtil.createDate(2006, 7, 16), DateUtil.createDate(2006, 7, 16), DateUtil.createDate(2006, 7, 16)]]
          def peopleEmailColumns = [['string', 'Name'], ['string', 'Email']]
          def peopleEmailData = [['John Lennon', 'john@beatles.co.uk'], ['Paul McCartney', 'paul@beatles.co.uk'], ['George Harrison', 'george@beatles.co.uk'], ['Ringo Starr', 'ringo@beatles.co.uk']]
          def arrowFormatters = [new ArrowFormatter(1)]
          def barFormatter = new BarFormatter(1)
          barFormatter.width = 120
          def barFormatters = [barFormatter]
          def colorFormatter = new ColorFormatter(1)
          colorFormatter.ranges = [new ColorRange(-20000, 0, 'white', 'orange'), new ColorRange(20000, null, 'red', '#33ff33')]
          def colorFormatters = [colorFormatter]
          def longDateFormatter = new DateFormatter(1)
          longDateFormatter.formatType = 'long'
          def mediumDateFormatter = new DateFormatter(2)
          mediumDateFormatter.formatType = 'medium'
          def shortDateFormatter = new DateFormatter(3)
          shortDateFormatter.formatType = 'short'
          def dateFormatters = [longDateFormatter, mediumDateFormatter, shortDateFormatter]
          def numberFormatter = new NumberFormatter(1)
          numberFormatter.prefix = '$'
          numberFormatter.negativeColor = 'red'
          numberFormatter.negativeParens = true
          def numberFormatters = [numberFormatter]
          def patternFormatter = new PatternFormatter('<a href=\"mailto:{1}\">{0}</a>', [0, 1])
          def patternFormatters = [patternFormatter]
       %>
       <h2>Table Formatter Examples</h2>
       <gvisualization:table elementId="arrowformat_div" allowHtml="${true}" showRowNumber="${true}" columns="${departmentRevenueChangeColumns}" data="${departmentRevenueChangeData}" formatters="${arrowFormatters}"/>
       <gvisualization:table elementId="barformat_div" allowHtml="${true}" showRowNumber="${true}" columns="${departmentRevenueColumns}" data="${departmentRevenueData}" formatters="${barFormatters}"/>
       <gvisualization:table elementId="colorformat_div" allowHtml="${true}" showRowNumber="${true}" columns="${departmentRevenueColumns}" data="${departmentRevenueData}" formatters="${colorFormatters}"/>
       <gvisualization:table elementId="dateformat_div" showRowNumber="${true}" columns="${employeeDatesColumns}" data="${employeeDatesData}" formatters="${dateFormatters}"/>
       <gvisualization:table elementId="numberformat_div" allowHtml="${true}" showRowNumber="${true}" columns="${departmentRevenueColumns}" data="${departmentRevenueData}" formatters="${numberFormatters}"/>
       <gvisualization:table elementId="patternformat_div" allowHtml="${true}" showRowNumber="${true}" columns="${peopleEmailColumns}" data="${peopleEmailData}" formatters="${patternFormatters}"/>
       <table cellpadding="2" cellspacing="0">
          <tr>
             <td>
                <a href="http://code.google.com/apis/visualization/documentation/reference.html#arrowformatter">Arrow Formatter</a>
             </td>
             <td>
                <div id="arrowformat_div"></div>
             </td>
          </tr>
          <tr>
             <td>
                <a href="http://code.google.com/apis/visualization/documentation/reference.html#barformatter">Bar Formatter</a>
             </td>
             <td>
                <div id="barformat_div"></div>
             </td>
          </tr>
          <tr>
             <td>
                <a href="http://code.google.com/apis/visualization/documentation/reference.html#colorformatter">Color Formatter</a>
             </td>
             <td>
                <div id="colorformat_div"></div>
             </td>
          </tr>
          <tr>
             <td>
                <a href="http://code.google.com/apis/visualization/documentation/reference.html#dateformatter">Date Formatter</a>
             </td>
             <td>
                <div id="dateformat_div"></div>
             </td>
          </tr>
          <tr>
             <td>
                <a href="http://code.google.com/apis/visualization/documentation/reference.html#numberformatter">Number Formatter</a>
             </td>
             <td>
                <div id="numberformat_div"></div>
             </td>
          </tr>
          <tr>
             <td>
                <a href="http://code.google.com/apis/visualization/documentation/reference.html#patternformatter">Pattern Formatter</a>
             </td>
             <td>
                <div id="patternformat_div"></div>
             </td>
          </tr>
       </table>
    </body>
</html>