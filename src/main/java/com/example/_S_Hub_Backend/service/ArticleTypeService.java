package com.example._S_Hub_Backend.service;
import com.example._S_Hub_Backend.domain.ArticleType;
import org.springframework.data.domain.Page;
import java.util.List;

/**
 * ArticleTypeService 接口定义了与 ArticleType 实体相关的业务逻辑方法。
 * 主要用于处理文章类型的查询等操作。
 * 
 * 包含以下方法：
 * - getAllArticleType: 获取所有文章类型列表。
 * - findArticleNoCriteria: 分页查询所有文章类型，无条件筛选。
 */
public interface ArticleTypeService {
    List<ArticleType> getAllArticleType();
    Page<ArticleType> findArticleNoCriteria(Integer page, Integer size);
}