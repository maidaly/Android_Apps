package com.example.maidaly.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MakeOrder extends AppCompatActivity {
    String UserName;
    String EmailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_order);
        UserName = getIntent().getStringExtra("UserName");
        EmailAddress = getIntent().getStringExtra("EmailAddress");
        final ArrayList<word> words = new ArrayList<>();

        words.add(new word("Arabic Coffee", "$5", R.drawable.arabia_coffe));
        words.add(new word("Latte", "$5", R.drawable.latte));
        words.add(new word("Cappuccino", "$5", R.drawable.cappuccino));
        words.add(new word("Espresso", "$5", R.drawable.espresso));
        words.add(new word("Mocha", "$5", R.drawable.mocha));
        words.add(new word("Amricano", "$5", R.drawable.amricano_cafe));
        words.add(new word("Macchiato", "$5", R.drawable.caramel_macchiato));
        words.add(new word("Con Panna", "$5", R.drawable.con_panna1));

        GridAdapter Adapter = new GridAdapter(this, words);
        GridView gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(Adapter);
        gridView.setSmoothScrollbarEnabled(true);
        /* We use this method to let the item of the GridView clickable
         * we add it by code--> implemented methods in android studio */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MakeOrder.this, OrderDetails.class);
                GridAdapter.ViewHolder holder = (GridAdapter.ViewHolder) view.getTag();
                word temp = words.get(position);
                intent.putExtra("UserName", UserName);
                intent.putExtra("EmailAddress", EmailAddress);
                intent.putExtra("CoffeType", temp.getmCoffeType());
                intent.putExtra("CoffeImage", temp.getmImageResourceId());
                startActivity(intent);
            }
        });


    }
}






