package com.ezial.bgmanage.common.utils.baidu;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;


public class BfbSdkComm {
	/**
	 * 生成百度钱包接口对应的URL
	 *
	 * @param ary $params	生成订单的参数数组，具体参数的取值参见接口文档
	 * @param url $url   百度钱包URL
	 * @return string 返回生成的百度钱包接口URL
	 * @throws UnsupportedEncodingException
	 */
	public String create_bdpay_pay_order_url(String[] ary,String[] ary1 ,String url,String key) throws UnsupportedEncodingException {

		//首先判断传入的必选参数是否为空
		//调用make_sign方法，返回签名结果sign，给参数排序和签名
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ary1.length; i++) {
			// 属性的值是否为空,值为空的参数名参与拼接，其他正常拼接
			ary1[i].substring(ary1[i].indexOf("=") + 1, ary1[i].length());

			sb.append(ary1[i] + "&");

		}
		String newStr =sb.toString();
		String sign=make_sign(ary,key);
		//组 URL get串提交串参数
		//提交

		String urlGet=url+"?"+newStr+"sign="+sign;
		return  urlGet;
	}

	/**
	 * 生成百度钱包PC端即时到账支付接口对应的URL
	 * @param ary
	 *        $params 生成订单的参数数组，具体参数的取值参见接口文档
	 * @param url
	 *        $url 百度钱包PC端即时到账支付接口URL
	 * @return string 返回生成的百度钱包PC端即时到账支付接口URL
	 * @throws UnsupportedEncodingException
	 */
	public String create_baifubao_pay_order_url(String[] ary, String[] ary1,
			String url,String key) throws UnsupportedEncodingException {
		// 首先判断传入的必选参数是否为空
		// 调用make_sign方法，返回签名结果sign，给参数排序和签名
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ary1.length; i++) {
			// 属性的值是否为空,值为空的参数名参与拼接，其他正常拼接
			ary1[i].substring(ary1[i].indexOf("=") + 1, ary1[i].length());

			sb.append(ary1[i] + "&");

		}
		String newStr = sb.toString();
		String sign = make_sign(ary,key);
		// 组 URL get串提交串参数
		// 提交
		String urlGet = url + "?" + newStr + "sign=" + sign;
		return urlGet;
	}

	/**
	 * 计算数组的签名，传入参数为数组，算法如下：
	 * 1. 对数组按KEY进行升序排序
	 * 2. 在排序后的数组中添加商户密钥，键名为key，键值为商户密钥
	 * 3. 将数组拼接成字符串，以key=value&key=value的形式进行拼接，注意这里不能直接调用
	 * http_build_query方法，因为该方法会对参数进行URL编码 4. 要所传入数组中的$params
	 * ['sign_method']定义的加密算法，对拼接好的字符串进行加密，生成的便是签名。 $params
	 * ['sign_method']等于1使用md5加密，等于2使用sha-1加密
	 *
	 * @param ary
	 *        $params 生成签名的数组
	 * @return string | boolean 成功返回生成签名，失败返回false
	 */
	public static String make_sign(String[] ary,String key) {
		Arrays.sort(ary, String.CASE_INSENSITIVE_ORDER);
		// 对参数数组进行按key升序排列,然后拼接，最后调用5签名方法
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ary.length; i++) {
			sb.append(ary[i] + "&");
		}
		// todo : 获取key
		key = "pSAw3bzfMKYAXML53dgQ3R4LsKp758Ss";
		String newStrTemp = sb.toString() + "key=" + key;
		// 获取sign_method
		String signmethod = GetMethodSign(newStrTemp);
		// 根据sign_method选择使用MD5签名1，还是哈希签名2
		String sign = null;
		if (signmethod.equals("1")) {
			sign = new MD5().md5Digest(newStrTemp);
		} else if (signmethod.equals("2")) {
			sign = new SHA1().Digest(newStrTemp, "gbk").toLowerCase();
		}
		return sign;
	}

	/**
	 * 查询订单情况，该方法需要商户自己实现，作用是查询商户自己的系统，验证该订单是否已经被处理了.
	 * 由于百度钱包的后台通知接口可能会调用多次，如果此处商户如果不处理，就直接进行记账等后续操作，
	 * 可能会一个订单在商户的系统里重复记录，造成商户的资金缺失.
	 * @param order_no
	 *        $order_no
	 * @return int 如果订单处于等待支付状态，返回sp_conf::SP_PAY_RESULT_WAITING 其它情况用户也可以自己定义
	 */
	public String query_order_state(String order_no) {
		/*
		 * 这里需要商户自己实现查询的相关业务逻辑,返回订单状态,我这里只是简单的返回1
		 */
		return "1";
	}

	/**
	 *选择签名方法
	 */
	private static String GetMethodSign(String sb) {
		int aa = sb.indexOf("sign_method=");
		String signmethod = sb.substring(aa + 12, aa + 13);
		return signmethod;
	}

}
