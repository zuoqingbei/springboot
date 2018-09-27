package com.hailian.controller;

import org.springframework.stereotype.Controller;
import com.hailian.base.BaseController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import com.hailian.service.ICommonInterfaceExcService;
import com.hailian.entity.CommonInterfaceExc;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.hailian.annotation.AuthPower;
import com.hailian.common.PublicResult;
import com.hailian.common.UUIDUtils;
import com.hailian.enums.PublicResultConstant;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 *
 * @author zuoqb123
 * @date 2018-09-27
 * @todo 统一接口路由
 */
@Controller
@RequestMapping("/api/{version}/commonInterfaceExc")
@Api(value = "统一接口CRUD",description="统一接口 @author zuoqb")
public class CommonInterfaceExcController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(CommonInterfaceExcController.class);

    @Autowired
    public ICommonInterfaceExcService iCommonInterfaceExcService;

    /**
     * @date   2018-09-27
     * @author zuoqb123
     * @todo   新增统一接口
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "新增统一接口", notes = "新增统一接口", httpMethod = "POST")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public PublicResult<CommonInterfaceExc> add(HttpServletRequest request,CommonInterfaceExc entity) {
		try {
			if(StringUtils.isBlank(entity.getId())){
				//新增
				entity.setId(UUIDUtils.getUuid());
				entity.setCreateDate(new Date());
				entity.setCreateBy(getLoginUser(request).getId());
				if(iCommonInterfaceExcService.insert(entity)){
					return new PublicResult<>(PublicResultConstant.SUCCESS, entity);
				}else{
					return new PublicResult<>(PublicResultConstant.ERROR, null);
				}
			}else{
				return new PublicResult<>(PublicResultConstant.PARAM_ERROR, "新增主键必须为空!",null);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(), null);
		}
	}
    
    /**
     * @date   2018-09-27
     * @author zuoqb123
     * @todo   删除统一接口
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "删除统一接口", notes = "删除统一接口", httpMethod = "DELETE")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public PublicResult<CommonInterfaceExc> delete(HttpServletRequest request,@PathVariable("id") String id) {
		try {
			CommonInterfaceExc entity=new CommonInterfaceExc();
			entity.setId(id);
			entity.setDelFlag(DEL_FLAG);
			entity.setUpdateDate(new Date());
			entity.setUpdateBy(getLoginUser(request).getId());
			 if(iCommonInterfaceExcService.updateById(entity)){
				 return new PublicResult<>(PublicResultConstant.SUCCESS, null);
			 }else{
				 return new PublicResult<>(PublicResultConstant.ERROR, null);
			 }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(), null);
		}
	}
	
	 /**
     * @date   2018-09-27
     * @author zuoqb123
     * @todo   更新统一接口
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "更新统一接口", notes = "更新统一接口", httpMethod = "PUT")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public PublicResult<CommonInterfaceExc> update(HttpServletRequest request,CommonInterfaceExc entity) {
		try {
			if(entity!=null&&StringUtils.isNotBlank(entity.getId())){
				//更新
				entity.setUpdateDate(new Date());
				entity.setUpdateBy(getLoginUser(request).getId());
				if(iCommonInterfaceExcService.updateById(entity)){
					return new PublicResult<>(PublicResultConstant.SUCCESS, entity);
				}else{
					return new PublicResult<>(PublicResultConstant.ERROR, null);
				}
			}else{
				return new PublicResult<>(PublicResultConstant.PARAM_ERROR, "修改主键不能为空!",null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(), null);
		}
	}
    
    
    /**
     * @date   2018-09-27
     * @author zuoqb123
     * @todo   查询单个统一接口
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "查询单个统一接口", notes = "查询单个统一接口", httpMethod = "GET")
  	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET )
  	public PublicResult<CommonInterfaceExc> get(HttpServletRequest request,@PathVariable("id") String id) {
  		CommonInterfaceExc entity=null;
  		try {
  			EntityWrapper<CommonInterfaceExc> wrapper = new EntityWrapper<CommonInterfaceExc>();
  			wrapper.where("del_flag={0}", UN_DEL_FLAG);
  			wrapper.eq("id", id);
  			entity=iCommonInterfaceExcService.selectOne(wrapper);
  			return new PublicResult<>(PublicResultConstant.SUCCESS, entity);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(), null);
		}
  	}
	
    /**
     * @date   2018-09-27
     * @author zuoqb123
     * @todo   分页查询统一接口
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "分页查询统一接口", notes = "分页查询统一接口", httpMethod = "GET")
  	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public PublicResult<PageInfo<CommonInterfaceExc>> list(CommonInterfaceExc entity,@RequestParam(value="pageNum",required = false,defaultValue="1") Integer pageNum,
			@RequestParam(value="pageSize",required = false,defaultValue="10") Integer pageSize,HttpServletRequest request) {
		try {
			EntityWrapper<CommonInterfaceExc> wrapper = searchWrapper(request, entity);
			PageHelper.startPage(pageNum, pageSize);
			List<CommonInterfaceExc> list = iCommonInterfaceExcService.selectList(wrapper);
			PageInfo<CommonInterfaceExc> page = new PageInfo<CommonInterfaceExc>(list);
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
    private EntityWrapper<CommonInterfaceExc> searchWrapper(HttpServletRequest request, CommonInterfaceExc entity) {
		EntityWrapper<CommonInterfaceExc> wrapper = new EntityWrapper<CommonInterfaceExc>();
		wrapper.where("del_flag={0}", UN_DEL_FLAG);
		if(getLoginUser(request)!=null&&StringUtils.isNotBlank(getLoginUser(request).getId())){
			if(!isAdmin(request))
			 wrapper.and("create_by", getLoginUser(request).getId());
		}
		//根据模糊查询
		if(entity.getId()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getId()))){
			wrapper.like("id", String.valueOf(entity.getId()));
		}
		//根据归属数据源 默认当前数据库模糊查询
		if(entity.getDbDatasourceId()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getDbDatasourceId()))){
			wrapper.like("db_datasource_id", String.valueOf(entity.getDbDatasourceId()));
		}
		//根据查询指标标识模糊查询
		if(entity.getDataType()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getDataType()))){
			wrapper.like("data_type", String.valueOf(entity.getDataType()));
		}
		//根据命名空间模糊查询
		if(entity.getDataSpace()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getDataSpace()))){
			wrapper.like("data_space", String.valueOf(entity.getDataSpace()));
		}
		//根据需要执行的sql语句，需要传参的位置使用#{参数名}，动态日期类型date_dt_kpi固定参数名称。模糊查询
		if(entity.getDataSql()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getDataSql()))){
			wrapper.like("data_sql", String.valueOf(entity.getDataSql()));
		}
		//根据横竖数据格式转换，默认纵向排列（V：垂直排列，H水平排列）模糊查询
		if(entity.getTransformData()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getTransformData()))){
			wrapper.like("transform_data", String.valueOf(entity.getTransformData()));
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

