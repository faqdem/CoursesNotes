package com.example.notes;

import android.app.Application;

public class NotesApplication extends Application{
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Singleton.getInstance().init();
	}


}
