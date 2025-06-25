package com.example._S_Hub_Backend.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import com.example._S_Hub_Backend.domain.Article;
import com.example._S_Hub_Backend.resultmap.ViewArtAndUser;

import java.util.List;
/**
 * ArticleRepository 接口用于访问和操作 Article 实体的数据。
 * 继承自 JpaRepository，提供了基本的 CRUD 操作。
 * 
 * 主要方法说明：
 * 
 * 1. findArticlesByTypeId(Long typeId)
 *    - 通过文章类型ID查询对应的文章及其作者信息。
 *    - 返回 ViewArtAndUser 结果映射的列表。
 *    - 使用 JPQL 联合 Article 和 User 实体，条件为 a.artUserId = u.userId 且 a.artTypeId = :typeId。
 * 
 * 2. findViewArtAndUser(Pageable pageable)
 *    - 分页查询所有文章及其作者信息。
 *    - 返回 ViewArtAndUser 结果映射的分页对象。
 *    - 使用 JPQL 联合 Article 和 User 实体，条件为 a.artUserId = u.userId。
 * 
 * 3. findViewArtAndUserMain(Pageable pageable)
 *    - 与 findViewArtAndUser 类似，分页查询所有文章及其作者信息。
 *    - 返回 ViewArtAndUser 结果映射的分页对象。
 *    - 可用于主页面等特殊场景的数据展示。
 * 
 * 4. findAllByArtUserId(Long userId)
 *    - 根据用户ID查询该用户发布的所有文章。
 *    - 返回 Article 实体列表。
 * 
 * 注意事项：
 * - ViewArtAndUser 是自定义的结果映射类，用于封装文章和用户的联合信息。
 * - 所有自定义查询均使用 JPQL 实现，确保实体类字段与数据库字段一致。
 * - incrementLikeCount 和 decrementLikeCount 方法使用 @Modifying 注解，需要在事务环境中调用。
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Query("SELECT new com.example._S_Hub_Backend.resultmap.ViewArtAndUser(a, u) " +
           "FROM Article a, User u WHERE a.artUserId = u.userId and a.artTypeId=:typeId")
    List<ViewArtAndUser> findArticlesByTypeId(@Param("typeId") Long typeId);

    @Query("SELECT new com.example._S_Hub_Backend.resultmap.ViewArtAndUser(a, u) " +
           "FROM Article a, User u WHERE a.artUserId = u.userId ")
    Page<ViewArtAndUser> findViewArtAndUser(Pageable pageable);

    @Query("SELECT new com.example._S_Hub_Backend.resultmap.ViewArtAndUser(a, u) " +
           "FROM Article a, User u WHERE a.artUserId = u.userId")
    Page<ViewArtAndUser> findViewArtAndUserMain(Pageable pageable);

    List<Article> findAllByArtUserId(Long userId);
}
