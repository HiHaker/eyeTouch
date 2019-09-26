package com.yonyou.pvideo.impl;

import com.yonyou.pvideo.api.PvideoQueryService;
import com.yonyou.pvideo.dto.PvideoDTO;
import com.yonyou.pvideo.po.Pvideo;
import com.yonyou.pvideo.service.PvideoService;
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
 * @date 2019-9-20 8:47:16
 */
@Service("com.yonyou.pvideo.impl.PvideoQueryServiceImpl")
public class PvideoQueryServiceImpl implements PvideoQueryService {

    private PvideoService pvideoService;

    @Autowired
    public void setPvideoService(PvideoService pvideoService) {
        this.pvideoService = pvideoService;
    }


    @Override
    public List<PvideoDTO> listPvideo(SearchParams searchParams) {
        List<Pvideo>  list = pvideoService.queryList(searchParams);
        List<PvideoDTO> result = new ArrayList<>();
        if (list!=null){
            for (Pvideo model:list){
                PvideoDTO dto = new PvideoDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
