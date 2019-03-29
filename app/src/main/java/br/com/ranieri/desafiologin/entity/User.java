package br.com.ranieri.desafiologin.entity;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("user_id")
    private long id;

    @SerializedName("user_email")
    private String email;

    @SerializedName("user_password")
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
