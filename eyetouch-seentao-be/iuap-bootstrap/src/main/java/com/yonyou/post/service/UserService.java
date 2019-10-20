package com.yonyou.post.service;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.ccomments.service.CcommentsService;
import com.yonyou.cfavorites.service.CfavoritesService;
import com.yonyou.clikes.service.ClikesService;
import com.yonyou.commodity.dto.CommodityDTO;
import com.yonyou.commodity.service.CommodityService;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
    CommodityService commodityService;
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

    // 时间模式
    private static final DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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
            followsList.add(myuserService.switchDTO(myuser));
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
            fansList.add(myuserService.switchDTO(myuser));
        }
        return fansList;
    }


    /**
     * 获取当日新增的用户数
     * @return
     */
    public Integer getNewUsers(){
        // 构造当日0点localdate对象
        String zeroDate = LocalDateTime.now().minusDays(1).format(datePattern);
        String zeroDateTimeString = zeroDate + " " + "00:00:00";
        LocalDateTime zeroDateTime = LocalDateTime.parse(zeroDateTimeString, dateTimePattern);
        String registerTime;
        Integer count = 0;
        List<Object> usersList = myuserService.getAllUsers();
        for (Object o:usersList){
            MyuserDTO md = (MyuserDTO)o;
            registerTime = md.getRegister_date();
            LocalDateTime registerDateTime = LocalDateTime.parse(registerTime, dateTimePattern);
            // 如果发帖时间在当日，就为当日新增
            if (ChronoUnit.DAYS.between(zeroDateTime, registerDateTime) == 1){
                count++;
            }
        }
        return count;
    }

    /**
     * 获取8日内新增的用户数
     * @return
     */
    public int[] getNewUsersForEightDays(){
        // 构造当日0点localdate对象
        String zeroDate = LocalDateTime.now().minusDays(1).format(datePattern);
        String zeroDate1 = LocalDateTime.now().minusDays(2).format(datePattern);
        String zeroDate2 = LocalDateTime.now().minusDays(3).format(datePattern);
        String zeroDate3 = LocalDateTime.now().minusDays(4).format(datePattern);
        String zeroDate4 = LocalDateTime.now().minusDays(5).format(datePattern);
        String zeroDate5 = LocalDateTime.now().minusDays(6).format(datePattern);
        String zeroDate6 = LocalDateTime.now().minusDays(7).format(datePattern);
        String zeroDate7 = LocalDateTime.now().minusDays(8).format(datePattern);

        String zeroDateTimeString = zeroDate + " " + "00:00:00";
        String zeroDateTimeString1 = zeroDate1 + " " + "00:00:00";
        String zeroDateTimeString2 = zeroDate2 + " " + "00:00:00";
        String zeroDateTimeString3 = zeroDate3 + " " + "00:00:00";
        String zeroDateTimeString4 = zeroDate4 + " " + "00:00:00";
        String zeroDateTimeString5 = zeroDate5 + " " + "00:00:00";
        String zeroDateTimeString6 = zeroDate6 + " " + "00:00:00";
        String zeroDateTimeString7 = zeroDate7 + " " + "00:00:00";

        LocalDateTime zeroDateTime = LocalDateTime.parse(zeroDateTimeString, dateTimePattern);
        LocalDateTime zeroDateTime1 = LocalDateTime.parse(zeroDateTimeString1, dateTimePattern);
        LocalDateTime zeroDateTime2 = LocalDateTime.parse(zeroDateTimeString2, dateTimePattern);
        LocalDateTime zeroDateTime3 = LocalDateTime.parse(zeroDateTimeString3, dateTimePattern);
        LocalDateTime zeroDateTime4 = LocalDateTime.parse(zeroDateTimeString4, dateTimePattern);
        LocalDateTime zeroDateTime5 = LocalDateTime.parse(zeroDateTimeString5, dateTimePattern);
        LocalDateTime zeroDateTime6 = LocalDateTime.parse(zeroDateTimeString6, dateTimePattern);
        LocalDateTime zeroDateTime7 = LocalDateTime.parse(zeroDateTimeString7, dateTimePattern);

        String registerTime;
        int[] count = new int[8];
        List<Object> usersList = myuserService.getAllUsers();
        for (Object o:usersList){
            MyuserDTO md = (MyuserDTO)o;
            registerTime = md.getRegister_date();
            LocalDateTime registerDateTime = LocalDateTime.parse(registerTime, dateTimePattern);
            // 如果发帖时间在当日，就为当日新增
            if (ChronoUnit.DAYS.between(zeroDateTime, registerDateTime) == 1){
                count[7]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime1, registerDateTime) == 1){
                count[6]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime2, registerDateTime) == 1){
                count[5]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime3, registerDateTime) == 1){
                count[4]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime4, registerDateTime) == 1){
                count[3]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime5, registerDateTime) == 1){
                count[2]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime6, registerDateTime) == 1){
                count[1]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime7, registerDateTime) == 1){
                count[0]++;
            }
        }
        return count;
    }

    /**
     * 获取当日新增的帖子数
     * @return
     */
    public Integer getNewPosts(){
        // 构造当日0点localdate对象
        String zeroDate = LocalDateTime.now().minusDays(1).format(datePattern);
        String zeroDateTimeString = zeroDate + " " + "00:00:00";
        LocalDateTime zeroDateTime = LocalDateTime.parse(zeroDateTimeString, dateTimePattern);
        String postTime;
        Integer count = 0;
        List<Object> postsList = postService.getAllPost();
        for (Object o:postsList){
            PostDTO pd = (PostDTO)o;
            postTime = pd.getTime();
            // 发帖的时间转换为localdate对象
            LocalDateTime postDateTime = LocalDateTime.parse(postTime, dateTimePattern);
            // 如果发帖时间在当日，就为当日新增
            if (ChronoUnit.DAYS.between(zeroDateTime, postDateTime) == 1){
                count++;
            }
        }
        return count;
    }

    /**
     * 获取8日内新增的帖子数
     * @return
     */
    public int[] getNewPostsForEightDays(){
        // 构造当日0点localdate对象
        String zeroDate = LocalDateTime.now().minusDays(1).format(datePattern);
        String zeroDate1 = LocalDateTime.now().minusDays(2).format(datePattern);
        String zeroDate2 = LocalDateTime.now().minusDays(3).format(datePattern);
        String zeroDate3 = LocalDateTime.now().minusDays(4).format(datePattern);
        String zeroDate4 = LocalDateTime.now().minusDays(5).format(datePattern);
        String zeroDate5 = LocalDateTime.now().minusDays(6).format(datePattern);
        String zeroDate6 = LocalDateTime.now().minusDays(7).format(datePattern);
        String zeroDate7 = LocalDateTime.now().minusDays(8).format(datePattern);

        String zeroDateTimeString = zeroDate + " " + "00:00:00";
        String zeroDateTimeString1 = zeroDate1 + " " + "00:00:00";
        String zeroDateTimeString2 = zeroDate2 + " " + "00:00:00";
        String zeroDateTimeString3 = zeroDate3 + " " + "00:00:00";
        String zeroDateTimeString4 = zeroDate4 + " " + "00:00:00";
        String zeroDateTimeString5 = zeroDate5 + " " + "00:00:00";
        String zeroDateTimeString6 = zeroDate6 + " " + "00:00:00";
        String zeroDateTimeString7 = zeroDate7 + " " + "00:00:00";

        LocalDateTime zeroDateTime = LocalDateTime.parse(zeroDateTimeString, dateTimePattern);
        LocalDateTime zeroDateTime1 = LocalDateTime.parse(zeroDateTimeString1, dateTimePattern);
        LocalDateTime zeroDateTime2 = LocalDateTime.parse(zeroDateTimeString2, dateTimePattern);
        LocalDateTime zeroDateTime3 = LocalDateTime.parse(zeroDateTimeString3, dateTimePattern);
        LocalDateTime zeroDateTime4 = LocalDateTime.parse(zeroDateTimeString4, dateTimePattern);
        LocalDateTime zeroDateTime5 = LocalDateTime.parse(zeroDateTimeString5, dateTimePattern);
        LocalDateTime zeroDateTime6 = LocalDateTime.parse(zeroDateTimeString6, dateTimePattern);
        LocalDateTime zeroDateTime7 = LocalDateTime.parse(zeroDateTimeString7, dateTimePattern);

        String postTime;
        int[] count = new int[8];
        List<Object> postsList = postService.getAllPost();
        for (Object o:postsList){
            PostDTO pd = (PostDTO)o;
            postTime = pd.getTime();
            // 发帖的时间转换为localdate对象
            LocalDateTime postDateTime = LocalDateTime.parse(postTime, dateTimePattern);
            // 如果发帖时间在当日，就为当日新增
            if (ChronoUnit.DAYS.between(zeroDateTime, postDateTime) == 1){
                count[7]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime1, postDateTime) == 1){
                count[6]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime2, postDateTime) == 1){
                count[5]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime3, postDateTime) == 1){
                count[4]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime4, postDateTime) == 1){
                count[3]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime5, postDateTime) == 1){
                count[2]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime6, postDateTime) == 1){
                count[1]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime7, postDateTime) == 1){
                count[0]++;
            }
        }
        return count;
    }

    /**
     * 获取当日新增的商品数
     * @return
     */
    public Integer getNewCommoditys(){
        // 构造当日0点localdate对象
        String zeroDate = LocalDateTime.now().minusDays(1).format(datePattern);
        String zeroDateTimeString = zeroDate + " " + "00:00:00";
        LocalDateTime zeroDateTime = LocalDateTime.parse(zeroDateTimeString, dateTimePattern);
        String publishTime;
        Integer count = 0;
        List<Object> commodityList = commodityService.getAllCommodity();
        for (Object o:commodityList){
            CommodityDTO cd = (CommodityDTO)o;
            publishTime = cd.getCreateTime();
            // 发帖的时间转换为localdate对象
            LocalDateTime publishDateTime = LocalDateTime.parse(publishTime, dateTimePattern);
            // 如果发帖时间在当日，就为当日新增
            if (ChronoUnit.DAYS.between(zeroDateTime, publishDateTime) == 1){
                count++;
            }
        }
        return count;
    }

    /**
     * 获取8日内新增的商品数
     * @return
     */
    public int[] getNewCommoditysForEightDays(){
        // 构造当日0点localdate对象
        String zeroDate = LocalDateTime.now().minusDays(1).format(datePattern);
        String zeroDate1 = LocalDateTime.now().minusDays(2).format(datePattern);
        String zeroDate2 = LocalDateTime.now().minusDays(3).format(datePattern);
        String zeroDate3 = LocalDateTime.now().minusDays(4).format(datePattern);
        String zeroDate4 = LocalDateTime.now().minusDays(5).format(datePattern);
        String zeroDate5 = LocalDateTime.now().minusDays(6).format(datePattern);
        String zeroDate6 = LocalDateTime.now().minusDays(7).format(datePattern);
        String zeroDate7 = LocalDateTime.now().minusDays(8).format(datePattern);

        String zeroDateTimeString = zeroDate + " " + "00:00:00";
        String zeroDateTimeString1 = zeroDate1 + " " + "00:00:00";
        String zeroDateTimeString2 = zeroDate2 + " " + "00:00:00";
        String zeroDateTimeString3 = zeroDate3 + " " + "00:00:00";
        String zeroDateTimeString4 = zeroDate4 + " " + "00:00:00";
        String zeroDateTimeString5 = zeroDate5 + " " + "00:00:00";
        String zeroDateTimeString6 = zeroDate6 + " " + "00:00:00";
        String zeroDateTimeString7 = zeroDate7 + " " + "00:00:00";

        LocalDateTime zeroDateTime = LocalDateTime.parse(zeroDateTimeString, dateTimePattern);
        LocalDateTime zeroDateTime1 = LocalDateTime.parse(zeroDateTimeString1, dateTimePattern);
        LocalDateTime zeroDateTime2 = LocalDateTime.parse(zeroDateTimeString2, dateTimePattern);
        LocalDateTime zeroDateTime3 = LocalDateTime.parse(zeroDateTimeString3, dateTimePattern);
        LocalDateTime zeroDateTime4 = LocalDateTime.parse(zeroDateTimeString4, dateTimePattern);
        LocalDateTime zeroDateTime5 = LocalDateTime.parse(zeroDateTimeString5, dateTimePattern);
        LocalDateTime zeroDateTime6 = LocalDateTime.parse(zeroDateTimeString6, dateTimePattern);
        LocalDateTime zeroDateTime7 = LocalDateTime.parse(zeroDateTimeString7, dateTimePattern);

        String publishTime;
        int[] count = new int[8];
        List<Object> commodityList = commodityService.getAllCommodity();
        for (Object o:commodityList){
            CommodityDTO cd = (CommodityDTO)o;
            publishTime = cd.getCreateTime();
            // 发帖的时间转换为localdate对象
            LocalDateTime publishDateTime = LocalDateTime.parse(publishTime, dateTimePattern);
            // 如果发帖时间在当日，就为当日新增
            if (ChronoUnit.DAYS.between(zeroDateTime, publishDateTime) == 1){
                count[7]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime1, publishDateTime) == 1){
                count[6]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime2, publishDateTime) == 1){
                count[5]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime3, publishDateTime) == 1){
                count[4]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime4, publishDateTime) == 1){
                count[3]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime5, publishDateTime) == 1){
                count[2]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime6, publishDateTime) == 1){
                count[1]++;
            } else if (ChronoUnit.DAYS.between(zeroDateTime7, publishDateTime) == 1){
                count[0]++;
            }
        }
        return count;
    }
}
