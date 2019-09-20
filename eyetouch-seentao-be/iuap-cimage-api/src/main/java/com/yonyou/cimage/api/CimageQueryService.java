package com.yonyou.cimage.api;
import com.yonyou.cimage.dto.CimageDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-20 11:17:57
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface CimageQueryService {

    /**
     * 查询商品图片列表
     */
    List<CimageDTO> listCimage(SearchParams searchParams);

}
