package com.yonyou.cbrand.api;
import com.yonyou.cbrand.dto.CbrandDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-25 21:04:26
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface CbrandQueryService {

    /**
     * 查询商品品牌列表
     */
    List<CbrandDTO> listCbrand(SearchParams searchParams);

}
