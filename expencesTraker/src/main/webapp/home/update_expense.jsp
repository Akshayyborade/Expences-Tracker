<%@page import="com.entity.Expense"%>
<%@page import="com.db.HibernateConfig"%>
<%@page import="com.dao.ExpensesDao"%>
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
<%
int id = Integer.parseInt(request.getParameter("id"));
ExpensesDao dao = new ExpensesDao(HibernateConfig.getSessionFactory());
Expense ex = dao.getExpense(id);



%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card ">
					<div class="card-header">
						<p class="text-center fs-3">Edit Expense</p>
					</div>
					<div class="card-body">
						<form action="../UpdateExpenseServlet" method="post">
							<div class="mb-3">
								<label>Title</label> <input type="text" name="title"
									class="form-control" value="<%=ex.getTitle() %>">
							</div>
							<div class="mb-3">
								<label>Date</label> <input type="date" name="date"
									class="form-control"value="<%=ex.getDate() %>">
							</div>
							<div class="mb-3">
								<label>Time</label> <input type="time" name="time"
									class="form-control"value="<%=ex.getTime() %>">
							</div>
							<div class="mb-3">
								<label>Price</label> <input type="text" name="price"
									class="form-control"value="<%=ex.getPrice() %>">
							</div>
							<div class="mb-3">
								<label>Description</label> <input type="text" name="description"
									class="form-control"value="<%=ex.getDescription() %>">
							</div>
							<input type ="hidden" name="id" class="form-control" value="<%= ex.getId() %>">
							<button class="btn btn-dark col-md-12">Update</button>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>