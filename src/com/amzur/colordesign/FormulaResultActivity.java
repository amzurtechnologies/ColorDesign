package com.amzur.colordesign;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FormulaResultActivity extends Activity implements OnClickListener {
	Dialog dialog;
	final Context context = this;
    private Button formulaResultBackScreen,formulaResultHomeScreen,formulaResultUpdateButton,dialogCancel;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_formula_result);
		
		
		formulaResultBackScreen     =   (Button)findViewById(R.id.formulaResultBackButton);
		formulaResultHomeScreen     =   (Button)findViewById(R.id.formulaResultHomeButton);
		formulaResultUpdateButton   =   (Button)findViewById(R.id.formulaResultUpdateButton);
		
		
		formulaResultBackScreen.setOnClickListener(this);
		formulaResultHomeScreen.setOnClickListener(this);
		formulaResultUpdateButton.setOnClickListener(this);
		
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
		
		switch (v.getId()){
		
		case R.id.formulaResultBackButton :
		startActivity(new Intent(this,ColorLevelActivity.class));
			break;
			
		case R.id.formulaResultHomeButton:
			startActivity(new Intent(this,MainActivity.class));
			break;
			
		case R.id.formulaResultUpdateButton:
			
		          show_Alert();   
		
			break;
		
		
			
		}
		
		
	}
	
	
	public void show_Alert(){
		
		AlertDialog.Builder dialog = new AlertDialog.Builder(getApplicationContext());
		 LayoutInflater inflater = ((Activity) getApplicationContext()).getLayoutInflater();

		    // Inflate and set the layout for the dialog
		    // Pass null as the parent view because its going in the dialog layout
		    dialog.setView(inflater.inflate(R.layout.activity_custom_dialog, null))
		    // Add action buttons
		           .setPositiveButton(R.string.cancel, new DialogInterface.OnClickListener() {
		               @Override
		               public void onClick(DialogInterface dialog, int id) {
		                   // sign in the user ...
		            	   dialog.dismiss();
		               }
		           });
		
		dialog.create();
	}
	
	
	
	
	
	

}
