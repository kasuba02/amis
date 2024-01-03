package com.amis.ms.Ctl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amis.ms.Bean.BaseBean;
import com.amis.ms.Bean.HolidayBean;
import com.amis.ms.Bean.OrderBean;
import com.amis.ms.Model.OrderModel;
import com.amis.ms.Bean.UserBean;
import com.amis.ms.Exception.ApplicationException;
import com.amis.ms.Exception.DuplicateRecordException;
import com.amis.ms.Model.HolidayModel;
import com.amis.ms.Utility.DataUtility;
import com.amis.ms.Utility.DataValidator;
import com.amis.ms.Utility.PropertyReader;
import com.amis.ms.Utility.ServletUtility;


/**
 * Servlet implementation class HolidayCtl
 */
@WebServlet(name = "OrderCtl", urlPatterns = "/order")
public class OrderCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_SAVE = "Save";
   
    public OrderCtl() {
        super();
    }

    @Override
	protected boolean validate(HttpServletRequest request) {
		System.out.println("in validation");
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("empName"))) {
			request.setAttribute("empName", PropertyReader.getvalue("error.require", "Emp Name"));
			pass = false;

		} else if (!DataValidator.isName(request.getParameter("empName"))) {
			request.setAttribute("empName", PropertyReader.getvalue("error.name", "Emp Name"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("empEmail"))) {
			request.setAttribute("empEmail", PropertyReader.getvalue("error.require", "Emp Email Id"));
			pass = false;

		} else if (!DataValidator.isEmail(request.getParameter("empEmail"))) {
			request.setAttribute("empEmail", PropertyReader.getvalue("error.login", " Emp Email Id"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("empContactNo"))) {
			request.setAttribute("empContactNo", PropertyReader.getvalue("error.require", "Emp ContactNo"));
			pass = false;
			
		} else if (!DataValidator.isMobileNo(request.getParameter("empContactNo"))) {
			request.setAttribute("empContactNo", PropertyReader.getvalue("error.name", "Emp ContactNo"));
			pass = false;

		}
		if ("-----Select-----".equalsIgnoreCase(request.getParameter("department"))) {
			request.setAttribute("department", PropertyReader.getvalue("error.require", "Department"));
			pass = false;
		}
		
		if ("-----Select-----".equalsIgnoreCase(request.getParameter("leaveType"))) {
			request.setAttribute("leaveType", PropertyReader.getvalue("error.require", "Leave Type"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("leaveDescription"))) {
			request.setAttribute("leaveDescription", PropertyReader.getvalue("error.require", "Leave Description"));
			pass = false;
		}
		
		return pass;
	}

    @Override
	protected BaseBean populateBean(HttpServletRequest request) {
		OrderBean bean = new OrderBean();
		HttpSession session = request.getSession(false);
		UserBean existBean = (UserBean)session.getAttribute("user");
		Long userId = existBean.getId();
		bean.setUserid(userId);
		bean.setStatus("Approve");
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setEmpName(DataUtility.getString(request.getParameter("empName")));
		bean.setEmpEmail(DataUtility.getString(request.getParameter("empEmail")));
		bean.setEmpContactNo(DataUtility.getString(request.getParameter("empContactNo")));
		bean.setLeaveType(DataUtility.getString(request.getParameter("type")));
		//bean.setLeaveFrom(LocalDate.parse(request.getParameter("leaveTo")));
		bean.setLeaveTo(DataUtility.getDate(request.getParameter("leaveTo")));
		bean.setLeavedescription(DataUtility.getString(request.getParameter("leaveDescription")));
		bean.setOrder(DataUtility.getLong(request.getParameter("order")));
		bean.setItem(DataUtility.getLong(request.getParameter("item")));
		bean.setQty(DataUtility.getLong(request.getParameter("qty")));
		bean.setUom(DataUtility.getString(request.getParameter("uom")));
		bean.setCode(DataUtility.getLong(request.getParameter("code")));
		bean.setPrice(DataUtility.getLong(request.getParameter("price")));
		bean.setAmount(DataUtility.getLong(request.getParameter("qty"))*DataUtility.getLong(request.getParameter("price")));
		bean.setDepartment(DataUtility.getString(request.getParameter("department")));
		populateDTO(bean, request);
		return bean;

	}
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do post");
		OrderModel model = new OrderModel();

		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		OrderBean bean = new OrderBean();
		bean = (OrderBean) populateBean(request);
		if (OP_SAVE.equalsIgnoreCase(op)) {
			bean = (OrderBean) populateBean(request);
			try {
				long pk = model.add(bean);
				ServletUtility.setbean(bean, request);
				ServletUtility.setSuccessMessage("Order Applied", request);
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
		return AMView.ORDER_VIEW;
	}

}
