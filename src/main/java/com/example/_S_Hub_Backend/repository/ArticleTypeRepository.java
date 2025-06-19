package com.example._S_Hub_Backend.repository;
import com.example._S_Hub_Backend.domain.ArticleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ArticleTypeRepository 接口用于访问和操作 ArticleType 实体的数据。
 * 继承自 JpaRepository，提供了基本的 CRUD 操作。
 * 
 * 主要方法说明：
 * 
 * - 无自定义查询方法，使用 JpaRepository 提供的默认方法进行数据访问。
 * 
 * 注意事项：
 * - ArticleType 实体应与数据库中的 article_type 表对应。
 */
@Repository
public interface ArticleTypeRepository extends JpaRepository<ArticleType,Long> {

}
