package com.ds.blog.dao;

import com.ds.blog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleDao extends JpaRepository<Article, String> {

    List<Article> findAllByIsDeleteEquals(Integer isDelete);
    List<Article> findAllByCategoryTypeAndIsDeleteEquals(String categoryType, Integer isDelete);
}
