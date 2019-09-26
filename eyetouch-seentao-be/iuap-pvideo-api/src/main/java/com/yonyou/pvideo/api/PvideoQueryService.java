package com.yonyou.pvideo.api;
import com.yonyou.pvideo.dto.PvideoDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-20 8:47:16
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface PvideoQueryService {

    /**
     * 查询帖子视频列表
     */
    List<PvideoDTO> listPvideo(SearchParams searchParams);

}
