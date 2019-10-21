package com.yonyou.post.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yonyou.commodity.service.CommodityService;
import com.yonyou.myuser.po.Myuser;
import com.yonyou.myuser.service.MyuserService;
import com.yonyou.pimage.po.Pimage;
import com.yonyou.post.dto.PostDTO;
import com.yonyou.post.po.Post;
import com.yonyou.post.service.CommunityService;
import com.yonyou.post.service.PostService;
import com.yonyou.post.service.TokenService;
import com.yonyou.pvideo.po.Pvideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/10/3 0003
 * BY Jianlong
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/community/community")
public class CommunityController extends BaseController{
    @Autowired
    CommunityService communityService;
    @Autowired
    MyuserService myuserService;
    @Autowired
    PostService postService;
    @Autowired
    TokenService tokenService;
    @Autowired
    CommodityService commodityService;

    /**
     * 发表帖子（图文）
     * @param jsonObjectAll
     */
    @RequestMapping(value = "/publishPostImg", method = RequestMethod.POST)
    @ResponseBody
    public Object publishPostImg(
            @RequestBody JSONObject jsonObjectAll
    ){
        // 获得帖子
        Post post = new Post();
        JSONObject jsonObjectPost = jsonObjectAll.getJSONObject("post");
        post.setId(jsonObjectPost.getString("id"));
        post.setUid(jsonObjectPost.getString("uid"));
        post.setTitle(jsonObjectPost.getString("title"));
        post.setContent(jsonObjectPost.getString("content"));
        post.setType(jsonObjectPost.getString("type"));
        post.setStyle(jsonObjectPost.getString("style"));
        post.setFpid(jsonObjectPost.getString("fpid"));
        post.setTime(jsonObjectPost.getString("time"));

        // 获得帖子图片
        List<Pimage> pimageList = new ArrayList<>();
        JSONArray imgJsons = jsonObjectAll.getJSONArray("images");

        for (int i=0; i<imgJsons.size(); i++){
            Pimage p = new Pimage();
            p.setId(imgJsons.getJSONObject(i).getString("id"));
            p.setPid(imgJsons.getJSONObject(i).getString("pid"));
            pimageList.add(p);
        }

        communityService.publishPostImg(post, pimageList);

        return this.buildSuccess(jsonObjectAll);
    }

    /**
     * 发表帖子（视频）
     * @param jsonObjectAll
     */
    @RequestMapping(value = "/publishPostVideo", method = RequestMethod.POST)
    @ResponseBody
    public Object publishPostVideo(
            @RequestBody JSONObject jsonObjectAll
    ){
        // 获得帖子
        Post post = new Post();
        JSONObject jsonObjectPost = jsonObjectAll.getJSONObject("post");
        post.setId(jsonObjectPost.getString("id"));
        post.setUid(jsonObjectPost.getString("uid"));
        post.setTitle(jsonObjectPost.getString("title"));
        post.setContent(jsonObjectPost.getString("content"));
        post.setType(jsonObjectPost.getString("type"));
        post.setStyle(jsonObjectPost.getString("style"));
        post.setFpid(jsonObjectPost.getString("fpid"));
        post.setTime(jsonObjectPost.getString("time"));

        // 获得帖子
        Pvideo pvideo = new Pvideo();
        JSONObject jsonObjectVideo = jsonObjectAll.getJSONObject("video");
        pvideo.setId(jsonObjectVideo.getString("id"));
        pvideo.setPid(jsonObjectVideo.getString("pid"));
        communityService.publishPostVideo(post, pvideo);
        return this.buildSuccess(jsonObjectAll);
    }

