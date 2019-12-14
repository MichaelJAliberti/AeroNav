package com.example.Project_App_Files;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.Project_App_Files.R;

public class about_page extends AppCompatActivity {

    Button backBtn;

    TextView aboutTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);

        Spanned sp = Html.fromHtml(getString(R.string.about_txt));

        aboutTxt = findViewById(R.id.aboutTxt);
        aboutTxt.setText(getString(R.string.about_txt));

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBackPage();

            }
        });
    }

    public void openBackPage() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
