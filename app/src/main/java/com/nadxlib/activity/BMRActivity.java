package com.nadxlib.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BMRActivity extends AppCompatActivity {

    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    EditText weight, height,age;
    TextView resultt;
    Button addData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_r);
        radioSexGroup=(RadioGroup)findViewById(R.id.radioGroup);
        weight = findViewById(R.id.et_email_edit_kt);
        height = findViewById(R.id.et_password_edit_kt);
        addData = findViewById(R.id.btn_cancel_save_edit);
        resultt = findViewById(R.id.result);
        age = findViewById(R.id.age);

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId=radioSexGroup.getCheckedRadioButtonId();
                radioSexButton=(RadioButton)findViewById(selectedId);
                Toast.makeText(getApplicationContext(),radioSexButton.getText(),Toast.LENGTH_SHORT).show();
                calculateBmr(weight.getText().toString(), height.getText().toString(),radioSexButton.getText().toString(),age.getText().toString());
            }
        });
    }

    private void calculateBmr(String toString, String toString1, String text,String age) {
        if(text.equals("Male")){
            float w = Float.parseFloat(toString);
            float h = Float.parseFloat(toString1);
            float a = Float.parseFloat(age);
            float result = (float) (66.47+(6.24*w)+(12.7*h)-(6.755*a));
            resultt.setText("BMR Is : "+result);

        }if(text.equals("Female")){
            float w = Float.parseFloat(toString);
            float h = Float.parseFloat(toString1);
            float a = Float.parseFloat(age);
            float result = (float) (655.1+(4.35*w)+(4.7*h)-(4.7*a));
            resultt.setText("BMR Is : "+result);

        }
    }
}