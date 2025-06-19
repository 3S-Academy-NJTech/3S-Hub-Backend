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

/*
 * 多级评论实体类
 * 用于记录对一级评论的回复
 * comMultiId: 多级评论的唯一标识符
 * comId: 一级评论的ID
 * comMultiContent: 多级评论内容
 * comMultiUserId: 发表评论的用户ID
 * comMultiTime: 评论时间
 * 该实体类用于存储多级评论信息，便于实现评论功能
 */
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class commentMulti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comMultiId;

    private Long comId;//一级评论id
    private String comMultiContent;
    private Long comMultiUserId;//多级评论用户id
    private Date comMultiTime;
}
