package com.ezial.bgmanage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ezial.bgmanage.common.model.baidu.*;
import com.ezial.bgmanage.common.utils.HttpsUtil;
import com.ezial.bgmanage.common.utils.baidu.BdPayUtil;
import com.ezial.bgmanage.common.utils.baidu.BfbSdkComm;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RequestMapping(value = "/baidu2")
@RestController
public class BaiduBarController {


    @GetMapping(value = "/bdpayBar")
    public void bdpay(@Param("payCode") String payCode,HttpServletResponse response) throws Exception {

        response.setCharacterEncoding("gbk");
        response.setContentType("text/html;charset=gbk");
        response.setHeader("content-type","text/html;charset=gbk");

        BdPayBarReq bdPayBarReq = new BdPayBarReq();
        bdPayBarReq.setGoods_name("1");
        bdPayBarReq.setGoods_desc("商品描述");
        bdPayBarReq.setGoods_url("https://127.0.0.1");
        bdPayBarReq.setTotal_amount("1");
        bdPayBarReq.setReturn_url("http://113.47.214.147:8080/ReturnServlet");
        //bdPayBarReq.setExtra("用户自定义数据");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 2);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMddHHmmss");
        bdPayBarReq.setExpire_time(formatter.format(c.getTime()).substring(0, 14));
        bdPayBarReq.setOrder_create_time(formatter.format(System.currentTimeMillis()));
        bdPayBarReq.setOrder_no(System.currentTimeMillis() + "");
        bdPayBarReq.setSp_no("9000100005");
        bdPayBarReq.setPay_code(payCode);
        bdPayBarReq.setMno("123456789012345");
        bdPayBarReq.setMname("门店名称");
        bdPayBarReq.setTno("123456789");
        // bdPayBarReq.setSp_pass_through("%7B%22offline_pay%22%3A1%7D");

        //签名串拼接数组
        String[]array={
                "mno=" + bdPayBarReq.getMno(),
                "mname=" + bdPayBarReq.getMname(),
                "tno=" + bdPayBarReq.getTno(),
                "pay_code=" + bdPayBarReq.getPay_code(),
                "service_code=" + bdPayBarReq.getService_code(),
                "sp_no=" + bdPayBarReq.getSp_no(),
                "order_create_time=" + bdPayBarReq.getOrder_create_time(),
                "order_no=" + bdPayBarReq.getOrder_no(),
                "goods_name=" + bdPayBarReq.getGoods_name(),
                "goods_desc=" + bdPayBarReq.getGoods_desc(),
                "goods_url=" + bdPayBarReq.getGoods_url(),
                "total_amount=" + bdPayBarReq.getTotal_amount(),
                "currency=" + bdPayBarReq.getCurrency(),
                "return_url=" + bdPayBarReq.getReturn_url(),
                "expire_time=" + bdPayBarReq.getExpire_time(),
                "input_charset=" + bdPayBarReq.getInput_charset(),
                "version=" + bdPayBarReq.getVersion(),
                "sign_method=" + bdPayBarReq.getSign_method(),
                "sp_pass_through=" + bdPayBarReq.getSp_pass_through(),
                "extra=" + bdPayBarReq.getExtra()
        };

        //浏览器参数拼接数组
        String[]array1={
                "mno=" + bdPayBarReq.getMno(),
                "mname=" + URLEncoder.encode(bdPayBarReq.getMname(),"gbk"),
                "tno=" + bdPayBarReq.getTno(),
                "pay_code=" + bdPayBarReq.getPay_code(),
                "service_code=" + bdPayBarReq.getService_code(),
                "sp_no=" + bdPayBarReq.getSp_no(),
                "order_create_time=" + bdPayBarReq.getOrder_create_time(),
                "order_no=" + bdPayBarReq.getOrder_no(),
                "goods_name=" + URLEncoder.encode(bdPayBarReq.getGoods_name(),"gbk"),
                "goods_desc=" + URLEncoder.encode(bdPayBarReq.getGoods_desc(),"gbk"),
                "goods_url=" + URLEncoder.encode(bdPayBarReq.getGoods_url(),"gbk"),
                "total_amount=" + bdPayBarReq.getTotal_amount(),
                "currency=" + bdPayBarReq.getCurrency(),
                "return_url="+ URLEncoder.encode(bdPayBarReq.getReturn_url(),"gbk"),
                "expire_time=" + bdPayBarReq.getExpire_time(),
                "input_charset=" + bdPayBarReq.getInput_charset(),
                "version=" + bdPayBarReq.getVersion(),
                "sign_method=" + bdPayBarReq.getSign_method(),
                "extra=" + URLEncoder.encode(bdPayBarReq.getExtra(),"gbk"),
                "sp_pass_through=" + URLEncoder.encode(bdPayBarReq.getSp_pass_through(),"gbk")
        };

        /**
         * 4、调用bfb_sdk_comm里create_bdpay_pay_order_url方法生成百度钱包扫码支付接口URL
         *   array是待签名串
         *   array1地址栏拼接串
         *
         */
        String getURL=new BfbSdkComm().create_bdpay_pay_order_url(array,array1,"https://www.baifubao.com/o2o/0/b2c/0/api/0/pay/0","");
        System.out.println("url:" + getURL);

        response.sendRedirect(getURL);

    }

