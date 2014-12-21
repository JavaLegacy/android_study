package com.example.govermentexam;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	static final String[] VALUES = new String[] { "Android", "iPhone", "WindowsMobile",
			"Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X", "Linux",
			"OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
			"Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2", "Android",
			"iPhone", "WindowsMobile" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);

		setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main,VALUES));

		ListView listView = getListView();

		listView.setTextFilterEnabled(true);

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// When clicked, show a toast with the TextView text
				Toast.makeText(getApplicationContext(),
						((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			}

		});

	}

}
