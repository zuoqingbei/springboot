package org.jon.lv.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.jon.lv.domain.User;
import org.jon.lv.result.ResultDO;
import org.jon.lv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * @Package org.jon.lv.controller.UserController
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/12 15:30
 * version V1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询单个用户",notes = "根据传入id查找用户",httpMethod = "GET")
    @RequestMapping(value ="/get/{id}", method = RequestMethod.GET)
    public ResultDO<User> get(@PathVariable("id")Integer id){
        ResultDO<User> resultDO = new ResultDO<>();
        resultDO.setSuccess(true);
        resultDO.setData(userService.getUserById(id));
        return resultDO;
    }

  /*  @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    })*/
    @ApiOperation(value="新增用户信息", notes="根据过来的user信息来新增用户")
    @RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
    public ResultDO<Integer> add(User user){
        ResultDO<Integer> resultDO = new ResultDO<>();
        resultDO.setSuccess(true);
        resultDO.setData(userService.save(user));
        return resultDO;
    }
}
