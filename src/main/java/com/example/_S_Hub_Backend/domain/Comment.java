package com.example._S_Hub_Backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

/**
 * 评论实体类
 * 用于记录评论的基本信息
 * commentId: 评论唯一标识
 * commentContent: 评论内容
 * commentTime: 评论时间
 * article: 所属文章（多对一）
 * user: 评论用户（多对一）
 * parentComment: 父评论（用于回复其他评论，支持嵌套）
 * childComments: 子评论列表（一对多）
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    
    @Column(columnDefinition = "TEXT")
    private String commentContent; // 评论内容
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentTime; // 评论时间
    
    // 多对一关系：多个评论属于一篇文章
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "art_id", referencedColumnName = "artId")
    private Article article;
    
    // 多对一关系：多个评论属于一个用户
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;
    
    // 自关联：父评论（多对一）
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_id", referencedColumnName = "commentId")
    private Comment parentComment;
    
    // 自关联：子评论列表（一对多）
    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> childComments;
}
