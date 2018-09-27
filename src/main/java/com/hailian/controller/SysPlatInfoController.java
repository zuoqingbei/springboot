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
import com.hailian.service.ISysPlatInfoService;
import com.hailian.entity.SysPlatInfo;
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
 * @todo 平台信息路由
 */
@Controller
@RequestMapping("/api/{version}/sysPlatInfo")
@Api(value = "平台信息",description="平台信息 @author zuoqb123")
public class SysPlatInfoController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(SysPlatInfoController.class);

    @Autowired
    public ISysPlatInfoService iSysPlatInfoService;

    /**
     * @date   2018-09-27
     * @author zuoqb123
     * @todo   新增平台信息
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "新增平台信息", notes = "新增平台信息", httpMethod = "POST")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public PublicResult<SysPlatInfo> add(HttpServletRequest request,SysPlatInfo entity) {
		try {
			if(StringUtils.isBlank(entity.getId())){
				//新增
				entity.setId(UUIDUtils.getUuid());
				entity.setCreateDate(new Date());
				entity.setCreateBy(getLoginUser(request).getId());
				if(iSysPlatInfoService.insert(entity)){
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
     * @todo   删除平台信息
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "删除平台信息", notes = "删除平台信息", httpMethod = "DELETE")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public PublicResult<SysPlatInfo> delete(HttpServletRequest request,@PathVariable("id") String id) {
		try {
			SysPlatInfo entity=new SysPlatInfo();
			entity.setId(id);
			entity.setDelFlag(DEL_FLAG);
			entity.setUpdateDate(new Date());
			entity.setUpdateBy(getLoginUser(request).getId());
			 if(iSysPlatInfoService.updateById(entity)){
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
     * @todo   更新平台信息
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "更新平台信息", notes = "更新平台信息", httpMethod = "PUT")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public PublicResult<SysPlatInfo> update(HttpServletRequest request,SysPlatInfo entity) {
		try {
			if(entity!=null&&StringUtils.isNotBlank(entity.getId())){
				//更新
				entity.setUpdateDate(new Date());
				entity.setUpdateBy(getLoginUser(request).getId());
				if(iSysPlatInfoService.updateById(entity)){
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
     * @todo   查询单个平台信息
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "查询单个平台信息", notes = "查询单个平台信息", httpMethod = "GET")
  	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET )
  	public PublicResult<SysPlatInfo> get(HttpServletRequest request,@PathVariable("id") String id) {
  		SysPlatInfo entity=null;
  		try {
  			EntityWrapper<SysPlatInfo> wrapper = new EntityWrapper<SysPlatInfo>();
  			wrapper.where("del_flag={0}", UN_DEL_FLAG);
  			wrapper.eq("id", id);
  			entity=iSysPlatInfoService.selectOne(wrapper);
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
     * @todo   分页查询平台信息
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "分页查询平台信息", notes = "分页查询平台信息", httpMethod = "GET")
  	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public PublicResult<PageInfo<SysPlatInfo>> list(SysPlatInfo entity,@RequestParam(value="pageNum",required = false,defaultValue="1") Integer pageNum,
			@RequestParam(value="pageSize",required = false,defaultValue="10") Integer pageSize,HttpServletRequest request) {
		try {
			EntityWrapper<SysPlatInfo> wrapper = searchWrapper(request, entity);
			PageHelper.startPage(pageNum, pageSize);
			List<SysPlatInfo> list = iSysPlatInfoService.selectList(wrapper);
			PageInfo<SysPlatInfo> page = new PageInfo<SysPlatInfo>(list);
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
    private EntityWrapper<SysPlatInfo> searchWrapper(HttpServletRequest request, SysPlatInfo entity) {
		EntityWrapper<SysPlatInfo> wrapper = new EntityWrapper<SysPlatInfo>();
		wrapper.where("del_flag={0}", UN_DEL_FLAG);
		if(getLoginUser(request)!=null&&StringUtils.isNotBlank(getLoginUser(request).getId())){
			if(!isAdmin(request))
			 wrapper.and("create_by", getLoginUser(request).getId());
		}
		//根据平台编号模糊查询
		if(entity.getId()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getId()))){
			wrapper.like("id", String.valueOf(entity.getId()));
		}
		//根据平台名称模糊查询
		if(entity.getName()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getName()))){
			wrapper.like("name", String.valueOf(entity.getName()));
		}
		//根据平台英文名称模糊查询
		if(entity.getEnname()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getEnname()))){
			wrapper.like("enname", String.valueOf(entity.getEnname()));
		}
		//根据接口版本模糊查询
		if(entity.getVersions()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getVersions()))){
			wrapper.like("versions", String.valueOf(entity.getVersions()));
		}
		//根据平台秘钥模糊查询
		if(entity.getSecretKey()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getSecretKey()))){
			wrapper.like("secret_key", String.valueOf(entity.getSecretKey()));
		}
		//根据平台联系人模糊查询
		if(entity.getContacts()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getContacts()))){
			wrapper.like("contacts", String.valueOf(entity.getContacts()));
		}
		//根据联系人电话模糊查询
		if(entity.getContactsTel()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getContactsTel()))){
			wrapper.like("contacts_tel", String.valueOf(entity.getContactsTel()));
		}
		//根据联系人邮箱模糊查询
		if(entity.getContactsMail()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getContactsMail()))){
			wrapper.like("contacts_mail", String.valueOf(entity.getContactsMail()));
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

