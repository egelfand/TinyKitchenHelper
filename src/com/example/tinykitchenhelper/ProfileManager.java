package com.example.tinykitchenhelper;

import android.os.Bundle;
import android.widget.Button;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class ProfileManager extends Activity {
	Context context;
	Button mealPrefs, colorPrefs;
	String profileName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile_manager);
		context = this;
		//call profile setup(to sign in or whatever) before beginning
		startSetup();
		//get username from internalstoragereadwrite, if not - guest.
		//eventually, call class to determine meal preferences for this profile,
		//and app color preferences for this profile (add to internal storage).
	}
	
	public void startSetup(){
		Intent enterProfileSetup = new Intent(context, ProfileSetup.class);
		startActivity(enterProfileSetup);
	}
}
