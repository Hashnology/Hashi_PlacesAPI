package com.example.hashi_placesapi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.hashi_placesapi.model.MyPlaces;

import java.util.ArrayList;

public class AppDataBase {
    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private Db Db;
    int total;

    public AppDataBase(Context context) {
        this.context = context;
    }

    /*DATA BASE NAME AND VERSION , CHANGE VERSION WHILE CHNAGE IN TABLE*/
    private static final String DATA_BASE_NAME = "location.db";
    private static final int DATA_BASE_VERSION = 2;

    /*  1 table name */
    private static final String TABLE_NAME_REGISTER = "register";

    /*2 columns of table*/
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";


    /* 3to drop a table*/
    /**/
    private static final String DROP_TABLE_REGISTER = "DROP TABLE IF EXISTS " + TABLE_NAME_REGISTER;

    /* 4 to creta a table*/

    private static final String CREATE_TABLE_REGISTER =
            "CREATE TABLE " + TABLE_NAME_REGISTER + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME + " TEXT)";


    /*5 th*/
    public long insertPlace(String name) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);


        long insertedId = sqLiteDatabase.insert(TABLE_NAME_REGISTER, null, contentValues);
        return insertedId;
    }


    public ArrayList<MyPlaces> getAllPlaces() {

        ArrayList<MyPlaces> myList = new ArrayList<>();


        Cursor cursor = sqLiteDatabase.query("register", null,null,null, null, null, null);

        while (cursor.moveToNext()) {

            String id = cursor.getString(cursor.getColumnIndex(COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));

            MyPlaces animalList = new MyPlaces(name);
            myList.add(animalList);
        }

        return myList;
    }





    public AppDataBase open() throws android.database.SQLException {
        Db = new Db(context);
        sqLiteDatabase = Db.getWritableDatabase();
        return AppDataBase.this;
    }

    public void close() {
        Db.close();
    }


    private class Db extends SQLiteOpenHelper {

        public Db(Context context) {
            super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_TABLE_REGISTER);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL(DROP_TABLE_REGISTER);
        }
    }

}
