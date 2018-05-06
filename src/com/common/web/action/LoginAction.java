package com.common.web.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.opensymphony.xwork.ActionContext;
import com.base.value.BaseObject;
import com.base.value.SessionUser;
import com.common.service.CommonManager;
import com.common.value.*;
import com.opensymphony.webwork.config.Configuration;
import com.opensymphony.xwork.util.LocalizedTextUtil;
import com.common.mail.*;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.base.value.*;
import com.common.web.*;

public class LoginAction extends CommonActionSupport {
	private static final long serialVersionUID = 100L;
	private final Log log;
	private String cellphone, password, msg;

	public LoginAction() {
		log = LogFactory.getLog(com.common.web.action.LoginAction.class);
	}

	public void setGenericManager(CommonManager m) {
		super.setGenericManager(m);
	}

	public CommonManager getGenericManager() {
		return (CommonManager) super.getGenericManager();
	}

	public String logout() {
		log.info("entering 'logout' method");
		super.getSession().removeAttribute("user"); // .remove(AuthenticationInterceptor.USER);
		super.getSession().invalidate();
		log.info("exit 'logout' method");
		return SUCCESS;
	}

	public String save() {
		log.info("entering 'execute' method");
		return SUCCESS;
	}

	public String execute() {
		if (cellphone == null || password == null) {
			appendXworkParam("msg=2");
			return INPUT;
		}
		System.out.println("cellphone="+cellphone+"---password="+password);
		Member user = getGenericManager().getMemberByLoginIdAndPassword(cellphone, password);
		if (user == null) {
			// 如果找不到這個user登入失敗
			System.out.println("如果找不到這個user登入失敗");
			appendXworkParam("msg=2");
			return INPUT;
		} else {
			System.out.println(user.getName() + " 登入成功!!    getLocal()=" + getLocal());
			getSession().setAttribute("user", copyToSessionUser(user)); // 成功登入
			return SUCCESS;
		}
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}