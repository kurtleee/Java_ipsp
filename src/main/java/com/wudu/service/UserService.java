package com.wudu.service;

import com.wudu.domain.ResultInfo;
import com.wudu.domain.User;

//用户管理服务层接口
public interface UserService {

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    ResultInfo addUser(User user);

    /**
     * 根据用户id查找用户
     *
     * @param u_id
     * @return
     */
    ResultInfo findUserById(int u_id);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    ResultInfo updateUser(User user);

    /**
     * 根据用户id删除用户
     *
     * @param u_id
     * @return
     */
    ResultInfo delUserById(int u_id);
}
