package com.example._S_Hub_Backend.repository;
import com.example._S_Hub_Backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository 接口
 * 用于用户登录验证
 * 继承自 JpaRepository 提供基本的 CRUD 操作
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUserEmailAndUserPassword(String userEmail, String userPassword);
    User findByUserEmail(String userEmail);
    
    /**
     * 根据用户ID查找用户信息
     * @param userId 用户ID
     * @return User 用户信息，如果不存在则返回null
     */
    User findByUserId(Long userId);
}

