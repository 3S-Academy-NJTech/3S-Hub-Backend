package com.example._S_Hub_Backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 收藏实体类
 * 用于记录用户收藏的文章信息
 * colId: 收藏关系的唯一标识符
 * colArtId: 被收藏文章的ID
 * colUserId: 收藏者的用户ID
 * 该实体类用于存储用户收藏信息
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Collect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colId;

    private Long colArtId;//收藏文章id
    private Long colUserId;//收藏用户得id/谁收藏了id
}

