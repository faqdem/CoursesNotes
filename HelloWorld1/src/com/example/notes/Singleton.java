package com.example.notes;

import java.util.ArrayList;
import java.util.List;

import com.example.notes.LoginActivity.RegistrationFragment;

public class Singleton {

	List<Note> notesList = new ArrayList<Note>();

	private Singleton() {

	}

	private static Singleton sInstance;

	public static Singleton getInstance() {

		if (sInstance == null)
			sInstance = new Singleton();
		return sInstance;
	}

	public void init() {
		notesList.add(new Note("Note1", "Hello first note!!! BLABLA"));
	}

	ArrayList<User> usersList = new ArrayList<User>();
	
	

	public void login(String name, String pass) throws LoginException {
		for (User user : usersList) {
			if (user.getName().equals(name)) {
				if (user.getPassword().equals(pass)) {
					return;
				} else {
					throw new LoginException(LoginException.Result.WRONG_PASSWORD);
				}
			} else {
				throw new LoginException(LoginException.Result.USER_NOT_FOUND);
			}

		}
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
