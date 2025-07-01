package com.example._S_Hub_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 简化的评论数据传输对象
 * 用于普通的评论列表查询，不包含子评论
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimpleCommentDTO {
    
    private Long commentId;
    private String commentContent;
    private Date commentTime;
    
    // 文章信息
    private Long articleId;
    private String articleTitle;
    
    // 用户信息
    private Long userId;
    private String userName;
    
    // 父评论信息
    private Long parentCommentId;
    private String parentCommentContent;
    private String parentCommentUserName;
}
