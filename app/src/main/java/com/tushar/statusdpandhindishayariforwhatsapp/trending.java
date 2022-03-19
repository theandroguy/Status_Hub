package com.tushar.statusdpandhindishayariforwhatsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.tushar.statusdpandhindishayariforwhatsapp.model.TrendingModel;
import com.tushar.statusdpandhindishayariforwhatsapp.view.TrendingAdapter;


public class trending extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    RecyclerView recviewT;
    TrendingAdapter mTrendingAdapter;

    public trending() {

    }


    public static trending newInstance(String param1, String param2) {
        trending fragment = new trending();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_trending, container, false);

        recviewT=view.findViewById(R.id.rcviewT);
        recviewT.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        FirebaseRecyclerOptions<TrendingModel> options = new FirebaseRecyclerOptions.Builder<TrendingModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("trend"), TrendingModel.class)
                .build();

        mTrendingAdapter = new TrendingAdapter(options);
        recviewT.setAdapter(mTrendingAdapter);

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        mTrendingAdapter.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();
        mTrendingAdapter.stopListening();
    }
}