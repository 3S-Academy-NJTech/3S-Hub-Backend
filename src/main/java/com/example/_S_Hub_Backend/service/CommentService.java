package com.example._S_Hub_Backend.service;

import com.example._S_Hub_Backend.domain.Comment;
import com.example._S_Hub_Backend.dto.SimpleCommentDTO;

import java.util.List;

/**
 * CommentService 接口定义了与 Comment 实体相关的业务逻辑方法。
 * 主要用于处理评论的创建和查询操作。
 * 
 * 包含以下方法：
 * - createComment: 创建新评论
 * - getCommentsByArticleId: 获取指定文章的所有评论
 */
public interface CommentService {
    
    /**
     * 创建新评论
     * @param articleId 文章ID
     * @param userId 用户ID
     * @param content 评论内容
     * @return 创建的评论对象
     */
    Comment createComment(Long articleId, Long userId, String content);
    
    /**
     * 获取指定文章的所有评论
     * @param articleId 文章ID
     * @return 评论DTO列表
     */
    List<SimpleCommentDTO> getCommentsByArticleId(Long articleId);
}
