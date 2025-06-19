package com.example._S_Hub_Backend.resultmap;
import java.io.Serializable;
import com.example._S_Hub_Backend.domain.User;
import com.example._S_Hub_Backend.domain.Article;

/**
 * ViewArtAndUser 类用于封装 Article 和 User 实体的联合信息。
 * 主要用于在查询文章时同时获取对应的用户信息。
 * 
 * 包含以下字段：
 * - article: 文章实体
 * - user: 用户实体
 * 
 * 提供了构造方法、getter 和 setter 方法，以及 toString 方法用于输出对象信息。
 */
public class ViewArtAndUser implements Serializable{
    @Override
    public String toString() {
        return "ViewArtAndUser{" +
                "article=" + article +
                ", user=" + user +
                '}';
    }

    private Article article;
    private User user;

    public ViewArtAndUser() {
    }

    public ViewArtAndUser(Article article, User user) {
        this.article = article;
        this.user = user;
    }
    public ViewArtAndUser(Article article) {
        User user=new User();
        this.article = article;
        this.user = user;
    }
    public ViewArtAndUser(User user) {
        Article article=new Article();
        this.article = article;
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
