package com.zlm.community.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String accountId;
    private String token;
    private String name;
    private Long creat;
    private Long modify;
}
