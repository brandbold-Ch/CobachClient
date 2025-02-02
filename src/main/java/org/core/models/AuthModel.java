package org.core.models;

import com.google.gson.Gson;

public class AuthModel {
    private String username;
    private String password;

    public AuthModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AuthModel() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toJSON() {
        return new Gson().toJson(this);
    }
}
