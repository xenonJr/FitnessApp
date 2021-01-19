package com.nadxlib.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nadxlib.Adapters.PurchaseItemRecyclerViewAdapter;
import com.nadxlib.chatOption.ChatAdapter;
import com.nadxlib.model.FitnessTIp;
import com.nadxlib.model.SingleChatMassage;

import java.util.ArrayList;
import java.util.List;

import ayalma.ir.expandablerecyclerview.ExpandableRecyclerView;

public class DeiseasesActivity extends AppCompatActivity {

    ArrayList<String> titles;
    ArrayList<String> descrips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diseaseslistview);
        ExpandableRecyclerView eRecyclerView = findViewById(R.id.purchase_list);
       // String[] foo_array = getApplicationContext().getResources().getStringArray(R.array.WomensHealthStatement);
       // String[] dN = getApplicationContext().getResources().getStringArray(R.array.dname);


        titles = new ArrayList<>();
        descrips = new ArrayList<>();

        FirebaseDatabase.getInstance().getReference("FitnessInfo").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<SingleChatMassage> l = new ArrayList<>();
                if (snapshot.exists()){
                    for (DataSnapshot npsnapshot : snapshot.getChildren()){
                        FitnessTIp r = npsnapshot.getValue(FitnessTIp.class);
                        titles.add(r.getTitle());
                        descrips.add(r.getDes());
                    }
                    PurchaseItemRecyclerViewAdapter mPIAdapter = new PurchaseItemRecyclerViewAdapter(titles,descrips); // purchaseItemAdapter
                    eRecyclerView.setAdapter(mPIAdapter);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });









    }
}