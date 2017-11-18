package com.example.quickhealthmob;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HealthList extends ListActivity {
	String[] regions={};
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basicviewlist);
		ListView lstvw=getListView();
		lstvw.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		lstvw.setTextFilterEnabled(true);
		regions=getResources().getStringArray(R.array.regions_array);
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,regions));
		
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		if(position==2){
			Intent myintent= new Intent(getBaseContext(),WesternDistricts.class);
			startActivity(myintent);
		}
		else if(position==0){
			Intent Myintent=new Intent(getBaseContext(),CentralDistricts.class);
			startActivity(Myintent);
		}
		else if(position==1){
			Intent intent=new Intent(getBaseContext(),EasternDistricts.class);
			startActivity(intent);
		}
		else if(position==3){
			Intent intt=new Intent(getBaseContext(),NothernDistricts.class);
			startActivity(intt);
		}
		else if(position==4){
			Intent intt=new Intent(getBaseContext(),SouthernDistricts.class);
			startActivity(intt);
		}
	}
			public void onClick(View view){
				
				ListView lstview=getListView();
				String itemSelected="selected items:\n";
				int count=0;
				for(int i=1; i<=lstview.getCount(); i++){
					if(lstview.isItemChecked(i)){
					itemSelected=lstview.getItemAtPosition(i)+"\n";
				
				count=i;
			}
				}
			
			Toast.makeText(this, "selected items are:"+count, Toast.LENGTH_LONG).show();
			
		// TODO Auto-generated method stub
		//super.onListItemClick(l, v, position, id);
		
		
	}
	
	

	

}
