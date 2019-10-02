package com.yonyou.ccomments.impl;

import com.yonyou.ccomments.api.CcommentsQueryService;
import com.yonyou.ccomments.dto.CcommentsDTO;
import com.yonyou.ccomments.po.Ccomments;
import com.yonyou.ccomments.service.CcommentsService;
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
 * @date 2019-10-2 20:20:07
 */
@Service("com.yonyou.ccomments.impl.CcommentsQueryServiceImpl")
public class CcommentsQueryServiceImpl implements CcommentsQueryService {

    private CcommentsService ccommentsService;

    @Autowired
    public void setCcommentsService(CcommentsService ccommentsService) {
        this.ccommentsService = ccommentsService;
    }


    @Override
    public List<CcommentsDTO> listCcomments(SearchParams searchParams) {
        List<Ccomments>  list = ccommentsService.queryList(searchParams);
        List<CcommentsDTO> result = new ArrayList<>();
        if (list!=null){
            for (Ccomments model:list){
                CcommentsDTO dto = new CcommentsDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
