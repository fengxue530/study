package com.fx.study.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: mabaofeng
 * @date: 2019/7/4 10:35
 * @description:
 */
@RestController
@RequestMapping("/member")
@Api(value = "会员管理中心接口", tags = "管理")
public class MemberController {

    @RequestMapping("/login")
    @ApiOperation(value = "会员登录", tags = {"管理"}, notes = "会员登录notes")
    public Map<String, Object> login(@ApiParam(name = "userName", value = "用户名", required = true) String userName,
                                     @ApiParam(name = "password", value = "密码", required = true) String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 1);
        map.put("message", "会员登录成功");
        return map;
    }


}
