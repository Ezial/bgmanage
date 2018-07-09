package com.ezial.bgmanage.dubbo.provider.dubbo.consumer.common.model.baidu;

import java.io.Serializable;

public class BdPayQueryDetail implements Serializable{
    private static final long serialVersionUID = -7184199795285337984L;

    private String sp_no;//商户号

    private String order_no;// 商户订单号

    private String bfb_order_no;// 百度钱包交易号

    private String mno;// 实体商户号

    private String mname;//实体商户门店号

    private String tno;//实体商户终端号

    private String goods_name;// 商品名称

    private String create_time;//交易创建时间 YYYY-MM-DD HH:MM:SS

    private String pay_time;//交易支付时间 YYYY-MM-DD HH:MM:SS

    private String total_amount;//总金额，以分为单位

    private String cash_amount;//交易现金金额，以分为单位

    private String mkt_amount;//营销优惠金额，以分为单位

    private String pay_result;//订单支付结果(1 等待支付 2 支付成功 3 交易成功 10 支付失败)

    private String version;// 接口的版本号

    private String sign;// 签名

    private String sign_method;//签名方法

    public String getSp_no() {
        return sp_no;
    }

    public void setSp_no(String sp_no) {
        this.sp_no = sp_no;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getBfb_order_no() {
        return bfb_order_no;
    }

    public void setBfb_order_no(String bfb_order_no) {
        this.bfb_order_no = bfb_order_no;
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getCash_amount() {
        return cash_amount;
    }

    public void setCash_amount(String cash_amount) {
        this.cash_amount = cash_amount;
    }

    public String getMkt_amount() {
        return mkt_amount;
    }

    public void setMkt_amount(String mkt_amount) {
        this.mkt_amount = mkt_amount;
    }

    public String getPay_result() {
        return pay_result;
    }

    public void setPay_result(String pay_result) {
        this.pay_result = pay_result;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign_method() {
        return sign_method;
    }

    public void setSign_method(String sign_method) {
        this.sign_method = sign_method;
    }
}
