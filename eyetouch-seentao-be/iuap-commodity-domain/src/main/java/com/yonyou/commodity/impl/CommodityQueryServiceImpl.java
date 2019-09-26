package com.yonyou.commodity.impl;

import com.yonyou.commodity.api.CommodityQueryService;
import com.yonyou.commodity.dto.CommodityDTO;
import com.yonyou.commodity.po.Commodity;
import com.yonyou.commodity.service.CommodityService;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.iuap.ucf.dao.support.SqlParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RPC provider端
 * @author  
 * @date 2019-9-20 9:52:27
 */
@Service("com.yonyou.commodity.impl.CommodityQueryServiceImpl")
public class CommodityQueryServiceImpl implements CommodityQueryService {

    private CommodityService commodityService;

    @Autowired
    public void setCommodityService(CommodityService commodityService) {
        this.commodityService = commodityService;
    }


    @Override
    public List<CommodityDTO> listCommodity(SearchParams searchParams) {
        List<Commodity>  list = commodityService.queryList(searchParams);
        List<CommodityDTO> result = new ArrayList<>();
        if (list!=null){
            for (Commodity model:list){
                CommodityDTO dto = new CommodityDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
