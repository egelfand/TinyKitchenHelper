package com.example.tinykitchenhelper;

import android.os.Bundle;
import android.app.Activity;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RecipeManager extends Activity {
	RadioGroup rg;
	RadioButton rB;
	Button go;
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipe_manager);
		setupActionBar();// Show the Up button in the action bar.
		go = (Button) findViewById(R.id.go);
		rg = (RadioGroup)findViewById(R.id.recipeChoiceGroup); //choose between buttons
		addListenerOnButton();
	}
	//What to do when the go button is clicked.			
	public void addListenerOnButton() {
		go.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {			
				int selectId = rg.getCheckedRadioButtonId();
				rB = (RadioButton) findViewById(selectId);
				if (rB == findViewById(R.id.all)) {
					sendOff("all"); //view all recipes
				} if (rB == findViewById(R.id.recent)) {
					sendOff("recent"); //view all sensors
				} if (rB == findViewById(R.id.search)) {
					sendOff("search"); //view all sensors
				} if (rB == findViewById(R.id.add)){
					sendOff("add"); //view all sensors
				} if (rB == findViewById(R.id.edit)) {
					sendOff("edit"); //view all sensors
				}
			} 
		}); 		
	}//end of addListenerOnButton
	
	//make it go - don't know why we need this. 
	//public void onStart() {
	//	super.onStart();
	//}
	//make it not go anymore - gonna try not using it, seeing what happens.
	//public void onStop() {
	//	super.onStop();
	//}

	public void sendOff(String classType){
		if (classType.equals("all")){
			//intent = new Intent(this, ??.class);
		} if (classType.equals("recent")){
			//intent = new Intent(this, ??.class);
		} if (classType.equals("search")){
			//intent = new Intent(this, ??.class);
		} if (classType.equals("add")){
			//intent = new Intent(this, ??.class);
		} if (classType.equals("edit")){
			//intent = new Intent(this, ??.class);
		} 
		startActivity(intent);
	}	

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

} //end RecipeManager