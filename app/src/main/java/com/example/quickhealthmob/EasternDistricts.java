package com.example.quickhealthmob;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class EasternDistricts extends ListActivity{
	String[] Eastern={};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.easterndistricts);
		ListView lstvw=getListView();
		lstvw.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lstvw.setTextFilterEnabled(true);
		Eastern=getResources().getStringArray(R.array.easterndistricts_array);
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice, Eastern));
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		if(position==0){
			Intent myintent=new Intent(getBaseContext(), EasternHospitals.class);
			startActivity(myintent);
		}
			else if(position==1){
				Intent intent=new Intent(getBaseContext(), EasternHospitals.class);
				startActivity(intent);
			}
		
		super.onListItemClick(l, v, position, id);
	}
	public void onClick(View view){
		ListView lstvw=getListView();
		String itemSelected="selected item\n";
		int count=0;
		for(int i=0; i<lstvw.getCount(); i++){
			if(lstvw.isItemChecked(i));
			itemSelected+=lstvw.getItemAtPosition(i);
			count+=count;
		}
		Toast.makeText(this, "selected item is"+count, Toast.LENGTH_LONG).show();
	}
	

}
