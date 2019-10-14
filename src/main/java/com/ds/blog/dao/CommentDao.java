package com.ds.blog.dao;

import com.ds.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, String> {
    List<Comment> findAllByArticleId(String articleId);

    List<Comment> findAllByIsDeleteEquals(Integer isDelete);
}
