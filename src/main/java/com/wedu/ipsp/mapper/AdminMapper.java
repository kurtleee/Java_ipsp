package com.wedu.ipsp.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wedu.ipsp.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.prefs.BackingStoreException;

//用户管理 数据访问层
@Mapper
public interface AdminMapper extends BaseMapper<User> {

    /**
     * 新增用户
     *
     * @param
     * @return
     */
    @Insert("insert into t_user(user_account,user_ninkname,user_gender,user_phone,user_email,oper_time) values(#{userAccount},#{userNinkname},#{userGender},#{userPhone},#{userEmail},#{operTime})")
    int addUser(User user);

    /**
     * 根据用户id查找用户
     *
     * @param u_id
     * @return
     */
    @Select("select * from t_user where user_id = #{userId}")
    User findUserById(int u_id);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @Update("update t_user set user_account=#{userAccount},user_ninkname=#{userNinkname},user_gender=#{userGender},user_phone=#{userPhone},user_email=#{userEmail}")
    int updateUser(User user);

    /**
     * 根据用户id删除用户
     *
     * @param u_id
     * @return
     */
    @Delete("delete from t_user where user_id=#{userId}")
    int delUserById(int u_id);

    /**
     * 查询所有用户信息
     * @return
     */
    @Select("select * from t_user")
    List<User> findAllUser();
}
