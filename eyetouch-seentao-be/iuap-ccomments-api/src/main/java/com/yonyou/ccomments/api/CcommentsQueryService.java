package com.yonyou.ccomments.api;
import com.yonyou.ccomments.dto.CcommentsDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-10-2 20:20:07
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface CcommentsQueryService {

    /**
     * 查询商品评论列表
     */
    List<CcommentsDTO> listCcomments(SearchParams searchParams);

}
