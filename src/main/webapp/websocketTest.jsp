<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>websocket</title>
</head>
<style type="text/css">
    #div {
        color: red;
    }
</style>
<body>
<h1>WEBSOCKET----TEST</h1>
<div id="div">

</div>
<script type="text/javascript">
var div = document.getElementById('div');
var socket = new WebSocket('ws://127.0.0.1:8088/websocket');

socket.onopen = function(event){
    console.log(event);
    socket.send('websocket client connect test');
}

socket.onclose = function(event){
    console.log(event);
}

socket.onerror = function(event){
    console.log(event);
}

socket.onmessage = function(event){
    console.log(event)
    div.innerHTML += (' @_@ ' + event.data + ' ~_~ ');
}
</script>
</body>
</html>