package com.shopphile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_checkout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {

            ImageButton Back_Button;
            Button checkoutButton;

            Back_Button = (ImageButton) findViewById(R.id.backbtn);
            checkoutButton = (Button) findViewById(R.id.checkoutbutton);


            Back_Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent MainIntent = new Intent(CheckoutActivity.this, CartActivity.class);
                    startActivity(MainIntent);
                }
            });


            checkoutButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent MainIntent = new Intent(CheckoutActivity.this, OrderActivity.class);
                    startActivity(MainIntent);
                }
            });

            // Retrieve data from Intent
            Intent intent = getIntent();
            int item1Quantity = intent.getIntExtra("ITEM1_QUANTITY", 0);
            int item2Quantity = intent.getIntExtra("ITEM2_QUANTITY", 0);
            int item3Quantity = intent.getIntExtra("ITEM3_QUANTITY", 0);
            int item1Price = intent.getIntExtra("ITEM1_PRICE", 0);
            int item2Price = intent.getIntExtra("ITEM2_PRICE", 0);
            int item3Price = intent.getIntExtra("ITEM3_PRICE", 0);
            int totalAmount = intent.getIntExtra("TOTAL_AMOUNT", 0);

            // Set data to TextViews
            TextView addressDetails = findViewById(R.id.addressDetails);
            TextView paymentDetails = findViewById(R.id.paymentDetails);
            TextView itemSummary1 = findViewById(R.id.itemSummary1);
            TextView itemSummary2 = findViewById(R.id.itemSummary2);
            TextView itemSummary3 = findViewById(R.id.itemSummary3);
            TextView totalAmountView = findViewById(R.id.totalAmount);

            addressDetails.setText("123 Main Street, City, Country"); // Example address
            paymentDetails.setText("Credit Card ending in 1234"); // Example payment method

            itemSummary1.setText("Item 1: ₱" + item1Price + " x " + item1Quantity);
            itemSummary2.setText("Item 2: ₱" + item2Price + " x " + item2Quantity);
            itemSummary3.setText("Item 3: ₱" + item3Price + " x " + item3Quantity);

            totalAmountView.setText("₱" + totalAmount);

            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}