    @GetMapping(value = "/bdpayQuery")
    public void bdpayQuery(@Param("orderNo") String orderNo) throws Exception {
        BdPayQueryReq bdPayQueryReq = new BdPayQueryReq();
        bdPayQueryReq.setOrder_no(orderNo);
        bdPayQueryReq.setSp_no("9000100005");

        String targetUrl = BdPayUtil.getBdPayo2oQueryUrl(bdPayQueryReq,"https://www.baifubao.com/o2o/0/b2c/0/api/0/query_trans/0","");
        System.out.println("target url:" + targetUrl);
        String resp = HttpsUtil.get(targetUrl);
        System.out.println(resp);

        BdPayQueryRes<BdPayQueryDetail> res = JSON.toJavaObject(JSON.parseObject(resp), BdPayQueryRes.class);

        BdPayQueryDetail detail = JSON.toJavaObject((JSONObject) JSON.parseObject(resp).get("content"), BdPayQueryDetail.class);
        String[] ary ={
                "bfb_order_no=" + detail.getBfb_order_no(),
                "cash_amount=" + detail.getCash_amount(),
                "create_time=" + detail.getCreate_time(),
                "goods_name=" + detail.getGoods_name(),
                "mkt_amount=" + detail.getMkt_amount(),
                "mname=" + detail.getMname(),
                "mno=" + detail.getMno(),
                "order_no=" + detail.getOrder_no(),
                "pay_result=" + detail.getPay_result(),
                "pay_time=" + detail.getPay_time(),
                "sign_method=" + detail.getSign_method(),
                "sp_no=" + detail.getSp_no(),
                "tno=" + detail.getTno(),
                "total_amount=" + detail.getTotal_amount(),
                "version=" + detail.getVersion()
        };

        String sign =  BfbSdkComm.make_sign( ary,"");

        if(sign.equals(detail.getSign())){
            System.out.println("验签成功");
        }else {
            System.out.println("验签失败");
        }

        System.out.println(res.getContent());
    }

    @GetMapping(value = "/testQRNotify")
    public void bdpayo2o(BdPayQRNotifyReq bdPayQRNotifyReq) throws Exception{
        System.out.println("");
        System.out.println(JSON.toJSON(bdPayQRNotifyReq));

        // bank_no bfb_order_create_time bfb_order_no buyer_sp_username currency fee_amount input_charset order_no
        // pay_result pay_time pay_type sign_method sp_no total_amount transport_amount unit_amount unit_count version key

        //浏览器参数拼接数组
        String[] ary ={
                "bank_no=" + bdPayQRNotifyReq.getBank_no(),
                "bfb_order_create_time=" + bdPayQRNotifyReq.getBfb_order_create_time(),
                "bfb_order_no=" + bdPayQRNotifyReq.getBfb_order_no(),
                "buyer_sp_username=" + bdPayQRNotifyReq.getBuyer_sp_username(),
                "currency=" + bdPayQRNotifyReq.getCurrency(),
                "fee_amount=" + bdPayQRNotifyReq.getFee_amount(),
                "input_charset=" + bdPayQRNotifyReq.getInput_charset(),
                "order_no=" + bdPayQRNotifyReq.getOrder_no(),
                "pay_result=" + bdPayQRNotifyReq.getPay_result(),
                "pay_time=" + bdPayQRNotifyReq.getPay_time(),
                "pay_type=" + bdPayQRNotifyReq.getPay_type(),
                "sign_method=" + bdPayQRNotifyReq.getSign_method(),
                "sp_no=" + bdPayQRNotifyReq.getSp_no(),
                "total_amount=" + bdPayQRNotifyReq.getTotal_amount(),
                "transport_amount=" + bdPayQRNotifyReq.getTransport_amount(),
                "unit_amount=" + bdPayQRNotifyReq.getUnit_amount(),
                "unit_count=" + bdPayQRNotifyReq.getUnit_count(),
                "version=" + bdPayQRNotifyReq.getVersion()
        };

       String sign =  BfbSdkComm.make_sign( ary,"");

        if(sign.equals(bdPayQRNotifyReq.getSign())){
            System.out.println("验签成功");
        }else {
            System.out.println("验签失败");
        }

    }
    
}
