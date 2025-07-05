package com.example._S_Hub_Backend.service;
import com.example._S_Hub_Backend.domain.User;

/**
 * UserService 接口定义了与 User 实体相关的业务逻辑方法。
 * 主要用于处理用户登录、注册和查询等操作。
 * 
 * 包含以下方法：
 * - userLogin: 根据用户邮箱和密码进行登录验证。
 * - userRegister: 注册新用户。
 * - findHotUser: 分页查询热门用户。
 */
public interface UserService {
    User userLogin(String email,String password);
    User userRegister(User user);
    
    /**
     * 根据用户ID获取用户信息
     * @param userId 用户ID
     * @return User 用户信息，如果不存在则返回null
     */
    User getUserById(Long userId);
}
