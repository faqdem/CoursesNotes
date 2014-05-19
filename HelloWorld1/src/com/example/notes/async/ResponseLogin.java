package com.example.notes.async;

import com.example.notes.Singleton;

/**
 * Created by student on 5/12/14.
 */
public class ResponseLogin {
    private boolean success;
    private Singleton.LoginException.Result exResult;

    ResponseLogin(boolean success, Singleton.LoginException.Result exResult){
        this.exResult = exResult;
        this.success = success;

    }

    public boolean isSuccess() {
        return success;
    }

    public Singleton.LoginException.Result getExResult() {
        return exResult;
    }
}
