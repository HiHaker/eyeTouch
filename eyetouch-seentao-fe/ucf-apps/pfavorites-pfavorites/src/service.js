import request from "utils/request";


//定义接口地址
const URL = {
    "GET_pfavorites": `${GROBAL_HTTP_CTX}` + '/pfavorites/pfavorites/list', // 获取主表
    "SAVE_pfavorites": `${GROBAL_HTTP_CTX}` + '/pfavorites/pfavorites/insertSelective', // 保存主表
    "UPDATE_pfavorites": `${GROBAL_HTTP_CTX}` + '/pfavorites/pfavorites/updateSelective', // 更新主表
    "DEL_pfavorites": `${GROBAL_HTTP_CTX}` + '/pfavorites/pfavorites/deleteBatch', // 删除主表
    "GET_QUERYPRINTTEMPLATEALLOCATE": `/eiap-plus/appResAllocate/queryPrintTemplateAllocate`,  // 查询打印模板
    "PRINTSERVER": '/print_service/print/preview',                                              // 打印
}

/**
 * 获取主列表
 * @param {*} params
 */
export const getpfavorites = (param) => {
    return request(URL.GET_pfavorites, {
        method: "get",
        param
    });
}
/**
 * 保存主表数据
 * @param {*} params
 */
export const savepfavorites = (params) => {
    return request(URL.SAVE_pfavorites, {
        method: "post",
        data: params
    });
}
/**
 * 更新主表数据
 * @param {*} params
 */
export const updatepfavorites = (params) => {
    return request(URL.UPDATE_pfavorites, {
        method: "post",
        data: params
    });
}
/**
 * 删除主表数据
 * @param {*} params
 */
export const delpfavorites = (params) => {
    return request(URL.DEL_pfavorites, {
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
