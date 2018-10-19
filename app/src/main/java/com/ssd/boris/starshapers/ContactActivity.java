package com.ssd.boris.starshapers;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {
   private TextView name;
   private TextView email;
   private TextView package_type;
   private TextView message;
   private TextView phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        name = (TextView)findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        package_type = (TextView) findViewById(R.id.package_type);
        message = (TextView) findViewById(R.id.message);
        phone = (TextView) findViewById(R.id.phone);

        name.setText(getIntent().getStringExtra("name"));
        email.setText(getIntent().getStringExtra("email"));
        package_type.setText(getIntent().getStringExtra("package_type"));
        message.setText(getIntent().getStringExtra("message"));
        phone.setText(getIntent().getStringExtra("phone"));


    }


    public void openEmail(View v){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",getIntent().getStringExtra("email"), null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "StarShapers..");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Thanks for Reaching Us");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }
}
