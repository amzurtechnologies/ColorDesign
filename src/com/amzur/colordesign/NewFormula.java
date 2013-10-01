package com.amzur.colordesign;

import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.AbstractWheelTextAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class NewFormula extends Activity implements OnClickListener {
    
	private boolean wheelScrolled = false;
	private WheelView colorDye; 
	private Button colorScreenBack,colorScreenNext,naturalButton1,naturalButton2,naturalButton3;
	private String colorSelectionValues[] =
			new String[] {"Black", "Darkest Brown", "Dark Brown", "Brown","Light Brown","Dark Blonde","Blonde","Light Blonde","Very Light Blonde","Platinum"};
	// Countries flags
	private int colorSelectionImages[] =
			new int[] {R.drawable.hair1, R.drawable.hair2, R.drawable.hair3, R.drawable.hair4,R.drawable.hair5,R.drawable.hair6,R.drawable.hair7,R.drawable.hair8,R.drawable.hair9,R.drawable.hair10};
	
	
	private String colorSelectionLevel[] =
			new String[] {"1","2","3","4","5","6","7","8","9","10"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_formula);
		colorScreenBack = (Button)findViewById(R.id.colorScreenBackButton);
		colorScreenNext = (Button)findViewById(R.id.colorScreenNextButton);
		colorScreenBack.setOnClickListener(this);
		colorScreenNext.setOnClickListener(this);
        colorDye= (WheelView) findViewById(R.id.naturalColorSelection);
		colorDye.setVisibleItems(3);
		colorDye.setViewAdapter(new ColorAdapter(this));
		colorDye.setCurrentItem(1);
		colorDye.addScrollingListener(new OnWheelScrollListener() {
			
			@Override
			public void onScrollingStarted(WheelView wheel) {
				// TODO Auto-generated method stub
				wheelScrolled = true;
			}
			
			@Override
			public void onScrollingFinished(WheelView wheel) {
				// TODO Auto-generated method stub
				wheelScrolled = false;
				Toast.makeText(getApplicationContext(), (colorSelectionValues[getWheel(R.id.naturalColorSelection).getCurrentItem()]), Toast.LENGTH_SHORT).show();
			}
			private WheelView getWheel(int id) {
				// TODO Auto-generated method stub
				return (WheelView) findViewById(id);
			}
		});
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 switch (v.getId()) {
		  
		 case R.id.colorScreenBackButton:
			 startActivity(new Intent(this,MainActivity.class));
	         
	        
			 break;
		
		 case R.id.colorScreenNextButton:
			 startActivity(new Intent(this,ColorLevelActivity.class));
			 
			 break;
			 
		
		 }
	}
    
	private class ColorAdapter extends AbstractWheelTextAdapter {
		// Countries names
		

		/**
		 * Constructor
		 */
		protected ColorAdapter(Context context) {
			super(context, R.layout.activity_color_selection_main, NO_RESOURCE);

			setItemTextResource(R.id.colorSelectionValue);
			
		}
    
		public View getItem(int index, View cachedView, ViewGroup parent) {
			View view = super.getItem(index, cachedView, parent);
			ImageView img = (ImageView) view.findViewById(R.id.colorSelectionImage);
			img.setImageResource(colorSelectionImages[index]);
			return view;
		}
		
		@Override
		public int getItemsCount() {
			// TODO Auto-generated method stub
			return colorSelectionValues.length;
		}

		@Override
		protected CharSequence getItemText(int index) {
			// TODO Auto-generated method stub
			return colorSelectionValues[index];
		}
	
	}

	
}
