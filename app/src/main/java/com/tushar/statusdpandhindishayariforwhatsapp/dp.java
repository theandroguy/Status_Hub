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
import com.tushar.statusdpandhindishayariforwhatsapp.model.DpModel;
import com.tushar.statusdpandhindishayariforwhatsapp.view.DpAdapter;

public class dp extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    RecyclerView recviewdp;
    DpAdapter mDpAdapter;
    //AdView mAdView;



    public dp() {
        // Required empty public constructor
    }

    public static dp newInstance(String param1, String param2) {
        dp fragment = new dp();
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
        View view= inflater.inflate(R.layout.fragment_dp, container, false);


// inset here the ads



        recviewdp=view.findViewById(R.id.rcviewDP);
        recviewdp.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        FirebaseRecyclerOptions<DpModel> options = new FirebaseRecyclerOptions.Builder<DpModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("dp"), DpModel.class)
                .build();
        mDpAdapter = new DpAdapter(options);
        recviewdp.setAdapter(mDpAdapter);

        return view;

    }


    @Override
    public void onStart() {
        super.onStart();
        mDpAdapter.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();
        mDpAdapter.stopListening();
    }

}