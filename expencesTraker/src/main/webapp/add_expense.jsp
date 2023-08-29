<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="componant/allcss.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
</head>
<body>
	<%@ include file="componant/navbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card card-sh">
					<div class="card-header">
						<p>Add Expense</p>
						<c:if test="${not empty msg }">
						<p class ="text-center text-dark fs-4">${msg}</p>
						<c:remove var="msg"/>
						</c:if>
					</div>
					<div class="card-body">
						<form action="ExpenseServlet" method="post">
							<div class="mb-3">
								<label>Title</label> <input type="text" name="title"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Date</label> <input type="date" name="date"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Time</label> <input type="time" name="time"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Price</label> <input type="text" name="price"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Description</label> <input type="text" name="description"
									class="form-control">
							</div>
							<button class="btn btn-dark col-md-12">Add</button>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>