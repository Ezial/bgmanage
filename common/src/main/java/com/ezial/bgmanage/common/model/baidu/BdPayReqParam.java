package com.ezial.bgmanage.common.model.baidu;

import lombok.Data;

@Data
public class BdPayReqParam {
    // 变量

    private String goods_category;// 商品种类

    private String goods_name;// 商品名称

    private String goods_desc;// 商品描述

    private String goods_url;// 商品在商户网站上的URL

    private String unit_amount;// 单价

    private String unit_count;// 数量

    private String transport_amount;// 运费

    private String total_amount;// 总金额

    private String buyer_sp_username;// 买家在商户网站的用户名

    private String return_url;// 后台通知地址

    private String page_url;// 前台通知地址

    private String pay_type;// 支付方式

    private String bank_no;// 默认银行的编码

    private String extra;// 商户自定义数据
}
