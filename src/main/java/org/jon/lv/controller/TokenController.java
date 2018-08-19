package org.jon.lv.controller;

import io.swagger.annotations.ApiOperation;

import org.jon.lv.annotation.AuthPower;
import org.jon.lv.common.TokenConstants;
import org.jon.lv.enums.PlatformType;
import org.jon.lv.repository.UserRepository;
import org.jon.lv.result.ResultDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jack
 * @date 2018/1/22
 */
@RestController
@RequestMapping("/api/v1")
public class TokenController {

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
