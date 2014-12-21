package com.example.sqlitecase;


import java.util.List;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class TestModel extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_item);
		
		
		DataBaseHandler baseHandler = new DataBaseHandler(this);
		
		Log.d("Insert: " , "Inserting...");
		Contact contact = new Contact();
		contact.set_name("name_one");
		contact.set_phone("123");
		baseHandler.insert(contact);
		
		 Log.d("Reading: ", "Reading all contacts.."); 
	        List<Contact> contacts = baseHandler.getAllContact();       
	         
	        for (Contact cn : contacts) {
	            String log = "Id: "+cn.get_id()+" ,Name: " + cn.get_name() + " ,Phone: " + cn.get_phone();
	                // Writing Contacts to log
	        Log.d("Name: ", log);
	    }
		
		
		
	}

}
