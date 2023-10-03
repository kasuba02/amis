<%@page import="com.amis.ms.Ctl.LoginCtl"%>
<%@page import="com.amis.ms.Utility.ServletUtility"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@include file="Header.jsp"%>
</head>
<body>


	<h6 class="text-center mt-5" style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h6>
	<!-- <h6 class="text-center mt-5" style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h6> -->
	<h3 class="text-center mt-5">Login</h3>
	<hr>
	<div class="container mt-5">
		<div
			class="row h-100 justify-content-center align-items-center col-12">

			<form style="width: 450px;" action="<%=AMView.LOGIN_CTL%>"
				method="post">

				<jsp:useBean id="bean" scope="request"
					class="com.amis.ms.Bean.UserBean" />

				<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
					type="hidden" name="createdBy" value="<%=bean.getCreatedby()%>">
				<input type="hidden" name="modifiedBy"
					value="<%=bean.getModifiedby()%>"> <input type="hidden"
					name="createdDatetime" value="<%=bean.getCreatedatetime()%>">
				<input type="hidden" name="modifiedDateTime"
					value="<%=bean.getModifieddatetime()%>">


				<div class="col-6 text-center " style="margin-left: 130px;">
					<label for="exampleInputEmail1" class="form-label">Email
						address</label> <input type="email" name="email" class="form-control"
						id="exampleInputEmail1" aria-describedby="emailHelp">
				</div>
				<div class="col-6  text-center" style="margin-left: 130px;">
					<label for="exampleInputPassword1" class="form-label">Password</label>
					<input type="password" name="password" class="form-control"
						id="exampleInputPassword1">
				</div>
				<br>
				<div class="container text-center">
					<input type="submit" class="btn btn-primary" name="operation"
						value="<%=LoginCtl.OP_SIGNIN%>">
				</div>
			</form>
		</div>
	</div>
	<br>
	<%@include file="Footer.jsp"%>

</body>
</html>