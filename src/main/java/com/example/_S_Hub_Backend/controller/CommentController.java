package com.example._S_Hub_Backend.controller;

import com.example._S_Hub_Backend.controller.request.CreateCommentRequest;
import com.example._S_Hub_Backend.domain.Comment;
import com.example._S_Hub_Backend.dto.SimpleCommentDTO;
import com.example._S_Hub_Backend.converter.CommentConverter;
import com.example._S_Hub_Backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * CommentController 处理与评论相关的 HTTP 请求
 * 提供评论的创建功能
 * 
 * 包含以下方法：
 * - createComment: 创建新评论
 */
@RestController
@RequestMapping("/comments")
@CrossOrigin(origins = "*")
public class CommentController {
    
    @Autowired
    private CommentService commentService;
    
    @Autowired
    private CommentConverter commentConverter;
    
    /**
     * 创建新评论
     */
    @PostMapping
    public ResponseEntity<?> createComment(@RequestBody CreateCommentRequest request) {
        try {
            Comment comment = commentService.createComment(
                    request.getArticleId(),
                    request.getUserId(),
                    request.getContent()
            );
            SimpleCommentDTO commentDTO = commentConverter.convertToSimpleDTO(comment);
            return ResponseEntity.ok(commentDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("创建评论失败: " + e.getMessage());
        }
    }
}
