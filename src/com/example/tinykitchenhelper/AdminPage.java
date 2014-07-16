package com.example.tinykitchenhelper;

import java.io.Serializable;
import java.util.HashMap;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class AdminPage extends Activity {
	int numberOfUsers;
	HashMap<String,String> savedUsernames;
	String key, user;
	Context context;
	Button view, remove;

	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_page);
		context = this;
		Bundle imported = this.getIntent().getExtras();
		numberOfUsers = imported.getInt("number");
		Serializable output = imported.getSerializable("names");
		savedUsernames = (HashMap<String, String>) output;
		view = (Button) findViewById(R.id.view);
		view.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				System.out.println("doing something1");
				seeUsers();
			}
		});

		remove = (Button) findViewById(R.id.remove);
		remove.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				dialog();
			}
		});
	}

	public void dialog(){
		AlertDialog.Builder removeDialog = new AlertDialog.Builder(context);
		final EditText userName = (EditText) findViewById(R.id.editTextDialogUserInput);
		removeDialog.setCancelable(false).setTitle("Remove").setMessage("be sure to have entered a username")
		.setPositiveButton("I did",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int id) {
				user = userName.getText().toString();
				removeUser(user);
			}
		})
		.setNegativeButton("I forgot", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int id) {
				dialog.cancel();
			}
		}).setCancelable(true).show();
	}

	public void seeUsers(){
		if (numberOfUsers>0 || savedUsernames.size()>0){
			for (int i = 0; i<numberOfUsers; i++){
				System.out.println(savedUsernames.get("user" + String.valueOf(i)));
			}
		}else{
			Toast.makeText(context, "no users", Toast.LENGTH_SHORT).show();
		}
	}

	public void removeUser(String nameToRemove){
		user = nameToRemove;
		if (numberOfUsers>0 || savedUsernames.size()>0){
			for (int i = 0; i<numberOfUsers; i++){
				key = "user" + String.valueOf(i);
				System.out.println("key value " + key);
				if(savedUsernames.get(key)==user){
					new AlertDialog.Builder(context).setMessage("Remove " + savedUsernames.get(key) + "?")
					.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							savedUsernames.remove(key);
							Toast.makeText(context, user + "removed", Toast.LENGTH_SHORT).show();
						}
					}).setNegativeButton("No", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					}).show();
				}
			}
		} else {
			Toast.makeText(context, "no users to remove", Toast.LENGTH_SHORT).show();

		}
	}
}
