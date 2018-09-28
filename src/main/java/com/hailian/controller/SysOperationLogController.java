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
import com.hailian.service.ISysOperationLogService;
import com.hailian.entity.SysOperationLog;
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
 * @date 2018-09-28
 * @todo 操作日志路由
 */
@Controller
@RequestMapping("/api/{version}/sysOperationLog")
@Api(value = "操作日志",description="操作日志 @author zuoqb123")
public class SysOperationLogController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(SysOperationLogController.class);

    @Autowired
    public ISysOperationLogService iSysOperationLogService;

    /**
     * @date   2018-09-28
     * @author zuoqb123
     * @todo   新增操作日志
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "新增操作日志", notes = "新增操作日志", httpMethod = "POST")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public PublicResult<SysOperationLog> add(HttpServletRequest request,SysOperationLog entity) {
		try {
			if(StringUtils.isBlank(entity.getId())){
				//新增
				entity.setId(UUIDUtils.getUuid());
				entity.setCreateDate(new Date());
				entity.setCreateBy(getLoginUser(request).getId());
				if(iSysOperationLogService.insert(entity)){
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
     * @date   2018-09-28
     * @author zuoqb123
     * @todo   删除操作日志
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "删除操作日志", notes = "删除操作日志", httpMethod = "DELETE")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public PublicResult<SysOperationLog> delete(HttpServletRequest request,@PathVariable("id") String id) {
		try {
			SysOperationLog entity=new SysOperationLog();
			entity.setId(id);
			entity.setDelFlag(DEL_FLAG);
			entity.setUpdateDate(new Date());
			entity.setUpdateBy(getLoginUser(request).getId());
			 if(iSysOperationLogService.updateById(entity)){
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
     * @date   2018-09-28
     * @author zuoqb123
     * @todo   更新操作日志
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "更新操作日志", notes = "更新操作日志", httpMethod = "PUT")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public PublicResult<SysOperationLog> update(HttpServletRequest request,SysOperationLog entity) {
		try {
			if(entity!=null&&StringUtils.isNotBlank(entity.getId())){
				//更新
				entity.setUpdateDate(new Date());
				entity.setUpdateBy(getLoginUser(request).getId());
				if(iSysOperationLogService.updateById(entity)){
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
     * @date   2018-09-28
     * @author zuoqb123
     * @todo   查询单个操作日志
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "查询单个操作日志", notes = "查询单个操作日志", httpMethod = "GET")
  	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET )
  	public PublicResult<SysOperationLog> get(HttpServletRequest request,@PathVariable("id") String id) {
  		SysOperationLog entity=null;
  		try {
  			EntityWrapper<SysOperationLog> wrapper = new EntityWrapper<SysOperationLog>();
  			wrapper.where("del_flag={0}", UN_DEL_FLAG);
  			wrapper.eq("id", id);
  			entity=iSysOperationLogService.selectOne(wrapper);
  			return new PublicResult<>(PublicResultConstant.SUCCESS, entity);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new PublicResult<>(PublicResultConstant.FAILED,e.getMessage(), null);
		}
  	}
	
    /**
     * @date   2018-09-28
     * @author zuoqb123
     * @todo   分页查询操作日志
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "分页查询操作日志", notes = "分页查询操作日志", httpMethod = "GET")
  	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public PublicResult<PageInfo<SysOperationLog>> list(SysOperationLog entity,@RequestParam(value="pageNum",required = false,defaultValue="1") Integer pageNum,
			@RequestParam(value="pageSize",required = false,defaultValue="10") Integer pageSize,HttpServletRequest request) {
		try {
			EntityWrapper<SysOperationLog> wrapper = searchWrapper(request, entity);
			PageHelper.startPage(pageNum, pageSize);
			List<SysOperationLog> list = iSysOperationLogService.selectList(wrapper);
			PageInfo<SysOperationLog> page = new PageInfo<SysOperationLog>(list);
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
    private EntityWrapper<SysOperationLog> searchWrapper(HttpServletRequest request, SysOperationLog entity) {
		EntityWrapper<SysOperationLog> wrapper = new EntityWrapper<SysOperationLog>();
		wrapper.where("del_flag={0}", UN_DEL_FLAG);
		if(getLoginUser(request)!=null&&StringUtils.isNotBlank(getLoginUser(request).getId())){
			if(!isAdmin(request))
			 wrapper.and("create_by", getLoginUser(request).getId());
		}
		//根据模糊查询
		if(entity.getId()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getId()))){
			wrapper.like("id", String.valueOf(entity.getId()));
		}
		//根据日志类型模糊查询
		if(entity.getLogDescription()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getLogDescription()))){
			wrapper.like("log_description", String.valueOf(entity.getLogDescription()));
		}
		//根据日志名称模糊查询
		if(entity.getActionArgs()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getActionArgs()))){
			wrapper.like("action_args", String.valueOf(entity.getActionArgs()));
		}
		//根据用户id模糊查询
		if(entity.getUserName()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getUserName()))){
			wrapper.like("user_name", String.valueOf(entity.getUserName()));
		}
		//根据类名称模糊查询
		if(entity.getClassName()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getClassName()))){
			wrapper.like("class_name", String.valueOf(entity.getClassName()));
		}
		//根据方法名称模糊查询
		if(entity.getMethod()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getMethod()))){
			wrapper.like("method", String.valueOf(entity.getMethod()));
		}
		//根据模糊查询
		if(entity.getIp()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getIp()))){
			wrapper.like("ip", String.valueOf(entity.getIp()));
		}
		//根据创建时间模糊查询
		if(entity.getCreateTime()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getCreateTime()))){
			wrapper.like("create_time", String.valueOf(entity.getCreateTime()));
		}
		//根据是否成功模糊查询
		if(entity.getSucceed()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getSucceed()))){
			wrapper.like("succeed", String.valueOf(entity.getSucceed()));
		}
		//根据备注模糊查询
		if(entity.getMessage()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getMessage()))){
			wrapper.like("message", String.valueOf(entity.getMessage()));
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

