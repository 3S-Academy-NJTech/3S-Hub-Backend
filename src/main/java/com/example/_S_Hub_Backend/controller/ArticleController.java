package com.example._S_Hub_Backend.controller;

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
 * - getArtAndUserInfo: 分页查询所有文章及其作者信息
 * - getArticleAndUser: 分页查询所有文章及其作者信息，适用于主页面等特殊场景
 * - getNewArticles: 分页查询最新的文章及其作者信息
 * - createNewPost: 发布新文章
 * - findArticlesByUserId: 根据用户ID查询对应的文章列表
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

    @PostMapping("/page")
    public Page<ViewArtAndUser> getArtAndUserInfo(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "5") Integer size) {
        System.out.println(page);
        return articleService.findAllArtAndUser(page, size);
    }

    @GetMapping("/get-page")
    public Page<ViewArtAndUser> getArticleAndUser(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "2") Integer size) {
        System.out.println(page);
        int adjustedPage = page > 0 ? page - 1 : page;
        System.out.println(adjustedPage);
        return articleService.findArtAndUser(adjustedPage, size);
    }

    @GetMapping("/get-new")
    public Page<ViewArtAndUser> getNewArticles(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "20") Integer size) {
        return articleService.findnew(page, size);
    }

    @PostMapping("/new-post")
    public int createNewPost(
            @RequestParam Long userId,
            @RequestParam String title,
            @RequestParam String text,
            @RequestParam Long select) {
        Article article = new Article();
        article.setArtUserId(userId);
        article.setArtTitle(title);
        article.setArtContent(text);
        article.setArtTypeId(select);
        article.setArtCreTime(new Date());

        return articleService.Post(article) != null ? 200 : 400;
    }

    @PostMapping("/find-by-user-id")
    public List<Article> findArticlesByUserId(@RequestParam Long userId) {
        return articleRepository.findAllByArtUserId(userId);
    }
}
