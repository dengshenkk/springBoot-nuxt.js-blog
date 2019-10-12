package com.ds.blog.controller;

import com.ds.blog.VO.ResultVO;
import com.ds.blog.entity.Article;
import com.ds.blog.service.impl.ArticleServiceImpl;
import com.ds.blog.utils.ResultVOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping("article")
@EnableSwagger2
public class ArticleController {

    @Autowired
    private ArticleServiceImpl articleService;

    @PostMapping("/createArticle")
    public ResultVO createArticle(@RequestBody Article article) {
        Article serviceArticle = articleService.createArticle(article);
        return ResultVOUtils.success(serviceArticle);
    }

    @DeleteMapping("/deleteArticleOne/{articleId}")
    public ResultVO deleteArticleOne(@PathVariable(value = "articleId") String articleId) {
        Article article = articleService.deleteArticleOne(articleId);
        System.out.println(article);
        return ResultVOUtils.success(article);
    }

    @PostMapping("/updateArticle")
    public ResultVO updateArticle(Article article) {

        Article article1 = articleService.updateArticle(article);
        return ResultVOUtils.success(article1);
    }

    @GetMapping("/queryArticle/{articleId}")
    public ResultVO queryArticle(@PathVariable(value = "articleId") String articleId) {
        Article article = articleService.queryArticleOne(articleId);
        return ResultVOUtils.success(article);
    }

    @GetMapping("/queryArticleAll")
    public ResultVO queryArticle(){
        List<Article> articleList = articleService.queryArticleAll();
        return ResultVOUtils.success(articleList);
    }

    @GetMapping("/queryArticleByCategory/{categoryType}")
    public ResultVO queryArticleByCategoryType(@PathVariable(value = "categoryType") String categoryType) {
        List<Article> articleList = articleService.queryArticleByCategory(categoryType);
        return ResultVOUtils.success(articleList);
    }

}
