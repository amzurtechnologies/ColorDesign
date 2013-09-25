package com.amzur.colordesign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ExistingClientActivity extends Activity implements OnClickListener {
    private Button existingClientHomeButton,existingClientNewCustomer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_existing_client);
		
		existingClientHomeButton  = (Button)findViewById(R.id.existingClientHomeButton);
		existingClientNewCustomer = (Button)findViewById(R.id.existingClientNewCustomer);
		
		existingClientHomeButton.setOnClickListener(this);
		existingClientNewCustomer.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 switch (v.getId()) {
		  
		 case R.id.existingClientHomeButton:
			 startActivity(new Intent(this,MainActivity.class));
			 break;
		
		 case R.id.existingClientNewCustomer:
			 startActivity(new Intent(this,NewCustomerActivity.class));
			 
			 break;
			 
		
		 }
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.existing_client, menu);
		return true;
	}

	

}
