package com.yonyou.clikes.impl;

import com.yonyou.clikes.api.ClikesQueryService;
import com.yonyou.clikes.dto.ClikesDTO;
import com.yonyou.clikes.po.Clikes;
import com.yonyou.clikes.service.ClikesService;
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
 * @date 2019-10-2 17:53:56
 */
@Service("com.yonyou.clikes.impl.ClikesQueryServiceImpl")
public class ClikesQueryServiceImpl implements ClikesQueryService {

    private ClikesService clikesService;

    @Autowired
    public void setClikesService(ClikesService clikesService) {
        this.clikesService = clikesService;
    }


    @Override
    public List<ClikesDTO> listClikes(SearchParams searchParams) {
        List<Clikes>  list = clikesService.queryList(searchParams);
        List<ClikesDTO> result = new ArrayList<>();
        if (list!=null){
            for (Clikes model:list){
                ClikesDTO dto = new ClikesDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
