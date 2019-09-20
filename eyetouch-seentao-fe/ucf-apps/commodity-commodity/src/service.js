import request from "utils/request";


//定义接口地址
const URL = {
    "GET_commodity": `${GROBAL_HTTP_CTX}` + '/commodity/commodity/list', // 获取主表
    "SAVE_commodity": `${GROBAL_HTTP_CTX}` + '/commodity/commodity/insertSelective', // 保存主表
    "UPDATE_commodity": `${GROBAL_HTTP_CTX}` + '/commodity/commodity/updateSelective', // 更新主表
    "DEL_commodity": `${GROBAL_HTTP_CTX}` + '/commodity/commodity/deleteBatch', // 删除主表
    "GET_QUERYPRINTTEMPLATEALLOCATE": `/eiap-plus/appResAllocate/queryPrintTemplateAllocate`,  // 查询打印模板
    "PRINTSERVER": '/print_service/print/preview',                                              // 打印
}

/**
 * 获取主列表
 * @param {*} params
 */
export const getcommodity = (param) => {
    return request(URL.GET_commodity, {
        method: "get",
        param
    });
}
/**
 * 保存主表数据
 * @param {*} params
 */
export const savecommodity = (params) => {
    return request(URL.SAVE_commodity, {
        method: "post",
        data: params
    });
}
/**
 * 更新主表数据
 * @param {*} params
 */
export const updatecommodity = (params) => {
    return request(URL.UPDATE_commodity, {
        method: "post",
        data: params
    });
}
/**
 * 删除主表数据
 * @param {*} params
 */
export const delcommodity = (params) => {
    return request(URL.DEL_commodity, {
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
