package com.tushar.statusdpandhindishayariforwhatsapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.tushar.statusdpandhindishayariforwhatsapp.model.vdoModel;
import com.tushar.statusdpandhindishayariforwhatsapp.view.vdoAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link video#newInstance} factory method to
 * create an instance of this fragment.
 */
public class video extends Fragment  {





    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    ViewPager2 mViewPager2;
    vdoAdapter mVdoAdapter;


    public video() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment category.
     */
    // TODO: Rename and change types and number of parameters
    public static video newInstance(String param1, String param2) {
        video fragment = new video();
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
        View view= inflater.inflate(R.layout.fragment_video, container, false);
         mViewPager2 =view.findViewById(R.id.view2);

        FirebaseRecyclerOptions<vdoModel> options=new FirebaseRecyclerOptions.Builder<vdoModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("videos"),vdoModel.class)
                .build();








        //Toast.makeText(getContext(), "Swipe 2 tabs left to stop video", Toast.LENGTH_LONG).show();
        mVdoAdapter=new vdoAdapter(options);
        mViewPager2.setAdapter(mVdoAdapter);

        return view;

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (this.isVisible())
        {
            if (!isVisibleToUser)   // If we are becoming invisible, then...
            {
                //pause or stop video
                mVdoAdapter.stopListening();
            }

            if (isVisibleToUser) // If we are becoming visible, then...
            {
                //play your video
               mVdoAdapter.startListening();
            }
        }
    }

}