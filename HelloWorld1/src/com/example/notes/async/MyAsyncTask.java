package com.example.notes.async;

import android.os.AsyncTask;
import com.example.notes.Singleton;

/**
 * Created by student on 5/12/14.
 */
public class MyAsyncTask extends AsyncTask<RequestEnter,Void,ResponseLogin> {


    public ILoading loadingInterface;

    @Override
    protected ResponseLogin doInBackground(RequestEnter... requestEnters) {
        try {
            Singleton.getInstance().login(requestEnters[0].getmLogin(),requestEnters[0].getmPass());
        } catch (Singleton.LoginException e) {
            return new ResponseLogin(false,e.getResult());
        }


        return new ResponseLogin(true,null);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    //    Button buttonLock =
}
