package com.ds.blog.service.impl;

import com.ds.blog.dao.ArticleDao;
import com.ds.blog.dao.CommentDao;
import com.ds.blog.entity.Article;
import com.ds.blog.entity.Comment;
import com.ds.blog.service.CommentService;
import com.ds.blog.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private ArticleDao articleDao;

    @Override
    public Comment createComment(Comment comment) {
        Optional<Article> optionalArticle = articleDao.findById(comment.getArticleId());
        Article article = optionalArticle.orElse(null);
        comment.setArticleId(article.getId());
        comment.setId(KeyUtil.genUniqueKey());
        Comment save = commentDao.save(comment);
        return save;
    }

    @Override
    public Comment deleteComment(String commentId) {
        Optional<Comment> optionalComment = commentDao.findById(commentId);
        optionalComment.get().setIsDelete(1);
        return commentDao.save(optionalComment.get());
    }

    @Override
    public Comment updateComment(Comment comment) {
        comment.setIsCheck(0);
        return commentDao.save(comment);
    }

    @Override
    public List<Comment> queryComment(String articleId) {
        List<Comment> commentList = commentDao.findAllByArticleId(articleId);
        return commentList;
    }
    @Override
    public List<Comment> queryCommentAll() {
        List<Comment> commentList = commentDao.findAllByIsDeleteEquals(0);
        return commentList;
    }
}
