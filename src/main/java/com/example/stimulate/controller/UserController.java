package com.example.stimulate.controller;

import com.example.stimulate.entity.Role;
import com.example.stimulate.entity.User;
import com.example.stimulate.service.UserService;
import com.example.stimulate.utils.R;
import com.example.stimulate.utils.Tool;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


/**
 * 用户相关
 * 注册、角色、修改密码、登录验证
 */
@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     */
    @PostMapping(value = "/sign",consumes = "application/json")
    @ResponseBody
    //@RequestMapping("/sign")
    public R save(@RequestBody User user){
        //判断用户是否存在
        if(userService.existUser(user.getUserName())>0){
            return R.error("用户名已经存在");
        }
        user.setPassword(Tool.MD5(user.getPassword()));
        Date date = new Date();
//        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
//        System.out.println(dateFormat.format(date));
        user.setCity("上海");
        user.setSchool("上海商学院");
        user.setCreateTime(date);
        if(userService.save(user)>0){
            return R.ok();
        }
        return R.error();
    }

    /**
     * 角色查询
     */
    @ResponseBody
    @RequestMapping("/getRoleList")
    public List<Role> getRoleList(){
        return userService.getRoleList();
    }


    /**
     * 修改用户信息
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(@RequestBody User user){
        if(userService.existUser(user.getUserName())>0){
            return R.error("用户名已经存在");
        }
        user.setPassword(Tool.MD5(user.getPassword()));
        Date date = new Date();
//        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
//        System.out.println(dateFormat.format(date));
        user.setUpdateTime(date);
        if(userService.update(user)>0){
            return R.ok();
        }
        return R.ok();
    }

    /**
     * 获取用户信息
     */
    @ResponseBody
    @RequestMapping("/getUserById")
    public User getUserById(Integer userId){
        return userService.getUserById(userId);
    }

    /**
     * 登录验证++++++++++++
     */
    @ResponseBody
    @RequestMapping("/login")
    public R checkUser(String userName,String password,Integer roleId){
        if(StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(password)
                && roleId != null){
            password = Tool.MD5(password);
            //判断用户是否存在
            if(userService.existUser(userName)<1){
                return R.error("用户不存在");
            }
            //判断角色是否正确
            if(userService.checkRole(userName,roleId)<1){
                return R.error("用户角色不正确");
            }
            if(userService.checkUser(userName,roleId,password)<1){
                return R.error("用户密码不正确");
            }
        }else {
            return R.error("用户信息不完整");
        }
        int userId = userService.getUserId(userName);
        User user = userService.getUserById(userId);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
//        String userId = (String) request.getSession().getAttribute("user_id");
        request.getSession().setAttribute("user_id",userId);
        request.getSession().setAttribute("username",userName);
        request.getSession().setAttribute("role_id",roleId);
        request.getSession().setMaxInactiveInterval(60*60);
        return R.resultData(user);
    }

    /**
     * 修改用户密码
     */
    @ResponseBody
    @RequestMapping("/updatePassword")
    public R updatePassword(Integer userId,String password){
        if(StringUtils.isNotEmpty(password) && userId != null){
            password = Tool.MD5(password);
            if(userService.updatePassword(userId, password) < 1){
                return R.error("修改失败");
            }
        }else {
            return R.error("修改信息不完整");
        }
        return R.ok();
    }

}
