<%@page import="com.amis.ms.Ctl.RegistrationCtl"%>
<%@page import="com.amis.ms.Utility.ServletUtility"%>
<%@page import="com.amis.ms.Utility.DataUtility"%>
<%@page import="com.amis.ms.Utility.HTMLUtility"%>
<%@page import="java.util.HashMap"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<%@include file="Header.jsp"%>
</head>
<body>
<div class="container mt-5">
	<h3 class="text-center mt-5">Registration</h3>
	<form action="<%=AMView.USER_REGISTRATION_CTL%>" method="post">
<h4 class="text-center mt-5" style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h4>
	<h4 class="text-center mt-5" style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h4>
	
		<jsp:useBean id="bean" scope="request"
			class="com.amis.ms.Bean.UserBean" />
		<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
			type="hidden" name="createdBy" value="<%=bean.getCreatedby()%>">
		<input type="hidden" name="modifiedBy"
			value="<%=bean.getModifiedby()%>"> <input type="hidden"
			name="createdDatetime" value="<%=bean.getCreatedatetime()%>">
		<input type="hidden" name="modifiedDateTime"
			value="<%=bean.getModifieddatetime()%>">



		<div class="container mt-5">
		  <div class="row h-100 justify-content-center align-items-center">
			<div class="col-6">
				<label for="exampleInputEmail1" class="form-label">First
					Name</label> <input type="text" name="firstName" class="form-control "
					id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>
			<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("firstName", request)%></div>
			<div class="col-6">
				<label for="exampleInputEmail1" class="form-label">Last Name</label>
				<input type="text" name="lastName" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>
			<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("lastName", request)%></div>
			<div class="col-6">
				<label for="exampleInputEmail1" class="form-label">Email</label> <input
					type="text" name="email" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>
			<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("email", request)%></div>
			<div class="col-6">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password" name="password" class="form-control"
					id="exampleInputPassword1">
			</div>

			<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("password", request)%></div>
			<div class="col-6">
				<label for="exampleInputEmail1" class="form-label">PhoneNo</label> <input
					type="text" name="phoneNo" class="form-control"
					id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>
			<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("phoneNo", request)%></div>
			
			
			<%
						HashMap<String, String> map = new HashMap<String, String>();
						map.put("Procurement", "Procurement");
						map.put("Accounts", "Accounts");
					%>

					<div class="col-6">
						<label class="form-label">Department</label>
						<%=HTMLUtility.getList("department", String.valueOf(bean.getDepartment()), map)%>
						</div>
						
						
						
						<div class="col-6" style="margin-left:10px;">
						<label class="form-label">Role</label>
						<select name="role" class="form-control">
						 <option >---Select---</option>
						 <option value="2">Stores Officer</option>
						<option value="3">Procurement Officer</option> 
						<option value="4">Head Of Accounts</option>
						<option value="5">Manager Procurement</option> 
						 </select>
						</div>
						
	<div class="form-text text-center" style="color: red"><%=ServletUtility.getErrorMessage("department", request)%></div>
			
			

<br>
			<div class="container text-center">
				<input type="submit" class="btn btn-primary" name="operation"
					value="<%=RegistrationCtl.OP_SAVE%>">
			</div>
			</div>
		</div>
	</form>
<br>

</div>
</body>
<%@include file="Footer.jsp"%>
</html>