package com.example._S_Hub_Backend.service;

/**
 * AdminService 接口
 * 用于管理员登录验证
 * 提供 adminLogin 方法
 */
public interface AdminService {
    boolean adminLogin(String username,String password);
}
