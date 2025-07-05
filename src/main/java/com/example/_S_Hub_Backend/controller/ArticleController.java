package com.example._S_Hub_Backend.controller;

import com.example._S_Hub_Backend.controller.request.CreateArticleRequest;
import com.example._S_Hub_Backend.domain.Article;
import com.example._S_Hub_Backend.repository.ArticleRepository;
import com.example._S_Hub_Backend.service.ArticleService;
import com.example._S_Hub_Backend.resultmap.ViewArtAndUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * ArticleController 处理与文章相关的 HTTP 请求
 * 提供获取文章列表、分页查询、发布新文章等功能
 * 
 * 包含以下方法：
 * - getAllArticles: 获取所有文章列表
 * - getArticlesByTypeId: 根据文章类型ID查询对应的文章及其作者信息
 * - getNewArticles: 分页查询最新的文章及其作者信息
 * - createNewPost: 发布新文章
 * - findArticlesByUserId: 根据用户ID查询对应的文章列表
 * - getArticleDetail: 根据文章ID获取文章详情及作者信息
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping("/get-all")
    public List<Article> getAllArticles() {
        return articleService.getAllArticle();
    }

    @PostMapping("/get-by-type-id")
    public List<ViewArtAndUser> getArticlesByTypeId(@RequestParam Long typeId) {
        System.out.println(typeId);
        return articleService.findArticlesByTypeId(typeId);
    }

    @GetMapping("/get-new")
    public Page<ViewArtAndUser> getNewArticles(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "20") Integer size) {
        return articleService.findnew(page, size);
    }

    /**
     * 发布新文章
     * 支持巨量文字内容，无长度限制
     * @param request 包含文章信息的请求对象
     * @return 操作结果状态码（200-成功，400-失败）
     */
    @PostMapping("/new-post")
    public int createNewPost(@RequestBody CreateArticleRequest request) {
        Article article = new Article();
        article.setArtUserId(request.getUserId());
        article.setArtTitle(request.getTitle());
        article.setArtContent(request.getText()); // 支持巨量文字内容，无长度限制
        article.setArtTypeId(request.getSelect());
        article.setArtCreTime(new Date());

        return articleService.Post(article) != null ? 200 : 400;
    }

    @PostMapping("/find-by-user-id")
    public List<Article> findArticlesByUserId(@RequestParam Long userId) {
        return articleRepository.findAllByArtUserId(userId);
    }

    /**j
     * 根据文章ID获取文章详情
     * @param articleId 文章ID
     * @return ViewArtAndUser 文章详情及作者信息，如果文章不存在则返回null
     */
    @GetMapping("/{articleId}")
    public ViewArtAndUser getArticleDetail(@PathVariable Long articleId) {
        return articleService.findArticleDetailById(articleId);
    }
}
