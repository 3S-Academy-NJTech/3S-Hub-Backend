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
 * userId: 用户的唯一标识符
 * userPassword: 用户密码
 * userName: 用户名
 * userEmail: 用户邮箱
 * userSex: 用户性别
 * userStatus: 用户状态（1：激活，0：未激活）
 * userTime: 注册时间
 * userShow: 个性签名
 * userBlog: 个人主页链接
 * userImg: 头像链接
 * userFans: 粉丝数
 * userConcern: 关注数
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
    private String userSex;
    private Byte userStatus;//用户状态1：激活 0：未激活


    private Date userTime;//注册时间
    private String userShow;//用户个性签名
    private String userBlog;//用户主页
    private String userImg;//用户头像
    private Integer userFans;//用户粉丝数
    private Integer userConcern;//用户关注数
}
