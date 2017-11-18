package com.example.quickhealthmob;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CentralDistricts extends ListActivity{
	String[] Central={};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.centraldistricts);
		ListView lstvw=getListView();
		lstvw.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lstvw.setTextFilterEnabled(true);
		Central=getResources().getStringArray(R.array.centraldistricts_array);
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,Central));
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		if(position==0){
			Intent intent=new Intent(getBaseContext(),CentralHospitals.class);
			startActivity(intent);
		}
		super.onListItemClick(l, v, position, id);
	}
	public void onClick(View view){
		ListView lst=getListView();
		int count=0;
		String itemSelected="selected item\n";
		for(int i=0; i<lst.getCount(); i++){
			if(lst.isItemChecked(i));
			itemSelected+=lst.getItemIdAtPosition(i);
			count+=count;
		}
		Toast.makeText(this, "item selected is"+count, Toast.LENGTH_LONG).show();
	}

}
