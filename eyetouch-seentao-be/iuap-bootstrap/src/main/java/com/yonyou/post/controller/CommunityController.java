package com.yonyou.post.controller;

import com.yonyou.post.service.CommunityService;
import com.yonyou.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 2019/10/3 0003
 * BY Jianlong
 */
@RestController
@RequestMapping(value = "/community/community")
public class CommunityController extends BaseController{
    CommunityService communityService;

    @Autowired
    PostService postService;

    /**
     * 获取全部的帖子列表
     * @param user_ID
     * @return
     */
    @RequestMapping(value = "/getAllPosts", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllPosts(
            @RequestParam(required = false) String user_ID
    ){
        return this.buildSuccess(communityService.encapsulatePost(postService.getAllPost(),user_ID));
    }

    /**
     * 获取关注的人发表的帖子
     * @param user_ID
     * @return
     */
    @RequestMapping(value = "/getFollowsPosts", method = RequestMethod.GET)
    @ResponseBody
    public Object getFollowsPosts(
            @RequestParam(required = false) String user_ID
    ){
        return this.buildSuccess(communityService.getFollowsPosts(user_ID));
    }

    /**
     * 根据类型（type）获取全部的帖子列表
     * @param user_ID
     * @param type
     * @return
     */
    @RequestMapping(value = "/getAllPostsByType", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllPostsByType(
            @RequestParam(required = false) String user_ID, String type
    ){
        return this.buildSuccess(communityService.encapsulatePost(postService.getPostByType(type),user_ID));
    }

    /**
     * 根据风格（style）获取全部的帖子列表
     * @param user_ID
     * @param style
     * @return
     */
    @RequestMapping(value = "/getAllPostsByStyle", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllPostsByStyle(
            @RequestParam(required = false) String user_ID, String style
    ){
        return this.buildSuccess(communityService.encapsulatePost(postService.getPostByStyle(style),user_ID));
    }

    /**
     * 得到帖子的评论
     * @param post_ID
     * @return
     */
    @RequestMapping(value = "/getPostsComments", method = RequestMethod.GET)
    @ResponseBody
    public Object getPostsComments(
            @RequestParam(required = false) String post_ID
    ){
        return this.buildSuccess(communityService.eGetComments(post_ID));
    }
}
