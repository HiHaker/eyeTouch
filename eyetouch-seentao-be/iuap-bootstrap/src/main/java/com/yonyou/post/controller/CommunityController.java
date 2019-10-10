package com.yonyou.post.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yonyou.commodity.service.CommodityService;
import com.yonyou.pimage.po.Pimage;
import com.yonyou.post.po.Post;
import com.yonyou.post.service.CommunityService;
import com.yonyou.post.service.PostService;
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
    PostService postService;
    @Autowired
    CommodityService commodityService;

    /**
     * 测试
     * @param jsonObjectAll
     * @return
     */
    @RequestMapping(value = "/publishTest", method = RequestMethod.POST)
    @ResponseBody
    public Object Test(
            @RequestBody JSONObject jsonObjectAll
    ){
       return "test";
    }

    /**
     * 发表帖子（图文）
     * @param jsonObjectAll
     */
    @RequestMapping(value = "/publishPostImg", method = RequestMethod.POST)
    @ResponseBody
    public void publishPostImg(
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
    }

    /**
     * 发表帖子（视频）
     * @param jsonObjectAll
     */
    @RequestMapping(value = "/publishPostVideo", method = RequestMethod.POST)
    @ResponseBody
    public void publishPostVideo(
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
    }

    /**
     * 根据商品的id删除商品
     * @param commodity_ID
     */
    @RequestMapping(value = "/deleteCommodityById", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCommodityById(
            @RequestParam(required = false) String commodity_ID
    ){
        communityService.deleteCommodityById(commodity_ID);
    }

    /**
     * 根据帖子的id删除帖子
     * @param post_ID
     */
    @RequestMapping(value = "/deletePostById", method = RequestMethod.DELETE)
    @ResponseBody
    public void deletePostById(
            @RequestParam(required = false) String post_ID
    ){
        communityService.deletePostById(post_ID);
    }

    /**
     * 根据用户的id删除用户
     * @param user_ID
     */
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUserById(
            @RequestParam(required = false) String user_ID
    ){
        communityService.deleteUserById(user_ID);
    }

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
     * 获取全部的商品列表
     * @param user_ID
     * @return
     */
    @RequestMapping(value = "/getAllCommodity", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodity(
            @RequestParam(required = false) String user_ID
    ){
        return this.buildSuccess(communityService.encapsulateCommodity(commodityService.getAllCommodity(), user_ID));
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
     * 根据类别获取全部的商品列表
     * @param user_ID
     * @param type
     * @return
     */
    @RequestMapping(value = "/getAllCommodityByType", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityByType(
            @RequestParam(required = false) String user_ID, String type
    ){
        return this.buildSuccess(communityService.encapsulateCommodity(commodityService.getAllCommodityByType(type),user_ID));
    }

    /**
     * 根据类别获取全部的商品列表
     * @param user_ID
     * @param brand
     * @return
     */
    @RequestMapping(value = "/getAllCommodityByBrand", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityByBrand(
            @RequestParam(required = false) String user_ID, String brand
    ){
        return this.buildSuccess(communityService.encapsulateCommodity(commodityService.getAllCommodityByBrand(brand),user_ID));
    }

    /**
     * 根据功效获取全部的商品列表
     * @param user_ID
     * @param effacicy
     * @return
     */
    @RequestMapping(value = "/getAllCommodityByEffacicy", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityByEffacicy(
            @RequestParam(required = false) String user_ID, String effacicy
    ){
        return this.buildSuccess(communityService.encapsulateCommodity(commodityService.getAllCommodityByEffacicy(effacicy),user_ID));
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
