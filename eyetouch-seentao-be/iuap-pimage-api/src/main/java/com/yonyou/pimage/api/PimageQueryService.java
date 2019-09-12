package com.yonyou.pimage.api;
import com.yonyou.pimage.dto.PimageDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-12 10:33:41
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface PimageQueryService {

    /**
     * 查询帖子图片列表
     */
    List<PimageDTO> listPimage(SearchParams searchParams);

}
