package com.zlm.community.model;

    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 问题表
    * </p>
*
* @author zhuluming
* @since 2019-06-25
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * id
            */
    private Integer id;

    /**
     * 发起人
     */
    private Integer creator;
    /**
     * 标题
     */
    private String title;

            /**
            * 描述
            */
    private String description;

            /**
            * 评论数
            */
    private Integer commentCount;

            /**
            * 浏览数
            */
    private Integer viewCount;

            /**
            * 关注数
            */
    private Integer likeCount;

            /**
            * 标签
            */
    private String tag;

            /**
            * 创建时间
            */
    private Long createTi;

            /**
            * 修改时间
            */
    private Long modifyTi;

    private Integer version;


}
