package com.ezial.bgmanage.common.model.baidu;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class BdPayQueryRes<T> implements Serializable {
    private static final long serialVersionUID = 7601595617096613289L;

    private String ret;// 返回码

    private String msg;// 返回信息描述

    private String token;

    private T content;//返回信息内容,订单不存在时为空

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public static void main(String[] args) {
//        String json = "{\"ret\":\"0\",\"msg\":\"OK\",\"content\":{\"bfb_order_no\":\"2014111990001000051110222861997\",\"cash_amount\":\"1\",\"create_time\":\"2014-11-19 19:25:29\",\"goods_name\":\"baiduwaimai\",\"mkt_amount\":\"0\",\"mname\":\"\",\"mno\":\"\",\"order_no\":\"123\",\"pay_result\":\"1\",\"pay_time\":\"0000-00-00 00:00:00\",\"sign_method\":\"1\",\"sp_no\":\"9000100005\",\"tno\":\"\",\"total_amount\":\"1\",\"version\":\"1\",\"sign\":\"79243ffdc58264902c9d1816232c3a52\"},\"token\":\"07321dd3529f0565edb6a1e2a8688635\"}";
//        BdPayQueryRes res = JSON.toJavaObject(JSON.parseObject(json), BdPayQueryRes.class);
//
//        System.out.println(res.getRet());
//        System.out.println(res.getMsg());
//        System.out.println(res.getContent());

        String resp = "{\"ret\":\"0\",\"msg\":\"OK\",\"content\":{\"bfb_order_no\":\"2018050990001000051113232946119\",\"cash_amount\":\"1\",\"create_time\":\"2018-05-09 16:52:17\",\"goods_name\":\"\\u5546\\u54c1\\u540d\\u79f0\",\"mkt_amount\":\"0\",\"mname\":\"\",\"mno\":\"\",\"order_no\":\"1525855920100\",\"pay_result\":\"2\",\"pay_time\":\"2018-05-09 16:52:25\",\"sign_method\":\"1\",\"sp_no\":\"9000100005\",\"tno\":\"\",\"total_amount\":\"1\",\"version\":\"1\",\"sign\":\"4cb14150a6beef059bb8c2b3d018be48\"},\"token\":\"\"}";

        BdPayQueryRes res = JSON.toJavaObject(JSON.parseObject(resp), BdPayQueryRes.class);

    System.out.println(res.getContent());
  }

}
