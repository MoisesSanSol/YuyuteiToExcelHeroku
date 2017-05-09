<!doctype html>
<html lang="en">
    <head>
        <title>Generando el excel</title>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
        <script type="text/javascript">
        
            $(document).ready(init);

            function init() {
                if (${not empty longProcess}) {
                    $.cartasProgress = 0;
                    $.excelProgress = 0;
                    $("#atras").hide();
                    checkProgress();
                }
            }

            function checkProgress() {
				if ($.excelProgress < 100) {
	                $.getJSON('checkExcelProgress', function(progressJSON) {
	                    $.cartasProgress = progressJSON.cartas;
	                    $("#cartasProgress").text($.cartasProgress);
	                    $.excelProgress = progressJSON.excel;
	                    $("#excelProgress").text($.excelProgress);
	                });
                    setTimeout(checkProgress, 2000);
                }
            	else{
            		document.getElementById("download").submit();
            		$("#atras").show();
            	}
            }
        </script>
    </head>
    <body>
    	<p>Obteniendo cartas: <span id="cartasProgress">0</span>%</p>
	    <p>Generando excel: <span id="excelProgress">0</span>%</p>
	    <form action="download" id="download">
		  <input type="hidden" value="submitDownload">
		</form>
		<button onclick="location.href='index.jsp'" id="atras">Nueva consulta</button>
    </body>
</html>