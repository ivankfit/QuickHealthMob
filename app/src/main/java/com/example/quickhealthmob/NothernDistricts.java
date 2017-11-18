package com.example.quickhealthmob;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NothernDistricts extends ListActivity {
	String[] Nothern={};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.northerndistricts);
		ListView lstvw=getListView();
		lstvw.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lstvw.setTextFilterEnabled(true);
		Nothern=getResources().getStringArray(R.array.northendistricts_array);
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,Nothern));
		
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		if(position==0){
			Intent myintent=new Intent(getBaseContext(),NothernHospital.class);
			startActivity(myintent);
		}
		else if(position==1){
			Intent intent=new Intent(getBaseContext(), NothernHospital.class);
			startActivity(intent);
		}
		super.onListItemClick(l, v, position, id);
	}
	public void onClick(View view){
		ListView lst=getListView();
		int count=0;
		for(int i=0; i<lst.getCount(); i++){
			if(lst.isItemChecked(i));
			String clickedItem="item clicked\n";
			clickedItem+=lst.getItemAtPosition(i);
			count+=count;
		}
		Toast.makeText(this, "item clicked is"+count, Toast.LENGTH_LONG).show();
	}
	

}
