package ynd.core.jwt;

import ynd.core.constant.BaseConstant;
import ynd.core.emums.ResponseEnum;
import ynd.core.exception.CustomException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.RsaProvider;
import org.apache.commons.codec.binary.Base64;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.HashMap;

public class JwtManage {

    /**
     * description: token 生成
     *
     * @param userMap 生成token的用户信息参数
     * @return String token字符串
     * @author Yang Daqiong
     * @date 2019-06-20 17:03
     */
    public static String createToken(HashMap<String, Object> userMap) throws CustomException {
        try {
            PrivateKey key = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(java.util.Base64.getDecoder().decode(BaseConstant.jwtPrivateSecret)));
            Date date = new Date();
            return Jwts.builder().setClaims(userMap)
                    .setIssuer(userMap.get("userId").toString())
                    .setIssuedAt(date)
                    .setExpiration(new Date(date.getTime() + 10800 * 1000))
                    .signWith(SignatureAlgorithm.forName("RS512"), key).compact();
        } catch (Exception e) {
            throw new CustomException(ResponseEnum.TOKEN_CREATE_FAIL);
        }
    }

    /**
     * description token解析
     *
     * @param token 用户token
     * @return Claims
     * @author Yang Daqiong
     * @date 2021-04-22 19:01:10
     **/
    public static Claims parseToken(String token)  {
        try {
            PublicKey key = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(java.util.Base64.getDecoder().decode(BaseConstant.jwtPublicSecret)));
            return Jwts.parser().setSigningKey(key).parseClaimsJws(token.replace("Bearer ", "")).getBody();
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new CustomException();
        }
    }

     /**
      * description 秘钥生成
      *
      * @param type 1:生成公钥 2：生成私钥
      * @return String 秘钥字符串
      * @author Yang Daqiong
      * @date 2021-04-22 19:36:30
      **/
    public static String createKeyPairs(Integer type) {
        KeyPair keyPair = RsaProvider.generateKeyPair(1024);
        if (type == 1) {
            return Base64.encodeBase64String(keyPair.getPublic().getEncoded());
        } else {
            return Base64.encodeBase64String(keyPair.getPrivate().getEncoded());
        }
    }
}
