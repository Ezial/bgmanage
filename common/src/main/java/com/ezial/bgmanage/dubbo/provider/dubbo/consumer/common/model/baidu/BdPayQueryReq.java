package com.ezial.bgmanage.dubbo.provider.dubbo.consumer.common.model.baidu;

public class BdPayQueryReq {

    private String sp_no;// 百度钱包商户号

    private String order_no;// 商户订单号

    private String input_charset="1";// 请求参数的字符编码

    private String version="2";// 版本号

    private String sign;// 签名

    private String sign_method="1";// 签名方法 1 MD5

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
}
