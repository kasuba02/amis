package com.amis.ms.Ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amis.ms.Bean.BaseBean;
import com.amis.ms.Bean.UserBean;
import com.amis.ms.Model.UserModel;
import com.amis.ms.Utility.DataUtility;
import com.amis.ms.Utility.DataValidator;
import com.amis.ms.Utility.PropertyReader;
import com.amis.ms.Utility.ServletUtility;

/**
 * Servlet implementation class LoginCtl
 */
@WebServlet(name = "LoginCtl", urlPatterns = "/login")
public class LoginCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_SIGNIN = "SignIn";
	public static final String OP_SING_UP = "SignUp";
	public static final String OP_LOGOUT = "Logout";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		String op = request.getParameter("operation");

		if (OP_SING_UP.equalsIgnoreCase(op) || OP_LOGOUT.equalsIgnoreCase(op)) {
			return true;
		}

		if (DataValidator.isNull(request.getParameter("email"))) {
			request.setAttribute("email", PropertyReader.getvalue("error.require", "Login Id"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("password"))) {
			request.setAttribute("password", PropertyReader.getvalue("error.require", "Password"));
			pass = false;

		}
		return pass;

	}
	
	protected BaseBean populateBean(HttpServletRequest request) {

		UserBean bean = new UserBean();

		bean.setEmail(DataUtility.getString(request.getParameter("email")));
		bean.setPassword(DataUtility.getString(request.getParameter("password")));
		populateDTO(bean, request);

		return bean;
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = DataUtility.getString(request.getParameter("operation"));

		HttpSession session = request.getSession(false);

		UserBean bean = (UserBean) populateBean(request);
		if (OP_LOGOUT.equalsIgnoreCase(op)) {
			session = request.getSession(false);
			session.invalidate();
			ServletUtility.setSuccessMessage("LogoutSucessfully", request);
			ServletUtility.forward(AMView.LOGIN_VIEW, request, response);
			return;
		}
		ServletUtility.setbean(bean, request);
		ServletUtility.forward(getView(), request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		String op = DataUtility.getString(request.getParameter("operation"));

		UserModel model = new UserModel();

		if (OP_SING_UP.equalsIgnoreCase(op)) {
			ServletUtility.redirect(AMView.USER_REGISTRATION_CTL, request, response);
			return;
		}

		if (OP_SIGNIN.equalsIgnoreCase(op)) {
			UserBean bean = (UserBean) populateBean(request);
			try {
				bean = model.Authenticate(bean.getEmail(), bean.getPassword());
				if (bean.getRoleid() == 1) {
				
						session.setAttribute("user", bean);
						ServletUtility.setbean(bean, request);
						ServletUtility.redirect(AMView.ADMIN_CTL, request, response);
						return;

					
				} else if(bean.getRoleid() == 2) {
					
					session.setAttribute("user", bean);
					ServletUtility.setbean(bean, request);
					ServletUtility.redirect(AMView.STOCKOFFICER_CTL, request, response);
					return;
					
					
				}else if(bean.getRoleid() == 3) {
					
					session.setAttribute("user", bean);
					ServletUtility.setbean(bean, request);
					ServletUtility.redirect(AMView.PROCUREMENTOFFICER_CTL, request, response);
					return;
					
					
				}else if(bean.getRoleid() == 4) {
					
					session.setAttribute("user", bean);
					ServletUtility.setbean(bean, request);
					ServletUtility.redirect(AMView.MANAGER_A_CTL, request, response);
					return;
					
					
				}else if(bean.getRoleid() == 5) {
					
					session.setAttribute("user", bean);
					ServletUtility.setbean(bean, request);
					ServletUtility.redirect(AMView.MANAGER_P_CTL, request, response);
					return;
					
					
				}
				
				
				
	
				
				
				else {
					bean = (UserBean) populateBean(request);
					ServletUtility.setbean(bean, request);
					ServletUtility.setErrorMessage("Invalid Id and Password", request);
					ServletUtility.forward(getView(), request, response);
				}
			} catch (Exception e) {
			}

		}

		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected String getView() {
		return AMView.LOGIN_VIEW;
	}

}
