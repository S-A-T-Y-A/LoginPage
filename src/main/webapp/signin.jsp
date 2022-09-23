<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign in</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/signin.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

</head>
<body>
	<div class="content">
	
	<h4>Log into your account and look after your WorkSheet</h4>
	
		<form action="LoginEntry" method='get'>
			<div>
			<input type="text" placeholder="Employe Id" class="input" name="empId"> 
			<span><i class="bi bi-card-heading"></i></span>
			
			</div>
			<div>
			<input	type="text" placeholder="User Name" class="input" name="userName">
			<span><i class="bi bi-person-circle"></i></span>
			</div>
			<div class="btns">
			<a href="index.jsp" class="btn">Home</a>
			
			<input type="submit" value="Log In" class="btn">
			</div>
			
		</form>
	</div>
</body>
</html>