package com.yonyou.cfavorites.api;
import com.yonyou.cfavorites.dto.CfavoritesDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-10-2 18:16:06
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface CfavoritesQueryService {

    /**
     * 查询商品收藏列表
     */
    List<CfavoritesDTO> listCfavorites(SearchParams searchParams);

}
