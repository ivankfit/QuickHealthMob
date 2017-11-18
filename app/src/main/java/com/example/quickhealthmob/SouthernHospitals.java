package com.example.quickhealthmob;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SouthernHospitals extends ListActivity{
	String []Southern={};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.southernlist);
		ListView lst=getListView();
		lst.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lst.setTextFilterEnabled(true);
		Southern=getResources().getStringArray(R.array.southern_array);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,Southern));
		
		
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		if(position==0){
			Intent myintent=new Intent(getBaseContext(),MainActivity.class);
			startActivity(myintent);
		}
		else if(position==4){
			Intent intent=new Intent(getBaseContext(),MainActivity.class);
			startActivity(intent);
		}
		super.onListItemClick(l, v, position, id);
	}

	public void onClick(View view){
		ListView lstvw=getListView();
		String itemSelected="selected items";
		int count=0;
		for(int i=0; i<lstvw.getCount();i++){
			if(lstvw.isItemChecked(i)){
				itemSelected+=lstvw.getCheckedItemPosition();
				count+=count;
			}
			Toast.makeText(this, "item selected is:"+count, Toast.LENGTH_LONG).show();
		}
	}
	
	

	}


