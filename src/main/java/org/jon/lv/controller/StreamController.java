package org.jon.lv.controller;

import org.jon.lv.annotation.AuthPower;
import org.jon.lv.domain.User;
import org.jon.lv.result.ResultDO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

/**
 * Package: org.jon.lv.controller.StreamController
 * Description: 描述
 * Copyright: Copyright (c) 2017
 *
 * @author lv bin
 * Date: 2018/1/19 14:00
 * Version: V1.0.0
 */
@RestController
@RequestMapping("/api/stream/{version}")
public class StreamController {

    /**
     * 免登陆
     */
    @AuthPower(avoidLogin = true)
    @PostMapping("/login")
    public ResultDO<String> login(@PathVariable("version")Integer version,@RequestBody String name){
        ResultDO<String> resultDO = new ResultDO<>();
        resultDO.setData(name);
        return resultDO;
    }

    /**
     * 免版本号校验
     * @param id
     * @return
     */
    @AuthPower(avoidVersion = true)
    @GetMapping("/get/{id}")
    public ResultDO<String> get(@PathVariable("version")Integer version,@PathVariable Long id){
        ResultDO<String> resultDO = new ResultDO<>();
        resultDO.setData(String.valueOf(id));
        return resultDO;
    }


    /**
     * 免参数加密校验
     * @param user
     * @return
     */
    @AuthPower(avoidSign = true)
    @PostMapping("/save")
    public ResultDO<String> save(@PathVariable("version")Integer version,@RequestBody User user){

        System.out.println("===============" + JSON.toJSONString(user));
        ResultDO<String> resultDO = new ResultDO<>();
        resultDO.setData(JSON.toJSONString(user));
        return resultDO;
    }

    /**
     * 需要校验用户是否有权访问此接口
     * @param user
     * @return
     */
    @AuthPower(avoidVersion = true,avoidPower = true,avoidSign = true,avoidLogin = true)
    @RequestMapping(value ="/update", method = RequestMethod.GET)
    public ResultDO<String> power(@PathVariable("version")Integer version){
        ResultDO<String> resultDO = new ResultDO<>();
        resultDO.setData(JSON.toJSONString(null));
        return resultDO;
    }

    /**
     * 测试Token
     * @param id
     * @return
     */
    @AuthPower(avoidVersion = true,avoidPower = true,avoidSign = true,avoidLogin = false)
    @RequestMapping(value = "delete.do",method = RequestMethod.POST)
    public ResultDO<String> detail(@PathVariable("version")Integer version,Long id){
        ResultDO<String> resultDO = new ResultDO<>();
        resultDO.setSuccess(true);

        return resultDO;
    }

}
