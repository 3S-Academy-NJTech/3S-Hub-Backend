package com.example._S_Hub_Backend.repository;
import com.example._S_Hub_Backend.domain.Comment;
import com.example._S_Hub_Backend.resultmap.ViewComAndUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * CommentRepositry 接口用于访问和操作 Comment 实体的数据。
 * 继承自 JpaRepository，提供了基本的 CRUD 操作。
 * 
 * 主要方法说明：
 * 
 * 1. findViewComAndUser(Pageable pageable, Long artId)
 *    - 分页查询指定文章的评论及其对应的用户信息。
 *    - 返回 ViewComAndUser 结果映射的分页对象。
 *    - 使用 JPQL 联合 Comment 和 User 实体，条件为 c.comUserId = u.userId 且 c.comArtId = :artId。
 * 
 * 注意事项：
 * - ViewComAndUser 是自定义的结果映射类，用于封装评论和用户的联合信息。
 * - 所有自定义查询均使用 JPQL 实现，确保实体类字段与数据库字段一致。
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query("select new com.example._S_Hub_Backend.resultmap.ViewComAndUser(c,u) from Comment c,User u where c.comUserId=u.userId and c.comArtId=:artId")
    Page<ViewComAndUser> findViewComAndUser(Pageable pageable,@Param("artId") Long artId);
}
