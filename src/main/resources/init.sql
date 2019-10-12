DROP TABLE IF EXISTS article;
CREATE TABLE IF NOT EXISTS article
(
  id          varchar(64)  NOT NULL COMMENT '',
  title       varchar(50)  NOT NULL COMMENT '标题',
  subtitle    varchar(200) NOT NULL COMMENT '子标题',
  content     longtext     NOT NULL COMMENT '内容',
  category    varchar(64)  NOT NULL COMMENT '分类',
  is_top      tinyint      NOT NULL DEFAULT 0 COMMENT '是否置顶',
  is_delete   tinyint      NOT NULL DEFAULT 0 COMMENT '是否删除',
  create_time timestamp    NOT NULL DEFAULT current_timestamp COMMENT '',
  update_time timestamp    NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '',
  PRIMARY KEY (id)
  )
  COMMENT '文章';


DROP TABLE IF EXISTS category;
CREATE TABLE IF NOT EXISTS category
(
  id            varchar(64) NOT NULL COMMENT '主键',
  category_name varchar(32) NOT NULL COMMENT '分类名称',
  category_type int(32)     NOT NULL COMMENT '分类类型',
  create_time   timestamp   NOT NULL DEFAULT current_timestamp COMMENT '',
  update_time   timestamp   NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '',
  PRIMARY KEY (id)
  ) COMMENT '分类';



DROP TABLE IF EXISTS comment;
CREATE TABLE comment
(
  id          varchar(64)                                                     NOT NULL COMMENT '主键',
  user_name   varchar(32)                                                     NOT NULL COMMENT '昵称',
  user_email  varchar(32)                                                     NOT NULL COMMENT '邮箱',
  article_id  varchar(64)                                                     NOT NULL COMMENT '文章id',
  content     longtext                                                        NOT NULL COMMENT '评论内容',
  create_time timestamp DEFAULT current_timestamp                             NOT NULL COMMENT '',
  update_time timestamp DEFAULT current_timestamp ON UPDATE current_timestamp NOT NULL COMMENT '',
  is_check    tinyint   DEFAULT 0                                             NOT NULL,
  is_delete   tinyint   DEFAULT 0                                             NOT NULL,
  is_awesome  tinyint   DEFAULT 0                                             NOT NULL,
  PRIMARY KEY (id)
  )
  COMMENT '评论'

