package com.yonyou.user.impl;

import com.yonyou.user.api.UserQueryService;
import com.yonyou.user.dto.UserDTO;
import com.yonyou.user.po.User;
import com.yonyou.user.service.UserService;
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
 * @date 2019-9-29 11:51:37
 */
@Service("com.yonyou.user.impl.UserQueryServiceImpl")
public class UserQueryServiceImpl implements UserQueryService {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public List<UserDTO> listUser(SearchParams searchParams) {
        List<User>  list = userService.queryList(searchParams);
        List<UserDTO> result = new ArrayList<>();
        if (list!=null){
            for (User model:list){
                UserDTO dto = new UserDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
