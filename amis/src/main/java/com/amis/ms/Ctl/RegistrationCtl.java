package com.amis.ms.Ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amis.ms.Bean.BaseBean;
import com.amis.ms.Bean.UserBean;
import com.amis.ms.Exception.ApplicationException;
import com.amis.ms.Exception.DuplicateRecordException;
import com.amis.ms.Model.UserModel;
import com.amis.ms.Utility.DataUtility;
import com.amis.ms.Utility.DataValidator;
import com.amis.ms.Utility.PropertyReader;
import com.amis.ms.Utility.ServletUtility;

/**
 * Servlet implementation class RegistrationCtl
 */
@WebServlet(name = "RegistrationCtl", urlPatterns = "/register")
public class RegistrationCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_SIGN_UP = "SignUp";
	public static final String OP_SAVE = "Save";
	public static final String OP_RESET = "Reset";
	public static final String OP_NEW = "New";
	public static final String OP_MYPROFILE = "MyProfile";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationCtl() {
        super();
        // TODO Auto-generated constructor stub
    }
	@Override
	protected boolean validate(HttpServletRequest request) {
		System.out.println("in validation");
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("firstName"))) {
			request.setAttribute("firstName", PropertyReader.getvalue("error.require", "First Name"));
			pass = false;

		} else if (!DataValidator.isName(request.getParameter("firstName"))) {
			request.setAttribute("firstName", PropertyReader.getvalue("error.name", "First Name"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("lastName"))) {
			request.setAttribute("lastName", PropertyReader.getvalue("error.require", "Last Name"));
			pass = false;
			
		} else if (!DataValidator.isName(request.getParameter("lastName"))) {
			request.setAttribute("lastName", PropertyReader.getvalue("error.name", "Last Name"));
			pass = false;

		}
		if (DataValidator.isNull(request.getParameter("email"))) {
			request.setAttribute("email", PropertyReader.getvalue("error.require", "Email Id"));
			pass = false;

		} else if (!DataValidator.isEmail(request.getParameter("email"))) {
			request.setAttribute("email", PropertyReader.getvalue("error.login", "Email Id"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("password"))) {
			request.setAttribute("password", PropertyReader.getvalue("error.require", "Password"));
			pass = false;

		}
		else if (!DataValidator.isPassword(request.getParameter("password"))) {
			request.setAttribute("password", PropertyReader.getvalue("error.password", "Password"));
			return false;

		}
		
		if (DataValidator.isNull(request.getParameter("phoneNo"))) {
			request.setAttribute("phoneNo", PropertyReader.getvalue("error.require", "Phone No"));
			pass = false;
			
		} else if (!DataValidator.isMobileNo(request.getParameter("phoneNo"))) {
			request.setAttribute("phoneNo", PropertyReader.getvalue("error.mobileNo", "Phone No"));
			pass = false;

		}
		if ("-----Select-----".equalsIgnoreCase(request.getParameter("department"))) {
			request.setAttribute("department", PropertyReader.getvalue("error.require", "Department"));
			pass = false;
		}
		
		return pass;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		UserBean bean = new UserBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setFirstName(DataUtility.getString(request.getParameter("firstName")));
		bean.setLastName(DataUtility.getString(request.getParameter("lastName")));
		bean.setEmail(DataUtility.getString(request.getParameter("email")));
		bean.setPassword(DataUtility.getString(request.getParameter("password")));
		bean.setPhoneNo(DataUtility.getString(request.getParameter("phoneNo")));
	//	bean.setRoleid(2);
		//bean.setRolename("Employ");
		
		bean.setRoleid(DataUtility.getLong(request.getParameter("role")));
		
		if (bean.getRoleid()==2) {
			bean.setRolename("StockOfficer");
		}else if (bean.getRoleid()==3) {
			
			bean.setRolename("ProcurementOfficer");
		}else if (bean.getRoleid() == 4) {
			
			bean.setRolename("ManagerAccounts");
		}else if (bean.getRoleid() == 5) {
			
			bean.setRolename("ManagerProcurement");
		}
		
		
		else {
			bean.setRolename("Manager");
		}
		//bean.setRolename(DataUtility.getString(request.getParameter("roleName")));
		bean.setDepartment(DataUtility.getString(request.getParameter("department")));
		populateDTO(bean, request);
		return bean;

	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletUtility.forward(getView(), request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do post");
		UserModel model = new UserModel();

		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		UserBean bean = new UserBean();
		bean = (UserBean) populateBean(request);
		if (OP_SAVE.equalsIgnoreCase(op)) {
			bean = (UserBean) populateBean(request);
			try {
				long pk = model.add(bean);
				ServletUtility.setbean(bean, request);
				ServletUtility.setSuccessMessage("User Successfully Registered", request);
				ServletUtility.forward(getView(), request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setbean(bean, request);
				ServletUtility.setErrorMessage(e.getMessage(), request);
				ServletUtility.forward(getView(), request, response);

			} catch (ApplicationException e) {

				e.printStackTrace();
			} catch (Exception e) {

				e.printStackTrace();
			}
			ServletUtility.forward(getView(), request, response);

		}
	}

	@Override
	protected String getView() {
		return AMView.USER_REGISTRATION_VIEW;
	}

}
