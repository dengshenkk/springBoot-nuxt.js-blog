package com.ds.blog.service;

import com.ds.blog.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment createComment(Comment comment);

    Comment deleteComment(String commentId);

    Comment updateComment(Comment comment);

    List<Comment> queryComment(String articleId);
}
