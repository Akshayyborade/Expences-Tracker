<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../componant/allcss.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
</head>
<body>
<c:if test ="${empty loginUser }">
<c:redirect url="../login.jsp"></c:redirect>
</c:if>
	<%@ include file="../componant/navbar.jsp"%>
</body>
</html>