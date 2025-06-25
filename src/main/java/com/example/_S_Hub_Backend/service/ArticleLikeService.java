package com.example._S_Hub_Backend.service;

/**
 * ArticleLikeService 接口定义了与 ArticleLike 实体相关的业务逻辑方法。
 * 主要用于处理用户对文章的点赞和取消点赞操作。
 * 
 * 包含以下方法：
 * - likeArticle: 用户点赞文章。
 * - unlikeArticle: 用户取消点赞文章。
 * - isUserLikedArticle: 检查用户是否已点赞指定文章。
 * - getArticleLikeCount: 获取文章的点赞数量。
 * - toggleLike: 切换点赞状态（如果已点赞则取消，如果未点赞则点赞）。
 */
public interface ArticleLikeService {
    
    /**
     * 用户点赞文章
     * @param userId 用户ID
     * @param articleId 文章ID
     * @return 操作是否成功
     */
    boolean likeArticle(Long userId, Long articleId);
    
    /**
     * 用户取消点赞文章
     * @param userId 用户ID
     * @param articleId 文章ID
     * @return 操作是否成功
     */
    boolean unlikeArticle(Long userId, Long articleId);
    
    /**
     * 检查用户是否已点赞指定文章
     * @param userId 用户ID
     * @param articleId 文章ID
     * @return 是否已点赞
     */
    boolean isUserLikedArticle(Long userId, Long articleId);
    
    /**
     * 获取文章的点赞数量
     * @param articleId 文章ID
     * @return 点赞数量
     */
    Long getArticleLikeCount(Long articleId);
    
    /**
     * 切换点赞状态
     * @param userId 用户ID
     * @param articleId 文章ID
     * @return 操作后的点赞状态（true-已点赞，false-未点赞）
     */
    boolean toggleLike(Long userId, Long articleId);
}
