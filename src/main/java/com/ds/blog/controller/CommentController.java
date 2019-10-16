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
        try {
            Comment comment1 = commentService.createComment(comment);
            return ResultVOUtils.success(comment1);
        } catch (Exception e) {
            return ResultVOUtils.error(e.getMessage());
        }
    }


    @DeleteMapping("/deleteComment/{commentId}")
    public ResultVO deleteComment(@PathVariable(value = "commentId") String commentId) {
        try {
            commentService.deleteComment(commentId);
            return ResultVOUtils.success(null);
        } catch (Exception e) {
            return ResultVOUtils.error(e.getMessage());
        }
    }

    @PostMapping("/updateComment/{commentId}")
    public ResultVO updateComment(@PathVariable(value = "commentId") String commentId, @RequestBody Comment commentObj) {
        try {
            Comment comment = commentService.queryCommentById(commentId);
            if (comment == null) {
                return ResultVOUtils.error("该评论Id有误");
            }
            System.out.println(commentObj);
            commentObj.setId(comment.getId());
            Comment updateComment = commentService.updateComment(commentObj);
            return ResultVOUtils.success(updateComment);
        } catch (Exception e) {
            return ResultVOUtils.error(e.getMessage());
        }
    }

    @GetMapping("/queryComment/{articleId}}")
    public ResultVO queryComment(@PathVariable(value = "articleId") String articleId) {
        try {
            List<Comment> commentList = commentService.queryComment(articleId);
            return ResultVOUtils.success(commentList);
        } catch (Exception e) {
            return ResultVOUtils.error(e.getMessage());
        }
    }

    @GetMapping("/queryCommentAll")
    public ResultVO queryComment() {
        List<Comment> commentList = commentService.queryCommentAll();
        return ResultVOUtils.success(commentList);
    }
}
