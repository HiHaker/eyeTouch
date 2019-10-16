package com.yonyou.post.service;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.cbrand.service.CbrandService;
import com.yonyou.ccomments.dto.CcommentsDTO;
import com.yonyou.ccomments.service.CcommentsService;
import com.yonyou.cfavorites.service.CfavoritesService;
import com.yonyou.cimage.service.CimageService;
import com.yonyou.clikes.service.ClikesService;
import com.yonyou.commodity.dto.CommodityDTO;
import com.yonyou.commodity.service.CommodityService;
import com.yonyou.ctype.service.CtypeService;
import com.yonyou.effacicy.service.EffacicyService;
import com.yonyou.myuser.po.Myuser;
import com.yonyou.myuser.service.MyuserService;
import com.yonyou.pcomments.dto.PcommentsDTO;
import com.yonyou.pcomments.service.PcommentsService;
import com.yonyou.pfavorites.service.PfavoritesService;
import com.yonyou.pimage.po.Pimage;
import com.yonyou.pimage.service.PimageService;
import com.yonyou.plikes.service.PlikesService;
import com.yonyou.post.dto.PostDTO;
import com.yonyou.post.po.Post;
import com.yonyou.pvideo.po.Pvideo;
import com.yonyou.pvideo.service.PvideoService;
import com.yonyou.relation.dto.RelationDTO;
import com.yonyou.relation.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2019/10/3 0003
 * BY Jianlong
 * 东方眼秀社区服务
 */
@Service
public class CommunityService {
    @Autowired
    PostService postService;
    @Autowired
    MyuserService myuserService;
    @Autowired
    CommodityService commodityService;
    @Autowired
    CimageService cimageService;
    @Autowired
    PimageService pimageService;
    @Autowired
    PvideoService pvideoService;
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
     * 得到转发的帖子的封装对象
     * forward:{        // 如果为1说明是原创
     *     uid: "",       //原帖作者
     *     nickName: "",  //原帖作者昵称
     *     avatarUrl: "",
     *     postTime: "",  //原帖发表时间
     *     pid: "",       //原帖id
     *     postTitle: "", //原帖标题
     *     body: ""
     *   }
     * @param post_ID
     * @return
     */
    public Object eGetForwardPost(String post_ID){
        JSONObject postObject = new JSONObject();
        Post p = postService.getAssoVo(post_ID).getEntity();
        postObject.put("uid",p.getUid());
        postObject.put("nickname",myuserService.getAssoVo(p.getUid()).getEntity().getNickname());
        postObject.put("avatarUrl",myuserService.getAssoVo(p.getUid()).getEntity().getAvatar());
        postObject.put("postTime",p.getTime());
        postObject.put("pid",p.getId());
        postObject.put("postTitle",p.getTitle());
        postObject.put("body",p.getContent());
        return postObject;
    }

    /**
     * 得到帖子的封装评论对象     * comments: [
     *     {
     *       userId: "",     // 评论帖子的人
     *       nickName: "",
     *       objectId: "",   // 评论的对象
     *       objectNickName: "", // 若对象是作者，前端显示XXX评论了你
     *       content: "" // 若果对象是另外的评论者，前端显XXX回复XXX
     *     }
     *   ]
     * @param post_ID
     * @return
     */
    public List<Object> eGetComments(String post_ID){
        List<Object> commentsList = pcommentsService.getAllByPostId(post_ID);
        Map<String,Object> commentObject = new HashMap<>();
        List<Object> eCommentList = new ArrayList<>();

        for (Object o:commentsList){
            // 强制类型转换
            PcommentsDTO c = (PcommentsDTO)o;
            commentObject.put("id",c.getId());
            commentObject.put("userId",c.getAuid());
            commentObject.put("nickname", myuserService.getAssoVo(c.getAuid()).getEntity().getNickname());
            commentObject.put("objectId",c.getBuid());
            commentObject.put("objectNickname", myuserService.getAssoVo(c.getBuid()).getEntity().getNickname());
            commentObject.put("content",c.getContent());

            // 加入list
            eCommentList.add(commentObject);
            commentObject = new HashMap<>();
        }
        return eCommentList;
    }

