package com.yonyou.user.api;
import com.yonyou.user.dto.UserDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-29 11:51:37
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface UserQueryService {

    /**
     * 查询用户列表
     */
    List<UserDTO> listUser(SearchParams searchParams);

}
