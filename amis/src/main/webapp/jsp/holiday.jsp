<%@page import="com.amis.ms.Ctl.HolidayCtl"%>
<%@page import="com.amis.ms.Bean.HolidayBean"%>
<%@page import="com.amis.ms.Utility.ServletUtility"%>
<%@page import="com.amis.ms.Utility.DataUtility"%>
<%@page import="com.amis.ms.Utility.HTMLUtility"%>
<%@page import="java.util.HashMap"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"> <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css"> <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script> <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript"> $('.datepicker').datepicker(); </script>

<meta charset="ISO-8859-1">
<title>Holiday</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<br>
<%
		UserBean bean2 = (UserBean) session.getAttribute("user");
	%>
	
	<h3 class="text-center mt-5">Apply Leave</h3>
	<hr>
	<h5 class="text-center mt-5" style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h5>
	<h5 class="text-center mt-5" style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h5>

	<form action="<%=AMView.HOLIDAY_CTL%>" method="post">
	<jsp:useBean id="bean" scope="request"
						class="com.amis.ms.Bean.HolidayBean" />
	
		<div class="container mt-5">
			<div class="row h-100 justify-content-center align-items-center">
				<div class="col-6">
					<label class="form-label">Emp Name</label> <input type="text"
						name="empName" class="form-control " value="<%=DataUtility.getStringData(bean2.getFirstName())%>" aria-describedby="emailHelp">
				</div>
				<div class="form-text  text-center" style="color: red"><%=ServletUtility.getErrorMessage("empName", request)%></div>
				<div class="col-6">
					<label class="form-label">Emp Email</label> <input type="text"
						name="empEmail" class="form-control" value="<%=DataUtility.getStringData(bean2.getEmail())%>" aria-describedby="emailHelp">
				</div>
				<div class="form-text  text-center" style="color: red"><%=ServletUtility.getErrorMessage("empEmail", request)%></div>
				<div class="col-6">
					<label class="form-label">Emp ContactNo</label> <input type="text"
						name="empContactNo" class="form-control"
						aria-describedby="emailHelp" value="<%=DataUtility.getStringData(bean2.getPhoneNo())%>">
				</div>
				<div class="form-text  text-center" style="color: red"><%=ServletUtility.getErrorMessage("empContactNo", request)%></div>
				
				<%
						HashMap<String, String> map1 = new HashMap<String, String>();
						map1.put("Manager", "Manager");
						map1.put("HR Department", "HR Department");
						map1.put("Research and development Department", "Research and development Department");
						map1.put("IT services Department", "IT services Department");
					%>

					<div class="col-6">
						<label class="form-label" value="<%=DataUtility.getStringData(bean2.getDepartment())%>" >Department</label>
						<%=HTMLUtility.getList("department", String.valueOf(bean2.getDepartment()), map1)%>
						</div>
	<div class="form-text text-center" style="color: red"><%=ServletUtility.getErrorMessage("department", request)%></div>
			
			
			
	<%
						HashMap<String, String> map = new HashMap<String, String>();
						map.put("Privilege Leave (PL)", "Privilege Leave (PL)");
						map.put("Casual Leave (CL)", "Casual Leave (CL)");
						map.put("Sick Leave (SL)", "Sick Leave (SL)");
						map.put("Maternity Leave (ML)", "Maternity Leave (ML)");
					%>

					<div class="col-6">
						<label class="form-label">Leave Type</label>
						<%=HTMLUtility.getList("leaveType", String.valueOf(bean.getLeaveType()), map)%>
						</div>
	<div class="form-text text-center" style="color: red"><%=ServletUtility.getErrorMessage("leaveType", request)%></div>

										


				<div class="col-6">
					<label class="form-label">Leave To</label> <input type="text"
						name="leaveTo" data-provide="datepicker" id="datepicker" class="form-control" required="required">
				</div>

				<div class="form-group" >
					<label class="form-label" style="margin-left:330px;">Leave From</label>
					<div class="col-6">
						<input style="margin-left:310px; width: 645px;" type="text" data-provide="datepicker" id="datepicker" class="form-control"
							name="leaveFrom" required="required">
					</div>

</div>
				<div class="col-6">
					<label class="form-label">Leave Description</label>
					<textarea rows="3" cols="3" name="leaveDescription"
						class="form-control"></textarea>
				</div>
				<div class="form-text text-center" style="color: red"><%=ServletUtility.getErrorMessage("leaveDescription", request)%></div>

				<br>
				<div class="container text-center">
					<input type="submit" class="btn btn-primary" name="operation"
						value="<%=HolidayCtl.OP_SAVE%>">
				</div>
			</div>
		
		</div>
	</form>
	<br>

	<%@include file="Footer.jsp"%>
</body>
</html>