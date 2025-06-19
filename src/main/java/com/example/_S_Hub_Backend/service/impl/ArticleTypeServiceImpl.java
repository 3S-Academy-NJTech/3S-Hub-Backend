package com.example._S_Hub_Backend.service.impl;
import com.example._S_Hub_Backend.domain.ArticleType;
import com.example._S_Hub_Backend.repository.ArticleTypeRepository;
import com.example._S_Hub_Backend.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * ArticleTypeServiceImpl 实现类
 * 实现 ArticleTypeService 接口
 * 提供文章类型相关的业务逻辑实现
 * getAllArticleType: 获取所有文章类型列表
 * findArticleNoCriteria: 分页查询所有文章类型，无条件筛选
 */
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Autowired
    ArticleTypeRepository articleTypeRepository;

    @Override
    public List<ArticleType> getAllArticleType() {
        return articleTypeRepository.findAll();
    }

    @Override
    public Page<ArticleType> findArticleNoCriteria(Integer page, Integer size) {
        Pageable pageable= PageRequest.of(page,size, Sort.Direction.DESC,"articleNum");
        return articleTypeRepository.findAll(pageable);
    }
}
