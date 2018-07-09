package com.ezial.bgmanage.dubbo.provider.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ezial.bgmanage.common.utils.HttpsUtil;
import com.ezial.bgmanage.common.utils.baidu.BdPayUtil;
import com.ezial.bgmanage.common.utils.baidu.BfbSdkComm;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RequestMapping(value = "/baidu")
@RestController
public class BaiduController {

    private static final String H5_URL = "https://www.baifubao.com/api/0/pay/0/wapdirect/0";

    @PostMapping(value = "/testPost")
    public void test(@RequestBody BdPayReqParam bdPayReqParam,HttpServletResponse response) throws Exception {
        System.out.println(bdPayReqParam);

        response.setCharacterEncoding("gbk");
        response.setContentType("text/html;charset=gbk");
        response.setHeader("content-type","text/html;charset=gbk");

        BdPayConstParam constParam = new BdPayConstParam();
        constParam.initConst();

        //签名串拼接数组
        String[] array={
                "service_code=" + constParam.getService_code(),
                "sp_no=" + constParam.getSp_no(),
                "order_create_time=" + constParam.getOrder_create_time(),
                "order_no=" + constParam.getOrder_no(),
                "goods_category=" + bdPayReqParam.getGoods_category(),
                "goods_name=" + bdPayReqParam.getGoods_name(),
                "goods_desc=" + bdPayReqParam.getGoods_desc(),
                "goods_url=" + bdPayReqParam.getGoods_url(),
                "unit_amount=" + bdPayReqParam.getUnit_amount(),
                "unit_count=" + bdPayReqParam.getUnit_count(),
                "transport_amount=" + bdPayReqParam.getTransport_amount(),
                "total_amount=" + bdPayReqParam.getTotal_amount(),
                "currency=" + constParam.getCurrency(),
                "buyer_sp_username=" + bdPayReqParam.getBuyer_sp_username(),
                "return_url=" + bdPayReqParam.getReturn_url(),
                "page_url=" + bdPayReqParam.getPage_url(),
                "pay_type=" + bdPayReqParam.getPay_type(),
                "bank_no=" + bdPayReqParam.getBank_no(),
                "expire_time=" + constParam.getExpire_time(),
                "input_charset=" + constParam.getInput_charset(),
                "version=" + constParam.getVersion(),
                "sign_method=" + constParam.getSign_method(),
                "extra=" + bdPayReqParam.getExtra()
        };

        //浏览器参数拼接数组
        String[]array1={
                "service_code=" + constParam.getService_code(),
                "sp_no=" + constParam.getSp_no(),
                "order_create_time=" + constParam.getOrder_create_time(),
                "order_no=" + constParam.getOrder_no(),
                "goods_category=" + bdPayReqParam.getGoods_category(),
                "goods_name=" + URLEncoder.encode(bdPayReqParam.getGoods_name(),"gbk"),
                "goods_desc=" + URLEncoder.encode(bdPayReqParam.getGoods_desc(),"gbk"),
                "goods_url=" + URLEncoder.encode(bdPayReqParam.getGoods_url(),"gbk"),
                "unit_amount=" + bdPayReqParam.getUnit_amount(),
                "unit_count=" + bdPayReqParam.getUnit_count(),
                "transport_amount=" + bdPayReqParam.getTransport_amount(),
                "total_amount=" + bdPayReqParam.getTotal_amount(),
                "currency=" + constParam.getCurrency(),
                "buyer_sp_username=" + URLEncoder.encode(bdPayReqParam.getBuyer_sp_username(),"gbk"),
                "return_url=" + URLEncoder.encode(bdPayReqParam.getReturn_url(),"gbk"),
                "page_url=" + URLEncoder.encode(bdPayReqParam.getPage_url(),"gbk"),
                "pay_type=" + bdPayReqParam.getPay_type(),
                "bank_no=" + bdPayReqParam.getBank_no(),
                "expire_time=" + constParam.getExpire_time(),
                "input_charset=" + constParam.getInput_charset(),
                "version=" + constParam.getVersion(),
                "sign_method=" + constParam.getSign_method(),
                "extra=" + URLEncoder.encode(bdPayReqParam.getExtra() == null ? "": bdPayReqParam.getExtra(),"gbk")
        };

        String getURL = new BfbSdkComm().create_baifubao_pay_order_url(array,array1,constParam.getBFB_PAY_DIRECT_LOGIN_URL(), BdPayUtil.getChannelKey());
        System.out.println("url:" + getURL);

        response.sendRedirect(getURL);

    }

