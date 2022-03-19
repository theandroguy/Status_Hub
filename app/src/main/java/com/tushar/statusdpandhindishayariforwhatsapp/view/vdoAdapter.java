package com.tushar.statusdpandhindishayariforwhatsapp.view;

import static android.app.DownloadManager.Request;
import static android.os.Environment.DIRECTORY_PICTURES;

import android.app.DownloadManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.storage.StorageReference;
import com.tushar.statusdpandhindishayariforwhatsapp.R;
import com.tushar.statusdpandhindishayariforwhatsapp.model.vdoModel;

public class vdoAdapter extends FirebaseRecyclerAdapter<vdoModel,vdoAdapter.myViewHolder> {

    VideoView mVideoView;



    String url;
    Context mContext;


    StorageReference ref;


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public vdoAdapter(@NonNull FirebaseRecyclerOptions<vdoModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull vdoModel model) {

        holder.setData(model);
        url=getItem(position).getUrl();




    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.vdo_ui,parent,false);
        return new myViewHolder(view);

    }

    class myViewHolder extends RecyclerView.ViewHolder{

        private static final int pick = 100;


        TextView title;
        ProgressBar mProgressBar;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

           mVideoView = itemView.findViewById(R.id.videoView);

            title = itemView.findViewById(R.id.headertextView);
            mProgressBar = itemView.findViewById(R.id.progressBar);

            AppCompatActivity mm2Activity = (AppCompatActivity)itemView.getContext();

            itemView.findViewById(R.id.shareVDO).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppCompatActivity mmActivity = (AppCompatActivity) v.getContext();

                    Toast.makeText(mmActivity, "Share Feature Coming in Next Update", Toast.LENGTH_SHORT).show();

//                    File file = new File(mmActivity.getExternalCacheDir(), "video.mp4");
//                    try {
//                        FileOutputStream fileOutputStream = new FileOutputStream(file);
//
//                        fileOutputStream.flush();
//                        fileOutputStream.close();
//                        Intent intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        //intent.putExtra(intent.EXTRA_TEXT)
//                        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
//                        intent.setType("video/mp4");
//                        mmActivity.startActivity(Intent.createChooser(intent, "share via"));
//
//
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
              }
            });

            itemView.findViewById(R.id.downVDO).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {


                    AppCompatActivity mmActivity = (AppCompatActivity) v.getContext();


                    String filename = String.format("%d.mp4", System.currentTimeMillis());
                    try {
                            Uri uri= Uri.parse(url);
                            DownloadManager downloadManager= (DownloadManager) mmActivity.getSystemService(Context.DOWNLOAD_SERVICE);
                            DownloadManager.Request request=new DownloadManager.Request(uri)
                                    .setTitle(filename)
                                    .setDescription("video is downloading")
                                    .setNotificationVisibility(Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                                    .setDestinationInExternalPublicDir(DIRECTORY_PICTURES,"/WhatsApp Dp Memes Status and Shayri/"+filename);
                            downloadManager.enqueue(request);
                            Toast.makeText(mmActivity, "Downloading , Check Notification", Toast.LENGTH_SHORT).show();
                            Toast.makeText(mmActivity, "Saved to Storage/Emulated/0/Pictures/WhatsApp Dp Memes Status and Shayri", Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        Toast.makeText(mmActivity, "Not Saved" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
       }




        void setData(vdoModel obj)
        {



            mVideoView.setVideoPath(obj.getUrl());
            title.setText(obj.getTitle());




           mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                    mProgressBar.setVisibility(View.GONE);

                }
            });

            mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });
        }



    }



}

