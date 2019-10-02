package com.yonyou.pcomments.api;
import com.yonyou.pcomments.dto.PcommentsDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-10-2 17:37:32
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface PcommentsQueryService {

    /**
     * 查询帖子评论列表
     */
    List<PcommentsDTO> listPcomments(SearchParams searchParams);

}
