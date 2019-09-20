import {actions} from "mirrorx";
// 引入services，如不需要接口请求可不写
import * as api from "./service";
// 接口返回数据公共处理方法，根据具体需要
import {processData, initStateObj, structureObj, Error, getCookie} from "utils";

/**
 *          btnFlag为按钮状态，新增、修改是可编辑，查看详情不可编辑，
 *          新增表格为空
 *          修改需要将行数据带上并显示在卡片页面
 *          查看详情携带行数据但是表格不可编辑
 *          0表示新增、1表示编辑，2表示查看详情 3提交
 *async loadList(param, getState) {
 *          rowData为行数据
 */

export default {
    // 确定 Store 中的数据模型作用域
    name: "masterDetailMany",
    // 设置当前 Model 所需的初始化 state
    initialState: {
                tabKey: "",
        pvideoIndex: 0, // 默认选中第一行
        showLoading: false,
        searchParam: {},
        pvideoObj: {
            list: [],
            pageIndex: 1,
            pageSize: 5,
            totalPages: 1,
            total: 0,
        },
    },
    reducers: {
        /**
         * 纯函数，相当于 Redux 中的 Reducer，只负责对数据的更新。
         * @param {*} state
         * @param {*} data
         */
        updateState(state, data) { //更新state
            return {
                ...state,
                ...data
            };
        },
        /**
         * 纯函数 合并 initialState
         * @param {*} state
         * @param {*} data
         */
        initState(state, data) { //更新state
            const assignState = deepAssign(state, data);
            return {
                ...assignState,
            };
        },

    },
    effects: {
        /**
         * 加载主列表数据
         * @param {*} param
         * @param {*} getState
         */
        async loadList(param, getState) {
            actions.masterDetailMany.updateState({showLoading: true});   // 正在加载数据，显示加载 Loading 图标
            const {result} = processData(await api.getpvideo(param));  // 调用 getList 请求数据
            const {data: respvideo} = result;
            const {content = []} = respvideo || {};

            if (content.length > 0) { // 获取子表数据
                const pvideoObj = structureObj(respvideo, param);
                actions.masterDetailMany.updateState({pvideoObj}); // 更新主表数据
            } else {
                 const {
                    pvideoObj,
                } = getState().masterDetailMany;
                actions.masterDetailMany.updateState({   // 如果请求出错,数据初始化
                        pvideoObj: initStateObj(pvideoObj),
                        pvideoRow: {}
                    }
                );
            }
            actions.masterDetailMany.updateState({showLoading: false, pvideoIndex: 0});
        },
        /**
         * getSelect：保存主表数据
         * @param {*} param
         * @param {*} getState
         */
        async savepvideo(param, getState) {
            actions.masterDetailMany.updateState({showLoading: true});   // 正在加载数据，显示加载 Loading 图标
            const {btnFlag} = param;
            let status = null;
            delete param.btnFlag; //删除标识字段
            if (btnFlag === 0) { // 添加数据
                const {result} = processData(await api.savepvideo(param), '添加成功');
                status = result.status;
            }
            if (btnFlag === 1) { // 修改数据
                const {result} = processData(await api.updatepvideo(param), '修改成功');
                status = result.status;
            }

            if (status === 'success') { // 如果不判断是会报错，param参数有错
                const {pageSize} = getState().masterDetailMany.pvideoObj;
                // 带上子表信息
                const {search_contactName} = getState().masterDetailMany.searchParam;
                const param = {pageIndex: 0, pageSize, search_contactName}; // 获取主表信息
                actions.masterDetailMany.loadList(param);
            }
            actions.masterDetailMany.updateState({showLoading: false});
        },
        /**
         * 删除主表数据
         * @param {*} param
         * @param {*} getState
         */
        async delpvideo(param, getState) {
            const {id} = param;
            const {result}=processData(await api.delpvideo([{id}]), '删除成功');
            const {status}=result;
            if(status==='success'){
                // 获取表pageSize;
                const {pvideoObj} = getState().masterDetailMany;
                const {pageSize} = pvideoObj;
                const initPage = {pageIndex: 0, pageSize};
                actions.masterDetailMany.loadList(initPage);
            }
        },
        /**
         * getSelect：通过id查询主表数据
         * @param {*} param
         * @param {*} getState
         */
        async querypvideo(param, getState) {
            let res = await api.getList(param);
            const {data: {detailMsg: {data: {content}}}} = res;
            return content[0];
        },
        /**
         *
         *
         * @param {*} param
         * @returns
         */
        async printDocument(param) {
            let {result} = processData(await api.queryPrintTemplateAllocate(param.queryParams), '');
            const {data:res}=result;
            if (!res || !res.res_code) {
                return false;
            }
            await api.printDocument({
                tenantId: getCookie('tenantid'),
                printcode: res['res_code'],
                serverUrl: `${GROBAL_HTTP_CTX}/passenger/dataForPrint`,
                params: encodeURIComponent(JSON.stringify(param.printParams)),
                sendType: 'post'
            })
        },
    }
};
