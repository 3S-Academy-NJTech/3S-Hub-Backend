package com.example._S_Hub_Backend.service;
import com.example._S_Hub_Backend.domain.Comment;
import com.example._S_Hub_Backend.resultmap.ViewComAndUser;
import org.springframework.data.domain.Page;

/**
 * CommentService 接口定义了与 Comment 实体相关的业务逻辑方法。
 * 主要用于处理评论的查询和插入操作。
 * 
 * 包含以下方法：
 * - findViewComAndUser: 分页查询指定文章的评论及其对应的用户信息。
 * - insertComment: 插入新的评论记录。
 */
public interface CommentService {

    Page<ViewComAndUser> findViewComAndUser(Integer page, Integer size, Long artId);
    Comment insertComment(Comment comment);
}
