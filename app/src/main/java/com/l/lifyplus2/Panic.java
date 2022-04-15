package com.l.lifyplus2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Panic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panic);
    }
    public void P1(View view) {

        Intent intent = new Intent(this, Panic_2.class);
        startActivity(intent);
    }
    public void H1(View view) {

        Intent intent = new Intent(this, Alcohol_1.class);
        startActivity(intent);
    }
}