package com.yonyou.commodity.api;
import com.yonyou.commodity.dto.CommodityDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-10-8 17:00:35
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface CommodityQueryService {

    /**
     * 查询商品列表
     */
    List<CommodityDTO> listCommodity(SearchParams searchParams);

}
