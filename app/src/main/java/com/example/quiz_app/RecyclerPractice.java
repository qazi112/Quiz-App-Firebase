package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerPractice extends AppCompatActivity {
    RecyclerView programmingList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_practice);
        String[] languages ={"C++","C","Python Love","Javascript","Java"};
        programmingList = (RecyclerView) findViewById(R.id.programming_list);
        programmingList.setLayoutManager(new LinearLayoutManager(this));
        programmingList.setAdapter(new ProgrammingAdaptor(languages));

    }
}