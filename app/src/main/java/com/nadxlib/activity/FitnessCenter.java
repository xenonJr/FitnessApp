package com.nadxlib.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nadxlib.Adapters.PurchaseItemRecyclerViewAdapter;

import java.util.ArrayList;

import ayalma.ir.expandablerecyclerview.ExpandableRecyclerView;

public class FitnessCenter extends AppCompatActivity {

    ArrayList<String> titles;
    ArrayList<String> descrips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_center);
        ExpandableRecyclerView eRecyclerView = findViewById(R.id.purchase_list);


        titles = new ArrayList<>();
        descrips = new ArrayList<>();

        titles.add("World gym");
        descrips.add("Location: \n 123, New Kakrail Road, Mouban Super Market ( 2nd Floor), Opposite Shantinagar Bazar, Ramna Dhaka-1000, Bangladesh. \n\n Contact: \n 01712-777222");

        titles.add("California fitness");
        descrips.add("Location: \n 79 Gulshan North Ave, Dhaka 1212 \n \n Contact: \n01715-698888");

        titles.add("X-Treme Fitness");
        descrips.add("Location: \n 16 Gareeb-e-Nawaz Ave, Dhaka 1230 \n\n Contact: \n 01919-162953");

        titles.add("AIUB Fitness Center");
        descrips.add("Location: \n 408/1, Kuratoli, Khilkhet, Dhaka 1229, Bangladesh \n\n Contact: \n 02-8414046");

        PurchaseItemRecyclerViewAdapter mPIAdapter = new PurchaseItemRecyclerViewAdapter(titles,descrips); // purchaseItemAdapter
        eRecyclerView.setAdapter(mPIAdapter);
    }
}