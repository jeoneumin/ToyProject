<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<title>Insert title here</title>

</head>
<body>

	<table id="memberView" border="1">
		<tr>
			<td>select</td>
			<td>memberId</td>
			<td>userName</td>
			<td>pw</td>
			<td>answer</td>
			<td>manageValue</td>
		</tr>
		<tbody id="memDiv">
		<!-- memberList가 있으면 출력 -->
		<c:if test="${not empty memberList }">
			<!-- 반복문을 이용해서 하나씩 출력 -->
			<c:forEach var="member" items="${memberList}">
				<tr>
					<td><input type="checkbox" name="checkBox" /></td>
					<td>${member.memberId }</td>
					<td>${member.userName }</td>
					<td>${member.pw }</td>
					<td>${member.answer }</td>
					<td>${member.manageValue }</td>
				</tr>
				<%-- <p>
					<c:out value="${boardVO.title}" />
				</p> --%>
			</c:forEach>
		</c:if>

		<!-- memberList가 없으면 빈줄 하나만 출력 -->
		<c:if test="${empty memberList }">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</c:if>
		</tbody>
	</table>

	<div id="nav">
		<c:if test="${lastPage >= scope}">
			<c:forEach var="i" begin="1" end="${scope }" step="1">
				<a href="javascript:void(0);" onclick="linkAjax(this)">${i }</a>
			</c:forEach>
			<c:if test="${lastPage > scope }">
				<a href="javascript:void(0);" onclick="linkAjax(this)">다음</a>
			</c:if>
		</c:if>
		<c:if test="${lastPage < scope }">
			<c:forEach var="i" begin="1" end="${lastPage }" step="1">
				<a href="javascript:void(0);">${i }</a>
			</c:forEach>
		</c:if>
	</div>


</body>

<script type="text/javascript">
function linkAjax(ths){
	var clickValue = $(ths).text();
	var submitData={"clickValue" : clickValue};
	console.log("a태그",clickValue);
	console.log("submitData",submitData);
	$.ajax({
		url:"list/linkAjax",
		type:'post',
		data: submitData,
		dataType: "json", 
		success:function(data){
			console.log("서버로부터 데이터 왔음",data);
			console.log("data길이",data.length);
			if(data.length > 0){
				$('#memDiv').empty();
				for(var i = 0 ; i <data.length ; i++){
					console.log("data[%d]",i,data[i]);
					var insertTr = "";
					insertTr += "<tr>";
					insertTr += "<td><input type='checkbox' name='checkBox'/></td>";
					insertTr += "<td>" + data[i].memberId+"</td>";
					insertTr += "<td>" + data[i].userName+"</td>";
					insertTr += "<td>" + data[i].pw+"</td>";
					insertTr += "<td>" + data[i].answer+"</td>";
					insertTr += "<td>" + data[i].manageValue+"</td>";
					insertTr += "</tr>";
					console.log("insertTr", insertTr);
					$("#memDiv").append(insertTr);
					
				}
			}
		},
		error:function(){
			console.log("에러발생");
		}
	});
}
</script>


</html>