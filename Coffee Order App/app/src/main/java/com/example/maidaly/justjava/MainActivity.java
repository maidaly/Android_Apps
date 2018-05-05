package com.example.maidaly.justjava;

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/



        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.EditText;
        import android.widget.TextView;
        import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the new order button is clicked.
     */
    public void NewOrder(View view) {
        Intent intent = new Intent(this,MakeOrder.class);// attach two activities
        EditText uesrName = (EditText) findViewById(R.id.user_name);
        EditText emailAddress = (EditText) findViewById(R.id.email);
        String UserName = uesrName.getText().toString();
        String EmailAddress = emailAddress.getText().toString();
        intent.putExtra("UserName",UserName);
        intent.putExtra("EmailAddress",EmailAddress);

        startActivity(intent);

    }
}
