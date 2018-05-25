package com.ezial.bgmanage.common.utils.baidu;

import com.ezial.bgmanage.common.model.baidu.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BdPayUtil {
    static BdPayConstParam constParam = new BdPayConstParam();

    public static String getBdPayUrl(BdPayReqParam bdPayReqParam, String key) throws UnsupportedEncodingException {

        // 签名串拼接数组
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

        return new BfbSdkComm().create_baifubao_pay_order_url(array,array1,constParam.getBFB_PAY_DIRECT_LOGIN_URL(),key);

    }

    public static String getBdPayQRUrl(BdPayQRReq bdPayQRReq, String bdo2oCreateUrl, String key) throws UnsupportedEncodingException {
        //签名串拼接数组
        String[]array={
                "service_code=" + bdPayQRReq.getService_code(),
                "sp_no=" + bdPayQRReq.getSp_no(),
                "order_create_time=" + bdPayQRReq.getOrder_create_time(),
                "order_no=" + bdPayQRReq.getOrder_no(),
                "goods_name=" + bdPayQRReq.getGoods_name(),
                "goods_desc=" + bdPayQRReq.getGoods_desc(),
                "goods_url=" + bdPayQRReq.getGoods_url(),
                "unit_amount=" + bdPayQRReq.getUnit_amount(),
                "unit_count=" + bdPayQRReq.getUnit_count(),
                "transport_amount=" + bdPayQRReq.getTransport_amount(),
                "total_amount=" + bdPayQRReq.getTotal_amount(),
                "currency=" + bdPayQRReq.getCurrency(),
                "return_url=" + bdPayQRReq.getReturn_url(),
                "pay_type=" + bdPayQRReq.getPay_type(),
                "expire_time=" + bdPayQRReq.getExpire_time(),
                "input_charset=" + bdPayQRReq.getInput_charset(),
                "version=" + bdPayQRReq.getVersion(),
                "sign_method=" + bdPayQRReq.getSign_method(),
                "extra=" + bdPayQRReq.getExtra()
        };
        //浏览器参数拼接数组
        String[]array1={
                "code_type=" + bdPayQRReq.getCode_type(),
                "code_size=" + bdPayQRReq.getCode_size(),
                "output_type=" + bdPayQRReq.getOutput_type(),
                "nologo=" + bdPayQRReq.getNologo(),
                "mname=" + URLEncoder.encode(bdPayQRReq.getMname(),"gbk"),
                "tno=" + bdPayQRReq.getTno(),
                "service_code=" + bdPayQRReq.getService_code(),
                "sp_no=" + bdPayQRReq.getSp_no(),
                "order_create_time=" + bdPayQRReq.getOrder_create_time(),
                "order_no=" + bdPayQRReq.getOrder_no(),
                "goods_name=" + URLEncoder.encode(bdPayQRReq.getGoods_name(),"gbk"),
                "goods_desc=" + URLEncoder.encode(bdPayQRReq.getGoods_desc(),"gbk"),
                "goods_url=" + URLEncoder.encode(bdPayQRReq.getGoods_url(),"gbk"),
                "unit_amount=" + bdPayQRReq.getUnit_amount(),
                "unit_count=" + bdPayQRReq.getUnit_count(),
                "transport_amount=" + bdPayQRReq.getTransport_amount(),
                "total_amount=" + bdPayQRReq.getTotal_amount(),
                "currency=" + bdPayQRReq.getCurrency(),
                "return_url="+ URLEncoder.encode(bdPayQRReq.getReturn_url(),"gbk"),
                "pay_type=" + bdPayQRReq.getPay_type(),
                "expire_time=" + bdPayQRReq.getExpire_time(),
                "input_charset=" + bdPayQRReq.getInput_charset(),
                "version=" + bdPayQRReq.getVersion(),
                "sign_method=" + bdPayQRReq.getSign_method(),
                "extra="+URLEncoder.encode(bdPayQRReq.getExtra(),"gbk")
        };
        /**
         * 4、调用bfb_sdk_comm里create_bdpay_pay_order_url方法生成百度钱包扫码支付接口URL
         *   array是待签名串
         *   array1地址栏拼接串
         *
         */
        return new BfbSdkComm().create_bdpay_pay_order_url(array,array1,bdo2oCreateUrl,key);
    }

    public static String getBdPayo2oQueryUrl(BdPayQueryReq bdPayQueryReq, String bdo2oQueryUrl, String key) throws UnsupportedEncodingException{
        // 给提交参数数值赋值
        String[] array = {
                "order_no=" + bdPayQueryReq.getOrder_no(),
                "input_charset=" + bdPayQueryReq.getInput_charset(),
                "sign_method=" + bdPayQueryReq.getSign_method(),
                "sp_no=" + bdPayQueryReq.getSp_no(),
                "version=" + bdPayQueryReq.getVersion()};

        return new BfbSdkComm().create_bdpay_pay_order_url(array,array,bdo2oQueryUrl,key);
    }

    public static String getBdPayH5Url(BdPayH5Req bdPayH5Req, String bdo2oCreateUrl, String key) throws UnsupportedEncodingException {
        //签名串拼接数组
        String[]array={
                "service_code=" + bdPayH5Req.getService_code(),
                "sp_no=" + bdPayH5Req.getSp_no(),
                "order_create_time=" + bdPayH5Req.getOrder_create_time(),
                "order_no=" + bdPayH5Req.getOrder_no(),
                "goods_name=" + bdPayH5Req.getGoods_name(),
                "goods_desc=" + bdPayH5Req.getGoods_desc(),
                "goods_url=" + bdPayH5Req.getGoods_url(),
                "unit_amount=" + bdPayH5Req.getUnit_amount(),
                "unit_count=" + bdPayH5Req.getUnit_count(),
                "transport_amount=" + bdPayH5Req.getTransport_amount(),
                "total_amount=" + bdPayH5Req.getTotal_amount(),
                "currency=" + bdPayH5Req.getCurrency(),
                "buyer_sp_username=" + bdPayH5Req.getBuyer_sp_username(),
                "return_url=" + bdPayH5Req.getReturn_url(),
                "page_url=" + bdPayH5Req.getPage_url(),
                "pay_type=" + bdPayH5Req.getPay_type(),
                "bank_no=" + bdPayH5Req.getBank_no(),
                "expire_time=" + bdPayH5Req.getExpire_time(),
                "input_charset=" + bdPayH5Req.getInput_charset(),
                "version=" + bdPayH5Req.getVersion(),
                "sign_method=" + bdPayH5Req.getSign_method(),
                "extra=" + bdPayH5Req.getExtra()
        };
        //浏览器参数拼接数组
        String[]array1={
                "service_code=" + bdPayH5Req.getService_code(),
                "sp_no=" + bdPayH5Req.getSp_no(),
                "order_create_time=" + bdPayH5Req.getOrder_create_time(),
                "order_no=" + bdPayH5Req.getOrder_no(),
                "goods_name=" + URLEncoder.encode(bdPayH5Req.getGoods_name(),"gbk"),
                "goods_desc=" + URLEncoder.encode(bdPayH5Req.getGoods_desc(),"gbk"),
                "goods_url=" + URLEncoder.encode(bdPayH5Req.getGoods_url(),"gbk"),
                "unit_amount=" + bdPayH5Req.getUnit_amount(),
                "unit_count=" + bdPayH5Req.getUnit_count(),
                "transport_amount=" + bdPayH5Req.getTransport_amount(),
                "total_amount=" + bdPayH5Req.getTotal_amount(),
                "currency=" + bdPayH5Req.getCurrency(),
                "buyer_sp_username=" + URLEncoder.encode(bdPayH5Req.getBuyer_sp_username(),"gbk"),
                "return_url="+ URLEncoder.encode(bdPayH5Req.getReturn_url(),"gbk"),
                "page_url="+ URLEncoder.encode(bdPayH5Req.getPage_url(),"gbk"),
                "pay_type=" + bdPayH5Req.getPay_type(),
                "bank_no=" + bdPayH5Req.getBank_no(),
                "expire_time=" + bdPayH5Req.getExpire_time(),
                "input_charset=" + bdPayH5Req.getInput_charset(),
                "version=" + bdPayH5Req.getVersion(),
                "sign_method=" + bdPayH5Req.getSign_method(),
                "extra="+URLEncoder.encode(bdPayH5Req.getExtra(),"gbk")
        };
        /**
         * 4、调用bfb_sdk_comm里create_bdpay_pay_order_url方法生成百度钱包扫码支付接口URL
         *   array是待签名串
         *   array1地址栏拼接串
         *
         */
        return new BfbSdkComm().create_bdpay_pay_order_url(array,array1,bdo2oCreateUrl,key);
    }

    public static String getChannelKey(){
//        String o =(String) GuavaCache.get(channel);
//        if(null==o){
//            String channelKey = null;
//            try {
//                channelKey = channelService.findChannelKey(channel);
//            } catch (Exception e) {
//                LOGGER.error("BdUtil getChannelKey error:",e);
//            }
//            if(StringUtils.isNotBlank(channelKey)){
//                GuavaCache.put(channel,channelKey);
//                o=channelKey;
//            }
//        }
        return "pSAw3bzfMKYAXML53dgQ3R4LsKp758Ss";
    }

}
