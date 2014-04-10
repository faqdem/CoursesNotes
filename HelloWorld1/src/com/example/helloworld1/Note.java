package com.example.helloworld1;

public class Note {

	private String title;
	private String content;
	
	public String getTitle()
	{
		return this.title;
	}
	public String getContent()
	{
		return this.content;
	}
	
	public Note()
	{
		this.title = null;
		this.content = null;
	}
	public Note(String t, String c)
	{
		this.title = t;
		this.content = c;
	}
}
