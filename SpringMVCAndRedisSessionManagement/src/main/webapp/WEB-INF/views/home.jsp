<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>

	<p>username : ${username}</p>
	<p>sessionId : ${sessionId}</p>

	<input type="button" value="connecteServer()"
		onclick="connecntServer()" />

</body>
<script type="text/javascript">
	function connecntServer() {
		if ("WebSocket" in window) {
			var ws = new WebSocket("ws://10.0.0.205:8080/sample/echo");

			ws.onopen = function() {
				ws.send("Message to send");
			};

			ws.onmessage = function(e) {
				// Message is received...
				var msg = e.data;
				alert(msg);
			};

			ws.onclose = function() {
				// Connection is closed...
			};
		} else {
			alert("You use Chrome. not supported websocket.");
		}
	}
</script>
</html>
