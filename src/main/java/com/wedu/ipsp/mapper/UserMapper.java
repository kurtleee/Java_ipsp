package com.wedu.ipsp.mapper;

import com.wedu.ipsp.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

//用户基本操作 数据访问层
@Mapper
@Repository
public interface UserMapper {

    /**
     * 根据手机号和密码查询用户
     * @param userPhone
     * @param userPassword
     * @return
     */
    @Select("select * from t_user where user_phone=#{userPhone} and user_password=#{userPassword}")
    User loginByPhone(String userPhone, String userPassword);

    /**
     * 用户修改密码
     * @param userId
     * @param userPassword
     * @return
     */
    @Update("update t_user set user_password=#{userPassword} where user_id=#{userId}")
    int updatePassword(int userId, String userPassword);

}
