package com.hailian.web;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.jon.lv.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hailian.annotation.AuthPower;
import com.hailian.conf.BaseController;
import com.hailian.entity.DataDatasourceConfig;
import com.hailian.result.ResultDO;
import com.hailian.service.IDataDatasourceConfigService;

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

    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "查询单个数据源配置", notes = "查询单个数据源配置", httpMethod = "GET")
  	@RequestMapping(value = "/get/{id}", method = {RequestMethod.GET,RequestMethod.POST})
 	public ResultDO<DataDatasourceConfig> get(@PathVariable("id") Integer id) {
  		ResultDO<DataDatasourceConfig> resultDO = new ResultDO<>();
  		/*List<DataDatasourceConfig> entity0=iDataDatasourceConfigService.selectListBySQL(id);
  		System.out.println(entity0);*/
  		List<String> ids=new ArrayList<String>();
  		ids.add("1");
  		List<DataDatasourceConfig> entity1=iDataDatasourceConfigService.selectBatchIds(ids);
  		System.out.println(entity1);
  		DataDatasourceConfig entity=iDataDatasourceConfigService.selectById(id);
  		resultDO.setSuccess(true);
  		resultDO.setData(entity);
  		return resultDO;
  	}
    /**
     * 
     * @time   2018年9月24日 下午4:51:58
     * @author zuoqb
     * @todo   分页查询
     * @return_type   Page<DataDatasourceConfig>
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

