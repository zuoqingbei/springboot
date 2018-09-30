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
import com.hailian.service.ISysUserService;
import com.hailian.entity.SysUser;
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
 * @todo 用户表路由
 */
@Controller
@RequestMapping("/api/{version}/sysUser")
@Api(value = "用户表",description="用户表 @author zuoqb123")
public class SysUserController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    public ISysUserService iSysUserService;

    /**
     * @date   2018-09-28
     * @author zuoqb123
     * @todo   新增用户表
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "新增用户表", notes = "新增用户表", httpMethod = "POST")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public PublicResult<SysUser> add(HttpServletRequest request,SysUser entity) {
		try {
			if(StringUtils.isBlank(entity.getId())){
				//新增
				entity.setId(UUIDUtils.getUuid());
				entity.setCreateDate(new Date());
				entity.setCreateBy(getLoginUser(request).getId());
				if(iSysUserService.insert(entity)){
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
     * @todo   删除用户表
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "删除用户表", notes = "删除用户表", httpMethod = "DELETE")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public PublicResult<SysUser> delete(HttpServletRequest request,@PathVariable("id") String id) {
		try {
			SysUser entity=new SysUser();
			entity.setId(id);
			entity.setDelFlag(DEL_FLAG);
			entity.setUpdateDate(new Date());
			entity.setUpdateBy(getLoginUser(request).getId());
			 if(iSysUserService.updateById(entity)){
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
     * @todo   更新用户表
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "更新用户表", notes = "更新用户表", httpMethod = "PUT")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public PublicResult<SysUser> update(HttpServletRequest request,SysUser entity) {
		try {
			if(entity!=null&&StringUtils.isNotBlank(entity.getId())){
				//更新
				entity.setUpdateDate(new Date());
				entity.setUpdateBy(getLoginUser(request).getId());
				if(iSysUserService.updateById(entity)){
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
     * @todo   查询单个用户表
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "查询单个用户表", notes = "查询单个用户表", httpMethod = "GET")
  	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET )
  	public PublicResult<SysUser> get(HttpServletRequest request,@PathVariable("id") String id) {
  		SysUser entity=null;
  		try {
  			EntityWrapper<SysUser> wrapper = new EntityWrapper<SysUser>();
  			wrapper.where("del_flag={0}", UN_DEL_FLAG);
  			wrapper.eq("id", id);
  			entity=iSysUserService.selectOne(wrapper);
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
     * @todo   分页查询用户表
     */
    @ResponseBody
 	@AuthPower(avoidVersion = false, avoidPower = true, avoidSign = true, avoidLogin = true, avoidPlatform = true)
  	@ApiOperation(value = "分页查询用户表", notes = "分页查询用户表", httpMethod = "GET")
  	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public PublicResult<PageInfo<SysUser>> list(SysUser entity,@RequestParam(value="pageNum",required = false,defaultValue="1") Integer pageNum,
			@RequestParam(value="pageSize",required = false,defaultValue="10") Integer pageSize,HttpServletRequest request) {
		try {
			EntityWrapper<SysUser> wrapper = searchWrapper(request, entity);
			PageHelper.startPage(pageNum, pageSize);
			List<SysUser> list = iSysUserService.selectList(wrapper);
			PageInfo<SysUser> page = new PageInfo<SysUser>(list);
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
    private EntityWrapper<SysUser> searchWrapper(HttpServletRequest request, SysUser entity) {
		EntityWrapper<SysUser> wrapper = new EntityWrapper<SysUser>();
		wrapper.where("del_flag={0}", UN_DEL_FLAG);
		if(getLoginUser(request)!=null&&StringUtils.isNotBlank(getLoginUser(request).getId())){
			if(!isAdmin(request))
			 wrapper.and("create_by", getLoginUser(request).getId());
		}
		//根据编号模糊查询
		if(entity.getId()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getId()))){
			wrapper.like("id", String.valueOf(entity.getId()));
		}
		//根据登录名模糊查询
		if(entity.getLoginName()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getLoginName()))){
			wrapper.like("login_name", String.valueOf(entity.getLoginName()));
		}
		//根据密码模糊查询
		if(entity.getPassword()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getPassword()))){
			wrapper.like("password", String.valueOf(entity.getPassword()));
		}
		//根据工号模糊查询
		if(entity.getNo()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getNo()))){
			wrapper.like("no", String.valueOf(entity.getNo()));
		}
		//根据姓名模糊查询
		if(entity.getName()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getName()))){
			wrapper.like("name", String.valueOf(entity.getName()));
		}
		//根据邮箱模糊查询
		if(entity.getEmail()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getEmail()))){
			wrapper.like("email", String.valueOf(entity.getEmail()));
		}
		//根据电话模糊查询
		if(entity.getPhone()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getPhone()))){
			wrapper.like("phone", String.valueOf(entity.getPhone()));
		}
		//根据手机模糊查询
		if(entity.getMobile()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getMobile()))){
			wrapper.like("mobile", String.valueOf(entity.getMobile()));
		}
		//根据用户类型模糊查询
		if(entity.getUserType()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getUserType()))){
			wrapper.like("user_type", String.valueOf(entity.getUserType()));
		}
		//根据用户头像模糊查询
		if(entity.getPhoto()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getPhoto()))){
			wrapper.like("photo", String.valueOf(entity.getPhoto()));
		}
		//根据最后登陆IP模糊查询
		if(entity.getLoginIp()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getLoginIp()))){
			wrapper.like("login_ip", String.valueOf(entity.getLoginIp()));
		}
		//根据最后登陆时间模糊查询
		if(entity.getLoginDate()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getLoginDate()))){
			wrapper.like("login_date", String.valueOf(entity.getLoginDate()));
		}
		//根据是否可登录模糊查询
		if(entity.getLoginFlag()!=null&&StringUtils.isNotBlank(String.valueOf(entity.getLoginFlag()))){
			wrapper.like("login_flag", String.valueOf(entity.getLoginFlag()));
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

