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

class AddEdituser extends Component {
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

        const { userObj, userIndex: currentIndex } = this.props;
        // 防止网络阻塞造成btnFlag显示不正常
        this.setState({btnFlag: btnFlag});
        let rowData = {};
        try {
            // 判断是否重后端请求数据
            if (btnFlag > 0 && checkTable === "user") {
                this.props.form.resetFields();
                const {list} =userObj;
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
                actions.masterDetailMany.saveuser(values); //保存主表数据
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
            头像id
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('avatar', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.avatar === 'undefined') ? "" : rowData.avatar
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入头像id',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ avatar: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
        <FormError errorMsg={getFieldError('avatar')}/>
                                </FormItem>
                                <FormItem>
        <Label >
            密码
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('password', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.password === 'undefined') ? "" : rowData.password
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入密码',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ password: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
        <FormError errorMsg={getFieldError('password')}/>
                                </FormItem>
                                <FormItem>
        <Label >
            性别
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('sex', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.sex === 'undefined') ? "" : rowData.sex
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入性别',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ sex: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
        <FormError errorMsg={getFieldError('sex')}/>
                                </FormItem>
                                <FormItem>
        <Label >
            注册日期
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('register_date', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.register_date === 'undefined') ? "" : rowData.register_date
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入注册日期',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ register_date: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
        <FormError errorMsg={getFieldError('register_date')}/>
                                </FormItem>
                                <FormItem>
        <Label >
            生日
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('birthday', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.birthday === 'undefined') ? "" : rowData.birthday
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入生日',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ birthday: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
        <FormError errorMsg={getFieldError('birthday')}/>
                                </FormItem>
                                <FormItem>
        <Label >
            用户昵称
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('nickname', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.nickname === 'undefined') ? "" : rowData.nickname
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入用户昵称',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ nickname: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
        <FormError errorMsg={getFieldError('nickname')}/>
                                </FormItem>
                                <FormItem>
        <Label >
            电话号码
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('phone_number', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.phone_number === 'undefined') ? "" : rowData.phone_number
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入电话号码',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ phone_number: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
        <FormError errorMsg={getFieldError('phone_number')}/>
                                </FormItem>
                                <FormItem>
        <Label >
            登录名
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('login_name', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.login_name === 'undefined') ? "" : rowData.login_name
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入登录名',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ login_name: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
        <FormError errorMsg={getFieldError('login_name')}/>
                                </FormItem>
                                <FormItem>
        <Label >
            简介
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('profile', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.profile === 'undefined') ? "" : rowData.profile
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入简介',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ profile: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
        <FormError errorMsg={getFieldError('profile')}/>
                                </FormItem>
                                <FormItem>
        <Label >
            邮箱
        </Label>
        <FormControl disabled={typeof btnFlag != 'undefined' && btnFlag == 2
}
            {
            ...getFieldProps('mailbox', {
                validateTrigger: 'onBlur',
                initialValue: (typeof rowData === 'undefined' || typeof rowData.mailbox === 'undefined') ? "" : rowData.mailbox
,
                rules: [{
                    type:'string',required: false,pattern:/\S+/ig, message: '请输入邮箱',
                }],
                onChange(value) {
if(typeof rowData !== 'undefined'){
    let tempRow = Object.assign({},rowData,{ mailbox: value });
    _this.setState({
        rowData:tempRow
    })
}
                }
            }
            )}
        />
        <FormError errorMsg={getFieldError('mailbox')}/>
                                </FormItem>
                </FormList>
            </div>
        )
    }
}

export default FormList.createForm()(AddEdituser);
