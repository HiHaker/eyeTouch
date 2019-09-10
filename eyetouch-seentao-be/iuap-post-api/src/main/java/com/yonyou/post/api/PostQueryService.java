package com.yonyou.post.api;
import com.yonyou.post.dto.PostDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-10 19:59:15
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface PostQueryService {

    /**
     * 查询帖子列表
     */
    List<PostDTO> listPost(SearchParams searchParams);

}
