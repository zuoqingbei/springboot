package com.hailian.base;

import java.text.SimpleDateFormat;

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
	public static final  String DB_TYPE = JdbcConstants.MYSQL;
	public static final  String DB_URL="jdbc:mysql://10.130.96.74:3306/lianxin?characterEncoding=utf8";
	public static final  String DB_DRIVER=JdbcConstants.MYSQL_DRIVER;
	public static final  String DB_USER="root";
	public static final String DB_PWD="hl123456";
	public static final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
	/**
	 * @time   2018年9月26日 上午11:24:33
	 * @author zuoqb
	 * @todo   判断是否为超级管理员
	 * @return_type   boolean
	 */
	public boolean isAdmin(HttpServletRequest request){
		User user=(User) request.getSession().getAttribute(USER_INFO);
		if(user==null)
			return false;
		if(!"1".equals(user.getUserType()))
			return false;
		return true;
	}
	
}
