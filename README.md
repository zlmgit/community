# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)

###脚本
```sql
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `account_id` int(11) DEFAULT NULL COMMENT 'git账户Id',
  `name` varchar(20) DEFAULT NULL COMMENT 'git昵称',
  `token` varchar(50) DEFAULT NULL COMMENT '登录持久化令牌',
  `avatar_url` varchar(250) DEFAULT NULL COMMENT '图像',
  `create_ti` bigint(17) DEFAULT NULL COMMENT '创建时间',
  `modify_ti` bigint(17) DEFAULT NULL COMMENT '修改时间',
  `version` int(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
```
```sql
CREATE TABLE `question` (
  `id` int(11) NOT NULL COMMENT 'id',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `comment_count` int(11) DEFAULT '0' COMMENT '评论数',
  `view_count` int(11) DEFAULT '0' COMMENT '浏览数',
  `like_count` int(11) DEFAULT '0' COMMENT '关注数',
  `tag` varchar(250) DEFAULT NULL COMMENT '标签',
  `create_ti` bigint(17) DEFAULT NULL COMMENT '创建时间',
  `modify_ti` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `version` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='问题表';
```

