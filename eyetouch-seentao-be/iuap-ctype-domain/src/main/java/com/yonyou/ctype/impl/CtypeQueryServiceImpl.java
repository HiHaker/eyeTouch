package com.yonyou.ctype.impl;

import com.yonyou.ctype.api.CtypeQueryService;
import com.yonyou.ctype.dto.CtypeDTO;
import com.yonyou.ctype.po.Ctype;
import com.yonyou.ctype.service.CtypeService;
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
 * @date 2019-9-26 10:19:47
 */
@Service("com.yonyou.ctype.impl.CtypeQueryServiceImpl")
public class CtypeQueryServiceImpl implements CtypeQueryService {

    private CtypeService ctypeService;

    @Autowired
    public void setCtypeService(CtypeService ctypeService) {
        this.ctypeService = ctypeService;
    }


    @Override
    public List<CtypeDTO> listCtype(SearchParams searchParams) {
        List<Ctype>  list = ctypeService.queryList(searchParams);
        List<CtypeDTO> result = new ArrayList<>();
        if (list!=null){
            for (Ctype model:list){
                CtypeDTO dto = new CtypeDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
