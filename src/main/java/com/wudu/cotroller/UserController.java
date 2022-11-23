package com.wudu.cotroller;

import com.wudu.domain.ResultInfo;
import com.wudu.domain.User;
import com.wudu.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//用户管理控制层
@RestController//@RestController注释用于定义RESTful Web服务,有了该注解，在响应返回的是json格式的数据，我们就不要写@ResponseBody注解了
@RequestMapping(value = "/user")
public class UserController {

    //注入用户服务层
    @Autowired
    private UserServiceImpl userService;

    /**
     * 增加用户
     *
     * @param user 传一个json对象封装user
     * @return
     */
    @PostMapping(value = "/addUser")
    public ResultInfo addUser(@RequestBody User user) {

        ResultInfo resultInfo = userService.addUser(user);

        return resultInfo;
    }

    /**
     * 根据用户id查找用户
     *
     * @param u_id
     * @return
     */
    @GetMapping(value = "/findUserById/{u_id}")
    public ResultInfo findUserById(@PathVariable("u_id") int u_id) {

        ResultInfo resultInfo = userService.findUserById(u_id);

        return resultInfo;
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @PutMapping(value = "/updateUser")
    public ResultInfo updateUser(@RequestBody User user) {

        ResultInfo resultInfo = userService.updateUser(user);

        return resultInfo;
    }

    /**
     * 根据用户id删除用户
     *
     * @param u_id
     * @return
     */
    @DeleteMapping(value = "/delUserById/{u_id}")
    public ResultInfo delUserById(@PathVariable("u_id") int u_id) {

        ResultInfo resultInfo = userService.delUserById(u_id);

        return resultInfo;
    }
}
