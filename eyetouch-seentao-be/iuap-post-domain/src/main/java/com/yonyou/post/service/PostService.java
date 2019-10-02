package com.yonyou.post.service;
import java.util.ArrayList;
import java.util.List;

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
        List postList = postQueryService.listPost(postSimpleDto.toSearchParams(Post.class));

        List<String> postIds = new ArrayList<>();
        for (Object o:postList){
            // 进行强制类型转换
            PostDTO record = (PostDTO)o;
            postIds.add(record.getId());
        }
        postMapper.deleteByIds(postIds);
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
}