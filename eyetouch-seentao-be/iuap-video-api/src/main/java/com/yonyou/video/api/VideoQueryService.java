package com.yonyou.video.api;
import com.yonyou.video.dto.VideoDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-20 8:26:15
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface VideoQueryService {

    /**
     * 查询视频列表
     */
    List<VideoDTO> listVideo(SearchParams searchParams);

}
