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
@CrossOrigin
public class ArticleController {


    // TODO 一般方式
    /**
     * @ Autowired
     * private ArticleServiceImpl articleService;
     */

    // TODO 自动装配编辑器推荐方式
    // TODO 1. 声明变量
    private final ArticleServiceImpl articleService;
    private Article article;

    // TODO 2. 构造函数注入
    @Autowired
    public ArticleController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/createArticle")
    public ResultVO createArticle(@RequestBody Article article) {
        try {
            Article serviceArticle = articleService.createArticle(article);
            return ResultVOUtils.success(serviceArticle);
        } catch (Exception e){
            return ResultVOUtils.error(e.getMessage());
        }
    }

    @DeleteMapping("/deleteArticleOne/{articleId}")
    public ResultVO deleteArticleOne(@PathVariable(value = "articleId") String articleId) {
        try {
            Article article = articleService.deleteArticleOne(articleId);
            System.out.println(article);
            return ResultVOUtils.success(null);
        } catch (Exception e) {
            return ResultVOUtils.error(e.getMessage());
        }


    }

    @PostMapping("/updateArticle")
    public ResultVO updateArticle(@RequestBody Article article) {

        try {
            Article article1 = articleService.updateArticle(article);
            return ResultVOUtils.success(article1);
        } catch (Exception e) {
            return ResultVOUtils.error(e.getMessage());
        }
    }

    @GetMapping("/queryArticle/{articleId}")
    public ResultVO queryArticle(@PathVariable(value = "articleId") String articleId) {
        try {
            Article article = articleService.queryArticleOne(articleId);
            return ResultVOUtils.success(article);
        } catch (Exception e) {
            return ResultVOUtils.error(e.getMessage());
        }
    }

    @GetMapping("/queryArticleAll")
    public ResultVO queryArticle() {
        try {
            List<Article> articleList = articleService.queryArticleAll();
            return ResultVOUtils.success(articleList);
        } catch (Exception e) {
            return ResultVOUtils.error(e.getMessage());
        }
    }

    @GetMapping("/queryArticleByCategory/{categoryType}")
    public ResultVO queryArticleByCategoryType(@PathVariable(value = "categoryType") String categoryType) {
        try {
            List<Article> articleList = articleService.queryArticleByCategory(categoryType);
            return ResultVOUtils.success(articleList);
        } catch (Exception e) {
            return ResultVOUtils.error(e.getMessage());
        }
    }

}
