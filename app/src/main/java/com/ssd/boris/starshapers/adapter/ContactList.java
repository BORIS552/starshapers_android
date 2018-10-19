package com.ssd.boris.starshapers.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.ssd.boris.starshapers.MainActivity;
import com.ssd.boris.starshapers.R;
import com.ssd.boris.starshapers.model.Contact;

import java.util.List;

public class ContactList extends ArrayAdapter<Contact> {

    private Activity context;
    List<Contact> contacts;

    public ContactList(Activity context, List<Contact> contacts){
        super(context, R.layout.layout_contact_list, contacts);
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View listViewItem = layoutInflater.inflate(R.layout.layout_contact_list, null, true);

        TextView name = (TextView) listViewItem.findViewById(R.id.name);
        TextView email = (TextView) listViewItem.findViewById(R.id.email);
        TextView phone = (TextView) listViewItem.findViewById(R.id.phone);
        TextView package_type = (TextView) listViewItem.findViewById(R.id.package_type);

        Contact contact = contacts.get(position);
        name.setText(contact.getName());
        email.setText(contact.getEmail());
        phone.setText(contact.getPhone());
        package_type.setText(contact.getPackage_type());



        return listViewItem;
    }

}
