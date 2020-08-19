package com.xkx.swapper.controller;

import com.xkx.swapper.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Hello控制器")
@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
    //只要我们的接口中，返回值中存在实体类，他就会被扫描到Swapper中
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }

    //Operation接口，不是写在类上的，是写在方法上的
    @ApiOperation("hello接口")
    @GetMapping(value = "/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello" + username;
    }














}
