package com.yonyou.pimage.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.pimage.po.Pimage;
import org.apache.ibatis.annotations.Delete;

@MyBatisRepository("com.yonyou.pimage.dao.PimageMapper")
public interface PimageMapper extends BaseDAO<Pimage,String> {
//    @Select({"select id, promotion_ratio as promotionRatio, promotion_fee as promotionFee,promotion_id as promotionId from temp_member_promotion_recall" +
//            " where game_id=#{gameId} and team_id = #{teamId} and game_level = #{gameLevel} order by create_date DESC LIMIT 1 " })
//    TempMemberPromotionRecall selectLatestOne(@Param("gameId") String gameId, @Param("teamId") String teamId, @Param("gameLevel") Integer gameLevel);

}