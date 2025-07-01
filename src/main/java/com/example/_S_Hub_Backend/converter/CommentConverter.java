package com.example._S_Hub_Backend.converter;

import com.example._S_Hub_Backend.domain.Comment;
import com.example._S_Hub_Backend.dto.SimpleCommentDTO;
import org.springframework.stereotype.Component;

/**
 * 评论实体与DTO转换器
 */
@Component
public class CommentConverter {
    
    /**
     * 将评论实体转换为简化DTO
     */
    public SimpleCommentDTO convertToSimpleDTO(Comment comment) {
        if (comment == null) {
            return null;
        }
        
        SimpleCommentDTO.SimpleCommentDTOBuilder builder = SimpleCommentDTO.builder()
                .commentId(comment.getCommentId())
                .commentContent(comment.getCommentContent())
                .commentTime(comment.getCommentTime());
        
        // 设置文章信息
        if (comment.getArticle() != null) {
            builder.articleId(comment.getArticle().getArtId())
                   .articleTitle(comment.getArticle().getArtTitle());
        }
        
        // 设置用户信息
        if (comment.getUser() != null) {
            builder.userId(comment.getUser().getUserId())
                   .userName(comment.getUser().getUserName());
        }
        
        // 设置父评论信息
        if (comment.getParentComment() != null) {
            builder.parentCommentId(comment.getParentComment().getCommentId())
                   .parentCommentContent(comment.getParentComment().getCommentContent());
            if (comment.getParentComment().getUser() != null) {
                builder.parentCommentUserName(comment.getParentComment().getUser().getUserName());
            }
        }
        
        return builder.build();
    }
}
