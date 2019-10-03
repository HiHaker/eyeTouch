package com.yonyou.plikes.service;
import java.util.ArrayList;
import java.util.List;

import com.yonyou.plikes.api.PlikesQueryService;
import com.yonyou.plikes.dto.PlikesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.plikes.dao.PlikesMapper;
import com.yonyou.plikes.po.Plikes;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.plikes.service.PlikesService")
public class PlikesService extends GenericAssoService<Plikes,String>{

    private PlikesMapper plikesMapper;

    @Autowired
    PlikesQueryService plikesQueryService;

    @Autowired
    public void setPlikesMapper(PlikesMapper plikesMapper) {
        this.plikesMapper = plikesMapper;
        super.setGenericMapper(plikesMapper);
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
     * 根据用户id和帖子的id删除记录
     * @param user_ID
     * @param post_ID
     */
   public void deleteByUserIdAndPostId(String user_ID, String post_ID){
       com.yonyou.plikes.dto.SimpleSearchDTO plikesSimpleDto = new
               com.yonyou.plikes.dto.SimpleSearchDTO();
       plikesSimpleDto.setSearch_uid(user_ID);
       plikesSimpleDto.setSearch_pid(post_ID);
       List deleteList = plikesQueryService.listPlikes(plikesSimpleDto.toSearchParams(Plikes.class));
       List<String> records = new ArrayList<>();
       for (Object o:deleteList){
           // 进行强制类型转换
           PlikesDTO record = (PlikesDTO)o;
           records.add(record.getId());
       }
       plikesMapper.deleteByIds(records);
   }

    /**
     * 根据帖子的id，得到点赞这条贴子的全部用户
     * @param post_ID
     * @return
     */
    public Object getAllUsers(String post_ID){
        com.yonyou.plikes.dto.SimpleSearchDTO plikesSimpleDto = new
                com.yonyou.plikes.dto.SimpleSearchDTO();
        plikesSimpleDto.setSearch_pid(post_ID);
        List usersList = plikesQueryService.listPlikes(plikesSimpleDto.toSearchParams(Plikes.class));
        return usersList;
    }

    /**
     * 根据用户的id，得到其点赞的全部帖子
     * @param user_ID
     * @return
     */
    public Object getAllPosts(String user_ID){
        com.yonyou.plikes.dto.SimpleSearchDTO plikesSimpleDto = new
                com.yonyou.plikes.dto.SimpleSearchDTO();
        plikesSimpleDto.setSearch_uid(user_ID);
        List postsList = plikesQueryService.listPlikes(plikesSimpleDto.toSearchParams(Plikes.class));
        return postsList;
    }

}