package com.example._S_Hub_Backend.resultmap;
import com.example._S_Hub_Backend.domain.Comment;
import com.example._S_Hub_Backend.domain.User;
import java.io.Serializable;

/**
 * ViewComAndUser 类用于封装 Comment 和 User 实体的联合信息。
 * 主要用于在查询评论时同时获取对应的用户信息。
 * 
 * 包含以下字段：
 * - comment: 评论实体
 * - user: 用户实体
 * 
 * 提供了构造方法、getter 和 setter 方法，以及 toString 方法用于输出对象信息。
 */
public class ViewComAndUser implements Serializable {
    private User user;
    private Comment comment;


    public ViewComAndUser(){}

    @Override
    public String toString() {
        return "ViewComAndUser{" +
                "user=" + user +
                ", comment=" + comment +
                '}';
    }

    public ViewComAndUser(Comment comment) {
        User user=new User();
        this.comment = comment;
        this.user=user;
    }

    public ViewComAndUser(User user) {
        Comment comment=new Comment();
        this.user = user;
        this.comment=comment;
    }

    public ViewComAndUser(Comment comment,User user) {
        this.user = user;
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}