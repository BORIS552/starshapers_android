package com.ssd.boris.starshapers;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ssd.boris.starshapers.adapter.ContactList;
import com.ssd.boris.starshapers.model.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    ListView listViewContacts;
    List<Contact> contacts;
    List<Contact> reverseContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewContacts = (ListView) findViewById(R.id.contactsList);

        contacts = new ArrayList<>();
        reverseContacts = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("contacts");

    }

    @Override
    protected void onStart(){
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                contacts.clear();
                for(DataSnapshot postSnapShot : dataSnapshot.getChildren()) {
                    Contact contact = postSnapShot.getValue(Contact.class);
                    contacts.add(contact);
                }
                Collections.reverse(contacts);
                ContactList contactListAdapter = new ContactList(MainActivity.this, contacts);
                listViewContacts.setAdapter(contactListAdapter);

                listViewContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                        intent.putExtra("name", contacts.get(position).getName());
                        intent.putExtra("email", contacts.get(position).getEmail());
                        intent.putExtra("package_type", contacts.get(position).getPackage_type());
                        intent.putExtra("message", contacts.get(position).getMessage());
                        intent.putExtra("phone", contacts.get(position).getPhone());
                        startActivity(intent);
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
