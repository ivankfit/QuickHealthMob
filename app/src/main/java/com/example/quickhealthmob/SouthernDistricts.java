package com.example.quickhealthmob;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SouthernDistricts extends ListActivity{
	String[] Southern={};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.southerndistricts);
		ListView lstvw=getListView();
		lstvw.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lstvw.setTextFilterEnabled(true);
		Southern=getResources().getStringArray(R.array.southerndistrict_array);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,Southern));
		}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		if(position==0){
			Intent myintent=new Intent(getBaseContext(),SouthernHospitals.class);
			startActivity(myintent);
		}
		super.onListItemClick(l, v, position, id);
	}
	public void onClick(View view){
		ListView lst=getListView();
		String itemClicked="clicked item \n";
		int count=0;
		for(int i=0; i<lst.getCount(); i++){
			if(lst.isItemChecked(i));
			count+=count;
			itemClicked+=lst.getItemAtPosition(i);
		}
		Toast.makeText(this, "clicked item is"+count, Toast.LENGTH_LONG).show();
	}
	

}
