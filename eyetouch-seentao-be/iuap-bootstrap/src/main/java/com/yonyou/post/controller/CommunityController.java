package com.yonyou.post.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yonyou.commodity.dto.CommodityDTO;
import com.yonyou.commodity.po.Commodity;
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
     * 测试
     * @param
     * @return
     */
    @RequestMapping(value = "/Test", method = RequestMethod.POST)
    @ResponseBody
    public Object Test(
            @RequestBody Myuser myuser
    ){
        return myuser;
    }

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
        Myuser user = myuserService.getAssoVo(myuser.getId()).getEntity();
        if (!user.getPassword().equals(myuser.getPassword())){
            jsonObject.put("message","登陆失败，密码错误!");
            return jsonObject;
        } else{
            String token = tokenService.getToken(myuser);
            jsonObject.put("token",token);
            return jsonObject;
        }
    }

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
     * 根据商品的id删除商品
     * @param commodity_ID
     */
    @RequestMapping(value = "/deleteCommodityById", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteCommodityById(
            @RequestParam String commodity_ID
    ){
        communityService.deleteCommodityById(commodity_ID);
        return "success";
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
     * 根据用户的id删除用户
     * @param user_ID
     */
    @RequestMapping(value = "/deleteUserById", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteUserById(
            @RequestParam String user_ID
    ){
        communityService.deleteUserById(user_ID);
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
            @RequestParam String post_ID, String user_ID
    ){
        // 转换为DTO
        Post post = postService.getAssoVo(post_ID).getEntity();
        PostDTO pd = new PostDTO();
        pd.setId(post.getId());
        pd.setUid(post.getUid());
        pd.setTitle(post.getTitle());
        pd.setContent(post.getContent());
        pd.setType(post.getType());
        pd.setStyle(post.getStyle());
        pd.setFpid(post.getFpid());
        pd.setTime(post.getTime());
        pd.setCreateUser(post.getCreateUser());
        pd.setCreateTime(post.getCreateTime());
        pd.setDr(post.getDr());
        pd.setTs(post.getTs());
        pd.setTenantId(post.getTenantId());
        pd.setLastModifyUser(post.getLastModifyUser());
        pd.setLastModified(post.getLastModified());
        // 封装成帖子列表
        List<Object> postList = new ArrayList<>();
        postList.add(pd);
        return this.buildSuccess(communityService.encapsulatePostLogin(postList,user_ID));
    }

    /**
     * 根据商品id获得商品对象
     * @param commodity_ID
     * @return
     */
    @RequestMapping(value = "/getCommodityById", method = RequestMethod.GET)
    @ResponseBody
    public Object getCommodityById(
            @RequestParam String commodity_ID, String user_ID
    ){
        // 转换为DTO
        Commodity commodity = commodityService.getAssoVo(commodity_ID).getEntity();
        CommodityDTO cd = new CommodityDTO();
        cd.setId(commodity.getId());
        cd.setName(commodity.getName());
        cd.setPrice(commodity.getPrice());
        cd.setLink(commodity.getLink());
        cd.setType(commodity.getType());
        cd.setBrand(commodity.getBrand());
        cd.setEffacicy(commodity.getEffacicy());
        cd.setCreateUser(commodity.getCreateUser());
        cd.setCreateTime(commodity.getCreateTime());
        cd.setDr(commodity.getDr());
        cd.setTs(commodity.getTs());
        cd.setTenantId(commodity.getTenantId());
        cd.setLastModifyUser(commodity.getLastModifyUser());
        cd.setLastModified(commodity.getLastModified());
        // 封装成帖子列表
        List<Object> commodityList = new ArrayList<>();
        commodityList.add(cd);
        return this.buildSuccess(communityService.encapsulateCommodityLogin(commodityList,user_ID));
    }

    /**
     * 获取全部的帖子列表
     * @param user_ID
     * @return
     */
    @RequestMapping(value = "/getAllPosts", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllPosts(
            @RequestParam String user_ID
    ){
        return this.buildSuccess(communityService.encapsulatePostLogin(postService.getAllPost(),user_ID));
    }

    /**
     * 获取全部的商品列表
     * @param user_ID
     * @return
     */
    @RequestMapping(value = "/getAllCommodity", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodity(
            @RequestParam String user_ID
    ){
        return this.buildSuccess(communityService.encapsulateCommodityLogin(commodityService.getAllCommodity(), user_ID));
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
     * 根据类型（type）获取全部的帖子列表
     * @param user_ID
     * @param type
     * @return
     */
    @RequestMapping(value = "/getAllPostsByType", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllPostsByType(
            @RequestParam String user_ID, String type
    ){
        return this.buildSuccess(communityService.encapsulatePostLogin(postService.getPostByType(type),user_ID));
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
            @RequestParam String user_ID, String style
    ){
        return this.buildSuccess(communityService.encapsulatePostLogin(postService.getPostByStyle(style),user_ID));
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
            @RequestParam String user_ID, String type
    ){
        return this.buildSuccess(communityService.encapsulateCommodityLogin(commodityService.getAllCommodityByType(type),user_ID));
    }

    /**
     * 根据品牌获取全部的商品列表
     * @param user_ID
     * @param brand
     * @return
     */
    @RequestMapping(value = "/getAllCommodityByBrand", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllCommodityByBrand(
            @RequestParam String user_ID, String brand
    ){
        return this.buildSuccess(communityService.encapsulateCommodityLogin(commodityService.getAllCommodityByBrand(brand),user_ID));
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
            @RequestParam String user_ID, String effacicy
    ){
        return this.buildSuccess(communityService.encapsulateCommodityLogin(commodityService.getAllCommodityByEffacicy(effacicy),user_ID));
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