package br.com.ranieri.desafiologin.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class UserSession {

    @SerializedName("user_token")
    private String token;

    @SerializedName("token_expiration")
    private Date tokenExpiration;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTokenExpiration() {
        return tokenExpiration;
    }

    public void setTokenExpiration(Date tokenExpiration) {
        this.tokenExpiration = tokenExpiration;
    }
}
