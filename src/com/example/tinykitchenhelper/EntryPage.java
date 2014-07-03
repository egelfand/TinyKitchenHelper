package com.example.tinykitchenhelper;

import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EntryPage extends Activity {
	TextView welcomeText;
	Button guest, signIn, newUser;
	EditText username, input;
	String name;
	AlertDialog.Builder builder = new AlertDialog.Builder(this);
	HashMap<String, String> savedUsernames;
	int numberOfUsers = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entry_page);
		welcomeText = (TextView) findViewById(R.id.welcomeText);
		username = (EditText) findViewById(R.id.uN);
		guest = (Button) findViewById(R.id.guest);
		input.setInputType(InputType.TYPE_CLASS_TEXT);
		guest.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				builder.setTitle("Welcome, Guest!").setMessage("if you are using this app as a guest, be sure to know that your information will NOT be saved.")
				.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						name = input.getText().toString();
						addNewUser(name);
					}
				}).setCancelable(false).setNegativeButton(R.string.No, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						name = "guest";
					}
				}).show();
			}
		});
		signIn = (Button) findViewById(R.id.signIn);
		signIn.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				name = username.getText().toString();
				mapOfUserNames(name);
			}
		});
	}

	public void mapOfUserNames(String attemptedUN){
		if (savedUsernames.size()==(0)|| numberOfUsers == 0){
			//tell them to addNewUser(attemptedUN);
		}
		else{
			for (int i = 0; i<numberOfUsers; i++){
				if (savedUsernames.get("user" + String.valueOf(i))== attemptedUN){
					//start the app
				} else {
					//tell them to addNewUser(attemptedUN);
				}
			} 
		}
	}

	public void addNewUser(String newUsername){
		String key = "user" + String.valueOf(numberOfUsers);
		savedUsernames.put(key, newUsername);
		numberOfUsers+=1;
		//prompt them to sign in correctly
	}

}
