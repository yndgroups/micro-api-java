package ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.utils;

import ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration.ResponseEnum;
import ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration.CustomException;
import ${cfg.basePackage}<#if package.ModuleName??>.${package.ModuleName}</#if>.configuration.Constant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.RsaProvider;
import org.apache.commons.codec.binary.Base64;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *@description jwt加解密
 *@return
 *@params
 *@author yangdaqiong
 *@date 2019-07-28 23:53
 **/
public class JwtUtil {
    /**
     * description: token 生成
     *
     * @param userMap
     * @return String
     * @author yangdaqiong
     * @date  2019-06-20 17:03
     */
    public static String createTokenString(HashMap<String, Object> userMap) {
        Map<String, Object> claims = new HashMap<>(0);
        claims.put("userId", userMap.get("userId"));
        claims.put("userName", userMap.get("userName"));
        claims.put("areaCode", userMap.get("areaCode"));
        claims.put("areaName", userMap.get("areaName"));
        claims.put("appId", userMap.get("appId"));
        try {
            return encoderToken(userMap.get("userId").toString(), claims);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(ResponseEnum.TOKEN_CRATE_FAIL);
        }
    }

    /**
     * description token解析
     *
     * @param token
     * @return Claims
     * @author yangdaqiong
     * @date 2019-06-20 17:03
     */
    public static Claims parseToken(String token) {
        try {
            return decoderToken(token);
        } catch (Exception e) {
            throw  new CustomException(ResponseEnum.TOKEN_PARSE_ERROR);
        }
    }

    /**
     * description 生成token
     *
     * @param userId
     * @param claims
     * @return string
     * @author yangdaqiong
     * @date 2020/03/26 15:26
     **/
    public static String encoderToken(String userId, Map<String, Object> claims) throws Exception {
        String privateKey = Constant.jwtPrivateSecret;
        try {
            PrivateKey key = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(java.util.Base64.getDecoder().decode(privateKey)));
            return Jwts.builder().setClaims(claims)
                    .setIssuer(userId)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 10800 * 1000))
                    .signWith(SignatureAlgorithm.forName("RS512"), key).compact();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * description 解析token
     *
     * @param token
     * @return Claims
     * @author yangdaqiong
     * @date 2020/03/26 15:26
     **/
    public static Claims decoderToken(String token) throws Exception {
        try {
            String publicKey = Constant.jwtPublicSecret;
            PublicKey key = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(java.util.Base64.getDecoder().decode(publicKey)));
            return Jwts.parser().setSigningKey(key).parseClaimsJws(token.replace("Bearer ","")).getBody();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * description 秘钥生成
     *
     * @param
     * @return
     * @author yangdaqiong
     * @date 2020/03/26 16:03
     **/
    public static void createKeyPairs() {
        KeyPair keyPair = RsaProvider.generateKeyPair(1024);
        System.out.println("publicKey---->" + Base64.encodeBase64String(keyPair.getPublic().getEncoded()));
        System.out.println("privateKey----->" + Base64.encodeBase64String(keyPair.getPrivate().getEncoded()));
    }

    public static void main(String[] args) throws Exception {
        createKeyPairs();
    }
}