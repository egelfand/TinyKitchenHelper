package com.example.tinykitchenhelper;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Writes to and reads from internal storage.
 * @author Emily
 *
 */
public class InternalStorageReadWrite extends Activity {
	private String file; 
	//current acceptable filenames:
	//for profiles: ProfileUsername, ProfileColorPrefs, ProfileMealPrefs
	private String dataIn;
	String dataOut;
	Context context;

	public InternalStorageReadWrite(){
		context = this;
		if (getIntent().getExtras()!=null){
			//TODO: EDIT TO CHANGE WHAT HAPPENS BASED ON REQUEST CODE
			file = getIntent().getExtras().getString("filename");
			dataIn=getIntent().getExtras().getString("data");
		}
	}

	public void save(){
		try {
			FileOutputStream fOut = openFileOutput(file,Context.MODE_PRIVATE);
			fOut.write(dataIn.getBytes());
			fOut.close();
			Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finish(); //see if this does what you want
	}

	public void read(){
		try{
			FileInputStream fin = openFileInput(file);
			int c;
			String temp="";
			while( (c = fin.read()) != -1){
				temp = temp + Character.toString((char)c);
			}
			dataOut = temp;
			Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_SHORT).show();
		} catch(Exception e){
			e.printStackTrace();
		}
		finish(); //see if this does what you want
	}
	
	@Override
	public void finish() {
	  // Prepare data intent 
	  Intent backToPrevious = new Intent();
	  // Activity finished ok, return the data
	  setResult(RESULT_OK, backToPrevious);
	  super.finish();
	} 
}
