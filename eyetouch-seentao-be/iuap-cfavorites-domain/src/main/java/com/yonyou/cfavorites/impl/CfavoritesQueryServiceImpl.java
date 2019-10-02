package com.yonyou.cfavorites.impl;

import com.yonyou.cfavorites.api.CfavoritesQueryService;
import com.yonyou.cfavorites.dto.CfavoritesDTO;
import com.yonyou.cfavorites.po.Cfavorites;
import com.yonyou.cfavorites.service.CfavoritesService;
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
 * @date 2019-10-2 18:16:06
 */
@Service("com.yonyou.cfavorites.impl.CfavoritesQueryServiceImpl")
public class CfavoritesQueryServiceImpl implements CfavoritesQueryService {

    private CfavoritesService cfavoritesService;

    @Autowired
    public void setCfavoritesService(CfavoritesService cfavoritesService) {
        this.cfavoritesService = cfavoritesService;
    }


    @Override
    public List<CfavoritesDTO> listCfavorites(SearchParams searchParams) {
        List<Cfavorites>  list = cfavoritesService.queryList(searchParams);
        List<CfavoritesDTO> result = new ArrayList<>();
        if (list!=null){
            for (Cfavorites model:list){
                CfavoritesDTO dto = new CfavoritesDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
