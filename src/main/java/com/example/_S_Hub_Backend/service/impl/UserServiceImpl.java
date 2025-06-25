package com.example._S_Hub_Backend.service.impl;
import com.example._S_Hub_Backend.domain.User;
import com.example._S_Hub_Backend.repository.UserRepository;
import com.example._S_Hub_Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserServiceImpl 实现类
 * 实现 UserService 接口
 * 提供用户相关的业务逻辑实现
 * userLogin: 用户登录验证
 * userRegister: 用户注册
 * findHotUser: 分页查询热门用户
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
        public User userLogin(String email, String password) {
            User user= userRepository.findUserByUserEmailAndUserPassword(email,password);
            return user;
    }

    @Override
    @Transactional
    public User userRegister(User user) {
        return userRepository.save(user);
    }
}
