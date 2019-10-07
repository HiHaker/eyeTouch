package com.yonyou.post.service;

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
import com.yonyou.myuser.service.MyuserService;
import com.yonyou.pcomments.dto.PcommentsDTO;
import com.yonyou.pcomments.service.PcommentsService;
import com.yonyou.pfavorites.service.PfavoritesService;
import com.yonyou.pimage.service.PimageService;
import com.yonyou.plikes.service.PlikesService;
import com.yonyou.post.dto.PostDTO;
import com.yonyou.post.po.Post;
import com.yonyou.pvideo.service.PvideoService;
import com.yonyou.relation.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    CbrandService cbrandService;
    @Autowired
    CtypeService ctypeService;
    @Autowired
    EffacicyService effacicyService;

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
        Map<String,Object> postObject = new HashMap<>();
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
     * 得到商品的封装评论对象
     * comments: [
     *      *     {
     *      *       userId: "",     // 评论帖子的人
     *      *       nickName: "",
     *      *       content: ""
     *      *     }
     *      *   ]
     * @param commodity_ID
     * @return
     */
    public List<Object> eGetCommentsC(String commodity_ID){
        List<Object> commentsList = ccommentsService.getAllCommentsByCommodityId(commodity_ID);
        Map<String,Object> commentObject = new HashMap<>();
        List<Object> eCommentList = new ArrayList<>();

        for (Object o:commentsList){
            // 强制类型转换
            CcommentsDTO c = (CcommentsDTO)o;

            commentObject.put("userId",c.getUid());
            commentObject.put("nickname", myuserService.getAssoVo(c.getUid()).getEntity().getNickname());
            commentObject.put("content",c.getContent());

            // 加入list
            eCommentList.add(commentObject);
            commentObject = new HashMap<>();
        }
        return eCommentList;
    }

    /**
     * 得到帖子的封装评论对象
     * comments: [
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
        if (relationService.getByFansIdAndFollowsId(auser_ID, buser_ID) == null){
            return false;
        } else{
            return true;
        }
    }

    /**
     * 判断当前用户是否点赞了商品
     * @param user_ID
     * @param commodity_ID
     * @return
     */
    public boolean eIfLikesC(String user_ID, String commodity_ID){
        if (clikesService.getByUserIdAndCommodityId(user_ID, commodity_ID) == null){
            return false;
        } else{
            return true;
        }
    }

    /**
     * 判断当前用户是否收藏了当前商品
     * @param user_ID
     * @param commodity_ID
     * @return
     */
    public boolean eIfFavoritesC(String user_ID, String commodity_ID){
        if (cfavoritesService.getByUserIdAndCommodityId(user_ID, commodity_ID) == null){
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
        if (plikesService.getByUserIdAndPostId(user_ID, post_ID) == null){
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
        if (pfavoritesService.getByUserIdAndPostId(user_ID, post_ID) == null){
            return false;
        } else{
            return true;
        }
    }

    /**
     * 将查询到的商品封装成前端需要的格式
     * @param commodity
     * @param user_ID
     * @return
     */
    public List<Object> encapsulateCommodity(List<Object> commodity, String user_ID){
        Map<String,Object> commodityObject = new HashMap<>();
        List<Object> eCommodityList = new ArrayList<>();

        for (Object o:commodity){
            // 强制类型转换
            CommodityDTO c = (CommodityDTO)o;
            // 商品的id
            commodityObject.put("cid",c.getId());
            // 商品名称
            commodityObject.put("name",c.getName());
            // 商品内容
            commodityObject.put("content",c.getContent());
            // 商品链接
            commodityObject.put("link",c.getLink());
            // 商品品牌
            commodityObject.put("brand",cbrandService.getAssoVo(c.getId()).getEntity().getName());
            // 商品功效
            commodityObject.put("effacicy",effacicyService.getAssoVo(c.getId()).getEntity().getName());
            // 商品类型
            commodityObject.put("type",ctypeService.getAssoVo(c.getId()).getEntity().getName());
            // 是否被当前用户点赞
            commodityObject.put("isLike",this.eIfLikesC(user_ID,c.getId()));
            // 是否被当前用户收藏
            commodityObject.put("isCollect",this.eIfFavoritesC(user_ID,c.getId()));
            // 点赞数
            commodityObject.put("likesCount",clikesService.eGetLikesNum(c.getId()));
            // 收藏数
            commodityObject.put("collectCount",cfavoritesService.eGetFavoritesNum(c.getId()));
            // 评论数
            commodityObject.put("commentCount",ccommentsService.eGetCommentsNum(c.getId()));
            // 商品图片
            commodityObject.put("imgUrl",cimageService.eGetImagesUrl(c.getId()));
            // 商品评论
            commodityObject.put("comments",this.eGetCommentsC(c.getId()));

            // 将封装好的对象加入列表
            eCommodityList.add(commodityObject);
            commodityObject = new HashMap<>();
        }
        return eCommodityList;
    }

    /**
     * 测试Map对象
     * @return
     */
    public Object EPtest1(){
        Map<String,Object> postObject = new HashMap<>();
        postObject.put("hello","test");
        return postObject;
    }

    /**
     * 测试List封装Map对象
     * @return
     */
    public Object EPtest2(){
        Map<String,Object> postObject = new HashMap<>();
        List<Object> ePostList = new ArrayList<>();
        postObject.put("hello","test");
        ePostList.add(postObject);
        postObject = new HashMap<>();
        postObject.put("hello2","test2");
        ePostList.add(postObject);
        return ePostList;
    }

    /**
     * 将查询到的帖子封装成前端需要的格式
     * @param postList
     * @param user_ID
     * @return
     */
    public List<Object> encapsulatePost(List<Object> postList, String user_ID){
        Map<String,Object> postObject = new HashMap<>();
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

            // 判断帖子是否是转发的,为"1"说明不是转发的
            if (p.getFpid().equals("1")){
                postObject.put("forward",null);
            } else {
                postObject.put("forward",this.eGetForwardPost(p.getFpid()));
            }

            // 是否被当前用户关注
            postObject.put("isAttent",this.eIfFollows(user_ID,p.getId()));
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

            postObject = new HashMap<>();
        }
        return ePostList;
    }

    /**
     * 根据商品的id删除商品
     * 因为商品有外键引用，需要先删除那些记录
     */
    @Transactional
    public void deleteCommodityById(String commodity_ID){
        // 删除点赞
        clikesService.deleteByCommodityId(commodity_ID);
        // 删除收藏
        cfavoritesService.deleteByCommodityId(commodity_ID);
        // 删除评论
        ccommentsService.deleteByCommodityId(commodity_ID);

        // 删除自身
        commodityService.deleteCommodityById(commodity_ID);
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
        // 最后删除自身
        postService.deletePostById(post_ID);
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
            this.deletePostById(p.getId());
        }

        // 删除自身
        myuserService.deleteUserById(user_ID);
    }

    /**
     * 获取关注的人发表的帖子
     * @param user_ID
     * @return
     */
    public Object getFollowsPosts(String user_ID){
        List<String> follows = relationService.eGetAllFollows(user_ID);
        Map<String,Object> postsObject = new HashMap<>();
        // 将关注的人发表的帖子分别封装起来放入Map
        for (String s:follows){
            postsObject.put(s,this.encapsulatePost(postService.getPostByUserId(user_ID),user_ID));
        }

        return postsObject;
    }
}