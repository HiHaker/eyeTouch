package com.yonyou.pfavorites.impl;

import com.yonyou.pfavorites.api.PfavoritesQueryService;
import com.yonyou.pfavorites.dto.PfavoritesDTO;
import com.yonyou.pfavorites.po.Pfavorites;
import com.yonyou.pfavorites.service.PfavoritesService;
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
 * @date 2019-10-2 17:20:02
 */
@Service("com.yonyou.pfavorites.impl.PfavoritesQueryServiceImpl")
public class PfavoritesQueryServiceImpl implements PfavoritesQueryService {

    private PfavoritesService pfavoritesService;

    @Autowired
    public void setPfavoritesService(PfavoritesService pfavoritesService) {
        this.pfavoritesService = pfavoritesService;
    }


    @Override
    public List<PfavoritesDTO> listPfavorites(SearchParams searchParams) {
        List<Pfavorites>  list = pfavoritesService.queryList(searchParams);
        List<PfavoritesDTO> result = new ArrayList<>();
        if (list!=null){
            for (Pfavorites model:list){
                PfavoritesDTO dto = new PfavoritesDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
