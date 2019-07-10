package com.example.sms_sender;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.gsm.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText ed1,ed2;
	Button  b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       ed1=(EditText) findViewById(R.id.editText1);
       ed2=(EditText) findViewById(R.id.editText2);
       b=(Button) findViewById(R.id.button1);
       
       b.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			String phno=ed1.getText().toString();
			String msg=ed2.getText().toString();
			
			try{
			SmsManager sms=SmsManager.getDefault();
			sms.sendTextMessage(phno, null, msg, null, null);
			Toast.makeText(getApplicationContext(),"sms sent", Toast.LENGTH_LONG).show();
			}
			catch(Exception e){
			Toast.makeText(getApplicationContext(),"failed", Toast.LENGTH_LONG).show();
			}
		}
	});  
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

