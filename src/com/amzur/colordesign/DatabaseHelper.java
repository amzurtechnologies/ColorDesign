package com.amzur.colordesign;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{

	  private static String DB_NAME = "ColorFormula.sqlite";
	  
	    private SQLiteDatabase myDataBase; 
	 
	    private final Context myContext;
		
	    String DB_PATH =null;
	     
		
		
		
		@SuppressLint("SdCardPath")
		public DatabaseHelper(Context context) {
			 
	    	super(context, DB_NAME, null, 1);
	        this.myContext = context;
	        DB_PATH="/data/data/"+context.getPackageName()+"/"+"databases/";
	    }
       
		
		 public void createDataBase() throws IOException{
			  
		        boolean dbExist = checkDataBase();
		  
		        if(dbExist){
		            //do nothing - database already exist
		        }else{
		  
		            //By calling this method and empty database will be created into the default system path
		               //of your application so we are gonna be able to overwrite that database with our database.
		            this.getReadableDatabase();
		  
		            try {
		
		                copyDataBase();
		  
		            } catch (IOException e) {
		  
		                throw new Error("Error copying database");
		  
		            }
		        }
		  
		    }
		 
		 private boolean checkDataBase(){
			  
		        SQLiteDatabase checkDB = null;
		  
		        try{
		            String myPath = DB_PATH + DB_NAME;
		            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
		  
		        }catch(SQLiteException e){
		  
		            //database does't exist yet.
		  
		        }
		  
		        if(checkDB != null){
		  
		            checkDB.close();
		  
		        }
		  
		        return checkDB != null ? true : false;
		    }
		 
		 
		 private void copyDataBase() throws IOException{
			  
		        //Open your local db as the input stream
		        InputStream myInput = myContext.getAssets().open(DB_NAME);
		  
		        // Path to the just created empty db
		        String outFileName = DB_PATH + DB_NAME;
		  
		        //Open the empty db as the output stream
		        OutputStream myOutput = new FileOutputStream(outFileName);
		  
		        //transfer bytes from the inputfile to the outputfile
		        byte[] buffer = new byte[1024];
		        int length;
		        while ((length = myInput.read(buffer))>0){
		            myOutput.write(buffer, 0, length);
		        }
		  
		        //Close the streams
		        myOutput.flush();
		        myOutput.close();
		        myInput.close();
		  
		    }
		 
		 public void openDataBase() throws SQLException{
			  
		        //Open the database
		        String myPath = DB_PATH + DB_NAME;
		        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
		  
		    }
		  
		    @Override
		    public synchronized void close() {
		  
		            if(myDataBase != null)
		                myDataBase.close();
		  
		            super.close();
		  
		    }
		 



		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			
		}




		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}	
	 
		public Cursor query(String table,String[] columns, String selection,String[] selectionArgs,String groupBy,String having,String orderBy){
	        //return myDataBase.query("EMP_TABLE", null, null, null, null, null, null);
			return myDataBase.query("ColorDesign", null, null, null, null, null, null);
	     
	    }
		
		
	public void some_function(){
	        
	        //  c=myDbHelper.query("EMP_TABLE", null, null, null, null,null, null);
	          
	         String selectQuery = "SELECT  * FROM ColorDesign WHERE graylevel = '0-40%' AND naturallevel = '1' AND targetcolor = '1'";
//		String selectQuery = "SELECT  * FROM EMP_TABLE";
		    
	  	    SQLiteDatabase db = this.getWritableDatabase();
	  	    Cursor cursor = db.rawQuery(selectQuery, null);
	          
	          if(cursor.moveToFirst())
	          {
	              do {
	                      
//	                  Log.v(1,
//	                          "_id: " + c.getString(0) + "\n" +
//	                          "E_NAME: " + c.getString(1) + "\n" +
//	                          "E_AGE: " + c.getString(2) + "\n" +
//	                          "E_DEPT:  " + c.getString(3),
//	                          Toast.LENGTH_LONG).show();
//	                  Log.v("Dataaaaaaaaaaaaaaaaaaaaaaaaaaaa", "dataaaaaaaaaaaaaaaaaaaaaaaaaaa");
//	                  Log.d("MainActivity.this",  "_id: " + c.getString(0) + "\n" +
//	                          "E_NAME: " + c.getString(1) + "\n" +
//	                          "E_AGE: " + c.getString(2) + "\n" +
//	                          "E_DEPT:  " + c.getString(3));
	              	Log.d("Some",
	                          "graylevel " + cursor.getString(0) + "\n" +
	                          "naturallevel " + cursor.getString(1) + "\n" +
	                          "targetcolor " + cursor.getString(2) + "\n" +
	                          "formula" + cursor.getString(3));
	                  Log.d("Nameeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", cursor.getString(3));
	              } while (cursor.moveToNext());
	          }
		}

		
		
	
}
