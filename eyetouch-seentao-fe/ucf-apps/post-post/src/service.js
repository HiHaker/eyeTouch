import request from "utils/request";


//定义接口地址
const URL = {
    "GET_post": `${GROBAL_HTTP_CTX}` + '/post/post/list', // 获取主表
    "SAVE_post": `${GROBAL_HTTP_CTX}` + '/post/post/insertSelective', // 保存主表
    "UPDATE_post": `${GROBAL_HTTP_CTX}` + '/post/post/updateSelective', // 更新主表
    "DEL_post": `${GROBAL_HTTP_CTX}` + '/post/post/deleteBatch', // 删除主表
    "GET_QUERYPRINTTEMPLATEALLOCATE": `/eiap-plus/appResAllocate/queryPrintTemplateAllocate`,  // 查询打印模板
    "PRINTSERVER": '/print_service/print/preview',                                              // 打印
}

/**
 * 获取主列表
 * @param {*} params
 */
export const getpost = (param) => {
    return request(URL.GET_post, {
        method: "get",
        param
    });
}
/**
 * 保存主表数据
 * @param {*} params
 */
export const savepost = (params) => {
    return request(URL.SAVE_post, {
        method: "post",
        data: params
    });
}
/**
 * 更新主表数据
 * @param {*} params
 */
export const updatepost = (params) => {
    return request(URL.UPDATE_post, {
        method: "post",
        data: params
    });
}
/**
 * 删除主表数据
 * @param {*} params
 */
export const delpost = (params) => {
    return request(URL.DEL_post, {
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
