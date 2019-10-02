package com.yonyou.plikes.impl;

import com.yonyou.plikes.api.PlikesQueryService;
import com.yonyou.plikes.dto.PlikesDTO;
import com.yonyou.plikes.po.Plikes;
import com.yonyou.plikes.service.PlikesService;
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
 * @date 2019-10-2 16:58:44
 */
@Service("com.yonyou.plikes.impl.PlikesQueryServiceImpl")
public class PlikesQueryServiceImpl implements PlikesQueryService {

    private PlikesService plikesService;

    @Autowired
    public void setPlikesService(PlikesService plikesService) {
        this.plikesService = plikesService;
    }


    @Override
    public List<PlikesDTO> listPlikes(SearchParams searchParams) {
        List<Plikes>  list = plikesService.queryList(searchParams);
        List<PlikesDTO> result = new ArrayList<>();
        if (list!=null){
            for (Plikes model:list){
                PlikesDTO dto = new PlikesDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
