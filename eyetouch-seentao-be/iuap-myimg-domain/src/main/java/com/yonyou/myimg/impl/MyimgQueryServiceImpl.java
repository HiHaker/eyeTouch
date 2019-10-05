package com.yonyou.myimg.impl;

import com.yonyou.myimg.api.MyimgQueryService;
import com.yonyou.myimg.dto.MyimgDTO;
import com.yonyou.myimg.po.Myimg;
import com.yonyou.myimg.service.MyimgService;
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
 * @date 2019-10-5 11:44:39
 */
@Service("com.yonyou.myimg.impl.MyimgQueryServiceImpl")
public class MyimgQueryServiceImpl implements MyimgQueryService {

    private MyimgService myimgService;

    @Autowired
    public void setMyimgService(MyimgService myimgService) {
        this.myimgService = myimgService;
    }


    @Override
    public List<MyimgDTO> listMyimg(SearchParams searchParams) {
        List<Myimg>  list = myimgService.queryList(searchParams);
        List<MyimgDTO> result = new ArrayList<>();
        if (list!=null){
            for (Myimg model:list){
                MyimgDTO dto = new MyimgDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
