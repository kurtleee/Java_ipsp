package com.wudu.service.impl;

import com.wudu.domain.ResultInfo;
import com.wudu.domain.User;
import com.wudu.mapper.UserMapper;
import com.wudu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//用户管理服务层
@Service
public class UserServiceImpl implements UserService {

    //注入数据访问层
    @Autowired
    private UserMapper userMapper;

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @Override
    public ResultInfo addUser(User user) {
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        try {
            int addUser = userMapper.addUser(user);
            if (addUser == 0) {
                info.setFlag(false);
                info.setErrorMsg("添加失败");
            } else {
                info.setErrorMsg("添加成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            info.setFlag(false);
            info.setErrorMsg("添加失败");
        }

        return info;
    }

    /**
     * 根据用户id查找用户
     *
     * @param u_id
     * @return
     */
    @Override
    public ResultInfo findUserById(int u_id) {
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        try {
            User user = userMapper.findUserById(u_id);
            if (user != null) {
                info.setData(user);
                info.setErrorMsg("查询成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            info.setFlag(false);
            info.setErrorMsg("查询失败！");
        }
        return info;
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @Override
    public ResultInfo updateUser(User user) {
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        try {
            int updateUser = userMapper.updateUser(user);
            if (updateUser == 0) {
                info.setFlag(false);
                info.setErrorMsg("修改失败");
            } else {
                info.setErrorMsg("修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            info.setFlag(false);
            info.setErrorMsg("修改失败！");
        }
        return info;
    }

    /**
     * 根据用户id删除用户
     *
     * @param u_id
     * @return
     */
    @Override
    public ResultInfo delUserById(int u_id) {
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        try {
            int delete= userMapper.delUserById(u_id);
            if (delete == 0) {
                info.setFlag(false);
                info.setErrorMsg("删除失败");
            } else {
                info.setErrorMsg("删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            info.setFlag(false);
            info.setErrorMsg("删除失败！");
        }
        return info;
    }


}
