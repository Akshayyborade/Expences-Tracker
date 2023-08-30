<%@page import="org.hibernate.Session"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.entity.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.db.HibernateConfig"%>
<%@page import="com.dao.ExpensesDao"%>
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
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-2">

				<div class="card">
					<div class="card-header">
						<p class="text-center fs-3">All Expenses</p>
						
						<c:if test="${not empty msg }">
						<p class ="text-center text-dark fs-4">${msg}</p>
						<c:remove var="msg"/>
						</c:if>
					</div>
					<div class="card-body">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Title</th>
									<th scope="col">Description</th>
									<th scope="col">Price</th>
									<th scope="col">Date</th>
									<th scope="col">Time</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								User user = (User) session.getAttribute("loginUser");
								ExpensesDao dao = new ExpensesDao(HibernateConfig.getSessionFactory());
								List<Expense> list = dao.viewExpense(user);
								for(Expense ex :list){
								%>
								<tr>
									<th scope="row">
										<%=
										ex.getTitle()
										%>
									</th>
									<td>
										<%=
										ex.getDescription()
										%>
									</td>
									<td>
										<%=
										ex.getPrice()
										%>
									</td>
									<td>
										<%=
										ex.getDate()
										%>
									</td>
									<td>
										<%=
										ex.getTime()
										%>
									</td>
									<td><a href ="update_expense.jsp?id=<%=ex.getId() %>" class="btn btn-sm btn-primary me-1">Edit</a> <a href="../DeleteExpenseServlet?id=<%=ex.getId()%>" class="btn btn-sm btn-danger me-1 ">Delete</a></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>