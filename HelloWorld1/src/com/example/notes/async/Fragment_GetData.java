package com.example.notes.async;

import android.app.Fragment;

/**
 * Created by student on 5/12/14.
 */
public class Fragment_GetData extends Fragment {

    MyAsyncTask myAsyncTask;

    public Fragment_GetData(){
        setRetainInstance(true);
    }


    public void login(String login, String pass,ILoading loadingInterface){
        myAsyncTask = new MyAsyncTask();
        myAsyncTask.loadingInterface = loadingInterface;
        myAsyncTask.execute(new RequestEnter(login,pass));
    }

    public void setLoadingInterface(ILoading loadingInterface){
       // new MyAsyncTask().loadingInterface.setViewIsLoading(true);


    }
}