package com.example.main_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button startBtn,
            settingBtn,
            aboutBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TextView HeaderTxt = (TextView) findViewById(R.id.HeaderTxt);
                //HeaderTxt.setText("It's a Train");
                openGamePage();

            }
        });

        settingBtn = findViewById(R.id.settingBtn);
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettingPage();

            }
        });

        aboutBtn = findViewById(R.id.aboutBtn);
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutPage();

            }
        });

    }
    public void openGamePage() {

        Intent intent = new Intent(this, game_page.class);
        startActivity(intent);

    }

    public void openSettingPage() {

        Intent intent = new Intent(this, setting_page.class);
        startActivity(intent);

    }

    public void openAboutPage() {

        Intent intent = new Intent(this, about_page.class);
        startActivity(intent);

    }

    //}
}
