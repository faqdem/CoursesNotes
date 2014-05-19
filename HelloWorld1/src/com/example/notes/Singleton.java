package com.example.notes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Singleton {

    public static final String DEMO_USER = "Stas";
    public static final String DEMO_PASSWORD = "1234";

	List<Note> notesList = new ArrayList<Note>();

	private Singleton() {

	}

    // NOTE METHODS HERE!!!

    public void deleteNote(String title){

    }

	private static Singleton sInstance;

    public HashMap<String, String> bufferNotes;
    public ArrayList<HashMap<String, String>> transferNotes;
	public static Singleton getInstance() {

		if (sInstance == null)
			sInstance = new Singleton();
		return sInstance;
	}

	public void init() {
		notesList.add(new Note("Note1", "Hello first note!!! BLABLA"));
        notesList.add(new Note("Note2", "Hello sec note!!!"));
        notesList.add(new Note("Note3", "Hello third note!!!"));

        try {
            register(DEMO_USER,DEMO_PASSWORD);
        } catch (RegistrationException e) {
            e.printStackTrace();
        }
    }

    public List<Note> getNotes(){
        return notesList;
    }


    public void addNote(Note n){

        this.notesList.add(n);

    }

    public ArrayList<HashMap<String, String>> getNotesList()
    {   transferNotes=new ArrayList<HashMap<String, String>>();
        for(Note n:notesList){
            bufferNotes=new HashMap<String, String>();
            bufferNotes.put("Title",n.getTitle());
            bufferNotes.put("Description",n.getContent());
            transferNotes.add(bufferNotes);
        }

        return transferNotes;
    }

	ArrayList<User> usersList = new ArrayList<User>();
	
	

	public void login(String name, String pass) throws LoginException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (User user : usersList) {
			if (user.getName().equals(name)) {
				if (user.getPassword().equals(pass)) {
					return;
				} else {
					throw new LoginException(LoginException.Result.WRONG_PASSWORD);
				}
			}
		}
        throw new LoginException(LoginException.Result.USER_NOT_FOUND);

    }

	public void register(String name, String pass) throws RegistrationException{
		for(User user : usersList){
			if (user.getName().equals(name))
				throw new RegistrationException(RegistrationException.Result.USERS_EXISTS);
			
		}
		if (pass.length() > 3)
			usersList.add(new User(name, pass));
		else throw new RegistrationException(RegistrationException.Result.SHORT_PASSWORD);
	}
	
	
	public static class LoginException extends Exception {

		public enum Result {
			USER_NOT_FOUND, WRONG_PASSWORD
		};

		private final Result mResult;

		public Result getResult() {
			return mResult;
		}

		public LoginException(Result result) {
			mResult = result;
		}

	}
	
	public static class RegistrationException extends Exception {
		
		public enum Result{
			USERS_EXISTS, SHORT_PASSWORD
		};
		
		private final Result mResult;
		
		public Result getResult()
		{
			return mResult;
		}
		
		public RegistrationException(Result result) {
			mResult = result;
		}
	}
	
	

}
