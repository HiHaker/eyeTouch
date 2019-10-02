import request from "utils/request";


//定义接口地址
const URL = {
    "GET_cfavorites": `${GROBAL_HTTP_CTX}` + '/cfavorites/cfavorites/list', // 获取主表
    "SAVE_cfavorites": `${GROBAL_HTTP_CTX}` + '/cfavorites/cfavorites/insertSelective', // 保存主表
    "UPDATE_cfavorites": `${GROBAL_HTTP_CTX}` + '/cfavorites/cfavorites/updateSelective', // 更新主表
    "DEL_cfavorites": `${GROBAL_HTTP_CTX}` + '/cfavorites/cfavorites/deleteBatch', // 删除主表
    "GET_QUERYPRINTTEMPLATEALLOCATE": `/eiap-plus/appResAllocate/queryPrintTemplateAllocate`,  // 查询打印模板
    "PRINTSERVER": '/print_service/print/preview',                                              // 打印
}

/**
 * 获取主列表
 * @param {*} params
 */
export const getcfavorites = (param) => {
    return request(URL.GET_cfavorites, {
        method: "get",
        param
    });
}
/**
 * 保存主表数据
 * @param {*} params
 */
export const savecfavorites = (params) => {
    return request(URL.SAVE_cfavorites, {
        method: "post",
        data: params
    });
}
/**
 * 更新主表数据
 * @param {*} params
 */
export const updatecfavorites = (params) => {
    return request(URL.UPDATE_cfavorites, {
        method: "post",
        data: params
    });
}
/**
 * 删除主表数据
 * @param {*} params
 */
export const delcfavorites = (params) => {
    return request(URL.DEL_cfavorites, {
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
