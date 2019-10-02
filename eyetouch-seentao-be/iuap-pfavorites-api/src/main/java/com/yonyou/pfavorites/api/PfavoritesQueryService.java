package com.yonyou.pfavorites.api;
import com.yonyou.pfavorites.dto.PfavoritesDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-10-2 17:20:02
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface PfavoritesQueryService {

    /**
     * 查询帖子收藏列表
     */
    List<PfavoritesDTO> listPfavorites(SearchParams searchParams);

}
