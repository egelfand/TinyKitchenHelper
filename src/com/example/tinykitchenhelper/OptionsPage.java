package com.example.tinykitchenhelper;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public class OptionsPage extends Activity {
	TextView overText;
	Button profile, recipes, planner, shop, kitchen;
	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_options_page);
		context = this;
		setupActionBar();// Show the Up button in the action bar. (Autogen)
		overText = (TextView) findViewById(R.id.options); //top of the page
		profile = (Button) findViewById(R.id.profile);
		profile.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, ProfileManager.class);
				startActivity(intent);
			}
		});
		recipes = (Button) findViewById(R.id.recipes);
		recipes.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, RecipeManager.class);
				startActivity(intent);
			}
		});
		planner = (Button) findViewById(R.id.planner);
		planner.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, MealManager.class);
				startActivity(intent);
			}
		});
		shop = (Button) findViewById(R.id.shop);
		shop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, ShoppingManager.class);
				startActivity(intent);
			}
		});
		kitchen = (Button) findViewById(R.id.kitchen);
		kitchen.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, KitchenManager.class);
				startActivity(intent);
			}
		});
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
}//end OptionsPage