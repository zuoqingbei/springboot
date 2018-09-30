package com.hailian.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hailian.annotation.AuthPower;
import com.hailian.base.BaseController;
import com.hailian.common.PublicResult;
import com.hailian.common.TokenConstants;
import com.hailian.entity.SysUser;
import com.hailian.enums.PlatformType;
import com.hailian.enums.PublicResultConstant;
import com.hailian.repository.UserRepository;
import com.hailian.result.ResultDO;
import com.hailian.service.ISysUserService;

/**
 * @time   2018年9月26日 下午10:43:32
 * @author zuoqb
 * @todo   Token相关
 */
@RestController
@RequestMapping("/api/{version}")
@Api(value = "Token相关",description="Token相关 @author zuoqb")
public class TokenController extends BaseController{
	@Autowired
	public ISysUserService iSysUserService;
    @Autowired
    private UserRepository userRepository;
    @ApiOperation(value = "获取用户token",notes = "获取用户token",httpMethod = "POST")
    @AuthPower(avoidLogin = true,avoidPower = true, avoidVersion = true, avoidSign = true)
    @PostMapping("/token")
    public ResultDO<String> token(@RequestParam("username")String username,
                                  @RequestParam("password")String password,
                                  @RequestHeader(TokenConstants.X_PLATFORM)String platform
                                  ) {

        return userRepository.login(username, password, PlatformType.getTypeByPlatform(platform));
    }
    
    @ApiOperation(value = "获取用户access_token",notes = "获取用户access_token",httpMethod = "POST")
    @AuthPower(avoidLogin = true,avoidPower = true, avoidVersion = true, avoidSign = true)
    @PostMapping("/token")
    public PublicResult<SysUser> accessToken(@RequestParam("loginName")String loginName,
                                  @RequestParam("password")String password,
                                  @RequestHeader(TokenConstants.X_PLATFORM)String platform
                                  ) {
    	EntityWrapper<SysUser> wrapper = new EntityWrapper<SysUser>();
		wrapper.where("del_flag={0}", UN_DEL_FLAG);
		wrapper.eq("login_name", loginName);
		SysUser entity=iSysUserService.selectOne(wrapper);
		if(entity==null){
			return new PublicResult<>(PublicResultConstant.FAILED,"该用户不存在!", null);
		}
		//校验密码
		return new PublicResult<>(PublicResultConstant.FAILED,"该用户不存在!", null);
    }
}
