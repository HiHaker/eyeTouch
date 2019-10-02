package com.yonyou.clikes.api;
import com.yonyou.clikes.dto.ClikesDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-10-2 17:53:56
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface ClikesQueryService {

    /**
     * 查询商品点赞列表
     */
    List<ClikesDTO> listClikes(SearchParams searchParams);

}
