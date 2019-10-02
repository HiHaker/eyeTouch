import request from "utils/request";


//定义接口地址
const URL = {
    "GET_plikes": `${GROBAL_HTTP_CTX}` + '/plikes/plikes/list', // 获取主表
    "SAVE_plikes": `${GROBAL_HTTP_CTX}` + '/plikes/plikes/insertSelective', // 保存主表
    "UPDATE_plikes": `${GROBAL_HTTP_CTX}` + '/plikes/plikes/updateSelective', // 更新主表
    "DEL_plikes": `${GROBAL_HTTP_CTX}` + '/plikes/plikes/deleteBatch', // 删除主表
    "GET_QUERYPRINTTEMPLATEALLOCATE": `/eiap-plus/appResAllocate/queryPrintTemplateAllocate`,  // 查询打印模板
    "PRINTSERVER": '/print_service/print/preview',                                              // 打印
}

/**
 * 获取主列表
 * @param {*} params
 */
export const getplikes = (param) => {
    return request(URL.GET_plikes, {
        method: "get",
        param
    });
}
/**
 * 保存主表数据
 * @param {*} params
 */
export const saveplikes = (params) => {
    return request(URL.SAVE_plikes, {
        method: "post",
        data: params
    });
}
/**
 * 更新主表数据
 * @param {*} params
 */
export const updateplikes = (params) => {
    return request(URL.UPDATE_plikes, {
        method: "post",
        data: params
    });
}
/**
 * 删除主表数据
 * @param {*} params
 */
export const delplikes = (params) => {
    return request(URL.DEL_plikes, {
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
