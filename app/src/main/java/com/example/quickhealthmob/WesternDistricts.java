package com.example.quickhealthmob;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class WesternDistricts extends ListActivity{
	String[]western={};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.westerndistricts);
		ListView lst=getListView();
		lst.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lst.setTextFilterEnabled(true);
		western=getResources().getStringArray(R.array.westerndistricts_array);
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice, western));
		
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		if(position==0){
			Intent myintent=new Intent(getBaseContext(),WesternHospitals.class);
			startActivity(myintent);
		}
		
		super.onListItemClick(l, v, position, id);
	}
	public void onClick(View view){
		ListView lstvw=getListView();
		String itemSelected="selected items\n";
		int count=0;
		for(int i=0; i<lstvw.getCount(); i++){
			if(lstvw.isItemChecked(i));
			itemSelected+=lstvw.getItemAtPosition(i);
			
		}
		Toast.makeText(this, "selected item is"+count, Toast.LENGTH_LONG) .show();
	}
	

}
