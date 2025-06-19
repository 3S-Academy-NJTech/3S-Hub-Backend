package com.example._S_Hub_Backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * 评论实体类
 * 用于记录用户对文章的评论信息
 * ComId: 评论的唯一标识符
 * comContent: 评论内容
 * comArtId: 关联的文章ID
 * comUserId: 评论者的用户ID
 * comTime: 评论时间
 * 该实体类用于存储用户评论信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ComId;

    private String comContent;//评论正文
    private Long comArtId;//文章id
    private Long comUserId;//评论用户得id
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date comTime;//评论时间
}
