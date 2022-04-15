package com.l.lifyplus2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class panic_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panic_3);
    }
    public void P3(View view) {

        Intent intent = new Intent(this, Panic.class);
        startActivity(intent);
    }
    public void H3(View view) {

        Intent intent = new Intent(this, Alcohol_1.class);
        startActivity(intent);
    }
}