package com.example._S_Hub_Backend.controller;
import com.example._S_Hub_Backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 负责管理员登录
 */
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping(value = "/loginbackstage")
    public boolean adminLogin(String username, String password){
        System.out.println(username+" "+password);
        return adminService.adminLogin(username,password);
    }
}
