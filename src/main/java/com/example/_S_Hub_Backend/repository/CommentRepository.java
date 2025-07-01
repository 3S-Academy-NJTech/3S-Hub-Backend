package com.example._S_Hub_Backend.repository;

import com.example._S_Hub_Backend.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CommentRepository 接口用于访问和操作 Comment 实体的数据。
 * 继承自 JpaRepository，提供了基本的 CRUD 操作。
 * 
 * 主要功能：
 * - 创建评论的基本数据库操作
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // 继承JpaRepository提供的基本CRUD操作已足够支持createComment功能
}
