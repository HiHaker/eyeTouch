package com.yonyou.pcomments.impl;

import com.yonyou.pcomments.api.PcommentsQueryService;
import com.yonyou.pcomments.dto.PcommentsDTO;
import com.yonyou.pcomments.po.Pcomments;
import com.yonyou.pcomments.service.PcommentsService;
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
 * @date 2019-10-2 20:07:08
 */
@Service("com.yonyou.pcomments.impl.PcommentsQueryServiceImpl")
public class PcommentsQueryServiceImpl implements PcommentsQueryService {

    private PcommentsService pcommentsService;

    @Autowired
    public void setPcommentsService(PcommentsService pcommentsService) {
        this.pcommentsService = pcommentsService;
    }


    @Override
    public List<PcommentsDTO> listPcomments(SearchParams searchParams) {
        List<Pcomments>  list = pcommentsService.queryList(searchParams);
        List<PcommentsDTO> result = new ArrayList<>();
        if (list!=null){
            for (Pcomments model:list){
                PcommentsDTO dto = new PcommentsDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
