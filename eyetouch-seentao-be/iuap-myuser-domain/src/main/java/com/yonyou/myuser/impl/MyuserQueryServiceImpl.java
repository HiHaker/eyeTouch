package com.yonyou.myuser.impl;

import com.yonyou.myuser.api.MyuserQueryService;
import com.yonyou.myuser.dto.MyuserDTO;
import com.yonyou.myuser.po.Myuser;
import com.yonyou.myuser.service.MyuserService;
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
 * @date 2019-9-29 21:10:19
 */
@Service("com.yonyou.myuser.impl.MyuserQueryServiceImpl")
public class MyuserQueryServiceImpl implements MyuserQueryService {

    private MyuserService myuserService;

    @Autowired
    public void setMyuserService(MyuserService myuserService) {
        this.myuserService = myuserService;
    }


    @Override
    public List<MyuserDTO> listMyuser(SearchParams searchParams) {
        List<Myuser>  list = myuserService.queryList(searchParams);
        List<MyuserDTO> result = new ArrayList<>();
        if (list!=null){
            for (Myuser model:list){
                MyuserDTO dto = new MyuserDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
