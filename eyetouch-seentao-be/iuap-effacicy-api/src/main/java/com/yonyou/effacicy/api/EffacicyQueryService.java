package com.yonyou.effacicy.api;
import com.yonyou.effacicy.dto.EffacicyDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-26 10:26:51
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface EffacicyQueryService {

    /**
     * 查询商品功效列表
     */
    List<EffacicyDTO> listEffacicy(SearchParams searchParams);

}
