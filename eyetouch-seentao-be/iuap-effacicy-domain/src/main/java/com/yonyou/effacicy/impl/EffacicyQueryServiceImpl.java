package com.yonyou.effacicy.impl;

import com.yonyou.effacicy.api.EffacicyQueryService;
import com.yonyou.effacicy.dto.EffacicyDTO;
import com.yonyou.effacicy.po.Effacicy;
import com.yonyou.effacicy.service.EffacicyService;
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
 * @date 2019-9-26 10:26:51
 */
@Service("com.yonyou.effacicy.impl.EffacicyQueryServiceImpl")
public class EffacicyQueryServiceImpl implements EffacicyQueryService {

    private EffacicyService effacicyService;

    @Autowired
    public void setEffacicyService(EffacicyService effacicyService) {
        this.effacicyService = effacicyService;
    }


    @Override
    public List<EffacicyDTO> listEffacicy(SearchParams searchParams) {
        List<Effacicy>  list = effacicyService.queryList(searchParams);
        List<EffacicyDTO> result = new ArrayList<>();
        if (list!=null){
            for (Effacicy model:list){
                EffacicyDTO dto = new EffacicyDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
