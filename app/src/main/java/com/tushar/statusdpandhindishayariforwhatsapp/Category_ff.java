package com.tushar.statusdpandhindishayariforwhatsapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.tushar.statusdpandhindishayariforwhatsapp.model.cat_freindsforever;
import com.tushar.statusdpandhindishayariforwhatsapp.view.cat_ffAdapter;

public class Category_ff extends AppCompatActivity {

    RecyclerView recviewdp;
    cat_ffAdapter mCatAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_love);

        recviewdp=findViewById(R.id.rcviewl);
        recviewdp.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        FirebaseRecyclerOptions<cat_freindsforever> options = new FirebaseRecyclerOptions.Builder<cat_freindsforever>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("ff"), cat_freindsforever.class)
                .build();
        mCatAdapter = new cat_ffAdapter(options);
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