package com.ds.blog.service.impl;

import com.ds.blog.entity.Comment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceImplTest {


    @Autowired
    private CommentServiceImpl commentService;

    @Test
    public void createComment() {
        Comment comment = new Comment();
        comment.setUserName("zs");
        comment.setUserEmail("zs@163.com");
        comment.setContent("很棒的文章");
        comment.setArticleId("12345");
        comment.setId("123");
        Comment reuslt = commentService.createComment(comment);
        Assert.assertNotNull(reuslt);

    }

    @Test
    public void deleteComment() {
        Comment comment = commentService.deleteComment("123");
        Assert.assertEquals((Integer) 1, comment.getIsDelete());
    }

    @Test
    public void updateComment() {
        Comment comment = new Comment();
        comment.setUserName("zs");
        comment.setUserEmail("zs@163.com");
        comment.setContent("很棒的文章new");
        comment.setArticleId("12345");
        comment.setId("123");
        Comment updateComment = commentService.updateComment(comment);
        Assert.assertNotNull(updateComment);

    }

    @Test
    public void queryComment() {
        List<Comment> commentList = commentService.queryComment("12345");
        Assert.assertEquals(commentList.size() > 0, commentList.size() > 0);
    }
}
