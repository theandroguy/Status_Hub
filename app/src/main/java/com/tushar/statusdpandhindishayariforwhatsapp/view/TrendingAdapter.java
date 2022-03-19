package com.tushar.statusdpandhindishayariforwhatsapp.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.tushar.statusdpandhindishayariforwhatsapp.R;
import com.tushar.statusdpandhindishayariforwhatsapp.model.TrendingModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TrendingAdapter extends FirebaseRecyclerAdapter<TrendingModel, TrendingAdapter.TrendingViewHolder> {


    private Bitmap getB(View view) {
        Bitmap rbitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(rbitmap);
        Drawable bgdraw = view.getBackground();
        if (bgdraw != null) {
            bgdraw.draw(canvas);
        } else {
            canvas.drawColor(Color.WHITE);
        }
        view.draw(canvas);
        return rbitmap;
    }

    public TrendingAdapter(@NonNull FirebaseRecyclerOptions<TrendingModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull TrendingViewHolder holder, int position, @NonNull TrendingModel model) {
        Glide.with(holder.memeImage.getContext()).load(model.getMeme()).into(holder.memeImage);


    }

    @NonNull
    @Override
    public TrendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meme_ui, parent, false);
        return new TrendingViewHolder(view);

    }


    class TrendingViewHolder extends RecyclerView.ViewHolder {
        ImageView memeImage;

        public TrendingViewHolder(@NonNull View itemView) {
            super(itemView);
            memeImage = itemView.findViewById(R.id.tmemes);

            itemView.findViewById(R.id.sharebtn).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    AppCompatActivity mmActivity = (AppCompatActivity) v.getContext();
                    Bitmap mBitmap = getB(memeImage);


                    Toast.makeText(mmActivity, "Sharing to Facebook/Instagram/Whatsapp", Toast.LENGTH_SHORT).show();

                    File file = new File(mmActivity.getExternalCacheDir(), "meme.png");
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        file.setReadable(true, false);
                        Intent intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        // intent.putExtra(intent.EXTRA_TEXT,"")
                        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                        intent.setType("image/png");
                        mmActivity.startActivity(Intent.createChooser(intent, "share via"));


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }


            });
        }
    }
}








