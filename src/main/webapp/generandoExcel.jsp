<!doctype html>
<html lang="en">
    <head>
        <title>Generando el excel</title>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
        <script type="text/javascript">
        
            $(document).ready(init);

            function init() {
                if (${not empty longProcess}) {
                    $.progress = 0;
                    checkProgress();
                }
            }

            function checkProgress() {
            	if ($.progress < 100) {
                $.getJSON('checkExcelProgress', function(progress) {
                    $('#progress').text(progress);
                    $.progress = parseFloat(progress).toFixed(2);
                });
                    setTimeout(checkProgress, 2000);
                }
            	else{
            		document.getElementById("download").submit();
            	}
            }
        </script>
    </head>
    <body>
	    <p>Generando excel: <span id="progress">0</span>%</p>
	    <form action="download" id="download">
	  <input type="hidden" value="Submit">
		</form>
    </body>
</html>