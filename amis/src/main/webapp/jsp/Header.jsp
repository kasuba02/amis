  <%@page import="com.amis.ms.Ctl.LoginCtl"%>
<%@ page import="com.amis.ms.Bean.UserBean"%>
<%@page import="com.amis.ms.Ctl.AMView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>


   <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
	<%
		UserBean userBean = (UserBean) session.getAttribute("user");
	%>
	<%
		boolean userLoggedIn = userBean != null;
		String welcomeMsg = "Hello, ";
		if (userLoggedIn) {
			welcomeMsg += userBean.getFirstName();
		} else {
			welcomeMsg += "Guest";
		}
	%>

	<nav class="navbar bg-dark">
	<div class="container">
		<ul class="nav nav-pills">
			<li class="nav-item"><a class="nav-link active"
				style="font-family: cursive;" aria-current="page"
				href="<%=AMView.WELCOME_CTL%>"> Home</a></li>
		
			<%
				if (userBean != null) {
			%>
			<%
				if (userBean.getRoleid() == 1) {
			%>

<li class="nav-item dropdown" style="font-family: cursive;"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false"> User</a>
				<ul class="dropdown-menu">
						<li><a class="dropdown-item"
						href="<%=AMView.USER_CTL%>">Add User</a></li>
					<li><a class="dropdown-item"
						href="<%=AMView.USER_LIST_CTL%>"> UserList </a></li>
				</ul></li>

			<li class="nav-item dropdown" style="font-family: cursive;"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false"> 2022 Holiday</a>
				<ul class="dropdown-menu">
				
					<li><a class="dropdown-item"
						href="<%=AMView.APPROVE_LIST_CTL%>"> Holiday List </a></li>
				</ul></li>

			<%
				} else if (userBean.getRoleid() == 2) {
			%>

			<li class="nav-item"><a class="nav-link"
				href="<%=AMView.HOLIDAY_CTL%>" style="font-family: cursive;">Apply Leave</a></li>

	<li class="nav-item"><a class="nav-link"
				href="<%=AMView.HOLIDAY_LIST_CTL%>" style="font-family: cursive;">Leave Status</a></li>

		
			<%
				} else if (userBean.getRoleid() == 3) {
			%>
			<li class="nav-item"><a class="nav-link"
				href="<%=AMView.MANAGER_CTL%>" style="font-family: cursive;">Leave Status</a></li>
			
			<%
				}
			%>
				
			<%
				}
			%>
			
			
		</ul>

		<%
			if (userBean == null) {
		%>
		<ul class="nav justify-content-end" style="font-family: cursive;">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false" style="margin-left: 10px;">Guest</a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="<%=AMView.LOGIN_CTL%>">SingIn</a></li>
					<li><a class="dropdown-item"
						href="<%=AMView.USER_REGISTRATION_CTL%>">SingUp</a></li>
					<li><a class="dropdown-item" href="#"></a></li>
				</ul></li>
		</ul>
		<%
			} else {
		%>
		<ul class="nav justify-content-end" style="font-family: cursive;">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-expanded="false" style="margin-left: 10px;"><%=welcomeMsg%></a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item"
						href="<%=AMView.LOGIN_CTL%>?operation=<%=LoginCtl.OP_LOGOUT%>">Logout</a></li>
				</ul></li>
		</ul>

		<%
			}
		%>
		</div>
	</nav>



</body>
</html>