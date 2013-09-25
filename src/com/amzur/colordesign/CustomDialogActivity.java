package com.amzur.colordesign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CustomDialogActivity  extends Activity implements OnClickListener{
    
	private Button dialogCreateClient,dialogAddToExistingClient;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_dialog);
		
		dialogCreateClient          =  (Button)findViewById(R.id.dialogCreateClient);
		dialogAddToExistingClient   =  (Button)findViewById(R.id.dialogAddToExistingClient);
		
		dialogCreateClient.setOnClickListener(this);
		dialogAddToExistingClient.setOnClickListener(this);
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.formula_result, menu);
		return true;
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		
		case R.id.dialogCreateClient:
			startActivity(new Intent(this,NewCustomerActivity.class));
			break;
			
		case R.id.dialogAddToExistingClient:
			startActivity(new Intent(this,ExistingClientActivity.class));
			break;
		
		}
		
	}
}
