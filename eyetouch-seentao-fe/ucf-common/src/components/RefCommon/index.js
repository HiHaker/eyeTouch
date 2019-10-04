
import React, { Component } from 'react';
import PropTypes from 'prop-types';
import {RefMultipleTableWithInput,RefMultipleTable,RefTreeWithInput,RefTree } from 'pap-refer/dist/index';
import "pap-refer/dist/index.css"
// import {RefTree} from 'ref-tree';
// import 'ref-tree/dist/index.css';

//1:树形 2:单表 3:树卡型 4:多选 5:穿梭框 6:多过滤项
const RefEnum = {
    tree: 1, 
    single: 2,
    treeTable: 3,
    multiple: 4,
    transfer: 5,
    multipleTable: 6
}

const propTypes = {
    type: PropTypes.number,
    title: PropTypes.string,
    rowData: PropTypes.object,
    btnFlag: PropTypes.number,
    refCode: PropTypes.string,
    param: PropTypes.object
};

//默认参数值
const defaultProps = {
    rowData: {},
    param: {},
}

class RefCommon extends Component {
    constructor(props) {
        super(props);
        this.state = {

        }
        this.renderTree = this.renderTree.bind(this);
        this.renderMutipleTable = this.renderMutipleTable.bind(this);
        this.renderDefault = this.renderDefault.bind(this);

    }
    componentWillReceiveProps(nextProps) {

    }
    renderTree(rowData,btnFlag){
        const {title,param} = this.props;

        return (
            <RefTreeWithInput
                disabled={btnFlag === 2}
                placeholder={`请选择${title}`}
                backdrop={false}
                title={title}
                param= {param}
                searchable= {true}
                multiple={false}
                checkStrictly={true}
                displayField='{refname}'
                valueField='refpk'
                refModelUrl= {{
                    treeUrl: `${GROBAL_HTTP_CTX}/common-ref/blobRefTree`, //树请求
                }}
                matchUrl={`${GROBAL_HTTP_CTX}/common-ref/matchPKRefJSON`}
                filterUrl={`${GROBAL_HTTP_CTX}/common-ref/filterRefJSON`}
                {...this.props}
            >
                <RefTree />
            </RefTreeWithInput>
        )
    }
    renderMutipleTable(rowData,btnFlag){
        const {title,param} = this.props;

        return (
            <RefMultipleTableWithInput
                disabled={btnFlag === 2}
                placeholder = {`请选择${title}`}
                title = {title}
                backdrop = {false}
                param = {param}
                displayField="{refcode}"
                valueField="refpk"
                refModelUrl = {{
                    tableBodyUrl:`${GROBAL_HTTP_CTX}/common-ref/blobRefTreeGrid`,//表体请求
                    refInfo:`${GROBAL_HTTP_CTX}/common-ref/refInfo`,//表头请求
                }}
                matchUrl={`${GROBAL_HTTP_CTX}/common-ref/matchPKRefJSON`}
                filterUrl={`${GROBAL_HTTP_CTX}/common-ref/filterRefJSON`}
                {...this.props}
            >
                <RefMultipleTable />
            </RefMultipleTableWithInput>
        )
    }
    renderDefault(){
        return 'default ref';
    }
    render() {
        const {rowData,btnFlag,type} = this.props;


        const map = {
            [RefEnum.tree]: this.renderTree,
            [RefEnum.multipleTable]: this.renderMutipleTable
        }


        const renderRef = map[type] || this.renderDefault;

        return (
            renderRef(rowData,btnFlag)
        )
    }
}

RefCommon.propTypes = propTypes;
RefCommon.defaultProps = defaultProps;

export default RefCommon;