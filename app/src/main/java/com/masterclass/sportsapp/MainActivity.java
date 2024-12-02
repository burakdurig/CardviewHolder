package com.masterclass.sportsapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // 1- Adapter View
    private RecyclerView recyclerView;

    // 2 - Data Source
    private List<Sport> sportList;

    // 3 - Adapter
    private CustomAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        sportList = new ArrayList<>();

        Sport s1 = new Sport("Football", R.drawable.football);
        Sport s2 = new Sport("Basketball", R.drawable.basketball);
        Sport s3 = new Sport("Volley Ball", R.drawable.volley);
        Sport s4 = new Sport("Tennis", R.drawable.tennis);
        Sport s5 = new Sport("Ping Pong", R.drawable.ping);

        sportList.add(s1);
        sportList.add(s2);
        sportList.add(s3);
        sportList.add(s4);
        sportList.add(s5);

        myAdapter = new CustomAdapter(sportList);

        // We need to layout a layout manager to manage the recycler view
        // this will measure and assign the context to the layout card automatically
        // the LinearLayout vs HorizontalLayout will layout views in a linear manner.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myAdapter);

    }




}