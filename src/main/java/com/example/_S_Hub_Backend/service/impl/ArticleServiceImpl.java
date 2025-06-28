package com.example._S_Hub_Backend.service.impl;
import com.example._S_Hub_Backend.domain.Article;
import com.example._S_Hub_Backend.repository.ArticleRepository;
import com.example._S_Hub_Backend.service.ArticleService;
import com.example._S_Hub_Backend.resultmap.ViewArtAndUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * ArticleServiceImpl 实现类
 * 实现 ArticleService 接口
 * 提供文章相关的业务逻辑实现
 * getAllArticle: 获取所有文章列表
 * findArticleNoCriteria: 分页查询所有文章，无条件筛选
 * findArticlesByTypeId: 根据文章类型ID查询对应的文章及其作者信息
 * findArtAndUser: 分页查询所有文章及其作者信息
 * findnew: 分页查询最新的文章及其作者信息
 * findAllArtAndUser: 分页查询所有文章及其作者信息，适用于主页面等特殊场景
 * Post: 发布新文章
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;


    @Override
    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }

    @Override
    public Page<Article> findArticleNoCriteria(Integer page, Integer size) {
        Pageable pageable=PageRequest.of(page,size,Sort.Direction.ASC,"artId");
        return articleRepository.findAll(pageable);
    }

    @Override
    public List<ViewArtAndUser> findArticlesByTypeId(Long typeId) {
        return articleRepository.findArticlesByTypeId(typeId);
    }

    @Override
    public Page<ViewArtAndUser> findArtAndUser(Integer page, Integer size) {
        Pageable pageable=PageRequest.of(page,size,Sort.Direction.DESC,"artLikeNum");
        return articleRepository.findViewArtAndUserMain(pageable);
    }

    @Override
    public Page<ViewArtAndUser> findnew(Integer page, Integer size) {
        Pageable pageable=PageRequest.of(page,size, Sort.Direction.DESC,"artCreTime");
        return articleRepository.findViewArtAndUserMain(pageable);
    }

    @Override
    public Page<ViewArtAndUser> findAllArtAndUser(Integer page, Integer size) {
        Pageable pageable=PageRequest.of(page,size, Sort.Direction.DESC,"artView");
        return articleRepository.findViewArtAndUser(pageable);
    }

    @Override
    @Transactional
    public Article Post(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public ViewArtAndUser findArticleDetailById(Long articleId) {
        return articleRepository.findArticleDetailById(articleId);
    }
}

