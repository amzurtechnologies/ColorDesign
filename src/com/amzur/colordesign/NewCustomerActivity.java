package com.amzur.colordesign;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class NewCustomerActivity extends FragmentActivity implements OnClickListener {
	private EditText first_name,last_name,phone_number,email,date_of_birth;
    private Button newCustomerBackButton,newCustomerSaveButton,newCustomerHomeButton;
    String valid_mob_number = null, valid_email = null, valid_first_name = null,valid_last_name = null,valid_dob = null,Toast_msg= null;
    int USER_ID;
    DatabaseHandler dbHandler = new DatabaseHandler(this, Toast_msg, null, USER_ID);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_customer);
		Objects_Creation();
		
		newCustomerBackButton.setOnClickListener(this);
		newCustomerHomeButton.setOnClickListener(this);
		newCustomerSaveButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_customer, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		
		case R.id.newCustomerBackButton:
			startActivity(new Intent(this,ExistingClientActivity.class));
		   break;
		   
		case R.id.newCustomerHomeButton:
			startActivity(new Intent(this,MainActivity.class));
			break;
			
		case R.id.newCustomerSaveData:
		     
			

		    dbHandler.Add_Contact(new Contact(valid_first_name,valid_last_name,
			    valid_mob_number, valid_email,valid_dob));
		    Toast_msg = valid_first_name+valid_last_name;
		    Log.v("Dataaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Toast_msg);
		    Show_Toast(Toast_msg);
		    Reset_Text();

		

		
			break;
			
		}
	}
     
	public void Objects_Creation(){
		
		
		//Edit Text Object Creation
		
		
		first_name           = (EditText)findViewById(R.id.editFirstName);
		last_name            = (EditText)findViewById(R.id.editLastName);
		phone_number         = (EditText)findViewById(R.id.editPhoneNumber);
		email                = (EditText)findViewById(R.id.editEmail);
		date_of_birth        = (EditText)findViewById(R.id.editBirthday);
		
		valid_first_name = first_name.getText().toString();
		valid_last_name  = last_name.getText().toString();
		valid_mob_number = phone_number.getText().toString();
		valid_email      = email.getText().toString();
		valid_dob        = date_of_birth.getText().toString();
		
		
		//Buttons Object Creation
		newCustomerBackButton = (Button)findViewById(R.id.newCustomerBackButton);
		newCustomerHomeButton = (Button)findViewById(R.id.newCustomerHomeButton);
		newCustomerSaveButton = (Button)findViewById(R.id.newCustomerSaveData);
		
		
	}
	
	
	public void Show_Toast(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	    }

	    public void Reset_Text() {

		first_name.getText().clear();
		last_name.getText().clear();
		phone_number.getText().clear();
		email.getText().clear();
		date_of_birth.getText().clear();

	    }
	    
	    public void selectDate(View view) {
	        DialogFragment newFragment = new SelectDateFragment();
	        newFragment.show(getSupportFragmentManager(), "DatePicker");
	    }
	    public void populateSetDate(int year, int month, int day) {
	    	date_of_birth = (EditText)findViewById(R.id.editBirthday);
	    	date_of_birth.setText(month+"/"+day+"/"+year);
	    }
	    @SuppressLint("ValidFragment")
		public class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
	    	@Override
	    	public Dialog onCreateDialog(Bundle savedInstanceState) {
				final Calendar calendar = Calendar.getInstance();
				int yy = calendar.get(Calendar.YEAR);
				int mm = calendar.get(Calendar.MONTH);
				int dd = calendar.get(Calendar.DAY_OF_MONTH);
				return new DatePickerDialog(getActivity(), this, yy, mm, dd);
	    	}
	    	
	    	public void onDateSet(DatePicker view, int yy, int mm, int dd) {
	    		populateSetDate(yy, mm+1, dd);
	    	}
	    }
	    
}
