<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
<br><br>
	<div class="row">
	
		<button type="button" id="selectBtn">선택</button>
		<table id="example-table-3" width="100%">
			<thead>
				<tr>
					<th>선택</th>
					<th>No. </th>
					<th>아이디</th>
					<th>이름</th>
					<th>이메일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="checkbox" ></td>
					<td>1</td>
					<td>user07</td>
					<td>NC소프트</td>
					<td>nc@gmail.com</td>
				</tr>
				<tr>
					<td><input type="checkbox" ></td>
					<td>2</td>
					<td>user08</td>
					<td>넥슨</td>
					<td>donson@naver.com</td>
				</tr>
				<tr>
					<td><input type="checkbox"></td>
					<td>3</td>
					<td>user09</td>
					<td>넷마블</td>
					<td>net@gmail.com</td>
				</tr>
			</tbody>
		</table>
		<div id="print"></div>
		<!-- <div id="ex_Result2"></div> -->
	</div>
	<!-- <script>
		$("#selectBtn").click(function(){
			var rowData = new Array();
			var tdArr = new Array();
			var checkbox = $("input[name=user_CheckBox]:checked");
			
			checkbox.each(function(i) {
				var tr = checkbox.parent().parent().eq(i);
				var td = tr.children();
				
				td.eq(1).html("<input type='text' name='Hello'>");
				
				/* document.getElementById("tdTag").innerHTML="<input type='text' name='Hello'>"; */
				
			});
		
			/* $("#ex_Result1").html(" * 체크된 Row의 모든 데이터 = "+rowData);
			$("#ex_Result2").html(tdArr); */
		});
	</script> -->
	
	<script>
		var inputChange = function() {
			var checkbox = $("input:checked");
			
			checkbox.each(function(i){
				var tr = $(checkbox.parent().parent().eq(i));
				var td = tr.children();
				
				td.eq(2).html("<input type='text' name='user' value='username'/>");
				td.eq(3).html("<input type='text' name='company' value='companyname'/>");
			});
			
			/* var tr = $("input:checked").parent().parent();
			var td = tr.$("#print").html("tr is "+tr.eq(1).text()); */
		};
		
		
		$("#selectBtn").on("click",inputChange);
	</script>
	<!-- <script>
		$("#selectBtn").click(function(){
			var rowData = new Array();
			var tdArr = new Array();
			var checkbox = $("input[name=user_CheckBox]:checked");
			
			checkbox.each(function(i) {
				var tr = checkbox.parent().parent().eq(i);
				var td = tr.children();
				
				rowData.push(tr.text());
				
				var no = td.eq(1).text()+", ";
				var userid = td.eq(2).text()+", ";
				var name = td.eq(3).text()+", ";
				var email = td.eq(4).text()+", ";
				
				tdArr.push(no);
				tdArr.push(userid);
				tdArr.push(name);
				tdArr.push(email);
			});
		
			$("#ex_Result1").html(" * 체크된 Row의 모든 데이터 = "+rowData);
			$("#ex_Result2").html(tdArr);
		});
	</script> -->
</body>
</html>