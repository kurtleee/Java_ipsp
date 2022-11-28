package com.wedu.ipsp.cotroller;

import com.wedu.ipsp.domain.ResultInfo;
import com.wedu.ipsp.domain.User;
import com.wedu.ipsp.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//用户管理 控制层
@RestController//@RestController注释用于定义RESTful Web服务,有了该注解，在响应返回的是json格式的数据，我们就不要写@ResponseBody注解了
@RequestMapping(value = "/admin")
public class AdminController {

    //注入用户服务层
    @Autowired
    private AdminServiceImpl adminService;

    /**
     * 增加用户
     *
     * @param user 传一个json对象封装user
     * @return
     */
    @PostMapping(value = "/addUser")
    public ResultInfo addUser(@RequestBody User user) {

        ResultInfo resultInfo = adminService.addUser(user);

        return resultInfo;
    }

    /**
     * 根据用户id查找用户
     *
     * @return
     */
    @GetMapping(value = "/findUserById/{userId}")
    public ResultInfo findUserById(@PathVariable("userId") int userId) {

        ResultInfo resultInfo = adminService.findUserById(userId);

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

        ResultInfo resultInfo = adminService.updateUser(user);

        return resultInfo;
    }

    /**
     * 根据用户id删除用户
     *
     * @return
     */
    @DeleteMapping(value = "/delUserById/{userId}")
    public ResultInfo delUserById(@PathVariable("userId") int userId) {

        ResultInfo resultInfo = adminService.delUserById(userId);

        return resultInfo;
    }

    /*
    * 根据用户ID批量删除用户
    *
    * @return
    * */
    @DeleteMapping(value  = "/delUserByIdBatch/{userID}")
    public resultInfo

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @GetMapping(value = "/findAllUser")
    public ResultInfo findAllUser(@RequestParam(value = "pageNum",required = false,defaultValue = "1")int pageNum,
                                  @RequestParam(value = "pageSize",required = false,defaultValue = "5")int pageSize) {

        ResultInfo resultInfo = adminService.findAllUser(pageNum,pageSize);

        return resultInfo;
    }
}
