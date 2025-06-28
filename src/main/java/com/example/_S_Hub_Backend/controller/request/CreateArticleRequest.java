package com.example._S_Hub_Backend.controller.request;

/**
 * 创建文章请求的数据传输对象
 * 用于接收前端发送的文章创建请求数据
 * 支持巨量文字内容，无长度限制
 */
public class CreateArticleRequest {
    
    private Long userId;        // 用户ID
    private String title;       // 文章标题
    private String text;        // 文章内容（支持巨量文字）
    private Long select;        // 文章类型ID

    // 默认构造函数
    public CreateArticleRequest() {}

    // 带参数的构造函数
    public CreateArticleRequest(Long userId, String title, String text, Long select) {
        this.userId = userId;
        this.title = title;
        this.text = text;
        this.select = select;
    }

    // Getter 和 Setter 方法
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getSelect() {
        return select;
    }

    public void setSelect(Long select) {
        this.select = select;
    }

    @Override
    public String toString() {
        return "CreateArticleRequest{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", text='" + (text != null ? text.substring(0, Math.min(100, text.length())) + "..." : "null") + '\'' +
                ", select=" + select +
                '}';
    }
}
