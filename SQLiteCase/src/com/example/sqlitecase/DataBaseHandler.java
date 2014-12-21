package com.example.sqlitecase;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHandler extends SQLiteOpenHelper {

	public DataBaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table" + TABLE_RICKSAW + "(" + KEY_ID
				+ "INTEGER PRIMARY KEY," + KEY_NAME + "TEXT," + KEY_PH_NO
				+ "TEXT" + ")";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_RICKSAW);
		onCreate(db);
	}

	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "rickSawApp";
	public static final String TABLE_RICKSAW = "rickSaw";

	public static final String KEY_ID = "id";
	public static final String KEY_NAME = "name";
	public static final String KEY_PH_NO = "phone";

	public void createDataBase() {

	}

	public void insert(Contact contact) {

		SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

		ContentValues contentValues = new ContentValues();

		contentValues.put(KEY_NAME, contact.get_name());
		contentValues.put(KEY_ID, contact.get_id());
		contentValues.put(KEY_PH_NO, contact.get_phone());

		sqLiteDatabase.insert(TABLE_RICKSAW, null, contentValues);
		sqLiteDatabase.close();

	}

	public void delete(Contact contact) {
		SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
		sqLiteDatabase.delete(TABLE_RICKSAW, KEY_ID + "=?", new String[]{String.valueOf(contact.get_id())});

	}

	public void update(Contact contact) {
		SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

		ContentValues contentValues = new ContentValues();

		contentValues.put(KEY_NAME, contact.get_name());	
		contentValues.put(KEY_PH_NO, contact.get_phone());

		sqLiteDatabase.update(TABLE_RICKSAW, contentValues, KEY_ID + "=?", new String[]{String.valueOf(contact.get_id())});
		sqLiteDatabase.close();
	}

	public Contact getContact(int id) {

		SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

		Cursor cursor = sqLiteDatabase.query(TABLE_RICKSAW, new String[] {
				KEY_ID, KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);

		if (cursor != null)
			cursor.moveToFirst();

		Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2));

		return contact;

	}

	public List<Contact> getAllContact() {

		List<Contact> contacts = new ArrayList<Contact>();

		String query = "SELECT * FROM " + TABLE_RICKSAW;

		SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

		Cursor cursor = sqLiteDatabase.rawQuery(query, null);
		if (cursor.moveToFirst()) {
			do {
				Contact contact = new Contact(Integer.parseInt(cursor
						.getString(0)), cursor.getString(1),
						cursor.getString(2));
				contacts.add(contact);

			} while (cursor.moveToNext());
		}
		return contacts;

	}

}
