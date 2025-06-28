package com.example._S_Hub_Backend.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Date;

/**
 * 文章实体类
 * 用于记录文章的基本信息
 * artId: 文章的唯一标识符
 * artUserId: 文章作者的用户ID
 * artTitle: 文章标题
 * artTypeId: 文章类型ID
 * artContent: 文章内容
 * artCommentId: 评论ID
 * artCreTime: 创建时间
 * artView: 浏览量
 * artComNum: 评论数
 * artHotNum: 热度
 * artLikeNum: 点赞数
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long artId;

    private Long artUserId;
    private String artTitle; //文章标题
    private Long artTypeId; //文章类型id
    
    @Column(columnDefinition = "LONGTEXT")
    private String artContent; //文章内容（支持巨量文字，无长度限制）
    private Date artCreTime;//创建时间
}
