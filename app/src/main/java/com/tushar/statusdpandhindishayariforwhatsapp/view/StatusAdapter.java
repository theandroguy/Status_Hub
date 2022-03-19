package com.tushar.statusdpandhindishayariforwhatsapp.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.tushar.statusdpandhindishayariforwhatsapp.R;
import com.tushar.statusdpandhindishayariforwhatsapp.model.StatusModel;

import static android.content.Context.CLIPBOARD_SERVICE;

public class StatusAdapter extends FirebaseRecyclerAdapter<StatusModel, StatusAdapter.StatusViewHolder> {




    public StatusAdapter(@NonNull FirebaseRecyclerOptions<StatusModel> options, Context context) {
        super(options);

    }

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public StatusAdapter(@NonNull FirebaseRecyclerOptions<StatusModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull StatusViewHolder holder, int position, @NonNull StatusModel model) {
        holder.StatusText.setText(model.getSt());

    }

    @NonNull
    @Override
    public StatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.status_ui,parent,false);
       return new StatusViewHolder(view);

    }



    class StatusViewHolder extends RecyclerView.ViewHolder
    {
        TextView StatusText;
        ClipboardManager mClipboardManager;
        ClipData mClipData;




        public StatusViewHolder(@NonNull View itemView) {
            super(itemView);
            StatusText=itemView.findViewById(R.id.statustext);

            itemView.findViewById(R.id.copybtn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity mActivity=(AppCompatActivity)v.getContext();
                    String text=StatusText.getText().toString();
                    mClipboardManager = (ClipboardManager)mActivity.getSystemService(CLIPBOARD_SERVICE);
                    mClipData = ClipData.newPlainText("text",text);
                    mClipboardManager.setPrimaryClip(mClipData);


                    Toast.makeText(mActivity, "Status Copied", Toast.LENGTH_SHORT).show();
                }
            });

            itemView.findViewById(R.id.sharebtn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity mmActivity=(AppCompatActivity)v.getContext();
                    Toast.makeText(mmActivity, "Sharing", Toast.LENGTH_SHORT).show();
                    String text=StatusText.getText().toString();
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, text);
                    sendIntent.setType("text/plain");

                    Intent shareIntent = Intent.createChooser(sendIntent, null);
                    mmActivity.startActivity(shareIntent);



                }



            });
        }

    }

}
