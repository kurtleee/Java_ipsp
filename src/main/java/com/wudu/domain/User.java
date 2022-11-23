package com.wudu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//用户信息实体类
@Data//替代手写 get,set,toString 方法
@AllArgsConstructor//替代有参构造
@NoArgsConstructor//替代无参构造
public class User {
    private int u_id;
    private int u_sex;
    private String u_name;
    private String u_password;
}
