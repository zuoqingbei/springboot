package com.hailian.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hailian.annotation.AuthPower;
import com.hailian.base.BaseController;
import com.hailian.utils.FileUtil;
import com.lianxin.tax.EtaxFileUtils;
/**
 *
 * @date 2018-10-09
 * @author zuoqb123
 * @todo 报税文件处理
 */
@Controller
@Api(value = "报税文件处理",description="报税文件处理 @author zuoqb123")
public class DtaxFileController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(DtaxFileController.class);

    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "生成报税文件", notes = "生成报税文件", httpMethod = "GET")
	@RequestMapping(value = "/api/v1/dtax/createFile", method = RequestMethod.GET)
	public Object createFile(HttpServletRequest request) {
    	Map<String, Object> data=EtaxFileUtils.dealFiles(FileUtil.ETAX_FILE_UPLOAD);//FileUtil.ETAX_FILE_UPLOAD
    	EtaxFileUtils.createExcel(null, FileUtil.CREATE_ETAX_PATH);//FileUtil.CREATE_ETAX_PATH
		return null;
	}
    
  
}

