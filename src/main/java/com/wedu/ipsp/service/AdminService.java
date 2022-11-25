package com.wedu.ipsp.service;


import com.wedu.ipsp.domain.ResultInfo;
import com.wedu.ipsp.domain.User;

//用户管理 服务层接口
public interface AdminService {

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
     * @return
     */
    ResultInfo findUserById(int userId);

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
     * @return
     */
    ResultInfo delUserById(int userId);

    /**
     * 查询所有用户信息
     * @return
     */
    ResultInfo findAllUser(int pageNum,int pageSize);
}
