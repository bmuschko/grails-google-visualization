<%@ page import="org.grails.plugins.google.visualization.formatter.ColorFormatter; org.grails.plugins.google.visualization.formatter.PatternFormatter" %>

<g:each var="formatter" in="${visualizationData.formatters}" status="i">
   <g:set var="index" value="${i + 1}"/>
   var formatter_${index} = new ${formatter.object}(${formatter.options});
   <g:if test="${formatter instanceof PatternFormatter}">
      formatter_${index}.format(${visualizationData.name}_data, ${formatter.srcColumnIndices}<g:if test="${formatter.dstColumnIndex}">, ${formatter.dstColumnIndex}</g:if>);
   </g:if>
   <g:elseif test="${formatter instanceof ColorFormatter}">
      <g:each var="range" in="${formatter.getFormattedRanges()}">
         formatter_${index}.addRange(${range});
      </g:each>
      <g:each var="gradientRange" in="${formatter.getFormattedGradientRanges()}">
         formatter_${index}.addGradientRange(${gradientRange});
      </g:each>
      formatter_${index}.format(${visualizationData.name}_data, ${formatter.column});
   </g:elseif>
   <g:else>
      formatter_${index}.format(${visualizationData.name}_data, ${formatter.column});
   </g:else>
</g:each>