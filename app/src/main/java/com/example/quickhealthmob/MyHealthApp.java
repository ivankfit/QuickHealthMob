package com.example.quickhealthmob;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MyHealthApp extends Activity {
	ImageView Mybtn;
	ImageView Btn;
	ImageView mybtn,Btn3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.healthmob);
		//setContentView(R.layout.adminform);
		Mybtn=(ImageView)findViewById(R.id.btn1);
		Btn=(ImageView)findViewById(R.id.btn4);
		mybtn=(ImageView)findViewById(R.id.btn2);
		Btn3=(ImageView)findViewById(R.id.btn3);
		Mybtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myintent=new Intent(getBaseContext(),HealthList.class);
				startActivity(myintent);

				
			}
		});
		
		Btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent Myintent=new Intent(getBaseContext(),AdminLogin.class);
             startActivity(Myintent);
			}
		});
		mybtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intt=new Intent(getBaseContext(),MainActivity.class);
				startActivity(intt);
				
			}
		});
		Btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myint=new Intent(getBaseContext(),MainActivity.class);
				startActivity(myint);
				
			}
		});
	}
	

}
