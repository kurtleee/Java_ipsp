package com.wedu.ipsp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wedu.ipsp.domain.ResultInfo;
import com.wedu.ipsp.domain.User;
import com.wedu.ipsp.mapper.AdminMapper;
import com.wedu.ipsp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

//用户管理 服务层
@Service
public class AdminServiceImpl implements AdminService {

    //注入数据访问层
    @Autowired
    private AdminMapper adminMapper;

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
            Date date = new Date();
            user.setOperTime(date);
            int addUser = adminMapper.addUser(user);
            if (addUser == 0) {
                info.setFlag(false);
                info.setErrorMsg("添加失败");
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
     * @return
     */
    @Override
    public ResultInfo findUserById(int userId) {
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        try {
            User user = adminMapper.findUserById(userId);
            if (user != null) {
                info.setData(user);
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
            int updateUser = adminMapper.updateUser(user);
            if (updateUser == 0) {
                info.setFlag(false);
                info.setErrorMsg("修改失败");
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
     * @return
     */
    @Override
    public ResultInfo delUserById(int userId) {
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        try {
            int delete= adminMapper.delUserById(userId);
            if (delete == 0) {
                info.setFlag(false);
                info.setErrorMsg("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            info.setFlag(false);
            info.setErrorMsg("删除失败！");
        }
        return info;
    }

    /**
     * 查询所有用户信息
     * @return
     */
    @Override
    public ResultInfo findAllUser(int pageNum,int pageSize) {
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        //当前页 pagenum  当前页显示条数 pageSize
        PageHelper.startPage(pageNum, pageSize);
        try {
            List<User> userList = adminMapper.findAllUser();
            PageInfo<User> pageInfo = new PageInfo<User>(userList);
            info.setData(pageInfo);
        } catch (Exception e) {
            info.setFlag(false);
            info.setErrorMsg("查询失败");
            e.printStackTrace();
        }
        return info;
    }


}
