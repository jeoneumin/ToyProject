<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<c:set var="path" value="${pageContext.request.contextPath}" />
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
	<button id="btn1">simpleAJAX</button>
	<div id="result"></div>
</body>
<script type="text/javascript">
	$('#btn1').on('click',function(){
		var form = {
				name: "jamong",
				age: 23
		}
		$.ajax({
			url: "requestObject",
			type: "POST",
			data: form,
			success: function(data) {
				$('#result').text(data);
			},
			error: function() {
				alert("simpleWithObject err");
			}
		});
	});
</script>
</html>