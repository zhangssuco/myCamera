package com.example.mycamera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class Images extends BaseAdapter {
    private Context context;
    private final ArrayList<ImageDataModel> il;

    public Images(Context context, ArrayList<ImageDataModel> il ) {
        this.context = context;
        this.il = il;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }

        String filename = il.get(position).getImagePath();
        Log.d("filename", filename);
        //Toast.makeText(context, filename, Toast.LENGTH_SHORT).show();
        Bitmap bmp = BitmapFactory.decodeFile(filename);
        imageView.setImageBitmap(bmp);
        imageView.setTag(filename);

        return imageView;
    }


    public View getView2(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;

        if (convertView == null) {

            //gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.animage, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);

            textView.setText(il.get(position).getImagePath());

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);

            String filename = il.get(position).getImagePath();

            Log.d("filename", filename);
            Toast.makeText(context, filename, Toast.LENGTH_SHORT).show();

            //String filePath = Environment.getDataDirectory()
            //        .getAbsolutePath() + File.separator + "your_image_name.png";
            Bitmap bmp = BitmapFactory.decodeFile(filename);
            imageView.setImageBitmap(bmp);

            return gridView;
        }
    return null;
    }



    @Override
        public int getCount()
    {
            if (il != null)
                return il.size();
            else
                return 0;
        }


    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}