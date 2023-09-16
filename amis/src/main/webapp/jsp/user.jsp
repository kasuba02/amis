<%@page import="com.amis.ms.UserCtl"%>
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
<title>UserView</title>
</head>
<body>

<%@include file="Header.jsp"%>

	
	<form action="<%=AMView.USER_CTL%>" method="post">
<h4 class="text-center mt-5" style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h4>
	<h4 class="text-center mt-5" style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h4>
	
		<jsp:useBean id="bean" scope="request"
			class="in.co.leave.mg.Bean.UserBean" />
		<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
			type="hidden" name="createdBy" value="<%=bean.getCreatedby()%>">
		<input type="hidden" name="modifiedBy"
			value="<%=bean.getModifiedby()%>"> <input type="hidden"
			name="createdDatetime" value="<%=bean.getCreatedatetime()%>">
		<input type="hidden" name="modifiedDateTime"
			value="<%=bean.getModifieddatetime()%>">

<div class="container text-center">
<%
						ServletUtility.getList(request);
					%>
					<%
						if (bean.getId() > 0) {
					%>
					<h1>Update User</h1>
					<%
						} else {
					%>
					<h1>Add User</h1>
					<%
						}
					%>
</div>

		<div class="container mt-5">
		  <div class="row h-100 justify-content-center align-items-center">
			<div class="col-6">
				<label for="exampleInputEmail1" class="form-label">First
					Name</label> <input type="text" name="firstName" class="form-control " value="<%=DataUtility.getStringData(bean.getFirstName())%>">

			</div>
			<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("firstName", request)%></div>
			<div class="col-6">
				<label for="exampleInputEmail1" class="form-label">Last Name</label>
				<input type="text" name="lastName" class="form-control" value="<%=DataUtility.getStringData(bean.getLastName())%>">
					
			</div>
			<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("lastName", request)%></div>
			<div class="col-6">
				<label for="exampleInputEmail1" class="form-label">Email</label> <input
					type="text" name="email" class="form-control" value="<%=DataUtility.getStringData(bean.getEmail())%>">
					
			</div>
			<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("email", request)%></div>
			<div class="col-6">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password" name="password" class="form-control" value="<%=DataUtility.getStringData(bean.getPassword())%>"
					id="exampleInputPassword1">
			</div>

			<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("password", request)%></div>
			<div class="col-6">
				<label for="exampleInputEmail1" class="form-label">PhoneNo</label> <input
					type="text" name="phoneNo" class="form-control" value="<%=DataUtility.getStringData(bean.getPhoneNo())%>">
					
			</div>
			<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("phoneNo", request)%></div>
			
			
			<%
						HashMap<String, String> map = new HashMap<String, String>();
						map.put("Accounts and Finance Department", "Accounts and Finance Department");
						map.put("HR Department", "HR Department");
						map.put("Research and development Department", "Research and development Department");
						map.put("IT services Department", "IT services Department");
					%>

					<div class="col-6">
						<label class="form-label" value="<%=DataUtility.getStringData(bean.getDepartment())%>">Department</label>
						<%=HTMLUtility.getList("department", String.valueOf(bean.getDepartment()), map)%>
						</div>
	<div class="form-text text-center" style="color: red"><%=ServletUtility.getErrorMessage("department", request)%></div>
			
			
<br>
<div class="container text-center">
			<%
						if (bean.getId() > 0) {
					%>
					<input type="submit" class="btn btn-primary" name="operation"
						value="<%=UserCtl.OP_UPDATE%>">
					<%
						} else {
					%>
					<input type="submit" class="btn btn-primary" name="operation"
						value="<%=UserCtl.OP_SAVE%>">
					<%
						}
					%>
					</div>
			</div>
		</div>
	</form>
<br>
<%@include file="Footer.jsp"%>


</body>
</html>