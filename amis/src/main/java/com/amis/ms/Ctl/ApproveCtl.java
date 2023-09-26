package com.amis.ms.Ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.amis.ms.Bean.BaseBean;
import com.amis.ms.Bean.HolidayBean;
import com.amis.ms.Bean.OrderBean;
import com.amis.ms.Bean.UserBean;
import com.amis.ms.Model.HolidayModel;
import com.amis.ms.Model.OrderModel;
import com.amis.ms.Utility.DataUtility;
import com.amis.ms.Utility.ServletUtility;

/**
 * Servlet implementation class ApproveCtl
 */
@WebServlet(name = "ApproveCtl", urlPatterns = "/approve")
public class ApproveCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
	public static final String OP_Approve = "APPROVE";

	public ApproveCtl() {
		super();
	}

    @Override
	protected BaseBean populateBean(HttpServletRequest request) {
		OrderBean bean = new OrderBean();
		HttpSession session = request.getSession(false);
		UserBean existBean = (UserBean)session.getAttribute("user");
		Long userId = existBean.getId();
		bean.setUserid(userId);
		bean.setStatus("Approved");
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setEmpName(DataUtility.getString(request.getParameter("empName")));
		bean.setEmpEmail(DataUtility.getString(request.getParameter("empEmail")));
		bean.setEmpContactNo(DataUtility.getString(request.getParameter("empContactNo")));
		bean.setLeaveType(DataUtility.getString(request.getParameter("leaveType")));
		//bean.setLeaveFrom(LocalDate.parse(request.getParameter("leaveTo")));
		bean.setLeaveTo(DataUtility.getDate(request.getParameter("leaveTo")));
		bean.setLeavedescription(DataUtility.getString(request.getParameter("leaveDescription")));
		bean.setOrder(DataUtility.getLong(request.getParameter("order")));
		bean.setItem(DataUtility.getLong(request.getParameter("item")));
		bean.setQty(DataUtility.getLong(request.getParameter("qty")));
		bean.setUom(DataUtility.getString(request.getParameter("uom")));
		bean.setCode(DataUtility.getLong(request.getParameter("code")));
		bean.setPrice(DataUtility.getLong(request.getParameter("price")));
		bean.setAmount(DataUtility.getLong(request.getParameter("amount")));
		bean.setDepartment(DataUtility.getString(request.getParameter("department")));
		populateDTO(bean, request);
		return bean;

	}
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderModel model = new OrderModel();
		OrderBean bean = null;
		System.out.println("in  APPROVE do get");
		long Hid = DataUtility.getLong(request.getParameter("Hid"));
		if (Hid > 0) {
			try {
				long i = model.Update("Approved", Hid);
				System.out.println("okkkk");
				ServletUtility.forward(getView(), request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		long Rid = DataUtility.getLong(request.getParameter("Rid"));
		if (Rid > 0) {
			try {
				long i = model.reject("Rejected", Rid);
				ServletUtility.forward(getView(), request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		long id = DataUtility.getLong(request.getParameter("id"));

		List list = null;
		HttpSession session = request.getSession(false);
		UserBean bean2 = (UserBean) session.getAttribute("user");
		long roleid = bean2.getRoleid();
		if (roleid == 2) {
			try {
				list = model.Showlist(bean2.getId());
				ServletUtility.setList(list, request);
				ServletUtility.forward(getView(), request, response);
			} catch (Exception e) {
			}
		} else if (roleid == 3) {
			try {
				list = model.Showlist(bean2.getId());
				ServletUtility.setList(list, request);
				ServletUtility.forward(getView(), request, response);
			} catch (Exception e) {
			}
		}
		
		else {
			try {
				list = model.list();
				ServletUtility.setList(list, request);

			} catch (Exception e) {
			}
			ServletUtility.forward(getView(), request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected String getView() {
		return AMView.ORDER_LIST_P_VIEW;
	}

}
