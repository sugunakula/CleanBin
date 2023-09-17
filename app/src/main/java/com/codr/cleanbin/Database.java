package com.codr.cleanbin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Database.db";
    private static final int DATABASE_VERSION = 1;

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableQuery = "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, email TEXT, address TEXT, password TEXT)";
        sqLiteDatabase.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // You can implement this method if you plan to upgrade your database schema in the future.
    }

    public long register(String username, String email, String address, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("email", email);
        values.put("address", address);
        values.put("password", password);

        // Insert the data into the "users" table and get the row ID
        long rowId = db.insert("users", null, values);

        // Close the database connection
        db.close();

        return rowId;
    }
    public int login( String email, String password ) {
        int result=0;
        String str[]=new String[2];
        str[0]=email;
        str[1]=password;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE email=? AND password=?", str);
        if(cursor.moveToFirst()){
            result=1;
        }
        return result;
    }
}
