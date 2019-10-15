package com.ds.blog.service.impl;

import com.ds.blog.entity.Article;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImplTest {


    @Autowired
    private ArticleServiceImpl articleService;
    @Test
    public void createArticle() {
        Article article = new Article();
        article.setId("12347");
        article.setTitle("测试标题");
        article.setSubtitle("小标题");
        article.setContent("测试内容");
        article.setCategoryType("11");
        article.setIsTop(0);
        article.setIsDelete(0);
        Article result = articleService.createArticle(article);
        Assert.assertNotNull(result);

    }

    @Test
    public void deleteArticleOne() {
        Article article = articleService.deleteArticleOne("12345");
        System.out.println(article);
//        createArticle();
    }

    @Test
    public void updateArticle() {
        Article article = articleService.queryArticleOne("1571152817208266804");
        article.setTitle("99996666688888");
        article.setSubtitle("小标题new");
        article.setContent("测试内容new");
        article.setCategoryType("11");
        article.setIsTop(0);
        Article result = articleService.updateArticle(article);
        Assert.assertNotNull(result);
    }

    @Test
    public void queryArticleOne() {
        Article article = articleService.queryArticleOne("12345");
        Assert.assertNotNull(article);
    }
}
