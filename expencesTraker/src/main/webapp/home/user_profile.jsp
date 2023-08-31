<%@page import="java.util.List"%>
<%@page import="com.db.HibernateConfig"%>
<%@page import="com.dao.UserDuo"%>
<%@page import="com.entity.User"%>
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
	<div class="container p-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card card-sh">
					<div class="card-header">
						<p class="text-center fs-3">Edit Your Profile</p>
						<c:if test="${not empty msg }">
						<p class ="text-center text-dark fs-4">${msg}</p>
						<c:remove var="msg"/>
						</c:if>
					</div>
					<div class="card-body">
					<form action="../EditProfileServlet" method="post">
					<%
								User user = (User) session.getAttribute("loginUser");
								
				
								%>
					<div class="mb-3">
					<label>Edit your name</label>
					<input type="text" name="fullName" class="form-control"  value="<%=user.getFullName()%>">
					</div>
					<div class="mb-3">
					<label>Change your email</label>
					<input type="email" name="email" class="form-control"value="<%=user.getEmail()%>" >
					</div>
					<div class="mb-3">
					<label>Change your password</label>
					<input type="password" name="password" class="form-control"value="<%=user.getPassword()%>" >
					</div>
					<div class="mb-3">
					<label>Edit About</label>
					<input type="text" name="about" class="form-control"value="<%=user.getAbout()%>" >
					</div>
					<button class="btn btn-dark col-md-12">Save</button>
					
					</form>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>