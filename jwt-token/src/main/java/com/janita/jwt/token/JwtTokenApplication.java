package com.janita.jwt.token;

import com.auth0.jwt.JWTVerifyException;
import com.janita.jwt.token.bean.Token;
import com.janita.jwt.token.util.TokenUtil;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;

/**
 * Created by Janita on 2017-03-28 16:16
 */
public class JwtTokenApplication {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, JWTVerifyException, InvalidKeyException, SignatureException {

        String jwtToken = TokenUtil.createToken("",10000,1);
        System.out.println("*******"+jwtToken);

        Token token = TokenUtil.parseToken(jwtToken);

        System.out.println("*******"+token.getId());

    }
}
