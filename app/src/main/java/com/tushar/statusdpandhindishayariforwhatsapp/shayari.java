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
import com.tushar.statusdpandhindishayariforwhatsapp.model.SayModel;
import com.tushar.statusdpandhindishayariforwhatsapp.view.SayAdapter;


public class shayari extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    RecyclerView mRecyclerView;
    SayAdapter mSayAdapter;

    public shayari() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment shayari.
     */
    // TODO: Rename and change types and number of parameters
    public static shayari newInstance(String param1, String param2) {
        shayari fragment = new shayari();
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
        View view= inflater.inflate(R.layout.fragment_shayari, container, false);



        mRecyclerView=view.findViewById(R.id.srcview);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));

        FirebaseRecyclerOptions<SayModel> options = new FirebaseRecyclerOptions.Builder<SayModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Shayari"), SayModel.class)
                .build();
        mSayAdapter = new SayAdapter(options);
        mRecyclerView.setAdapter(mSayAdapter);

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        mSayAdapter.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();
        mSayAdapter.stopListening();
    }

}