    /**
     * 判断当前用户（a）是否关注了发帖用户（b）
     * @param auser_ID
     * @param buser_ID
     * @return
     */
    public boolean eIfFollows(String auser_ID, String buser_ID){
        if (relationService.getByFansIdAndFollowsId(auser_ID, buser_ID).size() == 0){
            return false;
        } else{
            return true;
        }
    }

    /**
     * 判断当前用户是否点赞了当前帖子
     * @param user_ID
     * @param post_ID
     * @return
     */
    public boolean eIfLikes(String user_ID, String post_ID){
        if (plikesService.getByUserIdAndPostId(user_ID, post_ID).size() == 0){
            return false;
        } else{
            return true;
        }
    }

    /**
     * 判断当前用户是否收藏了当前帖子
     * @param user_ID
     * @param post_ID
     * @return
     */
    public boolean eIfFavorites(String user_ID, String post_ID){
        if (pfavoritesService.getByUserIdAndPostId(user_ID, post_ID).size() == 0){
            return false;
        } else{
            return true;
        }
    }

    /**
     * 将查询到的帖子封装成前端需要的格式（用户登录状态下）
     * @param postList
     * @param user_ID
     * @return
     */
    public List<Object> encapsulatePostLogin(List<Object> postList, String user_ID){
        JSONObject postObject = new JSONObject();
        List<Object> ePostList = new ArrayList<>();
        for (Object o:postList){
            // 强制类型转换
            PostDTO p = (PostDTO)o;
            // 帖子的id
            postObject.put("pid",p.getId());
            // 帖子的标题
            postObject.put("title",p.getTitle());
            // 帖子的类型（1：图文，2：视频）
            postObject.put("type",p.getType());
            // 帖子的风格（0：心情随笔，1：妆容分享，2：眼妆教程，3：妆品推荐）
            postObject.put("style",p.getStyle());
            // 发表的帖子的用户id
            postObject.put("uid",p.getUid());
            // 头像的url
            postObject.put("avatarUrl",myuserService.getAssoVo(p.getUid()).getEntity().getAvatar());
            // 用户昵称
            postObject.put("nickname",myuserService.getAssoVo(p.getUid()).getEntity().getNickname());
            // 发表时间
            postObject.put("postTime",p.getTime());
            // 图像url列表
            postObject.put("images",pimageService.eGetImagesUrl(p.getId()));
            // 视频url
            postObject.put("video",pvideoService.eGetVideoUrl(p.getId()));
            // body
            postObject.put("body",p.getContent());

            // 判断帖子是否是转发的,为"-1"说明不是转发的
            if (p.getFpid().equals("-1")){
                postObject.put("forward",null);
            } else {
                postObject.put("forward",this.eGetForwardPost(p.getFpid()));
            }

            // 是否被当前用户关注
            postObject.put("isAttent",this.eIfFollows(user_ID,p.getUid()));
            // 是否被当前用户点赞
            postObject.put("isLike",this.eIfLikes(user_ID,p.getId()));
            // 是否被当前用户收藏
            postObject.put("isCollect",this.eIfFavorites(user_ID,p.getId()));

            // 点赞数
            postObject.put("likeCount",plikesService.eGetLikesNum(p.getId()));
            // 收藏数
            postObject.put("collectionCount",pfavoritesService.eGetFavoritesNum(p.getId()));
            // 评论数
            postObject.put("commentCount",pcommentsService.eGetCommentsNum(p.getId()));
            // 转发数
            postObject.put("forwardCount",postService.eGetForwardNum(p.getId()));

            // 获取评论列表
            postObject.put("comments",this.eGetComments(p.getId()));
            // fpid
            postObject.put("fpid",p.getFpid());

            // 将封装好的对象加入列表
            ePostList.add(postObject);

            postObject = new JSONObject();
        }
        return ePostList;
    }

