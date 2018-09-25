package com.hailian.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.util.JdbcConstants;
import com.hailian.conf.Constant;
import com.hailian.domain.User;

public class BaseController implements Constant{
	/*@Value("${pager.pageSize}")
	public Integer pageSize;
	@Value("${pager.pageNumber}")
	public String pageNumber;*/
	@Autowired
	public JdbcTemplate jdbcTemplate;
	public String DB_TYPE = JdbcConstants.MYSQL;
	public String DB_URL="jdbc:mysql://10.130.96.74:3306/lianxin?characterEncoding=utf8";
	public String DB_DRIVER=JdbcConstants.MYSQL_DRIVER;
	public String DB_USER="root";
	public String DB_PWD="hl123456";
	public void clearSessionUser(HttpServletRequest request,HttpServletResponse response,String key){
		request.getSession().setAttribute(key, null);
	}
	
	/**
	 * 设置session
	 * */
	public void setSession(HttpServletRequest request,HttpServletResponse response,String key,Object value) {
		request.getSession().setAttribute(key, value);
		if("datamart_user".equals(key)){
			request.getSession().setMaxInactiveInterval(3600);
		}
	}
	/**
	 * 获取session
	 * @return 
	 * */
	public Object getSession(HttpServletRequest request,HttpServletResponse response,String key) {
		return request.getSession().getAttribute(key);
	}
	/**
	 * 获取当前登录人
	 * @param request
	 * @param response
	 * @return
	 */
	public User getLoginUser(HttpServletRequest request){
		User user=(User) request.getSession().getAttribute(USER_INFO);
		if(user==null)
			user=new User();
		return user;
	}
	
}