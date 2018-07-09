package com.ezial.bgmanage.dubbo.provider.dubbo.consumer.common.model.baidu;

public class BdPayH5Req {

    private String service_code = "1";//服务编号 整数，目前必须为 1

    private String sp_no="";// 百付宝商户号 10 位数字组成的字符串

    private String order_create_time="";//创建订单的时间 YYYYMMDDHHMMSS

    private String order_no="";// 订单号，商户须保证订单号在商户系统内部唯一

    private String goods_name="";// 商品名称

    private String goods_desc="";// 商品描述

    private String goods_url="";// 商品在商户网站上的URL

    private String unit_amount = "";// 单价

    private String unit_count = "";// 数量

    private String transport_amount = "";// 运费

    private String total_amount;// 总金额

    private String currency="1";// 币种

    private String buyer_sp_username="";// 买家在商户网站的用户名

    private String return_url;// 后台通知地址

    private String page_url;// 前台通知地址

    private String pay_type;// 支付类型{1 余额支付（必须登录百度钱包）2 网银支付（在百度钱包页面上选择银行，可以不登录百度钱包） 3 银行网关支付（直接跳到银行的支付页面，无需登录百度钱包）}

    private String bank_no="";// 默认银行的编码(用户使用网银支付和银行网关支付时才有)

    private String expire_time;//交易的超时时间 YYYYMMDDHHMMSS，不得早于交易创建的时间。

    private String sp_rcs;//商户风控信息

    private String input_charset = "1";//请求参数的字符编码

    private String version = "2";//接口的版本号 必须为 2

    private String sign;//签名结果

    private String sign_method = "1";//MD5

    private String extra = "";//商户自定义数据

    private String sp_statistics;//商户统计

    private String sp_pass_through;// 商户定制服务字段

    private String hd_tag;// 活动标记

    public String getService_code() {
        return service_code;
    }

    public void setService_code(String service_code) {
        this.service_code = service_code;
    }

    public String getSp_no() {
        return sp_no;
    }

    public void setSp_no(String sp_no) {
        this.sp_no = sp_no;
    }

    public String getOrder_create_time() {
        return order_create_time;
    }

    public void setOrder_create_time(String order_create_time) {
        this.order_create_time = order_create_time;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_desc() {
        return goods_desc;
    }

    public void setGoods_desc(String goods_desc) {
        this.goods_desc = goods_desc;
    }

    public String getGoods_url() {
        return goods_url;
    }

    public void setGoods_url(String goods_url) {
        this.goods_url = goods_url;
    }

    public String getUnit_amount() {
        return unit_amount;
    }

    public void setUnit_amount(String unit_amount) {
        this.unit_amount = unit_amount;
    }

    public String getUnit_count() {
        return unit_count;
    }

    public void setUnit_count(String unit_count) {
        this.unit_count = unit_count;
    }

    public String getTransport_amount() {
        return transport_amount;
    }

    public void setTransport_amount(String transport_amount) {
        this.transport_amount = transport_amount;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBuyer_sp_username() {
        return buyer_sp_username;
    }

    public void setBuyer_sp_username(String buyer_sp_username) {
        this.buyer_sp_username = buyer_sp_username;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getPage_url() {
        return page_url;
    }

    public void setPage_url(String page_url) {
        this.page_url = page_url;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getBank_no() {
        return bank_no;
    }

    public void setBank_no(String bank_no) {
        this.bank_no = bank_no;
    }

    public String getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(String expire_time) {
        this.expire_time = expire_time;
    }

    public String getSp_rcs() {
        return sp_rcs;
    }

    public void setSp_rcs(String sp_rcs) {
        this.sp_rcs = sp_rcs;
    }

    public String getInput_charset() {
        return input_charset;
    }

    public void setInput_charset(String input_charset) {
        this.input_charset = input_charset;
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

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getSp_statistics() {
        return sp_statistics;
    }

    public void setSp_statistics(String sp_statistics) {
        this.sp_statistics = sp_statistics;
    }

    public String getSp_pass_through() {
        return sp_pass_through;
    }

    public void setSp_pass_through(String sp_pass_through) {
        this.sp_pass_through = sp_pass_through;
    }

    public String getHd_tag() {
        return hd_tag;
    }

    public void setHd_tag(String hd_tag) {
        this.hd_tag = hd_tag;
    }
}
