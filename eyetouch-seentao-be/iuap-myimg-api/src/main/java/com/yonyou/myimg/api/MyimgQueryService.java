package com.yonyou.myimg.api;
import com.yonyou.myimg.dto.MyimgDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-10-5 11:43:16
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface MyimgQueryService {

    /**
     * 查询迁移图片列表
     */
    List<MyimgDTO> listMyimg(SearchParams searchParams);

}
