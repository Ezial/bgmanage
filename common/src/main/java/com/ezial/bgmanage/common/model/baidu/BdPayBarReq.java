package com.ezial.bgmanage.common.model.baidu;


import lombok.Data;

import java.io.Serializable;

@Data
public class BdPayBarReq implements Serializable {
    private static final long serialVersionUID = 2365403889706530349L;

    private String pay_code="";//付款码

    private String service_code = "1";//服务编号 整数，目前必须为 1

    private String sp_no="";// 百付宝商户号 10 位数字组成的字符串

    private String order_create_time="";//创建订单的时间 YYYYMMDDHHMMSS

    private String order_no="";// 订单号，商户须保证订单号在商户系统内部唯一

    private String goods_name="";// 商品名称

    private String goods_desc="";// 商品描述

    private String goods_url="";// 商品在商户网站上的URL

    private String total_amount;// 总金额

    private String currency="1";// 币种

    private String return_url;// 后台通知地址

    private String expire_time;//交易的超时时间 YYYYMMDDHHMMSS，不得早于交易创建的时间。

    private String input_charset = "1";//请求参数的字符编码

    private String version = "2";//接口的版本号 必须为 2

    private String sign;//签名结果

    private String sign_method = "1";//MD5

    private String extra = "";//商户自定义数据

    private String mno = "";// 实体商户门店号(不参与签名)

    private String mname = "";//实体商户门店名称(不参与签名)

    private String tno = "";// 实体商户终端号 (不参与签名)

    private String profit_type = "1";//分润类型1：实时分账；2：异步分账；3：记账（只记账不分润）

    private String profit_solution = "";// 分润方案

    private String sp_pass_through="";// 商户定制服务字段
}
