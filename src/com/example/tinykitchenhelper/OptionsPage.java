package com.example.tinykitchenhelper;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.content.Intent;

public class OptionsPage extends Activity {
	TextView overText;
	Button profile, recipes, planner, shop, kitchen;
	Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_options_page);
		context = this;
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
}//end OptionsPage