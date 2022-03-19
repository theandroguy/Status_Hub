package com.tushar.statusdpandhindishayariforwhatsapp;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.tushar.statusdpandhindishayariforwhatsapp.model.StatusModel;
import com.tushar.statusdpandhindishayariforwhatsapp.view.StatusAdapter;


public class status extends Fragment {
    //#cc66ff

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    private String mParam1;
    private String mParam2;
    RecyclerView mRecyclerView;
    StatusAdapter mStatusAdapter;
    DatabaseReference statues;
   SwipeRefreshLayout pullToRefresh;


    public status() {

    }

    public static status newInstance(String param1, String param2) {
        status fragment = new status();
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


        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_status, container, false);

        AppCompatActivity mmActivity = (AppCompatActivity) view.getContext();




        mRecyclerView = view.findViewById(R.id.rcview);
        pullToRefresh = view.findViewById(R.id.pullToRefresh);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        statues = FirebaseDatabase.getInstance().getReference().child("status");


        FirebaseRecyclerOptions<StatusModel> options = new FirebaseRecyclerOptions.Builder<StatusModel>()
                .setQuery(statues, StatusModel.class)
                .build();
        mStatusAdapter = new StatusAdapter(options);

        mRecyclerView.setAdapter(mStatusAdapter);


        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                // TODO Auto-generated method stub

                refreshContent();


            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        mStatusAdapter.startListening();

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();

        mStatusAdapter.stopListening();
    }

    private void refreshContent() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pullToRefresh.setRefreshing(false);
            }
        }, 4000);

    }
}
