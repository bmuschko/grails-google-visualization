<script type="text/javascript">
    google.load('visualization', '1', {'packages': ['${visualizationData.visualization.packageName}']<g:if test="${visualizationData.language}">, 'language': '${visualizationData.language}'</g:if>});
    google.setOnLoadCallback(drawVisualization);
    var ${visualizationData.name};

    function drawVisualization() {
        var data = new google.visualization.DataTable();
        <g:each var="column" in="${visualizationData.columns}">
        data.addColumn('${column[0]}', '${column[1]}');
        </g:each>
        <g:each var="row" in="${visualizationData.rows}">
        data.addRow(${row});
        </g:each>
      
        ${visualizationData.name} = new ${visualizationData.visualization.object}(document.getElementById('${visualizationData.elementId}'));

        <g:render template="/formatter" model="[visualizationData: visualizationData]" plugin="google-visualization"/>
        
        ${visualizationData.name}.draw(data, ${visualizationData.options});

        <g:each var="event" in="${visualizationData.events}">
        google.visualization.events.addListener(${visualizationData.name}, '${event.key}', ${event.value});
        </g:each>
    }
</script>