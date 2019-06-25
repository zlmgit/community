package com.zlm.community.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.io.Serializable;

@Data
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String accountId;
    private String token;
    private String name;
    private String avatarUrl;
    private Long createTi;
    private Long modifyTi;
}
