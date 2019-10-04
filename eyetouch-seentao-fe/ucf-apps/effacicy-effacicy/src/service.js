import request from "utils/request";


//定义接口地址
const URL = {
    "GET_effacicy": `${GROBAL_HTTP_CTX}` + '/effacicy/effacicy/list', // 获取主表
    "SAVE_effacicy": `${GROBAL_HTTP_CTX}` + '/effacicy/effacicy/insertSelective', // 保存主表
    "UPDATE_effacicy": `${GROBAL_HTTP_CTX}` + '/effacicy/effacicy/updateSelective', // 更新主表
    "DEL_effacicy": `${GROBAL_HTTP_CTX}` + '/effacicy/effacicy/deleteBatch', // 删除主表
    "GET_QUERYPRINTTEMPLATEALLOCATE": `/eiap-plus/appResAllocate/queryPrintTemplateAllocate`,  // 查询打印模板
    "PRINTSERVER": '/print_service/print/preview',                                              // 打印
}

/**
 * 获取主列表
 * @param {*} params
 */
export const geteffacicy = (param) => {
    return request(URL.GET_effacicy, {
        method: "get",
        param
    });
}
/**
 * 保存主表数据
 * @param {*} params
 */
export const saveeffacicy = (params) => {
    return request(URL.SAVE_effacicy, {
        method: "post",
        data: params
    });
}
/**
 * 更新主表数据
 * @param {*} params
 */
export const updateeffacicy = (params) => {
    return request(URL.UPDATE_effacicy, {
        method: "post",
        data: params
    });
}
/**
 * 删除主表数据
 * @param {*} params
 */
export const deleffacicy = (params) => {
    return request(URL.DEL_effacicy, {
        method: "post",
        data: params
    });
}


/**
 *
 * 查询打印模板
 * @param {*} params
 * @returns
 */
export const queryPrintTemplateAllocate = (params) => {
    return request(URL.GET_QUERYPRINTTEMPLATEALLOCATE, {
        method: "get",
        param: params
    });
}

export const printDocument = (params) => {
    let search = [];
    for (let key in params) {
        search.push(`${key}=${params[key]}`)
    }
    let exportUrl = `${URL.PRINTSERVER}?${search.join('&')}`;
    
    window.open(exportUrl);
}
