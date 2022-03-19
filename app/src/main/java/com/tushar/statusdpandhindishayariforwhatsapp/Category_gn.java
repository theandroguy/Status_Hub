package com.tushar.statusdpandhindishayariforwhatsapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.tushar.statusdpandhindishayariforwhatsapp.model.cat_gn;
import com.tushar.statusdpandhindishayariforwhatsapp.view.cat_gnAdapter;

public class Category_gn extends AppCompatActivity {

    RecyclerView recviewdp;
    cat_gnAdapter mCatAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_love);


        recviewdp=findViewById(R.id.rcviewl);
        recviewdp.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        FirebaseRecyclerOptions<cat_gn> options = new FirebaseRecyclerOptions.Builder<cat_gn>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("gn"), cat_gn.class)
                .build();
        mCatAdapter = new cat_gnAdapter(options);
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