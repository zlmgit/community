package com.zlm.community.dto;

import com.zlm.community.model.User;

import java.io.Serializable;

/**
 * @Auther: zhuluming
 * @Email: Luming.Zhu@paat.com
 * @Date: 2019/6/26 16:16
 * @Description:
 */
public class QuestionDTO implements Serializable {
    private Integer           id;

    /**
     * 发起人
     */
    private Integer           creator;
    /**
     * 标题
     */
    private String            title;

    /**
     * 描述
     */
    private String            description;

    /**
     * 评论数
     */
    private Integer           commentCount;

    /**
     * 浏览数
     */
    private Integer           viewCount;

    /**
     * 关注数
     */
    private Integer           likeCount;

    /**
     * 标签
     */
    private String            tag;

    /**
     * 创建时间
     */
    private Long              createTi;

    /**
     * 修改时间
     */
    private Long              modifyTi;

    private Integer           version;

    private User user;
}
