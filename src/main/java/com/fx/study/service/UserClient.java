package com.fx.study.service;

/**
 * @auther: mabaofeng
 * @date: 2019/7/5 10:05
 * @description:
 */
/*@FeignClient(name = "provider", url = "http://localhost:8093/")*/
public interface UserClient {

    /**
     * 从FEBS 查询用户
     * @param username
     * @return
     */
   /* @RequestMapping(value = "/user/findByName/{username}", method = RequestMethod.GET)
    ResponseEntity getUserByName(@PathVariable("username")String  username);*/
}
