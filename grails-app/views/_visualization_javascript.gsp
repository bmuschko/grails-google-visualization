<%@ page import="org.apache.commons.lang.StringUtils" %>
<g:set var="functionName" value="draw${StringUtils.capitalize(visualizationData.name)}"/>
<script type="text/javascript">
    google.load('visualization', '1', {'packages': ['${visualizationData.visualization.packageName}']<g:if test="${visualizationData.dynamicLoading}">, 'callback': ${functionName}</g:if><g:if test="${visualizationData.language}">, 'language': '${visualizationData.language}'</g:if>});
    <g:if test="${!visualizationData.dynamicLoading}">google.setOnLoadCallback(${functionName});</g:if>
    
    function ${functionName}() {
        ${visualizationData.name}_data = new google.visualization.DataTable();
        <g:each var="column" in="${visualizationData.columns}">
        ${visualizationData.name}_data.addColumn('${column[0]}', '${column[1]}');
        </g:each>
        <g:each var="row" in="${visualizationData.rows}">
        ${visualizationData.name}_data.addRow(${row});
        </g:each>
      
        ${visualizationData.name} = new ${visualizationData.visualization.object}(document.getElementById('${visualizationData.elementId}'));

        <g:render template="/formatter" model="[visualizationData: visualizationData]" plugin="google-visualization"/>
        
        ${visualizationData.name}.draw(${visualizationData.name}_data, ${visualizationData.options});

        <g:each var="event" in="${visualizationData.events}">
        google.visualization.events.addListener(${visualizationData.name}, '${event.key}', ${event.value});
        </g:each>
    }
</script>