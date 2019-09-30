package com.yonyou.relation.api;
import com.yonyou.relation.dto.RelationDTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-30 9:09:38
 */
@RemoteCall("iuap-eyetouch-seentao-server")
public interface RelationQueryService {

    /**
     * 查询用户关系列表
     */
    List<RelationDTO> listRelation(SearchParams searchParams);

}
