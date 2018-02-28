package com.example.maidaly.justjava;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by Mai Daly on 2/24/2018.
 */

public class GridAdapter extends ArrayAdapter<word> {

    public GridAdapter(Context context, ArrayList<word> words) {
        super(context, 0, words);
    }

    class ViewHolder {
        ImageView image;
        TextView text_1;
        TextView text_2;

        ViewHolder(View view) {
            image = (ImageView) view.findViewById(R.id.coffe_image);
            text_1 = (TextView) view.findViewById(R.id.coffe_type);
            text_2 = (TextView) view.findViewById(R.id.coffe_price);
        }
    }

    ViewHolder holder;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
         /* There is no view at this position, we create a new one.
       In this case by inflating an xml layout */
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
            word currentWord = getItem(position);
            holder.text_1.setText(currentWord.getmCoffeType());
            holder.text_2.setText(currentWord.getmCoffePrice());
            holder.image.setImageResource(currentWord.getmImageResourceId());
        } else {
            // if not null get tag
            // no need to initialize
             /* We recycle a View that already exists */
            holder = (ViewHolder) convertView.getTag();
        }
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Thread worker = new Thread(new Runnable(){
                    @Override
                    public void run()
                    {
                        Intent intent= new Intent(holder.image.getContext(),OrderDetails.class) ;
                        holder.image.getContext().startActivity(intent);                    }});
                   worker.start();}});
            return convertView;
    }

}


