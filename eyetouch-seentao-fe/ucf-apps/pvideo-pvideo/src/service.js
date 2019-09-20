import request from "utils/request";


//定义接口地址
const URL = {
    "GET_pvideo": `${GROBAL_HTTP_CTX}` + '/pvideo/pvideo/list', // 获取主表
    "SAVE_pvideo": `${GROBAL_HTTP_CTX}` + '/pvideo/pvideo/insertSelective', // 保存主表
    "UPDATE_pvideo": `${GROBAL_HTTP_CTX}` + '/pvideo/pvideo/updateSelective', // 更新主表
    "DEL_pvideo": `${GROBAL_HTTP_CTX}` + '/pvideo/pvideo/deleteBatch', // 删除主表
    "GET_QUERYPRINTTEMPLATEALLOCATE": `/eiap-plus/appResAllocate/queryPrintTemplateAllocate`,  // 查询打印模板
    "PRINTSERVER": '/print_service/print/preview',                                              // 打印
}

/**
 * 获取主列表
 * @param {*} params
 */
export const getpvideo = (param) => {
    return request(URL.GET_pvideo, {
        method: "get",
        param
    });
}
/**
 * 保存主表数据
 * @param {*} params
 */
export const savepvideo = (params) => {
    return request(URL.SAVE_pvideo, {
        method: "post",
        data: params
    });
}
/**
 * 更新主表数据
 * @param {*} params
 */
export const updatepvideo = (params) => {
    return request(URL.UPDATE_pvideo, {
        method: "post",
        data: params
    });
}
/**
 * 删除主表数据
 * @param {*} params
 */
export const delpvideo = (params) => {
    return request(URL.DEL_pvideo, {
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