    /**
     * 将查询到的帖子封装成前端需要的格式（访客模式）
     * @param postList
     * @return
     */
    public List<Object> encapsulatePost(List<Object> postList){
        JSONObject postObject = new JSONObject();
        List<Object> ePostList = new ArrayList<>();
        for (Object o:postList){
            // 强制类型转换
            PostDTO p = (PostDTO)o;
            // 帖子的id
            postObject.put("pid",p.getId());
            // 帖子的标题
            postObject.put("title",p.getTitle());
            // 帖子的类型（1：图文，2：视频）
            postObject.put("type",p.getType());
            // 帖子的风格（0：心情随笔，1：妆容分享，2：眼妆教程，3：妆品推荐）
            postObject.put("style",p.getStyle());
            // 发表的帖子的用户id
            postObject.put("uid",p.getUid());
            // 头像的url
            postObject.put("avatarUrl",myuserService.getAssoVo(p.getUid()).getEntity().getAvatar());
            // 用户昵称
            postObject.put("nickname",myuserService.getAssoVo(p.getUid()).getEntity().getNickname());
            // 发表时间
            postObject.put("postTime",p.getTime());
            // 图像url列表
            postObject.put("images",pimageService.eGetImagesUrl(p.getId()));
            // 视频url
            postObject.put("video",pvideoService.eGetVideoUrl(p.getId()));
            // body
            postObject.put("body",p.getContent());

            // 判断帖子是否是转发的,为"-1"说明不是转发的
            if (p.getFpid().equals("-1")){
                postObject.put("forward",null);
            } else {
                postObject.put("forward",this.eGetForwardPost(p.getFpid()));
            }

            // 点赞数
            postObject.put("likeCount",plikesService.eGetLikesNum(p.getId()));
            // 收藏数
            postObject.put("collectionCount",pfavoritesService.eGetFavoritesNum(p.getId()));
            // 评论数
            postObject.put("commentCount",pcommentsService.eGetCommentsNum(p.getId()));
            // 转发数
            postObject.put("forwardCount",postService.eGetForwardNum(p.getId()));

            // 获取评论列表
            postObject.put("comments",this.eGetComments(p.getId()));
            // fpid
            postObject.put("fpid",p.getFpid());

            // 将封装好的对象加入列表
            ePostList.add(postObject);

            postObject = new JSONObject();
        }
        return ePostList;
    }

    /**
     * 发表帖子（图片）
     * @param p
     * @param pimageList
     */
    @Transactional
    public void publishPostImg(Post p, List<Pimage> pimageList){
        postService.save(p,true,true);
        pimageService.insertImages(pimageList);
    }

    /**
     * 发表帖子（视频）
     * @param p
     * @param v
     */
    @Transactional
    public void publishPostVideo(Post p, Pvideo v){
        postService.save(p,true,true);
        pvideoService.save(v,true,true);
    }

    /**
     * 根据帖子的id删除帖子
     * 因为帖子有外键引用，所以需要先删除那些记录
     * @param post_ID
     */
    @Transactional
    public void deletePostById(String post_ID){
        // 删除图片
        pimageService.deleteImagesByPostId(post_ID);
        // 删除视频
        pvideoService.deleteVideoByPostId(post_ID);
        // 删除点赞
        plikesService.deleteByPostId(post_ID);
        // 删除收藏
        pfavoritesService.deleteByPostId(post_ID);
        // 删除评论
        pcommentsService.deleteByPostId(post_ID);
        // 删除子贴（转发了这条帖子的帖子）
        List<String> forwardIds = postService.eGetForwardList(post_ID);
        for (String id:forwardIds){
            // 删除图片
            pimageService.deleteImagesByPostId(id);
            // 删除视频
            pvideoService.deleteVideoByPostId(id);
            // 删除点赞
            plikesService.deleteByPostId(id);
            // 删除收藏
            pfavoritesService.deleteByPostId(id);
            // 删除评论
            pcommentsService.deleteByPostId(id);
            postService.deletePostById(id);
        }
        // 最后删除自身
        postService.deletePostById(post_ID);
    }

    /**
     * 获取关注的人发表的帖子
     * @param user_ID
     * @return
     */
    public Object getFollowsPosts(String user_ID){
        List<String> follows = relationService.eGetAllFollows(user_ID);
        JSONObject postsObject = new JSONObject();
        // 将关注的人发表的帖子分别封装起来放入Map
        for (String s:follows){
            postsObject.put("followsID: "+s,this.encapsulatePostLogin(postService.getPostByUserId(s),user_ID));
        }

        return postsObject;
    }
}