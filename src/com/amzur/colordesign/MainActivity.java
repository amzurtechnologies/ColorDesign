package com.amzur.colordesign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    private Button newFormula,existingClient;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		newFormula      = (Button)findViewById(R.id.mainScreenNewFormula);
		existingClient  = (Button)findViewById(R.id.mainScreenExistingClient);
		
		newFormula.setOnClickListener(this);
	    existingClient.setOnClickListener(this);	
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 switch (v.getId()) {
		  
		 case R.id.mainScreenNewFormula:
			 startActivity(new Intent(this,NewFormula.class));
			 break;
		
		 case R.id.mainScreenExistingClient:
			startActivity(new Intent(this,ExistingClientActivity.class));
	         break;
		 }
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	

}
