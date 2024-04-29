package com.example.myapplication.objects;

public class AccountData {
    private String login;
    private String password;

    public AccountData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
