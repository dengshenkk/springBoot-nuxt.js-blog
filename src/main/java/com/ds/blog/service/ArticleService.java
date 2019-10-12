package com.ds.blog.service;

import com.ds.blog.entity.Article;

import java.util.List;

public interface ArticleService {

    public Article createArticle(Article article);

    public Article deleteArticleOne(String articleId);

    public Article updateArticle(Article article);

    public Article queryArticleOne(String articleId);

    public List<Article> queryArticleAll();
    public List<Article> queryArticleByCategory(String categoryType);

}
