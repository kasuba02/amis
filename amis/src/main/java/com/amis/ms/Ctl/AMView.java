package com.amis.ms.Ctl;



public interface AMView {

	public String APP_CONTEXT = "/amis";
	public String PAGE_FOLDER="/jsp";
	
	
	//Controller------------------------------
	public String WELCOME_CTL = APP_CONTEXT + "/welcome";
	public String INDEX_CTL = APP_CONTEXT + "/index";
	public String LOGIN_CTL = APP_CONTEXT + "/login";
	public String USER_CTL = APP_CONTEXT + "/user";
	public String USERADD_CTL = APP_CONTEXT + "/adduser";
	public String USER_REGISTRATION_CTL = APP_CONTEXT +  "/register";
	public String USER_LIST_CTL = APP_CONTEXT + "/userlist";
	public String HOLIDAY_CTL = APP_CONTEXT + "/holiday";
	public String HOLIDAY_LIST_CTL = APP_CONTEXT + "/holidaylist";
	public String MANAGER_CTL = APP_CONTEXT + "/manager";
	public String APPROVE_LIST_CTL = APP_CONTEXT + "/approve";
	public String REJECT_LIST_CTL = APP_CONTEXT + "/reject";
	public String ORDER_CTL = APP_CONTEXT + "/order";
	public String ORDER_LIST_CTL = APP_CONTEXT + "/orderlist";
	public String ASSET_REGISTRATION_CTL = APP_CONTEXT + "/assetregistration";
	public String ASSET_REGISTRATION_STORES_CTL = APP_CONTEXT + "/assetregistrationstores";
	
	
	//User Controller
	public String ADMIN_CTL = APP_CONTEXT + "/admin";
	public String STOCKOFFICER_CTL = APP_CONTEXT + "/stockofficer";
	public String PROCUREMENTOFFICER_CTL = APP_CONTEXT + "/procurementofficer";
	public String MANAGER_A_CTL = APP_CONTEXT + "/manageraccounts";
	public String MANAGER_P_CTL = APP_CONTEXT + "/managerprocurement";
	public String MANAGER_P_LIST_CTL = APP_CONTEXT + "/managerprocurementorderlist";
	public String STORES_OFFICER_ORDER_LIST_CTL = APP_CONTEXT + "/storesofficerorderlist";
	public String PROCUREMENT_ORDER_LIST = APP_CONTEXT + "/procurementofficerorderlist";
	public String UPDATE_USER = APP_CONTEXT + "/updateuser";
	public String ORDER_EDIT = APP_CONTEXT + "/orderedit";
	
	public String ADMIN_VIEW = PAGE_FOLDER + "/admin.jsp";
	public String STOCKOFFICER_VIEW = PAGE_FOLDER + "/stockofficer.jsp";
	public String PROCUREMENTOFFICER_VIEW = PAGE_FOLDER + "/procurementofficer.jsp";
	public String MANAGER_A_VIEW = PAGE_FOLDER + "/manageraccounts.jsp";
	public String MANAGER_P_VIEW = PAGE_FOLDER + "/managerprocurement.jsp";
	public String MANAGER_P_LIST_VIEW = PAGE_FOLDER + "/managerprocurementorderlist.jsp";
	public String STORESOFFICER_ORDER_LIST_VIEW = PAGE_FOLDER + "/storesofficerorderlist.jsp";
	
	
	
	
	//View-------------------------------------
	public String WELCOME_VIEW = PAGE_FOLDER + "/welcome.jsp";
	public String INDEX_VIEW = PAGE_FOLDER + "/index.jsp";
	public String LOGIN_VIEW = PAGE_FOLDER + "/login.jsp";
	public String USER_VIEW = PAGE_FOLDER + "/user.jsp";
	public String USERADD_VIEW = PAGE_FOLDER + "/useradd.jsp";
	public String USER_REGISTRATION_VIEW = PAGE_FOLDER + "/registration.jsp";
	public String USER_LIST_VIEW = PAGE_FOLDER + "/userlist.jsp";
	public String HOLIDAY_VIEW = PAGE_FOLDER + "/holiday.jsp";
	public String HOLIDAY_LIST_VIEW = PAGE_FOLDER + "/holidaylist.jsp";
	public String MANAGER_VIEW = PAGE_FOLDER + "/manager.jsp";
	public String ORDER_VIEW = PAGE_FOLDER + "/order.jsp";
	public String ORDER_LIST_VIEW = PAGE_FOLDER + "/orderlist.jsp";
	public String ORDER_LIST_P_VIEW = PAGE_FOLDER + "/orderlistp.jsp";
	public String ASSET_REGISTRATION_VIEW = PAGE_FOLDER + "/assetregistration.jsp";
	public String ASSET_REGISTRATION_STORES_VIEW = PAGE_FOLDER + "/assetregistrationstores.jsp";
	public String APPROVE_REJECT_VIEW = PAGE_FOLDER + "/approve-reject.jsp";
	public String STOCKOFFICER_ORDER_VIEW = PAGE_FOLDER + "/orderlist.jsp";
	public String PROCUREMENTOFFICER_ORDER_VIEW = PAGE_FOLDER + "/procurementofficerorderlist.jsp";
	public String UPDATE_USER_VIEW = PAGE_FOLDER + "/updateuser.jsp";
	public String ORDER_EDIT_VIEW = PAGE_FOLDER + "/orderedit.jsp";
	
}  
