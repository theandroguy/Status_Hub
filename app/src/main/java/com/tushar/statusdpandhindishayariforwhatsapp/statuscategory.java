package com.tushar.statusdpandhindishayariforwhatsapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.tushar.statusdpandhindishayariforwhatsapp.view.cat_loveAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link statuscategory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class statuscategory extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public statuscategory() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment dpcategory.
     */
    // TODO: Rename and change types and number of parameters
    public static statuscategory newInstance(String param1, String param2) {
        statuscategory fragment = new statuscategory();
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
       View view= inflater.inflate(R.layout.fragment_statuscategory, container, false);
        AppCompatActivity mm2Activity = (AppCompatActivity)view.getContext();

       view.findViewById(R.id.love).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i=new Intent(mm2Activity, Category_love.class);
               mm2Activity.startActivity(i);
//               Toast.makeText(mm2Activity, "This feature is Coming Soon..!", Toast.LENGTH_SHORT).show();
           }
       });

        view.findViewById(R.id.attitude).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(mm2Activity, Category_attitude.class);
                mm2Activity.startActivity(i2);
               // Toast.makeText(mm2Activity, "This feature is Coming Soon..!", Toast.LENGTH_SHORT).show();
            }
        });


        view.findViewById(R.id.sed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i2=new Intent(mm2Activity, Category_sad.class);
                mm2Activity.startActivity(i2);
                //Toast.makeText(mm2Activity, "This feature is Coming Soon..!", Toast.LENGTH_SHORT).show();
            }
        });


        view.findViewById(R.id.ff).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(mm2Activity, Category_ff.class);
                mm2Activity.startActivity(i2);
                //Toast.makeText(mm2Activity, "This feature is Coming Soon..!", Toast.LENGTH_SHORT).show();
            }
        });

        view.findViewById(R.id.gm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(mm2Activity, Category_gm.class);
                mm2Activity.startActivity(i2);
                //Toast.makeText(mm2Activity, "This feature is Coming Soon..!", Toast.LENGTH_SHORT).show();
            }
        });


        view.findViewById(R.id.gn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(mm2Activity, Category_gn.class);
                mm2Activity.startActivity(i2);
                //Toast.makeText(mm2Activity, "This feature is Coming Soon..!", Toast.LENGTH_SHORT).show();
            }
        });


        view.findViewById(R.id.single).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i2=new Intent(mm2Activity, Category_single.class);
                mm2Activity.startActivity(i2);
               // Toast.makeText(mm2Activity, "This feature is Coming Soon..!", Toast.LENGTH_SHORT).show();
            }
        });

        view.findViewById(R.id.fest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(mm2Activity, Category_festival.class);
                mm2Activity.startActivity(i2);
              //  Toast.makeText(mm2Activity, "This feature is Coming Soon..!", Toast.LENGTH_SHORT).show();
            }
        });




       return view;




    }
}