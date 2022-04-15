package com.l.lifyplus2;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Panic_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panic_2);
    }
        public void P2(View view) {

            Intent intent = new Intent(this, panic_3.class);
            startActivity(intent);
        }
    public void H2(View view) {

        Intent intent = new Intent(this, Alcohol_1.class);
        startActivity(intent);
    }
    }
