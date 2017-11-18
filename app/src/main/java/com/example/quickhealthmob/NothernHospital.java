package com.example.quickhealthmob;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NothernHospital extends ListActivity {
	String []nothern={};
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.certrallist);
	ListView lst=getListView();
	lst.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	lst.setTextFilterEnabled(true);
	nothern=getResources().getStringArray(R.array.Northern_array);
	setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,nothern));
	}
	
   @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
	   if(position==0){
		   Intent myint=new Intent(getBaseContext(),MainActivity.class);
		   startActivity(myint);
	   }
	   else if(position==3){
		   Intent myintent=new Intent(getBaseContext(),MainActivity.class);
		   startActivity(myintent);
	   }
		super.onListItemClick(l, v, position, id);
	}

public void onClick(View view){
	   ListView lstvw=getListView();
	   String itemSelected="selected item";
	   int count=0;
	   for(int i=0; i<lstvw.getCount(); i++){
		   if(lstvw.isItemChecked(i)){
			   itemSelected+=lstvw.getCheckedItemPosition();
			   count+=count;
			   
		   }
		   Toast.makeText(this, "selected item is:"+count, Toast.LENGTH_LONG).show();
	   }
   }
}
