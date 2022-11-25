package com.wedu.ipsp.domain;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

//用户信息实体类
@Data//替代手写 get,set,toString 方法
@AllArgsConstructor//替代有参构造
@NoArgsConstructor//替代无参构造
@ToString
public class User {
    private int userId;//用户标识id(主键)
    private String userAccount;//用户账号（不可重复）
    private String userPassword;//用户密码
    private String userNinkname;//用户昵称（不可重复）
    private char userGender;//用户性别
    private String userPhone;//用户手机号（不可重复）
    private String userEmail;//用户邮箱（不可重复）
    private int userType;//用户类型（0：平台管理员，1：业务经理）
    private Date operTime;//最近操作时间

}
