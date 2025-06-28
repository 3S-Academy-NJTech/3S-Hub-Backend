package com.example._S_Hub_Backend.service;
import com.example._S_Hub_Backend.domain.Article;
import com.example._S_Hub_Backend.resultmap.ViewArtAndUser;
import org.springframework.data.domain.Page;
import java.util.List;

/**
 * ArticleService 接口定义了与 Article 实体相关的业务逻辑方法。
 * 主要用于处理文章的查询、发布等操作。
 * 
 * 包含以下方法：
 * - getAllArticle: 获取所有文章列表。
 * - findArticleNoCriteria: 分页查询所有文章，无条件筛选。
 * - findAllByArtTypeId: 根据文章类型ID查询对应的文章及其作者信息。
 * - findArtAndUser: 分页查询所有文章及其作者信息。
 * - findnew: 分页查询最新的文章及其作者信息。
 * - findAllArtAndUser: 分页查询所有文章及其作者信息，适用于主页面等特殊场景。
 * - Post: 发布新文章。
 * - findArticleDetailById: 根据文章ID获取文章详情及作者信息。
 */
public interface ArticleService {
    List<Article> getAllArticle();
    Page<Article> findArticleNoCriteria(Integer page, Integer size);//无条件查询
    List<ViewArtAndUser> findArticlesByTypeId(Long typeId);
    Page<ViewArtAndUser> findArtAndUser(Integer page, Integer size);
    Page<ViewArtAndUser> findnew(Integer page, Integer size);
    Page<ViewArtAndUser> findAllArtAndUser(Integer page, Integer size);
    Article Post(Article article);
    ViewArtAndUser findArticleDetailById(Long articleId);
}
