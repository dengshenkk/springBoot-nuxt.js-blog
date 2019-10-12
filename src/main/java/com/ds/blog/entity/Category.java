package com.ds.blog.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class Category {
    @Id
    private String id;
    private String categoryName;
    private String categoryType;
    private Integer isDelete;
    private Date createTime;
    private Date updateTime;
}