    @GetMapping(value = "/bdpay")
    public void bdpay(@Param("payType") String payType,HttpServletResponse response) throws Exception {

        response.setCharacterEncoding("gbk");
        response.setContentType("text/html;charset=gbk");
        response.setHeader("content-type","text/html;charset=gbk");

        BdPayReqParam bdPayReqParam = new BdPayReqParam();
        bdPayReqParam.setGoods_category("1");
        bdPayReqParam.setGoods_name("百度钱包百发needlogin");
        bdPayReqParam.setGoods_desc("百度百发百发百中needlogin");
        bdPayReqParam.setGoods_url("https://www.baifubao.com/");
        bdPayReqParam.setUnit_amount("1");
        bdPayReqParam.setUnit_count("1");
        bdPayReqParam.setTransport_amount("0");
        bdPayReqParam.setTotal_amount("1");
        bdPayReqParam.setBuyer_sp_username("三国乐斗spusername");
        bdPayReqParam.setReturn_url("http://113.47.214.147:8080/ReturnServlet");
        bdPayReqParam.setPage_url("http://localhost:8080/baiduqbpc/ReturnServlet");
        bdPayReqParam.setPay_type("2");
        bdPayReqParam.setBank_no("201");
        bdPayReqParam.setExtra("用户自定义数据");

        BdPayConstParam constParam = new BdPayConstParam();
        constParam.initConst();

        //签名串拼接数组
        String[] array={
                "service_code=" + constParam.getService_code(),
                "sp_no=" + constParam.getSp_no(),
                "order_create_time=" + constParam.getOrder_create_time(),
                "order_no=" + constParam.getOrder_no(),
                "goods_category=" + bdPayReqParam.getGoods_category(),
                "goods_name=" + bdPayReqParam.getGoods_name(),
                "goods_desc=" + bdPayReqParam.getGoods_desc(),
                "goods_url=" + bdPayReqParam.getGoods_url(),
                "unit_amount=" + bdPayReqParam.getUnit_amount(),
                "unit_count=" + bdPayReqParam.getUnit_count(),
                "transport_amount=" + bdPayReqParam.getTransport_amount(),
                "total_amount=" + bdPayReqParam.getTotal_amount(),
                "currency=" + constParam.getCurrency(),
                "buyer_sp_username=" + bdPayReqParam.getBuyer_sp_username(),
                "return_url=" + bdPayReqParam.getReturn_url(),
                "page_url=" + bdPayReqParam.getPage_url(),
                "pay_type=" + bdPayReqParam.getPay_type(),
                "bank_no=" + bdPayReqParam.getBank_no(),
                "expire_time=" + constParam.getExpire_time(),
                "input_charset=" + constParam.getInput_charset(),
                "version=" + constParam.getVersion(),
                "sign_method=" + constParam.getSign_method(),
                "extra=" + bdPayReqParam.getExtra()
        };

        //浏览器参数拼接数组
        String[]array1={
                "service_code=" + constParam.getService_code(),
                "sp_no=" + constParam.getSp_no(),
                "order_create_time=" + constParam.getOrder_create_time(),
                "order_no=" + constParam.getOrder_no(),
                "goods_category=" + bdPayReqParam.getGoods_category(),
                "goods_name=" + URLEncoder.encode(bdPayReqParam.getGoods_name(),"gbk"),
                "goods_desc=" + URLEncoder.encode(bdPayReqParam.getGoods_desc(),"gbk"),
                "goods_url=" + URLEncoder.encode(bdPayReqParam.getGoods_url(),"gbk"),
                "unit_amount=" + bdPayReqParam.getUnit_amount(),
                "unit_count=" + bdPayReqParam.getUnit_count(),
                "transport_amount=" + bdPayReqParam.getTransport_amount(),
                "total_amount=" + bdPayReqParam.getTotal_amount(),
                "currency=" + constParam.getCurrency(),
                "buyer_sp_username=" + URLEncoder.encode(bdPayReqParam.getBuyer_sp_username(),"gbk"),
                "return_url=" + URLEncoder.encode(bdPayReqParam.getReturn_url(),"gbk"),
                "page_url=" + URLEncoder.encode(bdPayReqParam.getPage_url(),"gbk"),
                "pay_type=" + bdPayReqParam.getPay_type(),
                "bank_no=" + bdPayReqParam.getBank_no(),
                "expire_time=" + constParam.getExpire_time(),
                "input_charset=" + constParam.getInput_charset(),
                "version=" + constParam.getVersion(),
                "sign_method=" + constParam.getSign_method(),
                "extra=" + URLEncoder.encode(bdPayReqParam.getExtra() == null ? "": bdPayReqParam.getExtra(),"gbk")
        };

        String getURL = new BfbSdkComm().create_baifubao_pay_order_url(array,array1,constParam.getBFB_PAY_DIRECT_LOGIN_URL(),BdPayUtil.getChannelKey());
        System.out.println("url:" + getURL);

        response.sendRedirect(getURL);
    }

