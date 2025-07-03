package com.example._S_Hub_Backend.service.impl;

import com.example._S_Hub_Backend.domain.Article;
import com.example._S_Hub_Backend.domain.Comment;
import com.example._S_Hub_Backend.domain.User;
import com.example._S_Hub_Backend.dto.SimpleCommentDTO;
import com.example._S_Hub_Backend.converter.CommentConverter;
import com.example._S_Hub_Backend.repository.ArticleRepository;
import com.example._S_Hub_Backend.repository.CommentRepository;
import com.example._S_Hub_Backend.repository.UserRepository;
import com.example._S_Hub_Backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * CommentService 的实现类
 * 实现了评论创建和查询的业务逻辑
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    private CommentRepository commentRepository;
    
    @Autowired
    private ArticleRepository articleRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CommentConverter commentConverter;
    
    @Override
    public Comment createComment(Long articleId, Long userId, String content) {
        // 验证文章是否存在
        Optional<Article> articleOpt = articleRepository.findById(articleId);
        if (!articleOpt.isPresent()) {
            throw new IllegalArgumentException("文章不存在，ID: " + articleId);
        }
        
        // 验证用户是否存在
        Optional<User> userOpt = userRepository.findById(userId);
        if (!userOpt.isPresent()) {
            throw new IllegalArgumentException("用户不存在，ID: " + userId);
        }
        
        // 创建评论
        Comment comment = Comment.builder()
                .commentContent(content)
                .commentTime(new Date())
                .article(articleOpt.get())
                .user(userOpt.get())
                .build();
        
        return commentRepository.save(comment);
    }
    
    @Override
    public List<SimpleCommentDTO> getCommentsByArticleId(Long articleId) {
        // 验证文章是否存在
        Optional<Article> articleOpt = articleRepository.findById(articleId);
        if (!articleOpt.isPresent()) {
            throw new IllegalArgumentException("文章不存在，ID: " + articleId);
        }
        
        // 查询该文章的所有评论
        List<Comment> comments = commentRepository.findByArticleIdOrderByCommentTimeDesc(articleId);
        
        // 将评论实体转换为DTO
        return comments.stream()
                .map(commentConverter::convertToSimpleDTO)
                .collect(Collectors.toList());
    }
}
