package com.ds.blog.service.impl;

import com.ds.blog.dao.ArticleDao;
import com.ds.blog.entity.Article;
import com.ds.blog.service.ArticleService;
import com.ds.blog.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public Article createArticle(Article article) {
        article.setId(KeyUtil.genUniqueKey());
        return articleDao.save(article);
    }

    @Override
    public Article deleteArticleOne(String articleId) {
        Optional<Article> result = articleDao.findById(articleId);
        if (result.isPresent()) {
            Article article = result.get();
            article.setIsDelete(1);
            return articleDao.save(article);
        }
        return null;
    }


    @Override
    public Article updateArticle(Article article) {
        return articleDao.save(article);
    }

    @Override
    public Article queryArticleOne(String articleId) {
        Optional<Article> article = articleDao.findById(articleId);
        Article article1 = article.orElse(null);
        return article1;
    }

    @Override
    public List<Article> queryArticleAll() {
        List<Article> articleList = articleDao.findAllByIsDeleteEquals(0);
        return articleList;
    }

    @Override
    public List<Article> queryArticleByCategory(String categoryType) {
        return articleDao.findAllByCategoryTypeAndIsDeleteEquals(categoryType, 0);
    }


}
