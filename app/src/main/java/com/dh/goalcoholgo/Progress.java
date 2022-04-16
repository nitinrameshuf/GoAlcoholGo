package com.dh.goalcoholgo;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dh.goalcoholgo.R;


public class Progress extends AppCompatActivity {
    //DrinkWater
     Button plus;
     Button Minus;
     TextView counterTxt;
     int counter;
    //Read Books
    Button plus3;
    Button Minus3;
    TextView counterTxt1;
    int counter1;
    //Meditation
    Button plus2;
    Button Minus2;
    TextView counterTxt2;
    int counter2;
    //WorkOut
    Button plus4;
    Button Minus4;
    TextView counterTxt3;
    int counter3;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        //Drink Water
        plus = findViewById(R.id.plus1);
        plus.setOnClickListener(clickListener);
        Minus = findViewById(R.id.minus3);
        Minus.setOnClickListener(clickListener);
        counterTxt = findViewById(R.id.textView12);
        // Read Books
        plus3 = findViewById(R.id.plus3);
        plus3.setOnClickListener(clickListener);
        Minus3 = findViewById(R.id.minus1);
        Minus3.setOnClickListener(clickListener);
        counterTxt1 = findViewById(R.id.textView13);
        //Meditation
        plus2 = findViewById(R.id.plus);
        plus2.setOnClickListener(clickListener);
        Minus2 = findViewById(R.id.minus);
        Minus2.setOnClickListener(clickListener);
        counterTxt2 = findViewById(R.id.textView14);
        //WorkOut
        plus4 = findViewById(R.id.plus2);
        plus4.setOnClickListener(clickListener);
        Minus4 = findViewById(R.id.minus2);
        Minus4.setOnClickListener(clickListener);
        counterTxt3 = findViewById(R.id.textView15);

    }

    //Drink Water
    @SuppressLint("SetTextI18n")
    private void plusCounter() {
        if(counter>=10)
            counter=9;
            Toast.makeText(this,"Congratulations Your goal is achieved",Toast.LENGTH_SHORT).show();
        counter++;
        counterTxt.setText(counter + "");
    }

    @SuppressLint("SetTextI18n")
    private void minusCounter() {
        if(counter<=0)
            counter=1;

        counter--;
        counterTxt.setText(counter + "");
    }

    //Read Books
    @SuppressLint("SetTextI18n")
    private void plusCounter1() {
        if(counter1>=5)
            counter1=4;
        Toast.makeText(this,"Congratulations Your goal is achieved",Toast.LENGTH_SHORT).show();
        counter1++;
        counterTxt1.setText(counter1 + "");
    }

    @SuppressLint("SetTextI18n")
    private void minusCounter1() {
        if(counter1<=0)
            counter1=1;
        counter1--;
        counterTxt1.setText(counter1 + "");
    }
    //Meditation

    @SuppressLint("SetTextI18n")
    private void plusCounter2() {
        if(counter2>=2)
            counter2=1;
        Toast.makeText(this,"Congratulations Your goal is achieved",Toast.LENGTH_SHORT).show();
        counter2++;
        counterTxt2.setText(counter2 + "");
    }

    @SuppressLint("SetTextI18n")
    private void minusCounter2() {
        if(counter2<=0)
            counter2=1;
        counter2--;
        counterTxt2.setText(counter2 + "");
    }
    //WorkOut

    @SuppressLint("SetTextI18n")
    private void plusCounter3() {
        if(counter3>=1)
            counter3=0;
        Toast.makeText(this,"Congratulations Your goal is achieved",Toast.LENGTH_SHORT).show();
        counter3++;
        counterTxt3.setText(counter3 + "");
    }

    @SuppressLint("SetTextI18n")
    private void minusCounter3() {
        if(counter3<=0)
            counter3=1;

        counter3--;
        counterTxt3.setText(counter3 + "");
    }


    private View.OnClickListener clickListener = new View.OnClickListener() {


        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.plus1:
                    plusCounter();                        //Drink Water
                    break;
                case R.id.minus3:
                    minusCounter();
                    break;
                case R.id.plus3:
                    plusCounter1();                            //Read Books
                    break;
                case R.id.minus1:
                    minusCounter1();
                    break;

                case R.id.plus:
                    plusCounter2();                             //Meditation
                    break;
                case R.id.minus:
                    minusCounter2();
                    break;
                case R.id.plus2:
                    plusCounter3();                             //WorkOut
                    break;
                case R.id.minus2:
                    minusCounter3();
                    break;
            }

        }
    };
}












