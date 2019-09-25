package com.yonyou.cbrand.impl;

import com.yonyou.cbrand.api.CbrandQueryService;
import com.yonyou.cbrand.dto.CbrandDTO;
import com.yonyou.cbrand.po.Cbrand;
import com.yonyou.cbrand.service.CbrandService;
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
 * @date 2019-9-25 20:55:32
 */
@Service("com.yonyou.cbrand.impl.CbrandQueryServiceImpl")
public class CbrandQueryServiceImpl implements CbrandQueryService {

    private CbrandService cbrandService;

    @Autowired
    public void setCbrandService(CbrandService cbrandService) {
        this.cbrandService = cbrandService;
    }


    @Override
    public List<CbrandDTO> listCbrand(SearchParams searchParams) {
        List<Cbrand>  list = cbrandService.queryList(searchParams);
        List<CbrandDTO> result = new ArrayList<>();
        if (list!=null){
            for (Cbrand model:list){
                CbrandDTO dto = new CbrandDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
