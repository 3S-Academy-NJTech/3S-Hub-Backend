package com.example._S_Hub_Backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * 文章点赞关系实体类
 * 用于记录用户对文章的点赞关系
 * 
 * 字段说明：
 * likeId: 点赞记录的唯一标识符
 * userId: 点赞用户的ID
 * articleId: 被点赞文章的ID
 * likeTime: 点赞时间
 * status: 点赞状态（1-已点赞，0-已取消点赞）
 */
@Entity
@Table(name = "article_like", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "article_id"})
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleLike {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;
    
    @Column(name = "user_id", nullable = false)
    private Long userId;
    
    @Column(name = "article_id", nullable = false)
    private Long articleId;
    
    @Column(name = "like_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date likeTime;
    
    @Column(name = "status", nullable = false)
    private Integer status; // 1-已点赞，0-已取消点赞
}
