package com.tushar.statusdpandhindishayariforwhatsapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.tushar.statusdpandhindishayariforwhatsapp.model.cat_gm;
import com.tushar.statusdpandhindishayariforwhatsapp.view.cat_gmAdapter;

public class Category_gm extends AppCompatActivity {

    RecyclerView recviewdp;
    cat_gmAdapter mCatAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_love);


        recviewdp=findViewById(R.id.rcviewl);
        recviewdp.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        FirebaseRecyclerOptions<cat_gm> options = new FirebaseRecyclerOptions.Builder<cat_gm>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("gm"), cat_gm.class)
                .build();
        mCatAdapter = new cat_gmAdapter(options);
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