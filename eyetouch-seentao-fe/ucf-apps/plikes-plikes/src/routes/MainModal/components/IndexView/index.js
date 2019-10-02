import React, {Component} from "react";
import {actions} from "mirrorx";
import {Col, Row,  FormControl, Label, Switch, Radio} from "tinper-bee";
import DatePicker from 'bee-datepicker';
import moment from "moment";
import FormList from 'components/FormList';
import FormError from 'components/FormError';
import Select from 'bee-select';
import PopDialog from 'components/Pop';
import FormControlPhone from 'components/FormControlPhone';
import RefCommon from 'components/RefCommon';
import zhCN from "rc-calendar/lib/locale/zh_CN";
import Header from "components/Header";
import queryString from 'query-string';
import Alert from 'components/Alert';
import Button from 'components/Button';
import './index.less'

const FormItem = FormList.Item;

const layoutOpt = null
const {Option} = Select;
const format = "YYYY-MM-DD";
let titleArr = ["新增", "修改", "详情"];

class AddEditplikes extends Component {
    constructor(props) {
        super(props);
        this.state = {
            rowData: {},
            btnFlag: 0,
            showPopBackVisible: false
        }
    }
    componentDidMount(){
        const searchObj = queryString.parse(this.props.location.search);
        let { btnFlag: flag, checkTable: checkTable} = searchObj;
        const btnFlag = Number(flag);

        const { plikesObj, plikesIndex: currentIndex } = this.props;
        // 防止网络阻塞造成btnFlag显示不正常
        this.setState({btnFlag: btnFlag});
        let rowData = {};
        try {
            // 判断是否重后端请求数据
            if (btnFlag > 0 && checkTable === "plikes") {
                this.props.form.resetFields();
                const {list} =plikesObj;
                rowData = list[currentIndex] || {};
            }
        } catch (error) {
            console.log(error);
        } finally {
            this.setState({rowData});
        }
    }
    /**
     * button关闭Modal 同时清空state
     * @param {Boolean} isSave 判断是否添加或者更新
     */
    onCloseEdit = (isSave) => {
        // 关闭当前 弹框清空当前的state的值，防止下次进入是上一次的数据
        this.setState({rowData: {}, btnFlag: 0});
        this.props.form.resetFields();
    }
    /**
     *  提交信息
     */
    onSubmitEdit = () => {
        const _this = this;
        const {btnFlag}=_this.state;
        this.props.form.validateFields(async (err, values) => {
            if (!err) {
                let {rowData} = _this.state;
                if (rowData && rowData.id) {
                    values.id = rowData.id;
                    values.ts = rowData.ts;
                }
                // 参照处理
                const {dept} = values;
                if (dept) {
                    const {refpk} = JSON.parse(dept);
                    values.dept = refpk;

                }
                // 是否会员，从state中取值
                const {isVip} = rowData;
                values.isVip = isVip;

                if(!isVip){ // 如果不是会员
                    values.grade = 0;
                    values.expirationDate = "";
                }

                try {
                    values.expirationDate = values.expirationDate.format(format);
                } catch (e) {
                }
                values.btnFlag=btnFlag;
                _this.onCloseEdit(true); // 关闭弹框 无论成功失败
                actions.masterDetailMany.saveplikes(values); //保存主表数据
                //返回
                actions.routing.replace({ pathname: '/' });
            }
        });
    }
     /**
     * 清空
     */
    clearQuery() {
        this.props.form.resetFields();
    }
    /**
     *
     * 返回上一级弹框提示
     * @param {Number} type 1、取消 2、确定
     * @memberof Order
     */
    async confirmGoBack(type) {
        this.setState({ showPopBackVisible: false });
        if (type === 1) { // 确定
            this.clearQuery();
            actions.routing.replace({ pathname: '/' });
        }
    }
     /**
     * 返回
     * @returns {Promise<void>}
     */
    onBack = async () => {
        const { btnFlag } = this.state;
        if (btnFlag === 2) { //判断是否为详情态
            const searchObj = queryString.parse(this.props.location.search);
            let { from } = searchObj;
            switch (from) {
                case undefined:
                    this.clearQuery();
                    actions.routing.replace({ pathname: '/' });
                    break;
                default:
                    window.history.go(-1);
            }

        } else {
            this.setState({ showPopBackVisible: true });
        }
    }
    render() {
        let _this = this;
        const {form, modalVisible} = _this.props;


        const {getFieldProps, getFieldError,} = form;
        const {rowData, btnFlag, showPopBackVisible } = _this.state;

        let isDisabled = btnFlag > 1 ? true : false;

        return (
            <div className="mainContainer">
                <Alert
                    show={showPopBackVisible}
                    context="数据未保存，确定离开 ?"
                    confirmFn={() => {
                        _this.confirmGoBack(1)
                    }}
                    cancelFn={() => {
                        _this.confirmGoBack(2)
                    }} />
                <Header back title={titleArr[btnFlag]}>
                    <div className='head-btn'>
                        <Button shape="border" className="ml8" onClick={_this.onBack}>取消</Button>
                        {(btnFlag !== 2) &&
                        <Button colors="primary" className="ml8" onClick={_this.onSubmitEdit}>保存</Button>
                        }
                    </div>
                </Header>
                <FormList className="formlist">
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
        <FormError errorMsg={getFieldError('time')}/>
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
        <FormError errorMsg={getFieldError('pid')}/>
                                </FormItem>
                                <FormItem>
        <Label >
            用户id
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('uid', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.uid === 'undefined') ? "" : rowData.uid
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入用户id',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ uid: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
        <FormError errorMsg={getFieldError('uid')}/>
                                </FormItem>
                </FormList>
            </div>
        )
    }
}

export default FormList.createForm()(AddEditplikes);
