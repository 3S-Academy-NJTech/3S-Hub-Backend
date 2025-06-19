package com.example._S_Hub_Backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

/**
 * 管理员实体类
 * 用于记录管理员的登录信息
 * adminId: 管理员的唯一标识符
 * adminLoginName: 管理员登录名
 * adminPassWord: 管理员密码
 */
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String adminLoginName;
    private String adminPassWord;

}
