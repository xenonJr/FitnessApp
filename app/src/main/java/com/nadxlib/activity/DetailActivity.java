package com.nadxlib.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nadxlib.chatOption.ChatScreen;
import com.nadxlib.model.FitnessTIp;
import com.smnadim21.api.SubscriptionStatusListener;

public class DetailActivity extends AppCompatActivity implements SubscriptionStatusListener {

    Button babyTodd, womanHealth, babyName, contractDoctor;
    boolean flag=false;

    int c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //button finding
        babyTodd = findViewById(R.id.babyTodd);
        womanHealth = findViewById(R.id.womanHealth);
        babyName = findViewById(R.id.babyName);
        contractDoctor = findViewById(R.id.contactDoctor);


        final String backuplink = "https://www.goal.com/en-in/team/";

        womanHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),BMRActivity.class));
            }
        });


         // button actions
        babyTodd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(DetailActivity.this, WV.class);
//                intent.putExtra("name", babyTodd.getText().toString());
//                intent.putExtra("url", backuplink);
//                startActivity(intent);
                startActivity(new Intent(getApplicationContext(),BMICalculator.class));
            }
        });



        babyName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DeiseasesActivity.class));
            }
        });

        contractDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FitnessCenter.class);
               // intent.putExtra("tag","users");
                startActivity(intent);
            }
        });

    }

    @Override
    public void onSuccess(boolean isSubscribed) {
        if (!isSubscribed) {
            flag = false;
        }
        else {
            flag = true;
        }
    }

    @Override
    public void onFailed(String message) {

    }
}