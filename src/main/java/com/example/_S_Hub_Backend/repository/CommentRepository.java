package com.example._S_Hub_Backend.repository;

import com.example._S_Hub_Backend.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CommentRepository 接口用于访问和操作 Comment 实体的数据。
 * 继承自 JpaRepository，提供了基本的 CRUD 操作。
 * 
 * 主要功能：
 * - 创建评论的基本数据库操作
 * - 根据文章ID查询评论列表
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 继承JpaRepository提供的基本CRUD操作已足够支持createComment功能
    
    /**
     * 根据文章ID查询该文章的所有评论，按时间降序排列
     * @param articleId 文章ID
     * @return 评论列表
     */
    @Query("SELECT c FROM Comment c WHERE c.article.artId = :articleId ORDER BY c.commentTime DESC")
    List<Comment> findByArticleIdOrderByCommentTimeDesc(@Param("articleId") Long articleId);
}
