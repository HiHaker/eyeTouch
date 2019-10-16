package com.yonyou.post.service;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.ccomments.service.CcommentsService;
import com.yonyou.cfavorites.service.CfavoritesService;
import com.yonyou.clikes.service.ClikesService;
import com.yonyou.myuser.dto.MyuserDTO;
import com.yonyou.myuser.po.Myuser;
import com.yonyou.myuser.service.MyuserService;
import com.yonyou.pcomments.service.PcommentsService;
import com.yonyou.pfavorites.service.PfavoritesService;
import com.yonyou.plikes.service.PlikesService;
import com.yonyou.post.dto.PostDTO;
import com.yonyou.relation.dto.RelationDTO;
import com.yonyou.relation.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/10/16 0016
 * BY Jianlong
 */
@Service
public class UserService {

    @Autowired
    CommunityService communityService;
    @Autowired
    MyuserService myuserService;
    @Autowired
    PostService postService;
    @Autowired
    RelationService relationService;
    @Autowired
    PlikesService plikesService;
    @Autowired
    PfavoritesService pfavoritesService;
    @Autowired
    PcommentsService pcommentsService;
    @Autowired
    ClikesService clikesService;
    @Autowired
    CfavoritesService cfavoritesService;
    @Autowired
    CcommentsService ccommentsService;

    /**
     * 将用户实体转换为DTO
     * @param myuser
     * @return
     */
    public MyuserDTO switchDTO(Myuser myuser){
        MyuserDTO myuserDTO = new MyuserDTO();
        myuserDTO.setId(myuser.getId());
        myuserDTO.setAvatar(myuser.getAvatar());
        myuserDTO.setLogin_name(myuser.getLogin_name());
        myuserDTO.setPassword(myuser.getPassword());
        myuserDTO.setNickname(myuser.getNickname());
        myuserDTO.setSex(myuser.getSex());
        myuserDTO.setBirthday(myuser.getBirthday());
        myuserDTO.setRegister_date(myuser.getRegister_date());
        myuserDTO.setProfile(myuser.getProfile());
        myuserDTO.setPhone_number(myuser.getPhone_number());
        myuserDTO.setMailbox(myuser.getMailbox());
        return myuserDTO;
    }

    /**
     * 封装用户测试
     * @param userList
     * @return
     */
    public List<Object> encapsulateUserTest(List<Object> userList){
        JSONObject userObject = new JSONObject();
        List<Object> eUserList = new ArrayList<>();
        for (Object o:userList){
            // 类型转换
            MyuserDTO myuserDTO = (MyuserDTO)o;
            // 将封装好的对象加入列表
            eUserList.add(userObject);
            // 基本信息
            userObject.put("id",myuserDTO.getId());
            userObject.put("avatar",myuserDTO.getAvatar());
            userObject.put("login_name",myuserDTO.getLogin_name());
            userObject.put("password",myuserDTO.getPassword());
            userObject.put("nickname",myuserDTO.getNickname());
            userObject.put("sex",myuserDTO.getSex());
            userObject.put("birthday",myuserDTO.getBirthday());
            userObject.put("register_date",myuserDTO.getRegister_date());
            userObject.put("profile",myuserDTO.getProfile());
            userObject.put("phone_number",myuserDTO.getPhone_number());
            userObject.put("mailbox",myuserDTO.getMailbox());
            userObject = new JSONObject();
        }
        return eUserList;
    }

    /**
     * 用户的封装对象
     * @param userList
     * @return
     */
    public List<Object> encapsulateUser(List<Object> userList){
        JSONObject userObject = new JSONObject();
        List<Object> eUserList = new ArrayList<>();
        for (Object o:userList){
            // 类型转换
            MyuserDTO myuserDTO = (MyuserDTO)o;
            // 基本信息
            userObject.put("id",myuserDTO.getId());
            userObject.put("avatar",myuserDTO.getAvatar());
            userObject.put("login_name",myuserDTO.getLogin_name());
            userObject.put("password",myuserDTO.getPassword());
            userObject.put("nickname",myuserDTO.getNickname());
            userObject.put("sex",myuserDTO.getSex());
            userObject.put("birthday",myuserDTO.getBirthday());
            userObject.put("register_date",myuserDTO.getRegister_date());
            userObject.put("profile",myuserDTO.getProfile());
            userObject.put("phone_number",myuserDTO.getPhone_number());
            userObject.put("mailbox",myuserDTO.getMailbox());

            // 发表贴子数
            userObject.put("posts_count",postService.eGetPostsNum(myuserDTO.getId()));
            // 收藏帖子数
            userObject.put("pfavorites_count",pfavoritesService.eGetUserFavoritesNum(myuserDTO.getId()));
            // 收藏的商品数
            userObject.put("cfavorites_count",cfavoritesService.eGetUserFavoritesNum(myuserDTO.getId()));
            // 关注数
            userObject.put("follows_count",this.getAllFollows(myuserDTO.getId()).size());
            // 粉丝数
            userObject.put("fans_count",this.getAllFans(myuserDTO.getId()).size());
            // 将封装好的对象加入列表
            eUserList.add(userObject);

            userObject = new JSONObject();
        }
        return eUserList;
    }

    /**
     * 根据用户的id删除用户
     * 因为用户有外键引用，所以在删除之前要先删除那些记录
     * @param user_ID
     */
    @Transactional
    public void deleteUserById(String user_ID){
        // 删除关注的记录
        relationService.deleteByFansId(user_ID);
        relationService.deleteByFollowsId(user_ID);
        // 帖子
        // 删除点赞的记录
        plikesService.deleteByUserId(user_ID);
        // 删除收藏的记录
        pfavoritesService.deleteByUserId(user_ID);
        // 删除评论的记录
        pcommentsService.deleteByAUserId(user_ID);
        pcommentsService.deleteByBUserId(user_ID);
        // 商品
        // 删除点赞
        clikesService.deleteByUserId(user_ID);
        // 删除收藏
        cfavoritesService.deleteByUserId(user_ID);
        // 删除评论
        ccommentsService.deleteByUserId(user_ID);

        // 删除帖子
        List<Object> posts = postService.getPostByUserId(user_ID);
        for (Object o:posts){
            PostDTO p = (PostDTO) o;
            communityService.deletePostById(p.getId());
        }

        // 删除自身
        myuserService.deleteUserById(user_ID);
    }

    /**
     * 获取全部的关注用户
     */
    public List<Object> getAllFollows(String user_ID){
        List<Object> relationList = relationService.getAllFollowsByFansId(user_ID);
        List<Object> followsList = new ArrayList<>();
        for (Object o:relationList){
            // 类型转换
            RelationDTO rd = (RelationDTO)o;
            Myuser myuser = myuserService.getAssoVo(rd.getFollows()).getEntity();
            followsList.add(this.switchDTO(myuser));
        }
        return followsList;
    }

    /**
     * 获取全部的粉丝用户
     */
    public List<Object> getAllFans(String user_ID){
        List<Object> relationList = relationService.getAllFansByFollowsId(user_ID);
        List<Object> fansList = new ArrayList<>();
        for (Object o:relationList){
            // 类型转换
            RelationDTO rd = (RelationDTO)o;
            Myuser myuser = myuserService.getAssoVo(rd.getFans()).getEntity();
            fansList.add(this.switchDTO(myuser));
        }
        return fansList;
    }
}
