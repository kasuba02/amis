package com.amis.ms.Ctl;



public interface AMView {

	public String APP_CONTEXT = "/amis";
	public String PAGE_FOLDER="/jsp";
	
	
	//Controller------------------------------
	public String WELCOME_CTL = APP_CONTEXT + "/welcome";
	public String INDEX_CTL = APP_CONTEXT + "/index";
	public String LOGIN_CTL = APP_CONTEXT + "/login";
	public String USER_CTL = APP_CONTEXT + "/user";
	public String USER_REGISTRATION_CTL = APP_CONTEXT +  "/register";
	public String USER_LIST_CTL = APP_CONTEXT + "/userlist";
	public String HOLIDAY_CTL = APP_CONTEXT + "/holiday";
	public String HOLIDAY_LIST_CTL = APP_CONTEXT + "/holidaylist";
	public String MANAGER_CTL = APP_CONTEXT + "/manager";
	public String APPROVE_LIST_CTL = APP_CONTEXT + "/approve";
	public String REJECT_LIST_CTL = APP_CONTEXT + "/reject";
	
	//User Controller
	public String ADMIN_CTL = APP_CONTEXT + "/admin";
	public String STOCKOFFICER_CTL = APP_CONTEXT + "/stockofficer";
	public String PROCUREMENTOFFICER_CTL = APP_CONTEXT + "/procurementofficer";
	public String MANAGER_A_CTL = APP_CONTEXT + "/manager-accounts";
	public String MANAGER_P_CTL = APP_CONTEXT + "/manager-procurement";
	
	//User View
	public String ADMIN_VIEW = PAGE_FOLDER + "/admin.jsp";
	public String STOCKOFFICER_VIEW = PAGE_FOLDER + "/stockofficer.jsp";
	public String PROCUREMENTOFFICER_VIEW = PAGE_FOLDER + "/procurementofficer.jsp";
	public String MANAGER_A_VIEW = PAGE_FOLDER + "/manageraccounts.jsp";
	public String MANAGER_P_VIEW = PAGE_FOLDER + "/managerprocurement.jsp";
	
	
	
	
	
	//View-------------------------------------
	public String WELCOME_VIEW = PAGE_FOLDER + "/welcome.jsp";
	public String INDEX_VIEW = PAGE_FOLDER + "/index.jsp";
	public String LOGIN_VIEW = PAGE_FOLDER + "/login.jsp";
	public String USER_VIEW = PAGE_FOLDER + "/user.jsp";
	public String USER_REGISTRATION_VIEW = PAGE_FOLDER + "/registration.jsp";
	public String USER_LIST_VIEW = PAGE_FOLDER + "/userlist.jsp";
	public String HOLIDAY_VIEW = PAGE_FOLDER + "/holiday.jsp";
	public String HOLIDAY_LIST_VIEW = PAGE_FOLDER + "/holidaylist.jsp";
	public String MANAGER_VIEW = PAGE_FOLDER + "/manager.jsp";
}