package com.example._S_Hub_Backend.controller;

import com.example._S_Hub_Backend.domain.ArticleType;
import com.example._S_Hub_Backend.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ArticleTypeController 处理与文章类型相关的 HTTP 请求
 * 提供获取文章类型列表、分页查询等功能
 * 
 * 包含以下方法：
 * - getAllArticleTypes: 获取所有文章类型列表
 * - findHotArticleTypes: 分页查询热门文章类型
 */
@RestController
public class ArticleTypeController {

    private final ArticleTypeService articleTypeService;

    @Autowired
    public ArticleTypeController(ArticleTypeService articleTypeService) {
        this.articleTypeService = articleTypeService;
    }

    @PostMapping("/get-all-article-types")
    public List<ArticleType> getAllArticleTypes() {
        return articleTypeService.getAllArticleType();
    }

    @PostMapping("/get-hot-article-types")
    public Page<ArticleType> findHotArticleTypes(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "5") Integer size) {
        return articleTypeService.findArticleNoCriteria(page, size);
    }
}
