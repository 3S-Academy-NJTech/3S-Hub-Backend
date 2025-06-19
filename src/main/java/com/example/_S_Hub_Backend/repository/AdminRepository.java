package com.example._S_Hub_Backend.repository;
import com.example._S_Hub_Backend.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AdminRepository 接口
 * 用于管理员登录验证
 * 继承自 JpaRepository 提供基本的 CRUD 操作
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByAdminLoginNameAndAdminPassWord(String adminLoginName, String adminPassWord);
}

