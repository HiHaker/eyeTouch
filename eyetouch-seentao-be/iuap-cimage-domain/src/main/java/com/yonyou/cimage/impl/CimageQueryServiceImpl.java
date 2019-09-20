package com.yonyou.cimage.impl;

import com.yonyou.cimage.api.CimageQueryService;
import com.yonyou.cimage.dto.CimageDTO;
import com.yonyou.cimage.po.Cimage;
import com.yonyou.cimage.service.CimageService;
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
 * @date 2019-9-20 11:17:57
 */
@Service("com.yonyou.cimage.impl.CimageQueryServiceImpl")
public class CimageQueryServiceImpl implements CimageQueryService {

    private CimageService cimageService;

    @Autowired
    public void setCimageService(CimageService cimageService) {
        this.cimageService = cimageService;
    }


    @Override
    public List<CimageDTO> listCimage(SearchParams searchParams) {
        List<Cimage>  list = cimageService.queryList(searchParams);
        List<CimageDTO> result = new ArrayList<>();
        if (list!=null){
            for (Cimage model:list){
                CimageDTO dto = new CimageDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
