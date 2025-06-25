package com.example._S_Hub_Backend.service.impl;

import com.example._S_Hub_Backend.domain.ArticleLike;
import com.example._S_Hub_Backend.repository.ArticleLikeRepository;
import com.example._S_Hub_Backend.service.ArticleLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

/**
 * ArticleLikeServiceImpl 实现类
 * 实现 ArticleLikeService 接口
 * 提供文章点赞关系相关的业务逻辑实现
 * 
 * 主要功能：
 * - likeArticle: 用户点赞文章
 * - unlikeArticle: 用户取消点赞文章
 * - isUserLikedArticle: 检查用户是否已点赞指定文章
 * - getArticleLikeCount: 获取文章的点赞数量
 * - toggleLike: 切换点赞状态
 */
@Service
public class ArticleLikeServiceImpl implements ArticleLikeService {
    
    @Autowired
    private ArticleLikeRepository articleLikeRepository;
    
    @Override
    @Transactional
    public boolean likeArticle(Long userId, Long articleId) {
        try {
            Optional<ArticleLike> existingLike = articleLikeRepository.findByUserIdAndArticleId(userId, articleId);
            
            if (existingLike.isPresent()) {
                // 如果记录存在，更新状态为已点赞
                int updatedRows = articleLikeRepository.updateLikeStatus(userId, articleId, 1);
                return updatedRows > 0;
            } else {
                // 如果记录不存在，创建新的点赞记录
                ArticleLike newLike = ArticleLike.builder()
                        .userId(userId)
                        .articleId(articleId)
                        .likeTime(new Date())
                        .status(1)
                        .build();
                ArticleLike saved = articleLikeRepository.save(newLike);
                return saved != null;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    @Transactional
    public boolean unlikeArticle(Long userId, Long articleId) {
        try {
            Optional<ArticleLike> existingLike = articleLikeRepository.findByUserIdAndArticleId(userId, articleId);
            
            if (existingLike.isPresent()) {
                // 如果记录存在，更新状态为已取消点赞
                int updatedRows = articleLikeRepository.updateLikeStatus(userId, articleId, 0);
                return updatedRows > 0;
            }
            // 如果记录不存在，说明用户本来就没有点赞，返回true表示操作成功
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean isUserLikedArticle(Long userId, Long articleId) {
        try {
            return articleLikeRepository.existsByUserIdAndArticleIdAndStatus(userId, articleId, 1);
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public Long getArticleLikeCount(Long articleId) {
        try {
            return articleLikeRepository.countByArticleIdAndStatus(articleId, 1);
        } catch (Exception e) {
            return 0L;
        }
    }
    
    @Override
    @Transactional
    public boolean toggleLike(Long userId, Long articleId) {
        try {
            boolean isLiked = isUserLikedArticle(userId, articleId);
            
            if (isLiked) {
                // 如果已点赞，则取消点赞
                return !unlikeArticle(userId, articleId); // 返回false表示现在未点赞
            } else {
                // 如果未点赞，则点赞
                return likeArticle(userId, articleId); // 返回true表示现在已点赞
            }
        } catch (Exception e) {
            return false;
        }
    }
}
