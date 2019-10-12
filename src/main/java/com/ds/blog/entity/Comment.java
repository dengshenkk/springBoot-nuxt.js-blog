package com.ds.blog.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class Comment {
    @Id
    private String id;
    private String userName;
    private String userEmail;
    private String articleId;
    private String content;
    private Integer isCheck = 0;
    private Integer isDelete = 0;
    private Integer isAwesome = 0;
    private Date createTime;
    private Date updateTime;
}
