package com.example._S_Hub_Backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


/**
 * 用户实体类
 * 用于记录用户的基本信息
 */
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userPassword;
    private String userName;
    private String userEmail;


    private Date userTime;//注册时间
    private String userShow;//用户个性签名
}
