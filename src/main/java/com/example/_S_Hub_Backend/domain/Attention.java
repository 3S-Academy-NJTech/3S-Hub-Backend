package com.example._S_Hub_Backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 关注实体类
 * 用于记录用户之间的关注关系
 * attid: 关注关系的唯一标识符
 * attAuthorId: 关注者的用户ID
 * attUserId: 被关注者的用户ID
 * 该实体类用于存储用户关注信息，便于实现社交功能
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Attention {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attId;

    private Long attAuthorId;//关注人id
    private Long attUserId;
}

