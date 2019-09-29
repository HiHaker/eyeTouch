package com.yonyou.myuser.api;
import com.yonyou.myuser.dto.MyuserDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-29 21:10:18
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface MyuserQueryService {

    /**
     * 查询平台用户列表
     */
    List<MyuserDTO> listMyuser(SearchParams searchParams);

}
