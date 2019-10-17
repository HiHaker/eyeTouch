package com.yonyou.post.controller;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.myuser.po.Myuser;
import com.yonyou.myuser.service.MyuserService;
import com.yonyou.post.service.PostService;
import com.yonyou.post.service.TokenService;
import com.yonyou.post.service.UserService;
import com.yonyou.relation.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/10/16 0016
 * BY Jianlong
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/user/user")
public class UserController extends BaseController{

    @Autowired
    UserService userService;
    @Autowired
    MyuserService myuserService;
    @Autowired
    PostService postService;
    @Autowired
    RelationService relationService;
    @Autowired
    TokenService tokenService;

    /**
     * 用户登录
     * @param myuser
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object userLogin(
            @RequestBody Myuser myuser
    ){
        JSONObject jsonObject = new JSONObject();
        Myuser user = myuserService.getUserByLoginName(myuser.getLogin_name());
        if (user == null){
            jsonObject.put("message","登陆失败，用户不存在!");
            return jsonObject;
        }
        if (!user.getPassword().equals(myuser.getPassword())){
            jsonObject.put("message","登陆失败，密码错误!");
            return jsonObject;
        } else{
            String token = tokenService.getToken(myuser);
            jsonObject.put("token",token);
            List<Object> userList = new ArrayList<>();
            userList.add(userService.switchDTO(user));
            jsonObject.put("userMessage",userService.encapsulateUser(userList));
            return jsonObject;
        }
    }

    /**
     * 根据id获取用户
     * @param user_ID
     * @return
     */
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserById(
            @RequestParam String user_ID
    ){
        Myuser myuser = myuserService.getAssoVo(user_ID).getEntity();
        List<Object> userList = new ArrayList<>();
        userList.add(userService.switchDTO(myuser));
        return  this.buildSuccess(userService.encapsulateUser(userList));
    }

    /**
     * 根据用户的id删除用户
     * @param user_ID
     */
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteUserById(
            @RequestParam String user_ID
    ){
        userService.deleteUserById(user_ID);
        return "success";
    }

    /**
     * 获取全部的关注用户
     */
    @RequestMapping(value = "/getAllFollows", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllFollows(
            @RequestParam String user_ID
    ){
        return this.buildSuccess(userService.encapsulateUser(userService.getAllFollows(user_ID)));
    }

    /**
     * 获取全部的粉丝用户
     */
    @RequestMapping(value = "/getAllFans", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllFans(
            @RequestParam String user_ID
    ){
        return this.buildSuccess(userService.encapsulateUser(userService.getAllFans(user_ID)));
    }

    /**
     * 获取当日新增用户数
     */
    @RequestMapping(value = "/getNewUsers", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllFans(){
        return userService.getNewUsers();
    }

    /**
     * 获取当日新增帖子数
     */
    @RequestMapping(value = "/getNewPosts", method = RequestMethod.GET)
    @ResponseBody
    public Object getNewPosts(){
        return userService.getNewPosts();
    }

    /**
     * 获取当日新增商品数
     */
    @RequestMapping(value = "/getNewCommoditys", method = RequestMethod.GET)
    @ResponseBody
    public Object getNewCommoditys(){
        return userService.getNewCommoditys();
    }
}