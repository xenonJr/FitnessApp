package com.nadxlib.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.nadxlib.model.FitnessTIp;

public class AddDataActivity extends AppCompatActivity {

    EditText title,description;
    Button addData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        title = findViewById(R.id.et_email_edit_kt);
        description = findViewById(R.id.et_password_edit_kt);
        addData = findViewById(R.id.btn_cancel_save_edit);



        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tit = title.getText().toString();
                String des = description.getText().toString();
                FitnessTIp fitnessTIp = new FitnessTIp(tit,des);
                FirebaseDatabase.getInstance().getReference("FitnessInfo").child(String.valueOf(System.currentTimeMillis())).setValue(fitnessTIp).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(AddDataActivity.this, "Data Added", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });





    }
}