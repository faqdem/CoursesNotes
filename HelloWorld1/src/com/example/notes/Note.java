package com.example.notes;

public class Note {

	private String title;
	private String content;
    private long id;
	private static long lastId = 0;


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
        this.id = lastId++;
		this.title = null;
		this.content = null;
	}
	public Note(String t, String c)
	{
        this.id = lastId++;
		this.title = t;
		this.content = c;
	}

    public long getId(){
        return this.id;
    }



}
