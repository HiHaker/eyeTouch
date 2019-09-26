package com.yonyou.ctype.api;
import com.yonyou.ctype.dto.CtypeDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-26 10:19:47
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface CtypeQueryService {

    /**
     * 查询商品类型列表
     */
    List<CtypeDTO> listCtype(SearchParams searchParams);

}
