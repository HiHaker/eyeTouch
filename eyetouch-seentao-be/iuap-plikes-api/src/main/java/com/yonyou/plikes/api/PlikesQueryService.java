package com.yonyou.plikes.api;
import com.yonyou.plikes.dto.PlikesDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-10-2 16:58:44
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface PlikesQueryService {

    /**
     * 查询帖子点赞列表
     */
    List<PlikesDTO> listPlikes(SearchParams searchParams);

}
