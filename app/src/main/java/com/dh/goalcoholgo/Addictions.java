package com.dh.goalcoholgo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.dh.goalcoholgo.R;

public class Addictions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addictions);
    }
    public void Alcohol(View view) {

        Intent intent = new Intent(this, Alcohol_1.class);
        startActivity(intent);
    }
//    public void Smoking(View view) {
//
//        Intent intent = new Intent(this, Smoking.class);
//        startActivity(intent);
//    }
//
//    public void Junkfood(View view) {
//
//        Intent intent = new Intent(this, JunkFood.class);
//        startActivity(intent);
//    }
}

