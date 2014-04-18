package com.example.notes;

import com.example.helloworld1.R;
import com.example.notes.Singleton.LoginException;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class LoginActivity extends Activity implements TabListener {

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		
		switch (tab.getPosition())
		{
			case 0:
				ft.replace(R.id.container, new LoginFragment() );
				break;
			case 1:
				ft.replace(R.id.container, new RegistrationFragment() );
				break;
		}
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar bar = getActionBar();
		bar.setNavigationMode(bar.NAVIGATION_MODE_TABS);
		Tab tab = bar.newTab()
				.setText(R.string.tab_login)
				.setTabListener(this);
		
		bar.addTab(tab);
		
		tab = bar.newTab()
				.setText(R.string.tab_registration)
				.setTabListener(this);
		bar.addTab(tab);
				
		Singleton.getInstance().usersList.add(new User("Stas","1234"));
		/*if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new LoginFragment()).commit();
		
		}*/
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class LoginFragment extends Fragment {

		public LoginFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			Button button1 = (Button) rootView.findViewById(R.id.login_button);
			button1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Log.i("But1","Hello button");
					String login = ((EditText)(getView().findViewById(R.id.login_login))).getText().toString();
					String password = ((EditText)(getView().findViewById(R.id.login_password))).getText().toString();
					try {
						Singleton.getInstance().login(login, password);
					} catch (LoginException e) {
						// TODO Auto-generated catch block
						Toast.makeText(getActivity(), e.getResult().toString(), Toast.LENGTH_SHORT).show();
						return;
					}
						startActivity(new Intent(getActivity(), NotesActivity.class));
				}
			});
			return rootView;
		}
	}
	public static class RegistrationFragment extends Fragment {

		public RegistrationFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_registration, container,
					false);
			Button button1 = (Button) rootView.findViewById(R.id.registration_button);
			button1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Log.i("But2","Hello button");
					startActivity(new Intent(getActivity(), NotesActivity.class));
				}
			});
			return rootView;
		}
	}

}
