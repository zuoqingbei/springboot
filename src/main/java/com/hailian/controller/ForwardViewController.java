package com.hailian.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.hailian.annotation.AuthPower;
import com.hailian.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
	/**
	 * 转发视图 2019/01/03
	 * @author lzg
	 */
	@Controller
	@Api(value = "转发视图",description="转发视图 @author lzg")
	public class ForwardViewController extends BaseController{
		//视图名
		private static List<String> viewName = new ArrayList<>();
		static {

		}
		  
	 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	  	@ApiOperation(value = "转发视图", notes = "转发视图", httpMethod = "GET")
		@RequestMapping(value = "/bigSreen/sys/v1/index", method = RequestMethod.GET)
		public String  getIndex(HttpServletRequest request,HttpServletResponse response) {
	    	return "690/sy-yhxw";
	    }
	
	 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	  	@ApiOperation(value = "转发视图", notes = "转发视图", httpMethod = "GET")
		@RequestMapping(value = "/bigSreen/sys/v1/cdwl-sq-2", method = RequestMethod.GET)
		public String  getCdwlSq2(HttpServletRequest request,HttpServletResponse response) {
	    	return "690/cdwl-sq-2";
	    }
	 	
	 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	  	@ApiOperation(value = "转发视图", notes = "转发视图", httpMethod = "GET")
		@RequestMapping(value = "/bigSreen/sys/v1/yhxv", method = RequestMethod.GET)
		public String  getYhxv(HttpServletRequest request,HttpServletResponse response) {
	    	return "690/yhxv";
	    }
	 	
	 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	  	@ApiOperation(value = "转发视图", notes = "转发视图", httpMethod = "GET")
		@RequestMapping(value = "/bigSreen/sys/v1/yhxv-3", method = RequestMethod.GET)
		public String  getYhxv3(HttpServletRequest request,HttpServletResponse response) {
	    	return "690/yhxv-3";
	    }
	 	

	 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	  	@ApiOperation(value = "转发视图", notes = "转发视图", httpMethod = "GET")
		@RequestMapping(value = "/bigSreen/sys/v1/cdwl-sq", method = RequestMethod.GET)
		public String  getCdwlsq(HttpServletRequest request,HttpServletResponse response) {
	    	return "690/cdwl-sq";
	    }
	 	
	 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	  	@ApiOperation(value = "转发视图", notes = "转发视图", httpMethod = "GET")
		@RequestMapping(value = "/bigSreen/sys/v1/cdwl-wg-2", method = RequestMethod.GET)
		public String  getCdwlWg2(HttpServletRequest request,HttpServletResponse response) {
	    	return "690/cdwl-wg-2";
	    }
	 	
	 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	  	@ApiOperation(value = "转发视图", notes = "转发视图", httpMethod = "GET")
		@RequestMapping(value = "/bigSreen/sys/v1/cdwl-wg", method = RequestMethod.GET)
		public String  getCdwlWg(HttpServletRequest request,HttpServletResponse response) {
	    	return "690/cdwl-wg";
	    }
	 	
	 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	  	@ApiOperation(value = "转发视图", notes = "转发视图", httpMethod = "GET")
		@RequestMapping(value = "/bigSreen/sys/v1/fhxv-2", method = RequestMethod.GET)
		public String  getFhxv2(HttpServletRequest request,HttpServletResponse response) {
	    	return "690/fhxv-2";
	    }
	 	
	 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	  	@ApiOperation(value = "转发视图", notes = "转发视图", httpMethod = "GET")
		@RequestMapping(value = "/bigSreen/sys/v1/fhxv", method = RequestMethod.GET)
		public String  getFhxv(HttpServletRequest request,HttpServletResponse response) {
	    	return "690/fhxv";
	    }
	 	
	 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	  	@ApiOperation(value = "转发视图", notes = "转发视图", httpMethod = "GET")
		@RequestMapping(value = "/bigSreen/sys/v1/gongyingbiao", method = RequestMethod.GET)
		public String  getGongyingbiao(HttpServletRequest request,HttpServletResponse response) {
	    	return "690/gongyingbiao";
	    }
	 	
	 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	  	@ApiOperation(value = "转发视图", notes = "转发视图", httpMethod = "GET")
		@RequestMapping(value = "/bigSreen/sys/v1/home", method = RequestMethod.GET)
		public String  getHome(HttpServletRequest request,HttpServletResponse response) {
	    	return "690/home";
	    }
	 	
	 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	  	@ApiOperation(value = "转发视图", notes = "转发视图", httpMethod = "GET")
		@RequestMapping(value = "/bigSreen/sys/v1/index_bak", method = RequestMethod.GET)
		public String  getIndexBak(HttpServletRequest request,HttpServletResponse response) {
	    	return "690/index_bak";
	    }
	 	
	 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	  	@ApiOperation(value = "转发视图", notes = "转发视图", httpMethod = "GET")
		@RequestMapping(value = "/bigSreen/sys/v1/login", method = RequestMethod.GET)
		public String  getLogin(HttpServletRequest request,HttpServletResponse response) {
	    	return "690/login";
	    }
	 	
	 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	  	@ApiOperation(value = "转发视图", notes = "转发视图", httpMethod = "GET")
		@RequestMapping(value = "/bigSreen/sys/v1/sy-cdwl", method = RequestMethod.GET)
		public String  getSyCdwl(HttpServletRequest request,HttpServletResponse response) {
	    	return "690/sy-cdwl";
	    }
	 	
	 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	  	@ApiOperation(value = "转发视图", notes = "转发视图", httpMethod = "GET")
		@RequestMapping(value = "/bigSreen/sys/v1/sy-yhxw", method = RequestMethod.GET)
		public String  getSyYhxw(HttpServletRequest request,HttpServletResponse response) {
	    	return "690/sy-yhxw";
	    }
	 	
	 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
	  	@ApiOperation(value = "转发视图", notes = "转发视图", httpMethod = "GET")
		@RequestMapping(value = "/bigSreen/sys/v1/yhxv-2", method = RequestMethod.GET)
		public String  getYhxv2(HttpServletRequest request,HttpServletResponse response) {
	    	return "690/yhxv-2";
	    }
	 	
	 	
	}
	
	
	
	
	
	
	
