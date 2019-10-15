package com.ds.blog.service;

import com.ds.blog.entity.Article;

import java.util.List;

public interface ArticleService {

    Article createArticle(Article article);

    Article deleteArticleOne(String articleId);

    Article updateArticle(Article article);

    Article queryArticleOne(String articleId);

    List<Article> queryArticleAll();

    List<Article> queryArticleByCategory(String categoryType);

}