    /**
     * 根据帖子的id删除帖子
     * @param post_ID
     */
    @RequestMapping(value = "/deletePostById", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deletePostById(
            @RequestParam String post_ID
    ){
        communityService.deletePostById(post_ID);
        return "success";
    }

    /**
     * 根据帖子id获得帖子对象
     * @param post_ID
     * @return
     */
    @RequestMapping(value = "/getPostById", method = RequestMethod.GET)
    @ResponseBody
    public Object getPostById(
            @RequestParam String post_ID
    ){
        // 转换为DTO
        Post post = postService.getAssoVo(post_ID).getEntity();
        // 封装成帖子列表
        List<Object> postList = new ArrayList<>();
        postList.add(postService.switchDTO(post));
        return this.buildSuccess(communityService.encapsulatePost(postList));
    }

    /**
     * 根据帖子id获得帖子对象(登录)
     * @param post_ID
     * @return
     */
    @RequestMapping(value = "/getPostByIdLogin", method = RequestMethod.GET)
    @ResponseBody
    public Object getPostByIdLogin(
            @RequestParam String post_ID, String user_ID
    ){
        // 转换为DTO
        Post post = postService.getAssoVo(post_ID).getEntity();
        // 封装成帖子列表
        List<Object> postList = new ArrayList<>();
        postList.add(postService.switchDTO(post));
        return this.buildSuccess(communityService.encapsulatePostLogin(postList,user_ID));
    }

    /**
     * 消息获取
     * @return
     */
    @RequestMapping(value = "/getCommunityMessage", method = RequestMethod.GET)
    @ResponseBody
    public Object getCommunityMessage(
            @RequestParam String user_ID
    ){
        return this.buildSuccess(communityService.getCommunityMessage(user_ID));
    }

    /**
     * 获取全部的帖子列表
     * @return
     */
    @RequestMapping(value = "/getAllPosts", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllPosts(){
        return this.buildSuccess(communityService.encapsulatePost(postService.getAllPost()));
    }

    /**
     * 获取全部的帖子列表(登录)
     * @param user_ID
     * @return
     */
    @RequestMapping(value = "/getAllPostsLogin", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllPostsLogin(
            @RequestParam String user_ID
    ){
        return this.buildSuccess(communityService.encapsulatePostLogin(postService.getAllPost(),user_ID));
    }


    /**
     * 获取用户发表的全部的帖子列表
     * @param user_ID
     * @return
     */
    @RequestMapping(value = "/getUsersAllPosts", method = RequestMethod.GET)
    @ResponseBody
    public Object getUsersAllPosts(
            @RequestParam String user_ID
    ){
        return this.buildSuccess(communityService.encapsulatePostLogin(postService.getPostByUserId(user_ID), user_ID));
    }

    /**
     * 得到用户收藏的全部帖子
     * @param user_ID
     * @return
     */
    @RequestMapping(value = "/getAllPostsFavorite", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllPostsFavorite(
            @RequestParam String user_ID
    ){
        return this.buildSuccess(communityService.encapsulatePostLogin(communityService.getAllPostsFavorite(user_ID), user_ID));
    }

    /**
     * 获取关注的人发表的帖子
     * @param user_ID
     * @return
     */
    @RequestMapping(value = "/getFollowsPosts", method = RequestMethod.GET)
    @ResponseBody
    public Object getFollowsPosts(
            @RequestParam String user_ID
    ){
        return this.buildSuccess(communityService.getFollowsPosts(user_ID));
    }

    /**
     * 模糊查询帖子
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/getAllPostsLikeSearch", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllPostsLikeSearch(
            @RequestParam String keyword
    ){
        return this.buildSuccess(communityService.encapsulatePost(communityService.getAllPostsLikeSearch(keyword)));
    }

    /**
     * 模糊查询帖子(登录)
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/getAllPostsLikeSearchLogin", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllPostsLikeSearch(
            @RequestParam String keyword, String user_ID
    ){
        return this.buildSuccess(communityService.encapsulatePostLogin(communityService.getAllPostsLikeSearch(keyword),user_ID));
    }

    /**
     * 根据类型（type）获取全部的帖子列表
     * @param type
     * @return
     */
    @RequestMapping(value = "/getAllPostsByType", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllPostsByType(
            @RequestParam String type
    ){
        return this.buildSuccess(communityService.encapsulatePost(postService.getPostByType(type)));
    }

    /**
     * 根据类型（type）获取全部的帖子列表(登录)
     * @param user_ID
     * @param type
     * @return
     */
    @RequestMapping(value = "/getAllPostsByTypeLogin", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllPostsByTypeLogin(
            @RequestParam String user_ID, String type
    ){
        return this.buildSuccess(communityService.encapsulatePostLogin(postService.getPostByType(type),user_ID));
    }

    /**
     * 根据风格（style）获取全部的帖子列表
     * @param style
     * @return
     */
    @RequestMapping(value = "/getAllPostsByStyle", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllPostsByStyle(
            @RequestParam String style
    ){
        return this.buildSuccess(communityService.encapsulatePost(postService.getPostByStyle(style)));
    }

    /**
     * 根据风格（style）获取全部的帖子列表(登录)
     * @param user_ID
     * @param style
     * @return
     */
    @RequestMapping(value = "/getAllPostsByStyleLogin", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllPostsByStyleLogin(
            @RequestParam String user_ID, String style
    ){
        return this.buildSuccess(communityService.encapsulatePostLogin(postService.getPostByStyle(style),user_ID));
    }

    /**
     * 根据类型和风格获取全部的帖子列表
     * @param type
     * @param style
     * @return
     */
    @RequestMapping(value = "/getAllPostsByTypeAndStyle", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllPostsByTypeAndStyle(
            @RequestParam String type, String style
    ){
        return this.buildSuccess(communityService.encapsulatePost(postService.getPostByTypeAndStyle(type, style)));
    }

    /**
     * 根据类型和风格获取全部的帖子列表(登录)
     * @param user_ID
     * @param style
     * @return
     */
    @RequestMapping(value = "/getAllPostsByTypeAndStyleLogin", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllPostsByTypeAndStyleLogin(
            @RequestParam String user_ID, String type, String style
    ){
        return this.buildSuccess(communityService.encapsulatePostLogin(postService.getPostByTypeAndStyle(type, style),user_ID));
    }

    /**
     * 得到帖子的评论
     * @param post_ID
     * @return
     */
    @RequestMapping(value = "/getPostsComments", method = RequestMethod.GET)
    @ResponseBody
    public Object getPostsComments(
            @RequestParam String post_ID
    ){
        return this.buildSuccess(communityService.eGetComments(post_ID));
    }



}