
import React, {Component} from 'react'
import {actions} from "mirrorx";
import {Col, Row, FormControl, Label, Radio} from "tinper-bee";
import DatePicker from 'bee-datepicker';
import moment from "moment";
import Select from 'bee-select';
import FormList from 'components/FormList';
import FormError from 'components/FormError';
import SearchPanel from 'components/SearchPanel';
import FormControlPhone from 'components/FormControlPhone';
import RefCommon from 'components/RefCommon';
import {addSearchKey} from 'utils';

import './index.less'

const FormItem = FormList.Item;

const layoutOpt = null

class SearchArea extends Component {

    constructor(props) {
        super(props);
        this.state = {}

    }

    componentDidMount(){
        this.props.onRef(this)
    }

    /** 查询数据
     * @param {*} error 校验是否成功
     * @param {object} values 表单数据
     */
    search = () => {
        this.props.form.validateFields(async (err, values) => {
            const {pcommentsObj} = this.props;
            const {pageSize} = pcommentsObj;
            values.pageIndex = 0;  // 默认回到第一页
            values.pageSize = pageSize;
            addSearchKey(values);
            actions.masterDetailMany.updateState({searchParam: values}); // 将查询数据放在 model里
            await actions.masterDetailMany.loadList(values);
        });
    }

    /**
     * 清空 action里的搜索条件
     */
    reset = () => {
        this.props.form.resetFields();
        actions.masterDetailMany.updateState({searchParam: {}});
    }

    render() {
        const {form} = this.props;
        const {getFieldProps} = form;
        return (
            <SearchPanel
                className="small"
                form={form}
                reset={this.reset}
                search={this.search}>
                <FormList>
                              <FormItem>
        <Label >
            a用户id
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('auid', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.auid === 'undefined') ? "" : rowData.auid
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入a用户id',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ auid: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
                              </FormItem>
                              <FormItem>
        <Label >
            b用户id
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('buid', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.buid === 'undefined') ? "" : rowData.buid
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入b用户id',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ buid: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
                              </FormItem>
                              <FormItem>
        <Label >
            发表时间
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('time', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.time === 'undefined') ? "" : rowData.time
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入发表时间',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ time: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
                              </FormItem>
                              <FormItem>
        <Label >
            帖子id
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('pid', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.pid === 'undefined') ? "" : rowData.pid
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入帖子id',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ pid: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
                              </FormItem>
                              <FormItem>
        <Label >
            评论内容
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('content', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.content === 'undefined') ? "" : rowData.content
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入评论内容',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ content: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
                              </FormItem>
                </FormList>
            </SearchPanel>
        )
    }
}

export default FormList.createForm()(SearchArea)
