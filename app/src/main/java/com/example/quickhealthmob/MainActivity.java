package com.example.quickhealthmob;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity  {
	
	Button btnSendSMS;
	Button start, stop;
	
	IntentFilter intentFilter;
	
	//broadcast receiver.....
	private BroadcastReceiver intentReceiver=new BroadcastReceiver(){

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			
			TextView SMSes=(TextView) findViewById(R.id.textView1);
			
		SMSes.setText(intent.getExtras().getString("sms"));
			
		}
		
			
		
	};



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.smsmain);
		//requesting for permission for the content provider.

		ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.READ_CONTACTS},1);
		ListView listview;
		ArrayList myarray=new ArrayList();
		//---intent to filter for SMS messages received..
		
		intentFilter=new IntentFilter();
		
		intentFilter.addAction("SMS_RECEIVED_ACTION");
		listview=(ListView)findViewById(R.id.listview);
		Cursor c=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
		while (c.moveToNext()){
			String name=c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
			myarray.add(name);

		}
		listview.setAdapter(new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1));
		//activating the background service.
		
		start=(Button)findViewById(R.id.buttonstart);
		start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startService(new Intent(getBaseContext(), MyService.class));
            }
            });
		stop=(Button)findViewById(R.id.buttonstop);
		stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getBaseContext(), MyService.class));
            }
        });


		btnSendSMS=(Button) findViewById(R.id.btnSendSMS);
		
		btnSendSMS.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i=new
						Intent(android.content.Intent.ACTION_VIEW);
				
				i.putExtra("address", "0701437989;  0777122972; 0756765813; 0783293874 ");
				i.putExtra("sms_body", "Helloz testing Texting Team LifeSavers for Quick Ambulance..PlotNo36/38 Mbra.");
				i.setType("vnd.android-dir/mms-sms");
				startActivity(i);

			}
		});
		findViewById(R.id.btncall).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialContactPhone("0701437989,0705749598");
			}
		});
	}

	private void dialContactPhone(final String phoneNumber) {
		startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));
	}



	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		
		//register the receiver
		
		registerReceiver(intentReceiver,intentFilter);
		super.onResume();
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		//unregister the receiver..
		
		unregisterReceiver(intentReceiver);
		super.onPause();
	}


	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		
		//unregister the receiver
		
		unregisterReceiver(intentReceiver);
		super.onDestroy();
	}







}
//class deliverReceiver extends BroadcastReceiver {
//    @Override
//    public void onReceive(Context context, Intent arg1) {
//        switch (getResultCode()) {
//            case Activity.RESULT_OK:
//                Toast.makeText(this, SmsMessage, Toast.LENGTH_SHORT).show();
//                break;
//            case Activity.RESULT_CANCELED:
//                Toast.makeText(getBaseContext(), sms_not_delivered,
//                        Toast.LENGTH_SHORT).show();
//                break;
//        }
//
//    }
//}
