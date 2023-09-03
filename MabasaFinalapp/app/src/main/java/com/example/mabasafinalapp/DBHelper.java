package com.example.mabasafinalapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "mabasa.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // create a table
        db.execSQL("CREATE TABLE myusers(username Text PRIMARY KEY, password Text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS myusers");
    }
    public Boolean addMyusers(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long res = db.insert("myusers", null, contentValues);
        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean userVerify(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM myusers WHERE username = ?", new String[]{username});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean passwordVerify(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM myusers WHERE username = ? AND password = ?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}