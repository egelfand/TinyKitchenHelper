package com.example.tinykitchenhelper;

import java.util.List;

public class Recipe {
	String title, tag;
	int ServingSize;
	long date;
	List<String> Ingredients, Instructions;

	public Recipe(String title, int servingSize, String tag,
			List<String> Ingredients, List<String> Instructions, long Date){
		this.title = title;
		this.ServingSize = servingSize;
		this.tag = tag;
		this.Ingredients = Ingredients;
		this.Instructions = Instructions;
		this.date = Date;
	}
	
	public String getTag(){
		return tag;
	}

	public long getDate(){
		return date;
	}

	public String getTitle(){
		return title;
	}

	public int getServingSize(){
		return ServingSize;
	}

	public List<String> getIngredients(){
		return Ingredients;
	}

	public List<String> getInstructions(){
		return Instructions;
	}
}//endRecipe