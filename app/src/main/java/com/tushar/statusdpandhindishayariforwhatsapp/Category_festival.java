package com.tushar.statusdpandhindishayariforwhatsapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.tushar.statusdpandhindishayariforwhatsapp.model.cat_festival;
import com.tushar.statusdpandhindishayariforwhatsapp.view.cat_festivalAdapter;

public class Category_festival extends AppCompatActivity {

    RecyclerView recviewdp;
    cat_festivalAdapter mCatAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_love);


        recviewdp=findViewById(R.id.rcviewl);
        recviewdp.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        FirebaseRecyclerOptions<cat_festival> options = new FirebaseRecyclerOptions.Builder<cat_festival>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("festival"), cat_festival.class)
                .build();
        mCatAdapter = new cat_festivalAdapter(options);
        recviewdp.setAdapter(mCatAdapter);

    }



    @Override
    public void onStart() {
        super.onStart();
        mCatAdapter.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();
        mCatAdapter.stopListening();
    }

}