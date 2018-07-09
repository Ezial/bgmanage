package com.ezial.bgmanage.dubbo.provider.dubbo.consumer.common.utils;

import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

public class JwtUtil {

    /**
     * 由字符串生成加密key
     * @return
     */
    public static SecretKey generalKey(){
        String stringKey = "123";
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 创建jwt
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     * @throws Exception
     */
    public static String createJWT(String id, String subject, long ttlMillis) throws Exception {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey key = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .signWith(signatureAlgorithm, key);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    /**
     * 解密jwt
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception{
        SecretKey key = generalKey();
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

  public static void main(String[] args) {
      try {
          String token = createJWT("ls","nb",15000l);
          System.out.println(token);
          Claims claims = parseJWT(token);

          System.out.println(claims.getId() + "--------------------------  " + claims.getSubject());
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

  //
//    /**
//     * 生成subject信息
//     * @param user
//     * @return
//     */
//    public static String generalSubject(t_user user){
//        JSONObject jo = new JSONObject();
//        jo.put("userId", user.getId());
//        jo.put("mobile", user.getMobile());
//        return jo.toJSONString();
//    }

}
