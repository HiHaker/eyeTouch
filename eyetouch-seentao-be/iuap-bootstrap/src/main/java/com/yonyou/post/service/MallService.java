package com.yonyou.post.service;

import com.yonyou.cbrand.service.CbrandService;
import com.yonyou.ccomments.dto.CcommentsDTO;
import com.yonyou.ccomments.service.CcommentsService;
import com.yonyou.cfavorites.dto.CfavoritesDTO;
import com.yonyou.cfavorites.service.CfavoritesService;
import com.yonyou.cimage.service.CimageService;
import com.yonyou.clikes.service.ClikesService;
import com.yonyou.commodity.dto.CommodityDTO;
import com.yonyou.commodity.service.CommodityService;
import com.yonyou.ctype.service.CtypeService;
import com.yonyou.effacicy.service.EffacicyService;
import com.yonyou.myuser.service.MyuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2019/10/16 0016
 * BY Jianlong
 */
@Service
public class MallService {

    @Autowired
    CommodityService commodityService;
    @Autowired
    MyuserService myuserService;
    @Autowired
    CimageService cimageService;
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
     * 判断当前用户是否点赞了商品
     * @param user_ID
     * @param commodity_ID
     * @return
     */
    public boolean eIfLikesC(String user_ID, String commodity_ID){
        if (clikesService.getByUserIdAndCommodityId(user_ID, commodity_ID).size() == 0){
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
        if (cfavoritesService.getByUserIdAndCommodityId(user_ID, commodity_ID).size() == 0){
            return false;
        } else{
            return true;
        }
    }

    /**
     * 将查询到的商品封装成前端需要的格式（用户登录状态下）
     * @param commodity
     * @param user_ID
     * @return
     */
    public List<Object> encapsulateCommodityLogin(List<Object> commodity, String user_ID){
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
            // 商品价格
            commodityObject.put("price",c.getPrice());
            // 商品品牌
            commodityObject.put("brand",cbrandService.getAssoVo(c.getBrand()).getEntity().getName());
            // 商品功效
            commodityObject.put("effacicy",effacicyService.getAssoVo(c.getEffacicy()).getEntity().getName());
            // 商品类型
            commodityObject.put("type",ctypeService.getAssoVo(c.getType()).getEntity().getName());
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
     * 将查询到的商品封装成前端需要的格式（访客模式）
     * @param commodity
     * @return
     */
    public List<Object> encapsulateCommodity(List<Object> commodity){
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
            // 商品价格
            commodityObject.put("price",c.getPrice());
            // 商品品牌
            commodityObject.put("brand",cbrandService.getAssoVo(c.getBrand()).getEntity().getName());
            // 商品功效
            commodityObject.put("effacicy",effacicyService.getAssoVo(c.getEffacicy()).getEntity().getName());
            // 商品类型
            commodityObject.put("type",ctypeService.getAssoVo(c.getType()).getEntity().getName());
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
     * 获取所有的模糊查询帖子
     */
    public List<Object> getAllCommodityLikeSearch(String keyword){
        List<Object> commodityList = commodityService.getCommodityByNameAndContent(keyword,keyword);
        List<String> idList = commodityService.eGetIdsList(commodityList);

        List<Object> queryList1 = commodityService.getCommodityByNameAndContent(keyword, "");
        for (Object o:queryList1){
            CommodityDTO cd = (CommodityDTO)o;
            if (!idList.contains(cd.getId())){
                commodityList.add(cd);
            }
        }
        idList = commodityService.eGetIdsList(commodityList);
        List<Object> queryList2 = commodityService.getCommodityByNameAndContent("", keyword);
        for (Object o:queryList2){
            CommodityDTO cd = (CommodityDTO)o;
            if (!idList.contains(cd.getId())){
                commodityList.add(cd);
            }
        }

        return commodityList;
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
     * 得到用户收藏的所有商品
     * @param user_ID
     * @return
     */
    public List<Object> getAllCommodityFavorites(String user_ID){
        List<Object> favoritesList = cfavoritesService.getAllCommodityByUserId(user_ID);
        List<Object> commodityList = new ArrayList<>();

        for (Object o:favoritesList){
            CfavoritesDTO cd = (CfavoritesDTO)o;
            commodityList.add(commodityService.switchDTO(commodityService.getAssoVo(cd.getCid()).getEntity()));
        }

        return commodityList;
    }
}
