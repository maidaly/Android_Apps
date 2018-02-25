package com.example.maidaly.justjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mai Daly on 2/24/2018.
 */

public class GridAdapter extends ArrayAdapter<word> {
    private int [] images ={
            R.drawable.latte,
            R.drawable.cappuccio,
            R.drawable.espresso,
            R.drawable.mocha1
    };
    public GridAdapter(Context context, ArrayList<word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        word currentWord = getItem(position);
        TextView CoffeType = (TextView) convertView.findViewById(R.id.coffe_type);
        TextView CoffePrice = (TextView) convertView.findViewById(R.id.coffe_price);
        ImageView image = (ImageView) convertView.findViewById(R.id.coffe_image);

        CoffeType.setText(currentWord.getmCoffeType());
        CoffePrice.setText(currentWord.getmCoffePrice());
        image.setImageResource(currentWord.getmImageResourceId());
        return convertView;

    }
}


