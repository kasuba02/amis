package com.amis.ms.Ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amis.ms.Bean.BaseBean;
import com.amis.ms.Bean.UserBean;
import com.amis.ms.Model.UserModel;
import com.amis.ms.Utility.DataUtility;
import com.amis.ms.Utility.ServletUtility;

/**
 * Servlet implementation class UserListCt
 */
@WebServlet(name = "UserListCt", urlPatterns = "/userlist")
public class UserListCt extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
   
    public UserListCt() {
        super();
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
		bean.setRoleid(2);
		bean.setRolename("Employ");
		bean.setDepartment(DataUtility.getString(request.getParameter("department")));
		populateDTO(bean, request);
		return bean;

	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel model = new UserModel();
		UserBean bean = null;
		long id = DataUtility.getLong(request.getParameter("id"));

		if (id > 0) {
			model.delete(id);
			ServletUtility.setSuccessMessage("Data Deleted Successfully", request);
		}

		List list = null;
		// read search name from form data
		String theSearchName = request.getParameter("theSearchName");
		try {
			System.out.println("in do get");
			list = model.list(theSearchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list == null && list.size() == 0) {
			ServletUtility.setErrorMessage("No record found", request);
		}
		ServletUtility.setList(list, request);
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected String getView() {
		return AMView.USER_LIST_VIEW;
	}

}
