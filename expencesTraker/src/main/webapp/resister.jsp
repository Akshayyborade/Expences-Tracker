<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="componant/allcss.jsp"%>
<style>
.card-sh{
box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body class="bg-light" >
	<%@ include file="componant/navbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card card-sh">
					<div class="card-header">
						<p class="text-center fs-3">Register Here</p>
					</div>
					<div class="card-body">
					<form action="userRegister" method="post">
					<div class="mb-3">
					<label>Enter Full Name</label>
					<input type="text" name="fullName" class="form-control" >
					</div>
					<div class="mb-3">
					<label>Email</label>
					<input type="email" name="email" class="form-control" >
					</div>
					<div class="mb-3">
					<label>Password</label>
					<input type="password" name="password" class="form-control" >
					</div>
					<div class="mb-3">
					<label>About</label>
					<input type="text" name="about" class="form-control" >
					</div>
					<button class="btn btn-success col-md-12">Register</button>
					</form>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>