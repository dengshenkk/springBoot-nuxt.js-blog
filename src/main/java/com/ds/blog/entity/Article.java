package com.ds.blog.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class Article {
    @Id
    private String id;
    private String title;
    private String subtitle;
    private String content;
    private String categoryType;
    private Integer isTop = 0;
    private Integer isDelete = 0;
    // TODO 返回类型需要去配置文件里配置Jackson
    private Date createTime;
    private Date updateTime;
}
