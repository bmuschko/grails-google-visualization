<%@ page import="grails.converters.JSON; org.apache.commons.lang.StringUtils" %>
<%@ page defaultCodec="none" %>

<g:set var="functionName" value="draw${StringUtils.capitalize(visualizationData.name)}"/>
<script type="text/javascript">
    google.load('visualization', '${visualizationData.version}', {'packages': ['${visualizationData.visualization.packageName}']<g:if test="${visualizationData.dynamicLoading}">, 'callback': ${functionName}</g:if><g:if test="${visualizationData.language}">, 'language': '${visualizationData.language}'</g:if>});
    <g:if test="${!visualizationData.dynamicLoading}">google.setOnLoadCallback(${functionName});</g:if>
    
    function ${functionName}() {
        ${visualizationData.name}_data = new google.visualization.DataTable();
        <g:each var="column" in="${visualizationData.columns}">
            <g:if test="${column instanceof Map}">
        ${visualizationData.name}_data.addColumn(${(column as JSON).toString()});
            </g:if>
            <g:else>
        ${visualizationData.name}_data.addColumn('${column[0]}', '${column[1]}');
            </g:else>
        </g:each>
        <g:each var="row" in="${visualizationData.rows}">
        ${visualizationData.name}_data.addRow(${row});
        </g:each>
      
        ${visualizationData.name} = new ${visualizationData.visualization.object}(document.getElementById('${visualizationData.elementId}'));

        <g:render template="/formatter" model="[visualizationData: visualizationData]" plugin="google-visualization"/>

        <g:each var="beforeDrawEvent" in="${visualizationData.beforeDrawEvents}">
        google.visualization.events.addListener(${visualizationData.name}, '${beforeDrawEvent.key}', ${beforeDrawEvent.value});
        </g:each>

        <g:if test="${visualizationData.dataView}">
            ${visualizationData.name}_view = new google.visualization.DataView(${visualizationData.name}_data);
            ${visualizationData.name}_view.setColumns(${visualizationData.dataView});
            ${visualizationData.name}.draw(${visualizationData.name}_view, ${visualizationData.options});
        </g:if>

        <g:if test="${visualizationData.dataView == null || visualizationData.dataView?.size() == 0 }">
            ${visualizationData.name}.draw(${visualizationData.name}_data, ${visualizationData.options});
        </g:if>


        <g:each var="afterDrawEvent" in="${visualizationData.afterDrawEvents}">
        google.visualization.events.addListener(${visualizationData.name}, '${afterDrawEvent.key}', ${afterDrawEvent.value});
        </g:each>
    }
</script>
