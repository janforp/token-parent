package com.janita.jwt.token.bean;

import java.io.Serializable;

/**
 * Created by Janita on 2017-03-28 16:14
 */
public class Token implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String audience;

    private String issuer;

    private String username;

    private long iat;

    private long exp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public long getIat() {
        return iat;
    }

    public void setIat(long iat) {
        this.iat = iat;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
