package com.wedu.ipsp.service;

import com.wedu.ipsp.domain.ResultInfo;
import com.wedu.ipsp.domain.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//用户基本操作 服务层接口
public interface UserService {

    /**
     * 用户手机登录
     * @param userPhone
     * @param userPassword
     * @param request
     * @param response
     * @return
     */
    ResultInfo loginByPhone(String userPhone, String userPassword, HttpServletRequest request, HttpServletResponse response, HttpSession session);

    /**
     * 用户退出登录
     * @param session
     * @param request
     * @param response
     * @return
     */
    ResultInfo logout(HttpSession session, HttpServletRequest request, HttpServletResponse response);

    /**
     * 用户修改密码
     * @param userId
     * @param userPassword
     * @return
     */
    ResultInfo updatePassword(int userId, String userPassword);
}
