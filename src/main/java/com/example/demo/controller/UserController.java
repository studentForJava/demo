package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/add")
    public void insertUser(@RequestBody UserEntity user){
        userService.addUser(user);
    }
    @GetMapping("/delete")
    public void insertUser(Integer id){
        userService.deleteUserById(id);
    }
    @PostMapping("/update")
    public void updateUser(@RequestBody UserEntity user){
        userService.updateUser(user);
    }
    @GetMapping("/findall")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @GetMapping("/gettoken")
    public ResponseEntity<String> show(){
       return userService.getTenantAccessToken();
    }

    @PostMapping("/test")
    public void show1(HttpServletRequest request){
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        System.out.println("进入。。。。111");
        System.out.println("code  :"+code);
        System.out.println("state  :"+state);
    }
    @GetMapping("/test1")
    public void show2(HttpServletRequest request){
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        System.out.println("进入。。。。222");
        System.out.println("code  :"+code);
        System.out.println("state  :"+state);
    }
}
