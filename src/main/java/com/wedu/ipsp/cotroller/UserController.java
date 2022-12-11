package com.wedu.ipsp.cotroller;

import com.wedu.ipsp.domain.ResultInfo;
import com.wedu.ipsp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//用户基本操作 控制层
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 用户手机登录
     * @param userPhone
     * @param userPassword
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/login")
    public ResultInfo loginByPhone(@RequestParam(value = "userPhone") String userPhone,
                                   @RequestParam(value = "userPassword") String userPassword,
                                   HttpServletRequest request, HttpServletResponse response,HttpSession session) {

        ResultInfo resultInfo = userService.loginByPhone(userPhone,userPassword,request,response,session);

        return resultInfo;
    }

    /**
     * 用户退出登录
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/logout")
    public ResultInfo logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

        ResultInfo resultInfo = userService.logout(session,request,response);

        return resultInfo;
    }

    /**
     * 用户修改密码
     * @param userId
     * @param userPassword
     * @return
     */
    @PutMapping(value = "/updatePassword")
    public ResultInfo updatePassword(@PathVariable("userId") int userId,
                                     @PathVariable("userPassword") String userPassword) {

        ResultInfo resultInfo = userService.updatePassword(userId,userPassword);

        return resultInfo;
    }
}
