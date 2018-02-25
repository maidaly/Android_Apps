package com.example.maidaly.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MakeOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_order);
        ArrayList<word> words = new ArrayList<>();

        words.add(new word("Latte","5 $", R.drawable.latte));
        words.add(new word("Cappuccino","5 $",R.drawable.cappuccio));
        words.add(new word("Espresso","5 $",R.drawable.espresso));
        words.add(new word("Mocha","5 $",R.drawable.mocha1));
        Toast.makeText(this, "In onCreate", Toast.LENGTH_SHORT).show();

        GridAdapter Adapter = new GridAdapter(this,words);
        GridView gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(Adapter);
        Toast.makeText(this, "In onCreate", Toast.LENGTH_SHORT).show();
        Log.i("info", "In onCreat"  );
    }
}
