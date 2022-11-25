package com.wedu.ipsp.service.impl;

import com.wedu.ipsp.domain.ResultInfo;
import com.wedu.ipsp.domain.User;
import com.wedu.ipsp.mapper.UserMapper;
import com.wedu.ipsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//用户基本操作 服务实现层
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户手机登录
     * @param userPhone
     * @param userPassword
     * @param request
     * @param response
     * @return
     */
    @Override
    public ResultInfo loginByPhone(String userPhone, String userPassword, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        try {
            //调用mapper查询
            User user = userMapper.loginByPhone(userPhone, userPassword);
            //判断user是否为空
            if (user == null) {
                //手机号或密码错误
                info.setFlag(false);
                info.setErrorMsg("手机号或密码错误");
            } else {
                //登陆成功
                info.setFlag(true);
                info.setData(user);

                //将登录用户存到本地cookie
                session.setAttribute("user",user);
                Cookie cookie_username = new Cookie("cookie_username", user.getUserNinkname());
                // 设置cookie的持久化时间，30天
                cookie_username.setMaxAge(30 * 24 * 60 * 60);
                // 设置为当前项目下都携带这个cookie
                cookie_username.setPath(request.getContextPath());
                // 向客户端发送cookie
                response.addCookie(cookie_username);
            }
        } catch (Exception e) {
            e.printStackTrace();
            info.setFlag(false);
            info.setErrorMsg("查询失败");
        }
        return info;
    }

    /**
     * 用户退出登录
     *注销登录时，我们需要删除 session 里面的用户信息，删除 cookie 里面的用户信息
     * @param session
     * @param request
     * @param response
     * @return
     */
    @Override
    public ResultInfo logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        ResultInfo info = new ResultInfo();
        info.setFlag(true);

        // 删除session里面的用户信息
        session.removeAttribute("user");
        // 修改cookie为空
        Cookie cookie_username = new Cookie("cookie_username", "");
        // 设置cookie的持久化时间，0
        cookie_username.setMaxAge(0);
        // 设置为当前项目下都携带这个cookie
        cookie_username.setPath(request.getContextPath());
        // 向客户端发送cookie
        response.addCookie(cookie_username);
        info.setFlag(true);

        return info;
    }

    /**
     * 用户修改密码
     * 修改当前登录帐号的密码，修改密码时需确认密码
     * @param userId
     * @param userPassword
     * @return
     */
    @Override
    public ResultInfo updatePassword(int userId, String userPassword) {
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        try{
            int updatePassword = userMapper.updatePassword(userId,userPassword);
            if (updatePassword == 0) {
                info.setFlag(false);
                info.setErrorMsg("修改失败");
            }
        }catch (Exception e) {
            e.printStackTrace();
            info.setFlag(false);
            info.setErrorMsg("修改失败");
        }
        return info;
    }
}
