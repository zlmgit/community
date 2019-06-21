package com.zlm.community.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private Integer id;
    private String accountId;
    private String token;
    private String name;
    private Long creat;
    private Long modify;
}
