//package com.example.maidaly.justjava;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//
//import java.util.zip.Inflater;
//
///**
// * Created by Mai Daly on 2/25/2018.
// */
//
//public class GridViewAdapter extends BaseAdapter {
//    private int [] images ={
//            R.drawable.latte,
//            R.drawable.cappuccio,
//            R.drawable.espresso,
//            R.drawable.mocha1
//    };
//    private String imageLabels [];
//    private Context context;
//    private LayoutInflater inflater;
//    public GridViewAdapter (Context con, String [] labels){
//        this.context=con;
//        this.inflater = LayoutInflater.from(con);
//        this.imageLabels = labels;
//    }
//
//    @Override
//    public int getCount() {
//        return images.length;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView==null){
//            convertView = inflater.inflate(R.layout.list_item, parent, false );}
//
//
//        }
//
//    @Override
//    public Object getItem(int position) {
//        return position;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//}
