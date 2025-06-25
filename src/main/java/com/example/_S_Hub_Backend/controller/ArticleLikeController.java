package com.example._S_Hub_Backend.controller;

import com.example._S_Hub_Backend.service.ArticleLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ArticleLikeController 处理与文章点赞关系相关的 HTTP 请求
 * 提供点赞、取消点赞、查询点赞状态等功能
 * 
 * 包含以下方法：
 * - likeArticle: 用户点赞文章
 * - unlikeArticle: 用户取消点赞文章
 * - toggleLike: 切换点赞状态
 * - checkLikeStatus: 检查用户是否已点赞指定文章
 * - getArticleLikeCount: 获取文章的点赞数量
 */
@RestController
@RequestMapping("/article-likes")
public class ArticleLikeController {
    
    @Autowired
    private ArticleLikeService articleLikeService;
    
    /**
     * 用户点赞文章
     * @param userId 用户ID
     * @param articleId 文章ID
     * @return 操作结果状态码
     */
    @PostMapping("/like")
    public int likeArticle(@RequestParam Long userId, @RequestParam Long articleId) {
        return articleLikeService.likeArticle(userId, articleId) ? 200 : 400;
    }
    
    /**
     * 用户取消点赞文章
     * @param userId 用户ID
     * @param articleId 文章ID
     * @return 操作结果状态码
     */
    @PostMapping("/unlike")
    public int unlikeArticle(@RequestParam Long userId, @RequestParam Long articleId) {
        return articleLikeService.unlikeArticle(userId, articleId) ? 200 : 400;
    }
    
    /**
     * 切换点赞状态
     * @param userId 用户ID
     * @param articleId 文章ID
     * @return 操作后的点赞状态和状态码的组合
     */
    @PostMapping("/toggle")
    public String toggleLike(@RequestParam Long userId, @RequestParam Long articleId) {
        boolean isLiked = articleLikeService.toggleLike(userId, articleId);
        return isLiked ? "liked_200" : "unliked_200";
    }
    
    /**
     * 检查用户是否已点赞指定文章
     * @param userId 用户ID
     * @param articleId 文章ID
     * @return 点赞状态（true-已点赞，false-未点赞）
     */
    @GetMapping("/status")
    public boolean checkLikeStatus(@RequestParam Long userId, @RequestParam Long articleId) {
        return articleLikeService.isUserLikedArticle(userId, articleId);
    }
    
    /**
     * 获取文章的点赞数量
     * @param articleId 文章ID
     * @return 点赞数量
     */
    @GetMapping("/count")
    public Long getArticleLikeCount(@RequestParam Long articleId) {
        return articleLikeService.getArticleLikeCount(articleId);
    }
}
