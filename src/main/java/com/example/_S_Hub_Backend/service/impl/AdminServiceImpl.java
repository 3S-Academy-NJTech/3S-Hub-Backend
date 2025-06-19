package com.example._S_Hub_Backend.service.impl;
import com.example._S_Hub_Backend.domain.Admin;
import com.example._S_Hub_Backend.repository.AdminRepository;
import com.example._S_Hub_Backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AdminServiceImpl 实现类
 * 实现 AdminService 接口
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public boolean adminLogin(String username, String password) {
        Admin admin = adminRepository.findAdminByAdminLoginNameAndAdminPassWord(username, password);
        return admin != null;
    }
}
