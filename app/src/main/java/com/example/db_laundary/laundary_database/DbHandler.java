package com.example.db_laundary.laundary_database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.db_laundary.model.contact;
import com.example.db_laundary.parameters.params;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {
    public DbHandler(Context context) {
        super(context, params.DB_NAME,null, params.DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + params.TABLE_NAME + "("
                + params.KEY_ID + " INTEGER PRIMARY KEY," + params.KEY_NAME
                + " TEXT, " + params.KEY_PASS + " TEXT," + params.KEY_TSHIRT + " INTEGER, " + params.KEY_SHIRT  + " INTEGER, " + params.KEY_TROUSER  + "INTEGER, " + params.KEY_WOOLLEN  + " INTEGER, " + params.KEY_TIMESLOT  + " TEXT )";
        Log.d("dbdb","Query being run is : "+ create);
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addContact(contact contact){
    SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(params.KEY_NAME, contact.getName());
        values.put(params.KEY_PASS, contact.getPass());

        db.insert(params.TABLE_NAME, null, values);
        Log.d("dbdb", "Successfully inserted");
        db.close();


    }

//    public void checkContact(contact contact){
//       SQLiteDatabase db= this.getReadableDatabase();
//
//    }

    public List<contact> checkContact(){
        List<contact> namepass= new ArrayList<>();
        SQLiteDatabase db= this.getReadableDatabase();

        String select1 = "SELECT " + params.KEY_NAME+ "," + params.KEY_PASS + " FROM " + params.TABLE_NAME ;
        Cursor cursor = db.rawQuery(select1,null);
        if(cursor.moveToFirst()){
            do{
                contact contact = new contact();
                contact.setName(cursor.getString(1));
                contact.setPass(cursor.getString(2));

                namepass.add(contact);

            }while(cursor.moveToNext()); }

        return namepass;
    }


    public List<contact> getAllContacts(){
        List<contact> contactList= new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM " + params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);
        //loop starts
        if(cursor.moveToFirst()){
            do{
                contact contact = new contact();
                contact.setS_id(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setTshirt(Integer.parseInt(cursor.getString(3)));
                contact.setShirt(Integer.parseInt(cursor.getString(4)));
                contact.setTrouser(Integer.parseInt(cursor.getString(5)));
                contact.setWoollen(Integer.parseInt(cursor.getString(6)));
                contact.setTime(cursor.getString(7));
                contactList.add(contact);

            }while(cursor.moveToNext());

        }
        return contactList;

    }



}




