package com.example.maidaly.justjava;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderDetails extends AppCompatActivity {

    int NumberOfCups = 1;
    int SugarNumber = 0;
    String orderSize;
    String CoffeType;
    int CoffeImageId;
    int Price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        Intent intent = getIntent();
        if (intent != null) {
            CoffeType = intent.getStringExtra("CoffeType");
            CoffeImageId = intent.getIntExtra("CoffeImage", 0);  // we use 0 as a default value
        }
        ImageView imageView = (ImageView) findViewById(CoffeImageId);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(CoffeType);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setBackgroundResource(CoffeImageId);
        collapsingToolbarLayout.setExpandedTitleColor(Color.parseColor("#ffffff"));
        collapsingToolbarLayout.setExpandedTitleGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        collapsingToolbarLayout.setContentScrimResource(R.color.havan);
        collapsingToolbarLayout.setExpandedTitleMarginBottom(PdToPx(this, 16));
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.parseColor("#FFFFFF"));
        collapsingToolbarLayout.setExpandedTitleMarginStart(PdToPx(this, 16));


        /* Buttons OnClick functions*/

        Button increment_quantity = (Button) findViewById(R.id.increment_button);
        Button decrement_quantity = (Button) findViewById(R.id.decrement_button);
        Button Done = (Button) findViewById(R.id.done_button);
        Button icrement_sugar = (Button) findViewById(R.id.increment_sugar_button);
        Button decrement_sugar = (Button) findViewById(R.id.decrement_sugar_button);
       final CheckBox chocoolate = (CheckBox) findViewById(R.id.Chocolate_checkbox) ;
       final CheckBox carmel  = (CheckBox) findViewById(R.id.Caramel_checkbox) ;
       final CheckBox vanilla  = (CheckBox) findViewById(R.id.vanilla_checkbox) ;
       final CheckBox wipeCream  = (CheckBox) findViewById(R.id.WipeCream_checkbox) ;

        Price = CalcTotalPrice(NumberOfCups);

        increment_quantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberOfCups = NumberOfCups + 1;
                if (NumberOfCups >= 100) {
                    NumberOfCups = 100;
                    Toast.makeText(OrderDetails.this, "The maxmum number of cups is 100", Toast.LENGTH_SHORT).show();
                }
                displayNumberOfCups(NumberOfCups);
                Price = CalcTotalPrice(NumberOfCups);

            }

        });

        decrement_quantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumberOfCups = NumberOfCups - 1;
                if (NumberOfCups < 1) {
                    NumberOfCups = 1;
                    Toast.makeText(OrderDetails.this, "The minimum number of cups is 1", Toast.LENGTH_SHORT).show();
                }
                displayNumberOfCups(NumberOfCups);
                Price = CalcTotalPrice(NumberOfCups);
            }

        });


        icrement_sugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SugarNumber = SugarNumber + 1;
                if (SugarNumber >= 10) {
                    SugarNumber = 10;
                    Toast.makeText(OrderDetails.this, "The maximum Sugar spoons is 10 per cup ", Toast.LENGTH_SHORT).show();
                }
                displayNumberOfSugar(SugarNumber);
            }
        });

        decrement_sugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SugarNumber = SugarNumber - 1;
                if (SugarNumber < 0) {
                    SugarNumber = 0;
                    Toast.makeText(OrderDetails.this, " It means Sugar free ", Toast.LENGTH_SHORT).show();
                }
                displayNumberOfSugar(SugarNumber);

            }
        });


        Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (orderSize != null){
                Intent intent = new Intent(OrderDetails.this, OrderSummeryDialog.class);
                intent.putExtra("TotalPrice", Price);
                intent.putExtra("chocolateState",chocoolate.isChecked());
                intent.putExtra("carmelState",carmel.isChecked());
                intent.putExtra("vanillaState",vanilla.isChecked());
                intent.putExtra("wipeCreamState",wipeCream.isChecked());
                intent.putExtra("SugarNumber",SugarNumber);
                intent.putExtra("CoffeType",CoffeType);
                intent.putExtra("NumberOfCups",NumberOfCups);
                intent.putExtra("orderSize",orderSize);
                intent.putExtra("UserName",getIntent().getStringExtra("UserName"));
                intent.putExtra("EmailAddress",getIntent().getStringExtra("EmailAddress"));

                    startActivity(intent);}
                else {Toast.makeText(OrderDetails.this,"Please choose the Coffee size",Toast.LENGTH_SHORT).show();}

            }
        });}

    public void onRadioButtonClicked(View v) {
        //require to import the RadioButton class
        //is the current radio button now checked?
        boolean checked = ((RadioButton) v).isChecked();

        //now check which radio button is selected
        //android switch statement
        switch (v.getId()) {

            case R.id.small_RadioButton:
                if (checked)
                    orderSize = "( Small )";
                break;

            case R.id.medium_RadioButton:
                if (checked)
                    orderSize = "( Medium )";
                break;

            case R.id.large_RadioButton:
                if (checked)
                    orderSize = "( Large )";

                break;
        }
    }


    private void displayNumberOfCups(int number) {
        TextView numberOfCups = (TextView) findViewById(R.id.cups_numbers_text);
        numberOfCups.setText(String.valueOf(number));
    }
    private void displayNumberOfSugar(int number) {
        TextView numberOfCups = (TextView) findViewById(R.id.sugar_spoons_numbers_text);
        numberOfCups.setText(String.valueOf(number));
    }

    private int CalcTotalPrice( int numberOfCups ) {
        int TotalPrice = 0;
        TotalPrice = numberOfCups * 5;
        return TotalPrice;
    }

    /* This function convert pd value to px value that needed in setMargin function */
    private int PdToPx(Context con, int dpValue) {
        float d = con.getResources().getDisplayMetrics().density;
        int pixelForDp = (int) (16 * d);
        return pixelForDp;
    }
}



