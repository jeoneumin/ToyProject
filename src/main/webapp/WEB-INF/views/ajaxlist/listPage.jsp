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
				<a href="javascript:void(0);" onclick="nextAjax(this)">다음</a>
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
	console.log("---------linkAjax-----------");
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
				console.log("ths value in success function",$(ths).text());
			}
		},
		error:function(){
			console.log("에러발생");
		}
	});
}
</script>

<script>
function nextAjax(ths){
	console.log("---------nextAjax-----------");
	var nextLink = $(ths).text();
	console.log("nextLink",nextLink);
	var divTag=$(ths).parent()
	console.log("divTag",divTag);
	var divTagId=divTag.attr('id');
	console.log("divTagId",divTagId);
	console.log("divTag.children().length",divTag.children().length);
	var lastNumAtag = divTag.children().eq(-2);
	console.log("lastNumAtag",lastNumAtag);
	var lastNumAtagValue = lastNumAtag.text();
	console.log("lastNumAtag",lastNumAtagValue);
	
	$.ajax({
		url:'list/nextAjax',
		type:'post',
		data: {'lastNumAtagValue' : lastNumAtagValue},
		dataType: "json",
		success: function(data){
			console.log("nextAjax 통신성공");
			console.log("data" , data);
			for(var step=0;step<3;step++){
				console.log('data[%d]',step,data[step]);
			}
			/* var nav = $('#nav');
			console.log("nav 길이",nav.children().length);
			nav.empty();
			console.log("empty후  nav 길이",nav.children().length);
			console.log("lastPage model",'${lastPage}');
			console.log("test typeof 3",typeof(3));
			console.log("model lastPage type",typeof('${lastPage}'));
			console.log("model lastPage type number()",typeof(Number('${lastPage}')));
			console.log("data[0] type",typeof(data[0]));
			console.log("data[0] number()",typeof(Number(data[0])));
			
			var lastPageNum = Number('${lastPage}');
			console.log("lastPageNum type",typeof(lastPageNum));
			console.log("lastPageNum value",lastPageNum);
			
			var newAtag = "";
			newAtag += "<a href='javascript:void(0);' onclick='preAjax(this)'>이전</a>&nbsp";
			
			console.log("scope model value",'${scope}');
			for(var i=0;i<'${scope}';i++){
				if(Number(data[i]) <= '${lastPage}'){
					newAtag += "<a href='javascript:void(0);' onclick='linkAjax(this)'>"+data[i]+"</a>&nbsp";
					console.log(newAtag);
				}
			}
			console.log("data[data.length-1]",data[data.length-1]);
			
			if(Number(data[data.length-1])<'${lastPage}'){
				console.log("다음링크 생성 조건 in");
				newAtag += '<a href="javascript:void(0);" onclick="nextAjax(this)">다음</a>';
				console.log(newAtag);
			}
			
			console.log("navAtag after if" ,newAtag);
			
			nav.append(newAtag);
			
			console.log("nav children length",nav.children().length);
			console.log("nav children1 value",nav.children().eq(1).text()); */
			
			createNav(data);
			
			$('#nav').children().eq(1).trigger("click");
			
		},
		error: function(err){
			console.log("nextAjax 통신실패");
		}
	});
}
</script>

<script type="text/javascript">
function preAjax(ths) {
	console.log("---------preAjax-----------");
	var pre = $(ths)
	console.log("pre value", pre.text());
	var nav = pre.parent();
	console.log("nav 길이",nav.children().length);
	var navAtagFirst = nav.children().eq(1);
	console.log("navAtagFirst value",navAtagFirst.text());
	
	$.ajax({
		url:'list/preAjax',
		type:'post',
		data: {'navAtagFirst' : navAtagFirst.text()} ,
		dataType: "json",
		success: function(data){
			console.log("통신성공");
			console.log("data",data);
			var nav = $('#nav');
			console.log("nav length", nav.children().length);
			nav.empty();
			console.log("after empty nav length", nav.children().length);
			
			createNav(data);
			console.log("nav children [0] value",$('#nav').children().eq(0).text());
			console.log("nav children [1] value",$('#nav').children().eq(1).text());
			if($('#nav').children().eq(0).text() != '1'){
				$('#nav').children().eq(1).trigger("click");
			}else{
				$('#nav').children().eq(0).trigger("click");
			}
		},
		error: function (request, status, error){
			console.log("통신실패");
		}
		});
}

</script>

<script type="text/javascript">
function createNav(navArr){
	var nav = $('#nav');
	console.log("nav 길이",nav.children().length);
	nav.empty();
	console.log("empty후  nav 길이",nav.children().length);
	console.log("lastPage model",'${lastPage}');
	console.log("test typeof 3",typeof(3));
	console.log("model lastPage type",typeof('${lastPage}'));
	console.log("model lastPage type number()",typeof(Number('${lastPage}')));
	console.log("navArr[0] type",typeof(navArr[0]));
	console.log("navArr[0] number()",typeof(Number(navArr[0])));
	
	var lastPageNum = Number('${lastPage}');
	console.log("lastPageNum type",typeof(lastPageNum));
	console.log("lastPageNum value",lastPageNum);
	
	var newAtag = "";
	if(Number(navArr[0]) > 1){
		newAtag += "<a href='javascript:void(0);' onclick='preAjax(this)'>이전</a>&nbsp";	
	}
	
	console.log("scope model value",'${scope}');
	for(var i=0;i<'${scope}';i++){
		if(Number(navArr[i]) <= '${lastPage}'){
			newAtag += "<a href='javascript:void(0);' onclick='linkAjax(this)'>"+navArr[i]+"</a>&nbsp";
			console.log(newAtag);
		}
	}
	console.log("navArr[navArr.length-1]",navArr[navArr.length-1]);
	
	if(Number(navArr[navArr.length-1])<'${lastPage}'){
		console.log("다음링크 생성 조건 in");
		newAtag += '<a href="javascript:void(0);" onclick="nextAjax(this)">다음</a>';
		console.log(newAtag);
	}
	
	console.log("navAtag after if" ,newAtag);
	
	nav.append(newAtag);
	
	console.log("nav children length",nav.children().length);
	console.log("nav children1 value",nav.children().eq(1).text());
	
	
}
</script>


</html>