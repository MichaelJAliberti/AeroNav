package com.example.main_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class game_page extends AppCompatActivity {

    Button topLeftBtn;
    Button bottomLeftBtn;
    Button topRightBtn;
    Button bottomRightBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
        backBtn = findViewById(R.id.backBtn);
        topLeftBtn = findViewById(R.id.topLeftBtn);
        bottomLeftBtn = findViewById(R.id.bottomLeftBtn);
        topRightBtn = findViewById(R.id.topRightBtn);
        bottomRightBtn = findViewById(R.id.bottomRightBtn);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBackPage();

            }
        });

        topLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topLeftBtn.setBackgroundColor(Color.GREEN);
            }
        });

        bottomLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomLeftBtn.setBackgroundColor(Color.RED);
            }
        });

        topRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topRightBtn.setBackgroundColor(Color.GREEN);
            }
        });

        topLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topLeftBtn.setBackgroundColor(Color.RED);
            }
        });
    }

    public void openBackPage() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
