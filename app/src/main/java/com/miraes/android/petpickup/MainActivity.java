package com.miraes.android.petpickup;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
//    Toolbar toolbar;
    private TextView sloganTextView;
    private TextView infoTextView;
    private TextView locationTextView;
    private TextView opTextView;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();

//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setTitle("PPU");
    }

    @SuppressLint("SetTextI18n")
    private void setup() {
         sloganTextView = findViewById(R.id.slogan_textView);
         infoTextView = findViewById(R.id.info_textView);
         locationTextView = findViewById(R.id.location_textView);
         opTextView = findViewById(R.id.hours_textView);

        sloganTextView.setText("We're PPU, the Pet Picker Uppers");
        infoTextView.setText("Need a ride to the next vet visit, or trip to the doggy park? " +
                "Ride with us in our all kinds of, sizes, species pet friendly buddy car service!");
        locationTextView.setText("123-45 Doge Street");
        opTextView.setText("We operate at all hours for emergency trips!");
    }

    public void openMap(View v) {
        Log.v("map", "open map");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(Uri.parse("geo:34.139591,-118.354126"));
        startActivity(mapIntent);
    }

    public void contactUsButtonTapped(View view) {
        Log.v("email", "tapped contact button");
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "imz.estil@gmaill.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Query");

        startActivity(Intent.createChooser(intent, "Send Email"));
    }

}
