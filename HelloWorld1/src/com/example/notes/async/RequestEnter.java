package com.example.notes.async;

/**
 * Created by student on 5/12/14.
 */
public class RequestEnter {
    private String mLogin;
    private String mPass;

    RequestEnter(String login, String pass){
        this.mLogin = login;
        this.mPass = pass;
    }

    public String getmPass()
    {
        return this.mPass;
    }

    public String getmLogin(){
        return this.mLogin;
    }

}
