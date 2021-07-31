package com.example.db_laundary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.db_laundary.laundary_database.DbHandler;
import com.example.db_laundary.model.contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHandler db= new DbHandler(MainActivity.this);

        //adding a contact
        contact pranjal = new contact();
        pranjal.setName("Pranjal Arora");
        pranjal.setPass("1234");
        pranjal.setTshirt(2);
        pranjal.setShirt(3);
        pranjal.setTrouser(2);
        pranjal.setWoollen(1);
        pranjal.setTime("5:00 pm");

        db.addContact(pranjal);

        ArrayList<String> contacts = new ArrayList<>();
        listView = findViewById(R.id.listView);

//        List<contact> contactchecker= db.checkContact();
//        for(contact contact : contactchecker){
//
//        }
        List<contact> allContacts = db.getAllContacts();
        for(contact contact: allContacts){
            Log.d("dbdb", "name:" + contact.getName()+ "with the student id" + contact.getS_id() + "has a slot" + contact.getTime()+ "\n");
            contacts.add( contact.getName()+ "=" + Integer.toString(contact.getTshirt()) + " Tshirts, "+ Integer.toString(contact.getShirt())+ " Shirts, " + Integer.toString(contact.getTrouser())+ " Trousers, " + Integer.toString(contact.getWoollen())+" Woollens. The time slot is:" + contact.getTime());


        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(arrayAdapter);





    }




}