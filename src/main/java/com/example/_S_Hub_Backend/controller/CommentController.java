package com.example._S_Hub_Backend.controller;

import com.example._S_Hub_Backend.domain.Comment;
import com.example._S_Hub_Backend.resultmap.ViewComAndUser;
import com.example._S_Hub_Backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * CommentController 处理与评论相关的 HTTP 请求
 * 提供获取评论列表、发布新评论等功能
 * 
 * 包含以下方法：
 * - findComment: 分页查询指定文章的评论及其作者信息
 * - postComment: 发布新评论
 */
@RestController
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/getComment")
    public Page<ViewComAndUser> findComment(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "30") Integer size,
            @RequestParam(value = "artId") Long artId) {
        Page<ViewComAndUser> comments = commentService.findViewComAndUser(page, size, artId);
        System.out.println(comments.getContent());
        return comments;
    }

    @PostMapping("/postComment")
    public int postComment(
            @RequestParam(value = "comArtId") Long comArtId,
            @RequestParam(value = "text") String text,
            @RequestParam(value = "comUserId") Long comUserId) {
        Comment comment = new Comment();
        comment.setComArtId(comArtId);
        comment.setComContent(text);
        comment.setComUserId(comUserId);
        comment.setComTime(new Date());

        return commentService.insertComment(comment) != null ? 200 : 404;
    }
}
