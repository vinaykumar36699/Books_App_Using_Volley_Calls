package com.example.books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Splash extends AppCompatActivity {
    Button books, permission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        books = findViewById(R.id.getBooks);
        permission = findViewById(R.id.permission);

        ((Button) findViewById(R.id.getBooks)).setText(this.getResources().getString(R.string.GET_BOOKS));
        ((Button) findViewById(R.id.permission)).setText(this.getResources().getString(R.string.Permissions));

        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
            }
        });

        permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Splash.this, permissions.class);
                startActivity(intent);
            }
        });
    }
}