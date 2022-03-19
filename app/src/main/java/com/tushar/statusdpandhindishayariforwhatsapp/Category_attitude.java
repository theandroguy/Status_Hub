package com.tushar.statusdpandhindishayariforwhatsapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.tushar.statusdpandhindishayariforwhatsapp.model.attitude_cat;
import com.tushar.statusdpandhindishayariforwhatsapp.view.attitude_catAdapter;

public class Category_attitude extends AppCompatActivity {

    RecyclerView recviewdp;
    attitude_catAdapter mAttitude_catAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_love);


        recviewdp=findViewById(R.id.rcviewl);
        recviewdp.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        FirebaseRecyclerOptions<attitude_cat> options = new FirebaseRecyclerOptions.Builder<attitude_cat>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("attitude"), attitude_cat.class)
                .build();
        mAttitude_catAdapter = new attitude_catAdapter(options);
        recviewdp.setAdapter(mAttitude_catAdapter);

    }



    @Override
    public void onStart() {
        super.onStart();
        mAttitude_catAdapter.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();
       mAttitude_catAdapter.stopListening();
    }

}