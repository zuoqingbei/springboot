package com.hailian.web;

import org.springframework.stereotype.Controller;
import com.hailian.base.BaseController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import com.hailian.service.IDataDatasourceConfigService;
import com.hailian.entity.DataDatasourceConfig;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.hailian.annotation.AuthPower;
import com.hailian.base.PublicResult;
import com.hailian.common.UUIDUtils;
import com.hailian.enums.PublicResultConstant;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 *
 * @author zuoqb123
 * @date 2018-09-26
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
     * @date   2018-09-26
     * @author zuoqb123
     * @todo   查询单个数据源配置
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "查询单个数据源配置", notes = "查询单个数据源配置", httpMethod = "GET")
  	@RequestMapping(value = "/get/{id}", method = {RequestMethod.GET,RequestMethod.POST})
  	public PublicResult<DataDatasourceConfig> get(HttpServletRequest request,@PathVariable("id") String id) {
  		DataDatasourceConfig entity=null;
  		try {
  			EntityWrapper<DataDatasourceConfig> wrapper = new EntityWrapper<DataDatasourceConfig>();
  			wrapper.where("del_flag={0}", 0);
  			wrapper.eq("id", id);
  			entity=iDataDatasourceConfigService.selectOne(wrapper);
  			return new PublicResult<>(PublicResultConstant.SUCCESS, entity);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(), null);
		}
  	}
    
    /**
     * @date   2018年9月25日 下午3:46:31
     * @author zuoqb123
     * @todo   保存或者更新数据源配置
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "保存或者更新数据源配置", notes = "保存或者更新数据源配置", httpMethod = "POST")
	@RequestMapping(value = "/saveOrUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public PublicResult<DataDatasourceConfig> add(HttpServletRequest request,DataDatasourceConfig entity) {
		try {
			if(entity!=null&&StringUtils.isNotBlank(entity.getId())){
				//更新
				entity.setUpdateDate(new Date());
				entity.setUpdateBy(getLoginUser(request).getId());
				iDataDatasourceConfigService.updateById(entity);
			}else{
				entity.setId(UUIDUtils.getUuid());
				entity.setCreateDate(new Date());
				entity.setCreateBy(getLoginUser(request).getId());
				iDataDatasourceConfigService.insert(entity);
			}
			return new PublicResult<>(PublicResultConstant.SUCCESS, entity);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(), null);
		}
	}
    
    
    
    /**
     * @date   2018年9月25日 下午3:46:31
     * @author zuoqb123
     * @todo   删除数据源配置
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "删除数据源配置", notes = "删除数据源配置", httpMethod = "POST")
    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET,RequestMethod.POST})
	public PublicResult<DataDatasourceConfig> delete(HttpServletRequest request,@PathVariable("id") String id) {
		try {
			DataDatasourceConfig entity=new DataDatasourceConfig();
			entity.setId(id);
			entity.setDelFlag("1");
			entity.setUpdateDate(new Date());
			entity.setUpdateBy(getLoginUser(request).getId());
			 if(iDataDatasourceConfigService.updateById(entity)){
				 return new PublicResult<>(PublicResultConstant.SUCCESS, null);
			 }else{
				 return new PublicResult<>(PublicResultConstant.FAILED, null);
			 }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(), null);
		}
	}
    
    /**
     * @date   2018-09-26
     * @author zuoqb123
     * @todo   按照条件查询数据源配置
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "按照条件查询数据源配置", notes = "按照条件查询数据源配置", httpMethod = "GET")
  	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
    public PublicResult<List<DataDatasourceConfig>> list(HttpServletRequest request,DataDatasourceConfig entity){
         try {
        	 EntityWrapper<DataDatasourceConfig> wrapper = searchWrapper(request, entity);
        	 List<DataDatasourceConfig> list = iDataDatasourceConfigService.selectList(wrapper);
 			return new PublicResult<>(PublicResultConstant.SUCCESS, list);
 		} catch (Exception e) {
 			e.printStackTrace();
 			logger.error(e.getMessage());
 			return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(), null);
 		}
    }
	
    /**
     * @date   2018-09-26
     * @author zuoqb123
     * @todo   分页查询数据源配置
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "分页查询数据源配置", notes = "分页查询数据源配置", httpMethod = "GET")
  	@RequestMapping(value = "/queryPage", method = {RequestMethod.GET,RequestMethod.POST})
    public PublicResult<PageInfo<DataDatasourceConfig>> queryPage(DataDatasourceConfig entity,@RequestParam(value="pageNum",required = false,defaultValue="1") Integer pageNum,
			@RequestParam(value="pageSize",required = false,defaultValue="10") Integer pageSize,HttpServletRequest request) {
		try {
			EntityWrapper<DataDatasourceConfig> wrapper = searchWrapper(request, entity);
			PageHelper.startPage(pageNum, pageSize);
			List<DataDatasourceConfig> list = iDataDatasourceConfigService.selectList(wrapper);
			PageInfo<DataDatasourceConfig> page = new PageInfo<DataDatasourceConfig>(list);
			return new PublicResult<>(PublicResultConstant.SUCCESS, page);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(),null);
		}

	}
    /**
     * @date   2018年9月25日 下午5:36:10
     * @author zuoqb123
     * @todo   构建查询条件-以后扩展
     */
    private EntityWrapper<DataDatasourceConfig> searchWrapper(HttpServletRequest request, DataDatasourceConfig entity) {
		EntityWrapper<DataDatasourceConfig> wrapper = new EntityWrapper<DataDatasourceConfig>();
		wrapper.where("del_flag={0}", 0);
		if(getLoginUser(request)!=null&&StringUtils.isNotBlank(getLoginUser(request).getId())){
			if(!isAdmin(request))
			 wrapper.and("create_by", getLoginUser(request).getId());
		}
		//根据编号模糊查询
		if(entity.getId()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getId()))){
			wrapper.like("id", String.valueOf(entity.getId()));
		}
		//根据创建用户模糊查询
		if(entity.getUserId()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getUserId()))){
			wrapper.like("user_id", String.valueOf(entity.getUserId()));
		}
		//根据数据源名称模糊查询
		if(entity.getName()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getName()))){
			wrapper.like("name", String.valueOf(entity.getName()));
		}
		//根据数据源英文名称模糊查询
		if(entity.getEnname()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getEnname()))){
			wrapper.like("enname", String.valueOf(entity.getEnname()));
		}
		//根据数据源类型模糊查询
		if(entity.getDbType()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getDbType()))){
			wrapper.like("db_type", String.valueOf(entity.getDbType()));
		}
		//根据数据源驱动模糊查询
		if(entity.getDbDiver()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getDbDiver()))){
			wrapper.like("db_diver", String.valueOf(entity.getDbDiver()));
		}
		//根据数据连接地址模糊查询
		if(entity.getDbUrl()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getDbUrl()))){
			wrapper.like("db_url", String.valueOf(entity.getDbUrl()));
		}
		//根据用户名模糊查询
		if(entity.getDbName()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getDbName()))){
			wrapper.like("db_name", String.valueOf(entity.getDbName()));
		}
		//根据连接密码模糊查询
		if(entity.getDbPassword()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getDbPassword()))){
			wrapper.like("db_password", String.valueOf(entity.getDbPassword()));
		}
		//根据最大连接数模糊查询
		if(entity.getMaxNum()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getMaxNum()))){
			wrapper.like("max_num", String.valueOf(entity.getMaxNum()));
		}
		//根据是否可用模糊查询
		if(entity.getUseable()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getUseable()))){
			wrapper.like("useable", String.valueOf(entity.getUseable()));
		}
		//根据数据库版本模糊查询
		if(entity.getDbVersion()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getDbVersion()))){
			wrapper.like("db_version", String.valueOf(entity.getDbVersion()));
		}
		//根据是否支持事务模糊查询
		if(entity.getSuportTransaction()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getSuportTransaction()))){
			wrapper.like("suport_transaction", String.valueOf(entity.getSuportTransaction()));
		}
		if(StringUtils.isNoneBlank(entity.getOrderBy())){
			wrapper.orderBy(entity.getOrderBy(), entity.isAsc());
		}else{
			wrapper.orderBy("create_date", true);
		}
		if(entity.getStartDate()!=null){
			wrapper.ge("create_date", entity.getStartDate());
		}
		if(entity.getEndDate()!=null){
			wrapper.le("create_date", entity.getEndDate());
		}
		System.out.println(wrapper.originalSql());
		return wrapper;
	}
}

