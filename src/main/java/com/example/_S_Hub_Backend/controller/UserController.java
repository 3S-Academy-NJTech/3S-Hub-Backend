package com.example._S_Hub_Backend.controller;

import com.example._S_Hub_Backend.domain.User;
import com.example._S_Hub_Backend.repository.UserRepository;
import com.example._S_Hub_Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * UserController 处理与用户相关的 HTTP 请求
 * 提供用户登录、注册、获取热门用户等功能
 * 
 * 包含以下方法：
 * - userLogin: 用户登录
 * - getHotUsers: 分页查询热门用户
 * - signUp: 用户注册
 * - getUserList: 获取所有用户列表
 * - getUserById: 根据用户ID获取用户信息
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public User userLogin(@RequestParam String email, @RequestParam String password) {
        System.out.println("Login attempt: " + email);
        
        // Find user by email first
        User user = userRepository.findByUserEmail(email);
        if (user == null) {
            return null; // User not found
        }
        
        // Verify password using BCrypt
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(password, user.getUserPassword())) {
            return user; // Login successful
        } else {
            return null; // Invalid password
        }
    }

    @PostMapping("/register")
    public int signUp(
            @RequestParam String userName,
            @RequestParam String userPassword,
            @RequestParam String userShow,
            @RequestParam String userEmail) {

        User user = new User();
        user.setUserEmail(userEmail);
        user.setUserName(userName);
        user.setUserShow(userShow);
        user.setUserTime(new Date());
        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setUserPassword(passwordEncoder.encode(userPassword));

        User newUser = userService.userRegister(user);
        return newUser == null ? 404 : 200;
    }

    @PostMapping("/list")
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    /**
     * 根据用户ID获取用户信息
     * @param userId 用户ID
     * @return User 用户信息，如果用户不存在则返回null
     */
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }
}
