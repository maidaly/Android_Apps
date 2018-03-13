package com.example.maidaly.justjava;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OrderSummeryDialog extends Activity {
    int Price = 0;
    int NumberOfCups;
    int SugarNumber;
    String CoffeType;
    String orderSize;
    String UserName;
    String EmailAddress;
    boolean chocolateState;
    boolean carmelState;
    boolean vanillaState;
    boolean wipeCreamState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_summery_dialoge);

        /* get window size*/

        Display display = getWindowManager().getDefaultDisplay(); /* get window size*/
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        /* Change the dialog size */

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.height = height - 256;
        params.width = width - 64;
        this.getWindow().setAttributes(params);

        /* Receive the data from the previous intent*/

        Price = getIntent().getIntExtra("TotalPrice", 0);
        CoffeType = getIntent().getStringExtra("CoffeType");
        NumberOfCups = getIntent().getIntExtra("NumberOfCups", 0);
        SugarNumber = getIntent().getIntExtra("SugarNumber", 0);
        orderSize = getIntent().getStringExtra("orderSize");
        UserName = getIntent().getStringExtra("UserName");
        EmailAddress = getIntent().getStringExtra("EmailAddress");
        chocolateState = getIntent().getBooleanExtra("chocolateState", false);
        carmelState = getIntent().getBooleanExtra("carmelState", false);
        vanillaState = getIntent().getBooleanExtra("vanillaState", false);
        wipeCreamState = getIntent().getBooleanExtra("wipeCreamState", false);

        /* Cast the xml elements */

        TextView messageSumerry = (TextView) findViewById(R.id.Order_summery_text);
        messageSumerry.setMaxLines(5);
        TextView totalPrice = (TextView) findViewById(R.id.total_price_text);

        messageSumerry.setText(OrderSumeryMessage());
        totalPrice.setText("$" + " " + String.valueOf(CalculateTotalPriceWithToping(Price)));

        Button Confirm = (Button) findViewById(R.id.confirm_button);

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button sendEmail = (Button) findViewById(R.id.sendMail);
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"+EmailAddress)); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order Summery for " + UserName);
                intent.putExtra(Intent.EXTRA_TEXT, OrderSumeryMessage());
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(OrderSummeryDialog.this, "There is no email app to use. Please install one.", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    private int CalculateTotalPriceWithToping(int price) {

        if (chocolateState) {
            price = price + 2;
        }
        if (carmelState) {
            price = price + 2;
        }
        if (vanillaState) {
            price = price + 2;
        }
        if (wipeCreamState) {
            price = price + 2;
        }
        return price; }

    private String TopingOptionsFunction() {
        String TopingOptions = null;

        if (chocolateState) {
            if (TopingOptions != null)
                TopingOptions = TopingOptions + " and Chocolate";
            else
                TopingOptions = " , Topping Chocolate";
        }
        if (carmelState) {
            if (TopingOptions != null)
                TopingOptions = TopingOptions + " and Caramel";
            else
                TopingOptions = " , Topping Caramel";
        }
        if (vanillaState) {
            if (TopingOptions != null)
                TopingOptions = TopingOptions + "  and Vanilla";
            else
                TopingOptions = " , Topping Vanilla";
        }
        if (wipeCreamState) {
            if (TopingOptions != null)
                TopingOptions = TopingOptions + " and Wipe Cream";
            else
                TopingOptions = " , Topping Wipe Cream";
        }
        return TopingOptions;}

    private String OrderSumeryMessage() {
        String Message;
        if (TopingOptionsFunction() != null) {
            Message = String.valueOf(NumberOfCups) + " " + CoffeType + " " + orderSize + " " + TopingOptionsFunction() + " with "
                    + String.valueOf(SugarNumber) + " Sugar spoons.";
        } else {
            Message = String.valueOf(NumberOfCups) + " " + CoffeType + " " + orderSize + " " + " with " + String.valueOf(SugarNumber) + " Sugar spoons.";
        }
        return Message;
    }

}
