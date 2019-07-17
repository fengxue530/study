package com.fx.study.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther: mabaofeng
 * @Date: 2019/7/4 09:40
 * @Description:
 */
@RestController
@Api(value="后台管理controller",tags={"后台人员操作接口"})
/*@ApiIgnore 忽略方法或者类*/
@RequestMapping("/administrator")
public class AdministratorController {

    private  static FastDateFormat FORMAT  = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

   /* @Autowired
    private UserClient uerClient;
*/
    @PostMapping("/login")
    @ApiOperation(value="登录接口",tags={"后台人员操作接口"},notes="提示内容")
    public Map<String, Object> login(@ApiParam(name="userName",value = "用户名",required = true) String userName,
                                     @ApiParam(name="password",value = "密码",required = true) String password   ) {
        /*ResponseEntity user = uerClient.getUserByName("mrbird");*/
        Map<String, Object> map = new HashMap<>();
        map.put("status", 1);
        map.put("message", "登录成功");
        return map;
    }

}
