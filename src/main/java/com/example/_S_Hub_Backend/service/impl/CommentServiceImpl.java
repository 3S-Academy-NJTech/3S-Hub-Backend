package com.example._S_Hub_Backend.service.impl;
import com.example._S_Hub_Backend.domain.Comment;
import com.example._S_Hub_Backend.repository.CommentRepository;
import com.example._S_Hub_Backend.resultmap.ViewComAndUser;
import com.example._S_Hub_Backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CommentServiceImpl 实现类
 * 实现 CommentService 接口
 * 提供评论相关的业务逻辑实现
 * findViewComAndUser: 分页查询指定文章的评论及其对应的用户信息
 * insertComment: 插入新的评论记录
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public Page<ViewComAndUser> findViewComAndUser(Integer page, Integer size,Long artId) {
        Pageable pageable = PageRequest.of(page,size,Sort.Direction.DESC,"comTime");
        return commentRepository.findViewComAndUser(pageable,artId);
    }

    @Override
    @Transactional
    public Comment insertComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
