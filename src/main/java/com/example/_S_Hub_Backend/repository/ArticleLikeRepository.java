package com.example._S_Hub_Backend.repository;

import com.example._S_Hub_Backend.domain.ArticleLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * ArticleLikeRepository 接口用于访问和操作 ArticleLike 实体的数据。
 * 继承自 JpaRepository，提供了基本的 CRUD 操作。
 * 
 * 主要方法说明：
 * 
 * 1. findByUserIdAndArticleId(Long userId, Long articleId)
 *    - 根据用户ID和文章ID查询点赞关系记录。
 *    - 返回 Optional<ArticleLike>，如果存在则包含记录，否则为空。
 * 
 * 2. updateLikeStatus(Long userId, Long articleId, Integer status)
 *    - 更新指定用户对指定文章的点赞状态。
 *    - 返回受影响的行数。
 * 
 * 3. countByArticleIdAndStatus(Long articleId, Integer status)
 *    - 统计指定文章在指定状态下的点赞数量。
 *    - 通常用于统计文章的总点赞数（status=1）。
 * 
 * 4. existsByUserIdAndArticleIdAndStatus(Long userId, Long articleId, Integer status)
 *    - 检查用户是否对指定文章进行了点赞（status=1）。
 *    - 返回布尔值。
 */
@Repository
public interface ArticleLikeRepository extends JpaRepository<ArticleLike, Long> {
    
    /**
     * 根据用户ID和文章ID查询点赞关系记录
     */
    Optional<ArticleLike> findByUserIdAndArticleId(Long userId, Long articleId);
    
    /**
     * 更新点赞状态
     */
    @Modifying
    @Query("UPDATE ArticleLike al SET al.status = :status, al.likeTime = CURRENT_TIMESTAMP WHERE al.userId = :userId AND al.articleId = :articleId")
    int updateLikeStatus(@Param("userId") Long userId, @Param("articleId") Long articleId, @Param("status") Integer status);
    
    /**
     * 统计文章的点赞数量
     */
    @Query("SELECT COUNT(al) FROM ArticleLike al WHERE al.articleId = :articleId AND al.status = :status")
    Long countByArticleIdAndStatus(@Param("articleId") Long articleId, @Param("status") Integer status);
    
    /**
     * 检查用户是否已点赞文章
     */
    boolean existsByUserIdAndArticleIdAndStatus(Long userId, Long articleId, Integer status);
}
