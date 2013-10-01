package com.amzur.colordesign;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {

	
	   // All Static variables
 // Database Version
 private static final int DATABASE_VERSION = 1;

 // Database Name
 private static final String DATABASE_NAME = "contactsManager";

 // Contacts table name
 private static final String TABLE_CONTACTS = "contacts";
 
 private static final String KEY_ID = "id";
 private static final String KEY_FIRSTNAME = "firstName";
 private static final String KEY_LASTNAME= "lastName";
 private static final String KEY_PHONENUMBER = "phoneNumber";
 private static final String KEY_EMAIL = "email";
 private static final String KEY_DATEOFBIRTH ="dateOfBirth";
 private final ArrayList<Contact> contact_list = new ArrayList<Contact>();
 private final ArrayList<Contact> name_list = new ArrayList<Contact>();
 
 
	
	
 public DatabaseHandler(Context context) {
 	super(context, DATABASE_NAME, null, DATABASE_VERSION);
     }

	

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_TABLE = "CREATE TABLE "+TABLE_CONTACTS+"("+KEY_ID+" INTEGER  PRIMARY KEY ,"
				              + KEY_FIRSTNAME + " TEXT," + KEY_LASTNAME + " TEXT,"+KEY_PHONENUMBER
				              + " TEXT," + KEY_EMAIL + " TEXT," + KEY_DATEOFBIRTH + " TEXT )";
		
		db.execSQL(CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

		// Create tables again
		onCreate(db);

	}
	
	
	 /**
  * All CRUD(Create, Read, Update, Delete) Operations
  */

 // Adding new contact
 public void Add_Contact(Contact contact) {
	SQLiteDatabase db = this.getWritableDatabase();
	ContentValues values = new ContentValues();
	values.put(KEY_FIRSTNAME, contact.getFirstName()); // Contact Name
	values.put(KEY_LASTNAME, contact.getLastName());
	values.put(KEY_PHONENUMBER, contact.getPhoneNumber()); // Contact Phone
	values.put(KEY_EMAIL, contact.getEmail()); // Contact Email
	values.put(KEY_DATEOFBIRTH, contact.getDateOfBirth());
	// Inserting Row
	db.insert(TABLE_CONTACTS, null, values);
	db.close(); // Closing database connection
 }

 Contact Get_Contact(int id) {
 	SQLiteDatabase db = this.getReadableDatabase();

 	Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
 	KEY_FIRSTNAME,KEY_LASTNAME, KEY_PHONENUMBER, KEY_EMAIL,KEY_DATEOFBIRTH }, KEY_ID + "=?",
 	new String[] { String.valueOf(id) }, null, null, null, null);
 	if (cursor != null)
 	cursor.moveToFirst();

 	Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
 	cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4),cursor.getString(5));
 	// return contact
 	cursor.close();
 	db.close();

 	return contact;
 	}
 
 
 public int Update_Contact(Contact contact) {
 	SQLiteDatabase db = this.getWritableDatabase();

 	ContentValues values = new ContentValues();

 	values.put(KEY_FIRSTNAME, contact.getFirstName());
 	values.put(KEY_LASTNAME, contact.getLastName());
 	values.put(KEY_PHONENUMBER, contact.getPhoneNumber());
 	values.put(KEY_EMAIL, contact.getEmail());
 	values.put(KEY_DATEOFBIRTH, contact.getDateOfBirth());

 	// updating row

 	return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
 	new String[] { String.valueOf(contact.getId()) });

 	}
  
 public void Delete_Contact(int id) {
 	SQLiteDatabase db = this.getWritableDatabase();
 	db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
 	new String[] { String.valueOf(id) });
 	db.close();
 	}
 
 public ArrayList<Contact> Get_Contacts() {
 	try {
 	contact_list.clear();

 	// Select All Query
 	String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;

 	SQLiteDatabase db = this.getWritableDatabase();
 	Cursor cursor = db.rawQuery(selectQuery, null);

 	// looping through all rows and adding to list
 	if (cursor.moveToFirst()) {
 	do {
 	Contact contact = new Contact();
 	contact.setId(Integer.parseInt(cursor.getString(0)));
 	contact.setFirstName(cursor.getString(1));
 	contact.setLastName(cursor.getString(2));
 	contact.setPhoneNumber(cursor.getString(3));
 	contact.setEmail(cursor.getString(4));
 	contact.setDateOfBirth(cursor.getString(5));
 	
 	
 	// Adding contact to list
 	contact_list.add(contact);
 	} while (cursor.moveToNext());
 	}

 	// return contact list
 	cursor.close();
 	db.close();
 	return contact_list;
 	} catch (Exception e) {
 	// TODO: handle exception
 	Log.e("all_contact", "" + e);
 	}

 	return contact_list;
 	}
  

 
    
}
