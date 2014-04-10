package com.example.helloworld1;

import java.util.ArrayList;
import java.util.List;


public class Singleton {

	List<Note> notesList = new ArrayList<Note>();
	
	private Singleton()
	{
		
	}
	
	private static Singleton sInstance;
	
	public static Singleton getInstance()
	{
		
		if(sInstance == null)
			sInstance = new Singleton();
		return sInstance;
	}
	public void init()
	{
		notesList.add(new Note("Note1", "Hello first note!!! BLABLA"));
	}
}
