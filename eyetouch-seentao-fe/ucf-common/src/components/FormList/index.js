/**
 * 用于向搜索面板，表单等输出统一的表单容器和表单项目
 * */
import React, { Component } from 'react'
import PropTypes from 'prop-types'
import { Label, Row, Col, Form } from 'tinper-bee'
import './index.less'
const FormItem = Form.FormItem;


class FormListItem extends Component{
    constructor(props) {
        super(props)
    }
    static defaultProps = {
        required: false,
        label: ''
    }
    static propTypes = {
        required: PropTypes.bool,
        label: PropTypes.node
    }
    getLayoutOption = () => {
        const {size, layoutOpt} = this.props;
        if (layoutOpt) {
            return layoutOpt
        } else {
            if (size === 'sm') {
                return {
                    md: 4,
                    xs: 6
                }
            } else {
                return {
                    md: 6,
                    sm: 10,
                    xs: 12
                }
            }
        }

    }


    render() {
        const { children, label, required } = this.props;
        const wrapLayoutOpt = this.getLayoutOption();
        let showLabel = !!label;
        let outLabel = '';
        let lastChildren = [];
        if(!showLabel && Array.isArray(children)){
            outLabel = children[0];
            if(children.length > 1){
                lastChildren = children.slice(1);
            }
        }

        return (
            <Col {...wrapLayoutOpt}>
                <FormItem className="u-form-item">
                    <Col md={3}  sm={4} xs={4}>
                        {showLabel ? <Label className={required ? "required" : ''} style={{width: "100%"}}>{label}</Label> : outLabel}
                    </Col>
                    <Col md={9} sm={8} xs={8} className="form-input-wrap">
                        {showLabel ? children : lastChildren}
                    </Col>
                </FormItem>
            </Col>
        )
    }
}

class FormList extends Component {
    constructor(props) {
        super(props)
    }
    static defaultProps = {
        size: '',
        className: ''
    }
    static propTypes = {
        size: PropTypes.string,
    }

    static Item = FormListItem;
    static createForm = Form.createForm;

    render() {
        const { className, size, children} = this.props;
        const cls = `ucf-exam-form ${size} ${className || ""}`;
        return (
            <Form
                className={cls}
            >
                <Row>
                    {React.Children.map(children,(child, ind) => {
                        if (child) {
                            return (
                                React.cloneElement(child, {size: size, key: ind})
                            )
                        }
                    })}
                </Row>
            </Form>
        )
    }
}

export default FormList;

