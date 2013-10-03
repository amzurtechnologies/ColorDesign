package com.amzur.colordesign;

import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.AbstractWheelTextAdapter;
import kankan.wheel.widget.adapters.ArrayWheelAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ColorLevelActivity extends Activity implements OnClickListener {
	private boolean scrolling = false;
	private Button colorLevelBackButton,colorLevelHomeButton,colorLevelNextButton;
	private String colors[] =
			new String[] {"1.Black","2.Darkest Brown","3.Dark Brown","4.Brown","5.Light Brown","6.Dark Blonde","7.Blonde","8.Light Blonde","9.Very Light Blonde","10.Platinum Blonde","11.Super Paltinum","12.Extra Super Platinum"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_level);
		
		
		colorLevelBackButton = (Button)findViewById(R.id.colorLevelBackButton);
		colorLevelHomeButton = (Button)findViewById(R.id.colorLevelHomeButton);
		colorLevelNextButton = (Button)findViewById(R.id.colorLevelNextButton);
		
		colorLevelBackButton.setOnClickListener(this);
		colorLevelHomeButton.setOnClickListener(this);
		colorLevelNextButton.setOnClickListener(this);
		
		final WheelView color = (WheelView) findViewById(R.id.color);
		color.setVisibleItems(5);
		color.setViewAdapter(new ColorAdapter(this));
		
		final String naturalColors[][] = new String[][] {
				new String[] {".10 Blue"},
				new String[] {".2 Violet"},
				new String[] {""},
				new String[] {".01 Ash Natural", ".2 Violet", ".23 Tobacco", ".3 Golden",".4 Copper",".5 Mahogany",".62 Auburn Violet"},
				new String[] {".003Medium Natural",".01 Ash Natural",".03 Soft Natural",".2 Violet",".22 Intense Violet",".23 Tobacco",".3 Golden",".4 Copper",".5 Mahogany",".55 Intense Mahogany",".56 Mahogany Auburn",".6 Auburn",".77 Chocolate"},
				new String[] {".003Medium Natural",".01 Ash Natural",".03 Soft Natural",".2 Violet",".222 Extra Intense",".23 Tobacco","/2 Matte",".3 Golden",".32 Beige",".34 Gold Copper",".4 Copper",".5 Mahogany",".6 Auburn",".66 Intense Auburn",".666 Extra Intense",".77 Chocolate"},
				new String[] {".003Medium Natural",".01 Ash Natural",".03 Soft Natural",".2 Violet",".23 Tobacco","/2 Matte",".3 Golden",".32 Beige",".33 Intense Golden",".34 Gold Copper",".4 Copper",".44 Intense Copper",".444 Extra Intense","0.46 ",".5 Mahogany",".62 Auburn Violet",".66 Intense Auburn",".666 Extra Intense",".77 Chocolate"},
				new String[] {".003Medium Natural",".01 Ash Natural",".03 Soft Natural","/2 Matte",".3 Light Golden",".32 Beige",".34 Gold Copper",".4 Copper",".52 Mahogany Violet",".77 Chocolate"},
				new String[] {".003Medium Natural",".01 Ash Natural",".03 Soft Natural","/2 Matte",".3 Golden",".32 Beige",".33 Copper",".34 Gold Copper",".4 Copper"},
				new String[] {".0 Superlift Natural",".003 Medium Natural",".03 Superlift Golden",".1 Superlift Ash",".11 Extra Superlift",".13 Superlift Beige",".3 Superlift Golden"},
				new String[] {".0 Natural Blonde",".11 Ash Blonde",".13 Beige Blonde",".3 Golden Blonde"},
				new String[] {".0 Natural Blonde"},
		};
		
		final WheelView naturalColor = (WheelView) findViewById(R.id.NaturalColor);
		naturalColor.setVisibleItems(5);
		
		
		
		
	
		
		color.addChangingListener(new OnWheelChangedListener() {
			@Override
			public void onChanged(WheelView wheel, int oldValue, int newValue) {
				if (!scrolling) {
					updateColors(naturalColor, naturalColors, newValue);
					
				}
			}
		});
		
		color.addScrollingListener( new OnWheelScrollListener() {
			@Override
			public void onScrollingStarted(WheelView wheel) {
				scrolling = true;
			  

			}
			@Override
			public void onScrollingFinished(WheelView wheel) {
				scrolling = false;
				updateColors(naturalColor, naturalColors, color.getCurrentItem());
				//Toast.makeText(getApplicationContext(), color.getCurrentItem(), Toast.LENGTH_LONG).show();
				 Toast.makeText(getApplicationContext(),(colors[getWheel(R.id.color).getCurrentItem()]) , Toast.LENGTH_SHORT).show();
				
				
//					}
			}
			
			
		});

		color.setCurrentItem(1);
		
		
		
		
		
	}
	
	
	protected WheelView getWheel(int id) {
		// TODO Auto-generated method stub
		return (WheelView) findViewById(id);
	}


	private void updateColors(WheelView colorLevel, String naturalColors[][], int index) {
		ArrayWheelAdapter<String> adapter =
				new ArrayWheelAdapter<String>(this, naturalColors[index]);
		adapter.setTextSize(14);
		colorLevel.setCurrentItem(1);
		colorLevel.setViewAdapter(adapter);
		colorLevel.setCurrentItem(naturalColors[index].length / 2);
	   
		
		
	}
	
	private class ColorAdapter extends AbstractWheelTextAdapter {
		

		protected ColorAdapter(Context context) {
			
			super(context, R.layout.activity_color_level_selection, NO_RESOURCE);

			setItemTextResource(R.id.colorLevelValue);
			// TODO Auto-generated constructor stub
		}

		// Countries names
//		private String colors[] =
//				new String[] {"1.Black","2.Darkest Brown","3.Dark Brown","4.Brown","5.Light Brown","6.Dark Blonde","7.Blonde","8.Light Blonde","9.Very Light Blonde","10.Platinum Blonde","11.Super Paltinum","12.Extra Super Platinum"};
		// Countries flags
		

		/**
		 * Constructor
		 */
		

		
//		public View getItem(int index, View cachedView, ViewGroup parent) {
//			View view = super.getItem(index, cachedView, parent);
//			ImageView img = (ImageView) view.findViewById(R.id.flag);
//			img.setImageResource(flags[index]);
//			return view;
//		}

		@Override
		public int getItemsCount() {
			return colors.length;
		}

		@Override
		protected CharSequence getItemText(int index) {
			return colors[index];
		}
	}
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.color_level, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		  
		 case R.id.colorLevelBackButton:
			 startActivity(new Intent(this,NewFormula.class));
	         break;
		
		 case R.id.colorLevelHomeButton:
			 startActivity(new Intent(this,MainActivity.class));
	         
		 case R.id.colorLevelNextButton:
			 startActivity(new Intent(this,FormulaResultActivity.class));
			 
			 break;
			 
		
		 }
	}
	
	
	
	

}
