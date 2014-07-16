package com.example.tinykitchenhelper;

import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileSetup extends Activity {
	TextView welcomeText;
	Button guest, signIn, newProfile;
	EditText profileName, input;
	String name, key;
	HashMap<String, String> savedProfiles = new HashMap<String,String>();
	int numberOfUsers = 0;
	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_setup);
		context = this;
		welcomeText = (TextView) findViewById(R.id.welcomeText); //IS THIS NECESSARY OR PATRONIZING?
		profileName = (EditText) findViewById(R.id.uN);
		guest = (Button) findViewById(R.id.guest);
		guest.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				new AlertDialog.Builder(context).setTitle("Welcome, Guest!")
				.setMessage("If you are using this app as a guest, be sure to know that your information will NOT be saved.")
				.setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						Toast.makeText(context, "Welcome, guest", Toast.LENGTH_SHORT).show();
						Intent returnToManager = new Intent(context, ProfileManager.class);
						startActivity(returnToManager); //IS THIS FINE? CHANGE GUEST TO BE DEFAULT IF THIS RETURNS WITH NO EXTRAS
					}
				}).setNegativeButton(R.string.reject, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				}).show();
			}
		});
		signIn = (Button) findViewById(R.id.signIn);
		signIn.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				name = profileName.getText().toString();
				mapOfUserNames(name);
			}
		});
		newProfile = (Button) findViewById(R.id.newProfile);
		newProfile.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				name = profileName.getText().toString();
				addNewUser(name);
			}
		});
	}
	
	public void mapOfUserNames(String attemptedUN){
		//FILL SAVEDPROFILES WITH INTERNAL STORAGE DATA
		if (savedProfiles.size()<1 || numberOfUsers == 0){ //CHANGE THIS: if file!exist
			new AlertDialog.Builder(context).setTitle("Sorry,")
			.setMessage("There are currently no stored usernames. Please create a new profile.")
			.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
				}
			}).setCancelable(true).show();	
		}
		else{
			for (int i = 0; i<numberOfUsers; i++){
				if (savedProfiles.get("user" + String.valueOf(i))== attemptedUN){ //CHANGE THIS
					Toast.makeText(context, "Welcome, " + attemptedUN, Toast.LENGTH_SHORT).show();
					Intent backToManager = new Intent(context, ProfileManager.class);
					backToManager.putExtra("username", attemptedUN);
					startActivity(backToManager);
				} else {
					new AlertDialog.Builder(context).setTitle("Sorry,")
					.setMessage("Your username is not recognized. Please create a new profile.")
					.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					}).setCancelable(true).show();
				}
			} 
		}
	}

	public void addNewUser(String newUsername){
		if (newUsername.equals("")){
			Toast.makeText(context, "please add a full username", Toast.LENGTH_SHORT).show();
		} else {
			addNewProfileName(newUsername);
			Toast.makeText(context, "Username add successful", Toast.LENGTH_SHORT).show();
			//should something else happen here? Should this happen at all?
			//Intent returnToManager = new Intent(context, ProfileManager.class);
			//startActivity(returnToManager);
		}
	}
	
	public void getSavedProfileNames(){
		//SHOULD BE CALLED BEFORE STARTING?!
		Intent readStorage = new Intent(context, InternalStorageReadWrite.class);
		readStorage.putExtra("filename", "ProfileUsername");
		startActivityForResult(readStorage, 1);//1 is the request code
	}
	
	public void addNewProfileName(String profileName){
		Intent writeStorage = new Intent(context, InternalStorageReadWrite.class);
		writeStorage.putExtra("filename", "ProfileUsername");
		writeStorage.putExtra("data", profileName);
		startActivityForResult(writeStorage, 2);//2 is the request code
	}
	
	public void onActivityResult(int requestCode, int resultCode){
		//SHOULD THERE BE TWO OF THESE? CHECK WHAT YOU HAD WRITTEN BEFORE
		//HAVE SOMETHING HAPPEN - WHAT? HOW DO I KNOW WHAT CALLED THIS?
	}

}
