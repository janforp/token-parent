package com.janita.jwt.token.token;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class TokenUtil {

    private static final String SALT = "GGKSI8HFLSAF";
    private static final String LOGIN_NAME = "loginName";
    private static final String TOKEN_TIME = "tokenTime";


    /**
     * 生成token的静态方法，
     * 传入用户的帐号和id
     * @param loginName  用户名
     * @return token
     */
    public static String createToken(String loginName, Long tokenTime){

        final JWTSigner signer = new JWTSigner(SALT);
        final HashMap<String, Object> claims = new HashMap<>();
        claims.put(LOGIN_NAME, loginName);
        claims.put(TOKEN_TIME, tokenTime);
        claims.put(LOGIN_NAME,loginName);
        return signer.sign(claims);
    }


    /**
     * 解析Token，其中可以获取id参数
     */
    public static TokenDto parseToken(String token) throws SignatureException, NoSuchAlgorithmException, JWTVerifyException, InvalidKeyException, IOException {

        TokenDto tokenDto = new TokenDto();
        final JWTVerifier verifier = new JWTVerifier(SALT);
        Map<String, Object> claims ;
        claims = verifier.verify(token);
        tokenDto.setLoginName(claims.get(LOGIN_NAME).toString());
        tokenDto.setTokenTime(Long.parseLong( claims.get(TOKEN_TIME).toString()));

        return tokenDto;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, SignatureException, JWTVerifyException, InvalidKeyException, IOException {
        String token = createToken("student", System.currentTimeMillis());
        System.out.println("\n***** 生成的token : " + token  +"\n");

        TokenDto dto = parseToken(token);

        System.out.println("\n***** token 解析成: " +  dto  +"\n");
    }
}
