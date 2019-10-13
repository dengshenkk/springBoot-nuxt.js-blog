package com.ds.blog.controller;

import com.ds.blog.VO.ResultVO;
import com.ds.blog.entity.Comment;
import com.ds.blog.service.impl.CommentServiceImpl;
import com.ds.blog.utils.ResultVOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@RestController
@RequestMapping("/comment")
@EnableSwagger2
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @PostMapping("/createComment")
    public ResultVO craeteComment(Comment comment) {
        Comment comment1 = commentService.createComment(comment);
        return ResultVOUtils.success(comment1);
    }


    @DeleteMapping("/deleteComment/{commentId}")
    public ResultVO deleteComment(@PathVariable(value = "commentId") String commentId){
        Comment comment = commentService.deleteComment(commentId);
        return ResultVOUtils.success(comment);
    }

    @PostMapping("/updateComment")
    public ResultVO updateComment(Comment comment) {
        Comment updateComment = commentService.updateComment(comment);
        return ResultVOUtils.success(updateComment);
    }

    @GetMapping("/queryComment/{articleId}}")
    public ResultVO queryComment(@PathVariable(value = "articleId") String articleId) {
        List<Comment> commentList = commentService.queryComment(articleId);
        return ResultVOUtils.success(commentList);
    }
}
