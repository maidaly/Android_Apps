package com.example.maidaly.justjava;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MakeOrder extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_order);
        ArrayList<word> words = new ArrayList<>();

        words.add(new word("Arabic Coffee","$5",R.drawable.arabia_coffe));
        words.add(new word("Latte","$5", R.drawable.latte));
        words.add(new word("Cappuccino","$5",R.drawable.cappuccino));
        words.add(new word("Espresso","$5",R.drawable.espresso));
        words.add(new word("Mocha","$5",R.drawable.mocha));
        words.add(new word("Amricano","$5",R.drawable.amricano_cafe));
        words.add(new word("Macchiato","$5",R.drawable.caramel_macchiato));
        words.add(new word("Con Panna","$5",R.drawable.con_panna1));

        GridAdapter Adapter = new GridAdapter(this,words);
        GridView gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(Adapter);
        gridView.setSmoothScrollbarEnabled(true);
//        gridView.setOnItemClickListener(this);
    }
/* We use this method to let the item of the GridView clickable
* we add it by code--> implemented methods in android studio */
//    @Override
//    // AdapterView<?> : represent the GridView in this case
//    // View : represent the the item of the gridView
//    // position: the position of item components
//    // id : we use it with SQL databases
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        new Thread(new Runnable() {
//            public void run() {
//                Intent intent = new Intent(MakeOrder.this,OrderDetails.class);
//                startActivity(intent);
//            }
//
//        }).start();
//    }
}






