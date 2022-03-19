package com.tushar.statusdpandhindishayariforwhatsapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.tushar.statusdpandhindishayariforwhatsapp.model.love_cat;
import com.tushar.statusdpandhindishayariforwhatsapp.view.cat_loveAdapter;

public class Category_love extends AppCompatActivity {

    RecyclerView recviewdp;
    cat_loveAdapter mCat_loveAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_love);

        recviewdp=findViewById(R.id.rcviewl);
        recviewdp.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        FirebaseRecyclerOptions<love_cat> options = new FirebaseRecyclerOptions.Builder<love_cat>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("love"), love_cat.class)
                .build();
        mCat_loveAdapter = new cat_loveAdapter(options);
        recviewdp.setAdapter(mCat_loveAdapter);

    }



    @Override
    public void onStart() {
        super.onStart();
        mCat_loveAdapter.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();
        mCat_loveAdapter.stopListening();
    }

}