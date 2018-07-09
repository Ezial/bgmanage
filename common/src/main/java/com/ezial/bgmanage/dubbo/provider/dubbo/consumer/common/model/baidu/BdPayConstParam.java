package com.ezial.bgmanage.dubbo.provider.dubbo.consumer.common.model.baidu;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Data
public class BdPayConstParam {

    // 常量
    private String service_code; // 商品分类号

    private String sp_no;// 商户号

    private String expire_time;// 交易的超时时间,当前时间加2天

    private String order_create_time;// 订单创建时间

    private String order_no;// 订单号

    private String currency;// 币种

    private String input_charset;// 编码

    private String version;// 版本

    private String sign_method;// 加密方式md5或者hash

    private String BFB_PAY_DIRECT_LOGIN_URL;// 提交地址

    public void initConst(){
        this.setService_code("1");// 百度钱包即时到账接口服务ID
        this.setSp_no("9000100005");// 商户号
        Calendar c   =   Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 2);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMddHHmmss");
        this.setExpire_time(formatter.format(c.getTime()).substring(0, 14));
        this.setOrder_create_time(formatter.format(System.currentTimeMillis()));
        this.setOrder_no(formatter.format(System.currentTimeMillis()) + (int)(Math.random() * 100));
        this.setCurrency("1");// 百度钱包接口货币单位：人民币
        this.setInput_charset("1");// 百度钱包接口字符编码
        this.setVersion("2");// 百度钱包接口版本
        this.setSign_method("1");// 签名校验算法md5
        this.setBFB_PAY_DIRECT_LOGIN_URL("https://www.baifubao.com/api/0/pay/0/direct/0");// 百度钱包PC端即时到账支付接口URL（需要用户登录百度钱包）

    }

}
