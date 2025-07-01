package com.example._S_Hub_Backend.controller.request;

/**
 * 创建评论请求的数据传输对象
 * 用于接收前端发送的评论创建请求数据
 */
public class CreateCommentRequest {
    
    private Long articleId;     // 文章ID
    private Long userId;        // 用户ID
    private String content;     // 评论内容
    
    // 默认构造函数
    public CreateCommentRequest() {}
    
    // 带参数的构造函数
    public CreateCommentRequest(Long articleId, Long userId, String content) {
        this.articleId = articleId;
        this.userId = userId;
        this.content = content;
    }
    
    // Getter 和 Setter 方法
    public Long getArticleId() {
        return articleId;
    }
    
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    @Override
    public String toString() {
        return "CreateCommentRequest{" +
                "articleId=" + articleId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                '}';
    }
}
