package com.hailian.web;

import org.jon.lv.pagination.Page;
import org.springframework.stereotype.Controller;

import  com.hailian.conf.BaseController;
import com.hailian.domain.User;
import com.alibaba.fastjson.JSON;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hailian.service.IDataDatasourceConfigService;
import com.hailian.entity.DataDatasourceConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.hailian.annotation.AuthPower;
import com.hailian.result.ResultDO;

/**
 *
 * @author zuoqb123
 * @date 2018-09-24
 * @todo 数据源配置路由
 */
@Controller
@RequestMapping("/api/{version}/dataDatasourceConfig")
@Api(value = "数据源配置控制器")
public class DataDatasourceConfigController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(DataDatasourceConfigController.class);

    @Autowired
    public IDataDatasourceConfigService iDataDatasourceConfigService;

	 /**
     * @time   2018-09-24
     * @author zuoqb123
     * @todo   查询单个对象
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "查询单个数据源配置", notes = "查询单个数据源配置", httpMethod = "GET")
  	@RequestMapping(value = "/get/{id}", method = {RequestMethod.GET,RequestMethod.POST})
  	public ResultDO<DataDatasourceConfig> get(@PathVariable("id") Integer id) {
  		ResultDO<DataDatasourceConfig> resultDO = new ResultDO<>();
  		resultDO.setSuccess(true);
  		List<Integer> idList=new ArrayList<Integer>();
  		idList.add(id);
  		List<DataDatasourceConfig>l=iDataDatasourceConfigService.selectBatchIds(idList);
  		resultDO.setData(iDataDatasourceConfigService.selectByIds(id));
  		return resultDO;
  	}
    
    /**
     * @time   2018-09-24
     * @author zuoqb123
     * @todo   修改单个对象
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "更新单个数据源配置", notes = "更新单个数据源配置", httpMethod = "GET")
  	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
  	public ResultDO<DataDatasourceConfig> update() {
  		ResultDO<DataDatasourceConfig> resultDO = new ResultDO<>();
  		resultDO.setSuccess(true);
  		//DataDatasourceConfig entity=iDataDatasourceConfigService.selectById(1);
  		DataDatasourceConfig entity=new DataDatasourceConfig();
  		entity.setId("1");
  		entity.setEnname("zzzzz");
  		iDataDatasourceConfigService.updateById(entity);
  		resultDO.setData(entity);
  		return resultDO;
  	}
	 /**
     * @time   2018-09-24
     * @author zuoqb123
     * @todo   分页查询
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "分页查询数据源配置", notes = "分页查询数据源配置", httpMethod = "GET")
  	@RequestMapping(value = "/queryPage", method = {RequestMethod.GET,RequestMethod.POST})
    public Page<DataDatasourceConfig> queryPage(Integer pageNumber, Integer pageSize){
        Page<DataDatasourceConfig> page = new Page<>(pageNumber, pageSize);
        iDataDatasourceConfigService.queryPage(page);
        return page;
    }
}

