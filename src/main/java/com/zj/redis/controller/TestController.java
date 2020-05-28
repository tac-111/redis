package com.zj.redis.controller;

import com.zj.redis.bean.Users;
import com.zj.redis.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Resource
    private UserService userService;

    @RequestMapping("/queryAll")
    public List<Users> queryAll(){
        List<Users> lists = userService.queryAll();
        return lists;
    }

    @RequestMapping("/findUserById")
    public Map<String, Object> findUserById(@RequestParam int id){
        Users user = userService.findUserById(id);
        Map<String, Object> result = new HashMap<>();
        result.put("uid", user.getUid());
        result.put("uname", user.getUserName());
        result.put("pass", user.getPassWord());
        result.put("salary", user.getSalary());
        return result;
    }

    @RequestMapping("/updateUser")
    public String updateUser(){
        Users user = new Users();
        user.setUid(1);
        user.setUserName("cat");
        user.setPassWord("miaomiao");
        user.setSalary(4000);

        int result = userService.updateUser(user);

        if(result != 0){
            return "update user success";
        }

        return "fail";
    }

    @RequestMapping("/deleteUserById")
    public String deleteUserById(@RequestParam int id){
        int result = userService.deleteUserById(id);
        if(result != 0){
            return "delete success";
        }
        return "delete fail";
    }
}
