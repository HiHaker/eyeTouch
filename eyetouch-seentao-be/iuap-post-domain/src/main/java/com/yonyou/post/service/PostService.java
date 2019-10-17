package com.yonyou.post.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yonyou.post.api.PostQueryService;
import com.yonyou.post.dto.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.post.dao.PostMapper;
import com.yonyou.post.po.Post;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.post.service.PostService")
public class PostService extends GenericAssoService<Post,String>{

    private PostMapper postMapper;

    @Autowired
    PostQueryService postQueryService;

    @Autowired
    public void setPostMapper(PostMapper postMapper) {
        this.postMapper = postMapper;
        super.setGenericMapper(postMapper);
    }



    /**
     * 可插拔设计
     * @return 向父类 提供可插拔的特性声明
     */
    @Override
    protected ServiceFeature[] getFeats() {
        return new ServiceFeature[]{ AUDIT,I18N_ENUM };
    }

    /**
     * 根据帖子的id删除帖子
     * @param post_ID
     */
    public void deletePostById(String post_ID){
        List<String> postIds = new ArrayList<>();
        postIds.add(post_ID);
        postMapper.deleteByIds(postIds);
    }

    /**
     * 根据用户id删除其全部的帖子
     * @param user_ID
     */
    public void deletePostByUserId(String user_ID){
        com.yonyou.post.dto.SimpleSearchDTO postSimpleDto = new
                com.yonyou.post.dto.SimpleSearchDTO();
        postSimpleDto.setSearch_uid(user_ID);
        postMapper.delete(postSimpleDto.toSearchParams(Post.class));
    }

    /**
     * 得到全部的帖子列表
     * @return
     */
    public List<Object> getAllPost(){
        com.yonyou.post.dto.SimpleSearchDTO postSimpleDto = new
                com.yonyou.post.dto.SimpleSearchDTO();
        List postList = postQueryService.listPost(postSimpleDto.toSearchParams(Post.class));
        return postList;
    }

    /**
     * 根据用户id查询帖子
     * @param user_ID
     * @return
     */
    public List<Object> getPostByUserId(String user_ID){
        com.yonyou.post.dto.SimpleSearchDTO postSimpleDto = new
                com.yonyou.post.dto.SimpleSearchDTO();
        postSimpleDto.setSearch_uid(user_ID);
        List postList = postQueryService.listPost(postSimpleDto.toSearchParams(Post.class));
        return postList;
    }

    /**
     * 查询出转发某条帖子的全部帖子
     * @param forward_ID
     * @return
     */
    public List<Object> getPostByForwardId(String forward_ID){
        com.yonyou.post.dto.SimpleSearchDTO postSimpleDto = new
                com.yonyou.post.dto.SimpleSearchDTO();
        postSimpleDto.setSearch_fpid(forward_ID);
        List postList = postQueryService.listPost(postSimpleDto.toSearchParams(Post.class));
        return postList;
    }

    /**
     * 根据type值查询帖子（1：图文，2：视频）
     * @param
     * @return
     */
    public List<Object> getPostByType(String type){
        com.yonyou.post.dto.SimpleSearchDTO postSimpleDto = new
                com.yonyou.post.dto.SimpleSearchDTO();
        postSimpleDto.setSearch_type(type);
        List postList = postQueryService.listPost(postSimpleDto.toSearchParams(Post.class));
        return postList;
    }

    /**
     * 根据style值查询帖子（0：心情随笔，1：妆容分享，2：眼妆教程，3：妆品推荐）
     * @param
     * @return
     */
    public List<Object> getPostByStyle(String style){
        com.yonyou.post.dto.SimpleSearchDTO postSimpleDto = new
                com.yonyou.post.dto.SimpleSearchDTO();
        postSimpleDto.setSearch_style(style);
        List postList = postQueryService.listPost(postSimpleDto.toSearchParams(Post.class));
        return postList;
    }

    /**
     * 根据帖子的类型和风格获取帖子列表
     * @param type
     * @param style
     * @return
     */
    public List<Object> getPostByTypeAndStyle(String type, String style){
        com.yonyou.post.dto.SimpleSearchDTO postSimpleDto = new
                com.yonyou.post.dto.SimpleSearchDTO();
        postSimpleDto.setSearch_type(type);
        postSimpleDto.setSearch_style(style);
        List postList = postQueryService.listPost(postSimpleDto.toSearchParams(Post.class));
        return postList;
    }

    /**
     * 根据帖子的标题和内容进行模糊查询
     * @param title
     * @param content
     * @return
     */
    public List<Object> getPostByTitleAndContent(String title, String content){
        com.yonyou.post.dto.SimpleSearchDTO postSimpleDto = new
                com.yonyou.post.dto.SimpleSearchDTO();
        postSimpleDto.setSearch_title(title);
        postSimpleDto.setSearch_content(content);
        List postList = postQueryService.listPost(postSimpleDto.toSearchParams(Post.class));
        return postList;
    }

    /**
     * 根据帖子列表转换为字符串id列表
     * @param postList
     * @return
     */
    public List<String> eGetIdsList(List<Object> postList){
        List<String> idList = new ArrayList<>();
        for (Object o:postList){
            PostDTO pd = (PostDTO)o;
            idList.add(pd.getId());
        }
        return idList;
    }

    /**
     * 得到某条帖子的转发id列表
     * @param post_ID
     * @return
     */
    public List<String> eGetForwardList(String post_ID){
        List<Object> forwardList = this.getPostByForwardId(post_ID);
        List<String> forwardIds = new ArrayList<>();
        for (Object o:forwardList){
            PostDTO pd = (PostDTO)o;
            forwardIds.add(pd.getId());
        }
        return forwardIds;
    }

    /**
     * 得到用户发表的帖子id列表
     * @param user_ID
     * @return
     */
    public List<String> eGetPostsList(String user_ID){
        List<Object> postsList = this.getPostByUserId(user_ID);
        List<String> postsIds = new ArrayList<>();
        for (Object o:postsList){
            PostDTO pd = (PostDTO)o;
            postsIds.add(pd.getId());
        }
        return postsIds;
    }

    /**
     * 得到用户发表的帖子数
     * @param user_ID
     * @return
     */
    public Integer eGetPostsNum(String user_ID){
        List<Object> postsList = this.getPostByUserId(user_ID);
        return postsList.size();
    }

    /**
     * 得到某条帖子的转发数
     * @param post_ID
     * @return
     */
    public Integer eGetForwardNum(String post_ID){
        List<Object> forwardList = this.getPostByForwardId(post_ID);
        return forwardList.size();
    }
}