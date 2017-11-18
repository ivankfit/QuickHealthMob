package com.example.quickhealthmob;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminLogin extends Activity {
	
	   String user_name, user_pass;
	    EditText username, password;
	    Button button2;
	   
	    private DatabaseOperations mDbHelper;
	    private SQLiteDatabase mdb=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adminform);
		
		 mDbHelper=new DatabaseOperations(this);

	        username = (EditText) findViewById(R.id.et1);
	        password = (EditText) findViewById(R.id.et2);
		Button Login= (Button) findViewById(R.id.btnlogin);
		button2=(Button)findViewById(R.id.button2);
		//TextView create_account=(TextView) findViewById(R.id.et1);
		
		Login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			       user_name = username.getText().toString();
	                user_pass = password.getText().toString();
	                mDbHelper.open();
	                mdb=mDbHelper.getReadableDatabase();

	                Cursor c=mDbHelper.getAllContacts();


	                if(c.moveToFirst()){
	                    do{
	                       if(user_pass.equals(c.getString(3))&&user_name.equals(c.getString(2))){
	                           Intent intent = new Intent(AdminLogin.this, MainActivity.class);
	                           startActivity(intent);
	                           
	      	                 username.setText("");
	                 	   password.setText("");
	                       }
	                        
	                    }while (c.moveToNext());
	                    
	                   
	                }
	                else {
	                  	   
	                    Toast.makeText(getBaseContext(), "User Does not exist In the database", Toast.LENGTH_SHORT).show();
	                    
	                 username.setText("");
           	         password.setText("");
	                } 

	            }
				
				
			
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent intent=new Intent(getApplicationContext(),MainActivity.class);
				
				startActivity(intent);
			}
		});
		
	}
}
	


