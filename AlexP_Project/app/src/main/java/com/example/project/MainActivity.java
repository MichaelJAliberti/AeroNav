package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button topLeftBtn;
    private Button bottomLeftBtn;
    private Button topRightBtn;
    private Button bottomRightBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topLeftBtn = (Button) findViewById(R.id.topLeftBtn);
        bottomLeftBtn = (Button) findViewById(R.id.bottomLeftBtn);
        topRightBtn = (Button) findViewById(R.id.topRightBtn);
        bottomRightBtn = (Button) findViewById(R.id.bottomRightBtn);

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
}
