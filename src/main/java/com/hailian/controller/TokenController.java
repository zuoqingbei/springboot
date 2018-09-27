package com.hailian.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hailian.annotation.AuthPower;
import com.hailian.base.BaseController;
import com.hailian.common.TokenConstants;
import com.hailian.enums.PlatformType;
import com.hailian.repository.UserRepository;
import com.hailian.result.ResultDO;

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
}
