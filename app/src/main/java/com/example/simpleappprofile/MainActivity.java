package com.example.simpleappprofile;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    /////// common intent feature start from here

    public void onClickSetAlarm(View view) {
        MyIntent _myIntent = new MyIntent();
        _myIntent.createAlarm("Alarm Testing", 23, 59, this);
    }

    public void onClickOpenWeb(View view) {
        MyIntent myIntent = new MyIntent();
        myIntent.openWeb(this);
    }

    public void onClickDialPhone(View view) {
        MyIntent myIntent = new MyIntent();
        myIntent.dialPhoneNumber(getString(R.string.default_contact_number),this);
    }

    public void onClickPlayMedia(View view) {
        MyIntent myIntent = new MyIntent();
        myIntent.playMedia(this);
    }

    public void onClickStartTimer(View view) {
        MyIntent myIntent = new MyIntent();
        myIntent.startTimer("Timer testing the feature of your alarm app", 30, this);
    }
}