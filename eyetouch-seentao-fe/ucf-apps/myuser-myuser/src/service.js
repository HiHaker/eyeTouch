import request from "utils/request";


//定义接口地址
const URL = {
    "GET_myuser": `${GROBAL_HTTP_CTX}` + '/myuser/myuser/list', // 获取主表
    "SAVE_myuser": `${GROBAL_HTTP_CTX}` + '/myuser/myuser/insertSelective', // 保存主表
    "UPDATE_myuser": `${GROBAL_HTTP_CTX}` + '/myuser/myuser/updateSelective', // 更新主表
    "DEL_myuser": `${GROBAL_HTTP_CTX}` + '/myuser/myuser/deleteBatch', // 删除主表
    "GET_QUERYPRINTTEMPLATEALLOCATE": `/eiap-plus/appResAllocate/queryPrintTemplateAllocate`,  // 查询打印模板
    "PRINTSERVER": '/print_service/print/preview',                                              // 打印
}

/**
 * 获取主列表
 * @param {*} params
 */
export const getmyuser = (param) => {
    return request(URL.GET_myuser, {
        method: "get",
        param
    });
}
/**
 * 保存主表数据
 * @param {*} params
 */
export const savemyuser = (params) => {
    return request(URL.SAVE_myuser, {
        method: "post",
        data: params
    });
}
/**
 * 更新主表数据
 * @param {*} params
 */
export const updatemyuser = (params) => {
    return request(URL.UPDATE_myuser, {
        method: "post",
        data: params
    });
}
/**
 * 删除主表数据
 * @param {*} params
 */
export const delmyuser = (params) => {
    return request(URL.DEL_myuser, {
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
