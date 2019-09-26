package com.yonyou.pimage.impl;

import com.yonyou.pimage.api.PimageQueryService;
import com.yonyou.pimage.dto.PimageDTO;
import com.yonyou.pimage.po.Pimage;
import com.yonyou.pimage.service.PimageService;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.iuap.ucf.dao.support.SqlParam;
import com.yonyou.post.api.PostQueryService;
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
 * @date 2019-9-12 10:58:51
 */
@Service("com.yonyou.pimage.impl.PimageQueryServiceImpl")
public class PimageQueryServiceImpl implements PimageQueryService {

    private PimageService pimageService;

    @Autowired
    private PostQueryService postQueryService;

    @Autowired
    public void setPimageService(PimageService pimageService) {
        this.pimageService = pimageService;
    }

    @Override
    public List<PimageDTO> listPimage(SearchParams searchParams) {
        List<Pimage>  list = pimageService.queryList(searchParams);
        List<PimageDTO> result = new ArrayList<>();
        if (list!=null){
            for (Pimage model:list){
                PimageDTO dto = new PimageDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }
}