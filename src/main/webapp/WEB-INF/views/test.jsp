<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="total" value="17" />
	<c:set var="pageSize" value="3" />
	<c:set var="pre" value="false" />
	<c:set var="next" value="false" />
	<fmt:parseNumber var="Scope" value="${Scope }"/>
	<fmt:parseNumber var="result" integerOnly="true"
		value="${(total/pageSize) +1 }" />
	
	<c:set var="pre" value="true" />
	<c:set var="next" value="true" />
	<%-- <c:choose>
		<c:when test="${(total%pageSize) ne 0 }"> <h2>yes</h2> </c:when>
		<c:otherwise> <h2>no</h2> </c:otherwise>
	</c:choose> --%>
	test5: ${Scope } <br>
	<c:if test="${pre } eq 'true'"> true</c:if>
	<c:if test="${pre eq 'true'}"> true</c:if>
	 
	

</body>
</html>