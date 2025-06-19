package com.example._S_Hub_Backend.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;  
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * 文章类型实体类
 * 用于记录文章的类型信息
 * typeId: 文章类型的唯一标识符
 * typeName: 文章类型名称
 * typeCreateTime: 创建时间
 * typeDesc: 描述信息
 * articleNum: 帖子数量
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    private String typeName;//标签类型
    private Date typeCreateTime;//创建时间
    private String typeDesc;//描述
    private Integer articleNum;//帖子数量

}
