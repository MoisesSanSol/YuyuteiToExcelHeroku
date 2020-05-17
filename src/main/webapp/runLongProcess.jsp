<!doctype html>
<html lang="en">
    <head>
        <title>Show progress of long running process with help of Thread and Ajax.</title>
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
                $.getJSON('runLongProcess', function(progress) {
                    $('#progress').text(progress);
                    $.progress = parseInt(progress);
                });
                    setTimeout(checkProgress, 5000);
                }
            }
        </script>
    </head>
    <body>
        <form action="runLongProcess" method="post">
            <p>Run long process: <input type="submit"></p>
            <p>Current status: <span id="progress">0</span>%</p>
        </form>
    </body>
</html>