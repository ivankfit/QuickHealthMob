package com.example.quickhealthmob;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CentralHospitals extends ListActivity {
	String[] central={};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.northernlist);
		ListView lstvw=getListView();
		lstvw.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lstvw.setTextFilterEnabled(true);
		central=getResources().getStringArray(R.array.central_array);
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,central));
		
		
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		if(position==0){
			Intent myintent=new Intent(getBaseContext(),MainActivity.class);
			startActivity(myintent);
		}
		else if(position==6){
			Intent intent=new Intent(getBaseContext(),MainActivity.class);
			startActivity(intent);
		}
		super.onListItemClick(l, v, position, id);
	}

	public void onClick(View view){
		ListView listview=getListView();
		int count=1;
		String itemSelected="selected items\n";
		for(int i=0; i<listview.getCount(); i++){
			if(listview.isItemChecked(i));
			itemSelected+=listview.getItemAtPosition(i);
			count+=count;
			
		}
		
		Toast.makeText(this,"selected items are"+count, Toast.LENGTH_LONG).show();
		count=0;
	}

	

	

}
