package com.tushar.statusdpandhindishayariforwhatsapp.view;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
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
import com.tushar.statusdpandhindishayariforwhatsapp.model.cat_gn;
import com.tushar.statusdpandhindishayariforwhatsapp.model.cat_single;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

import static android.os.Environment.DIRECTORY_PICTURES;

public class cat_SingleAdapter extends FirebaseRecyclerAdapter<cat_single, cat_SingleAdapter.DpViewHolder> {


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




    public cat_SingleAdapter(@NonNull FirebaseRecyclerOptions<cat_single> options, Context context) {
        super(options);
    }


    public cat_SingleAdapter(@NonNull FirebaseRecyclerOptions<cat_single> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull DpViewHolder holder, int position, @NonNull cat_single model) {
        Glide.with(holder.dpView.getContext()).load(model.getSi()).into(holder.dpView);


    }

    @NonNull
    @Override
    public DpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dp_ui, parent, false);
        return new DpViewHolder(view);

    }


    class DpViewHolder extends RecyclerView.ViewHolder {
        ImageView dpView;

        public DpViewHolder(@NonNull View itemView) {
            super(itemView);
            dpView = itemView.findViewById(R.id.dpimage);

            itemView.findViewById(R.id.sharebtn).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    AppCompatActivity mmActivity = (AppCompatActivity) v.getContext();
                    Bitmap mBitmap = getB(dpView);


                    Toast.makeText(mmActivity, "Sharing", Toast.LENGTH_SHORT).show();

                    File file = new File(mmActivity.getExternalCacheDir(), "dp.png");
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        file.setReadable(true, false);
                        Intent intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        //intent.putExtra(intent.EXTRA_TEXT)
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

            itemView.findViewById(R.id.downbtn).setOnClickListener(v -> {
                FileOutputStream outputStream1 = null;

                AppCompatActivity mmActivity = (AppCompatActivity) v.getContext();


                dpView.buildDrawingCache();
                Bitmap bitmap = dpView.getDrawingCache();



                File sdcard = Environment.getExternalStoragePublicDirectory(DIRECTORY_PICTURES);
                File dir = new File(sdcard + "/WhatsApp Dp Memes Status and Shayri/");
                dir.mkdirs();
                String filename = String.format("%d.jpg", System.currentTimeMillis());
                File outFile = new File(dir, filename);



                try {
                    if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
                        outputStream1 = new FileOutputStream(outFile);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream1);
                        outputStream1.flush();
                        outputStream1.close();
                        outFile.setReadable(true, false);
                        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                        intent.setData(Uri.fromFile(outFile));
                        mmActivity.sendBroadcast(intent);
                        Toast.makeText(mmActivity, " Saved to " + dir + " " + filename, Toast.LENGTH_SHORT).show();


                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        ContentResolver resolver = mmActivity.getContentResolver();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, System.currentTimeMillis());
                        contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg");
                        contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + File.separator + "WhatsApp Dp Memes Status and Shayri");
                        Uri imageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                        outputStream1 = (FileOutputStream) resolver.openOutputStream(Objects.requireNonNull(imageUri));
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream1);
                        Objects.requireNonNull(outputStream1);

                        Toast.makeText(mmActivity, "Saved to Storage/Emulated/0/Pictures/WhatsApp Dp Memes Status and Shayri", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(mmActivity, "Not Saved" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }



            });
        }



    }

}

