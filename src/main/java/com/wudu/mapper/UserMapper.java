package com.wudu.mapper;

import com.wudu.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

//用户管理数据访问层
@Mapper
@Repository
public interface UserMapper {

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @Insert("insert into t_user(u_name,u_sex,u_password) values(#{u_name},#{u_sex},#{u_password})")
    int addUser(User user);

    /**
     * 根据用户id查找用户
     *
     * @param u_id
     * @return
     */
    @Select("select * from t_user where u_id = #{u_id}")
    User findUserById(int u_id);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @Update("update t_user set u_name=#{u_name} where u_id=#{u_id}")
    int updateUser(User user);

    /**
     * 根据用户id删除用户
     *
     * @param u_id
     * @return
     */
    @Delete("delete from t_user where u_id=#{u_id}")
    int delUserById(int u_id);

}
