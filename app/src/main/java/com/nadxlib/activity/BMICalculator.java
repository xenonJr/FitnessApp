package com.nadxlib.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalculator extends AppCompatActivity {
    EditText weight, height;
    TextView resultt,r2;
    Button addData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i_calculator);
        weight = findViewById(R.id.et_email_edit_kt);
        height = findViewById(R.id.et_password_edit_kt);
        addData = findViewById(R.id.btn_cancel_save_edit);
        resultt = findViewById(R.id.result);
        r2 = findViewById(R.id.result2);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBmi(weight.getText().toString(), height.getText().toString());
            }
        });







    }



    private void calculateBmi(String toString, String toString1) {
        float w = Float.parseFloat(toString);
        float h = Float.parseFloat(toString1);
        float result = w/(h*h);
        if(result<=18.5){
            r2.setText("You are Underweight");
        }else if(result==18.5 && result<24.9){
            r2.setText("You have Normal Weight");
        }else if(result==25 && result<29.9){
            r2.setText("You are overweight");
        }else {
            r2.setText("You have obesity");
        }
        resultt.setText("BMI Is : "+result);
    }
}