    @GetMapping(value = "/bdpayQR")
    public void bdpayQR(HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("gbk");
        response.setContentType("text/html;charset=gbk");
        response.setHeader("content-type","text/html;charset=gbk");

        BdPayQRReq bdPayQRReq = new BdPayQRReq();
        bdPayQRReq.setSp_no("9000100005");
        // bdPayQRReq.setBuyer_sp_username("三国乐斗spusername");
        bdPayQRReq.setGoods_name("商品名称");
        bdPayQRReq.setGoods_desc("商品描述");
        bdPayQRReq.setGoods_url("https://127.0.0.1");
        bdPayQRReq.setUnit_amount("1");
        bdPayQRReq.setUnit_count("1");
        bdPayQRReq.setTransport_amount("0");
        bdPayQRReq.setTotal_amount("1");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 2);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMddHHmmss");
        bdPayQRReq.setExpire_time(formatter.format(c.getTime()).substring(0, 14));
        bdPayQRReq.setOrder_create_time(formatter.format(System.currentTimeMillis()));
        bdPayQRReq.setOrder_no(System.currentTimeMillis() + "");
        System.out.println("订单号：" + bdPayQRReq.getOrder_no());
        // bdPayQRReq.setSp_uno("843680335@qq.com");
        bdPayQRReq.setReturn_url("http://192.168.1.106:8443/baidu/testNotify");
        bdPayQRReq.setPage_url("www.baidu.com");
        bdPayQRReq.setPay_type("2");

        String getUrl = BdPayUtil.getBdPayQRUrl(bdPayQRReq,"https://www.baifubao.com/o2o/0/code/0/create/0",BdPayUtil.getChannelKey());
        System.out.println("url:" + getUrl);

        response.sendRedirect(getUrl);
    }

    @GetMapping(value = "/bdpayH5")
    public void bdpayH5(HttpServletResponse response) {
        response.setCharacterEncoding("gbk");
        response.setContentType("text/html;charset=gbk");
        response.setHeader("content-type","text/html;charset=gbk");

        // init req
        BdPayH5Req bdPayH5Req = new BdPayH5Req();
        bdPayH5Req.setSp_no("9000100005");
        bdPayH5Req.setBuyer_sp_username("三国乐斗spusername");
        bdPayH5Req.setGoods_name("baifubao_game");
        bdPayH5Req.setGoods_desc("baifubao_game_desc");
        bdPayH5Req.setGoods_url("https://127.0.0.1");
        bdPayH5Req.setUnit_amount("1");
        bdPayH5Req.setUnit_count("1");
        bdPayH5Req.setTransport_amount("0");
        bdPayH5Req.setTotal_amount("1");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 2);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMddHHmmss");
        bdPayH5Req.setExpire_time(formatter.format(c.getTime()).substring(0, 14));
        bdPayH5Req.setOrder_create_time(formatter.format(System.currentTimeMillis()));
        bdPayH5Req.setOrder_no(System.currentTimeMillis() + "");
        System.out.println("order no:" + bdPayH5Req.getOrder_no());
        bdPayH5Req.setReturn_url("http://192.168.1.106:8443/baidu/testNotify");
        bdPayH5Req.setPage_url("www.baidu.com");
        bdPayH5Req.setPay_type("2");
        bdPayH5Req.setBank_no("201");
        bdPayH5Req.setExtra("用户自定义数据");

        String getUrl = null;
        try {
            getUrl = BdPayUtil.getBdPayH5Url(bdPayH5Req, H5_URL, BdPayUtil.getChannelKey());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("url:" + getUrl);

        try {
            response.sendRedirect(getUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @GetMapping(value = "/bdpayQRQuery")
    public void bdpayQRQuery(@Param("orderNo") String orderNo) throws Exception {
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
    public void testQRNotify(BdPayQRNotifyReq bdPayQRNotifyReq) throws Exception{
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
