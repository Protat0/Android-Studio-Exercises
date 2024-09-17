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

public class CartActivity extends AppCompatActivity {

    private TextView orderNumber1, orderNumber2, orderNumber3;
    private TextView totalPrice, shippingPrice, amountDue;
    private int price1 = 1490, price2 = 599, price3 = 999;
    private int quantity1 = 1, quantity2 = 1, quantity3 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {

            ImageButton Back_Button;

            Back_Button = (ImageButton) findViewById(R.id.backbtn);


            Back_Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent MainIntent = new Intent(CartActivity.this, MainActivity.class);
                    startActivity(MainIntent);
                }
            });


            Button checkoutButton = findViewById(R.id.button2);
            checkoutButton.setOnClickListener(view -> {
                Intent checkoutIntent = new Intent(CartActivity.this, CheckoutActivity.class);

                // Example data to pass (in a real app, gather actual data from cart)
                int item1Price = 1490;
                int item2Price = 599;
                int item3Price = 999;

                int totalAmount = (item1Price * quantity1) + (item2Price * quantity2) + (item3Price * quantity3);

                checkoutIntent.putExtra("ITEM1_QUANTITY", quantity1);
                checkoutIntent.putExtra("ITEM2_QUANTITY", quantity2);
                checkoutIntent.putExtra("ITEM3_QUANTITY", quantity3);
                checkoutIntent.putExtra("ITEM1_PRICE", item1Price);
                checkoutIntent.putExtra("ITEM2_PRICE", item2Price);
                checkoutIntent.putExtra("ITEM3_PRICE", item3Price);
                checkoutIntent.putExtra("TOTAL_AMOUNT", totalAmount);

                startActivity(checkoutIntent);
            });

            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        orderNumber1 = findViewById(R.id.orderNumber1);
        orderNumber2 = findViewById(R.id.orderNumber2);
        orderNumber3 = findViewById(R.id.orderNumber3);

        totalPrice = findViewById(R.id.textView9);
        shippingPrice = findViewById(R.id.textView10);
        amountDue = findViewById(R.id.textView11);

        // Set initial values
        updateTotalPrice();

        // Set up button click listeners
        setUpQuantityButtons();

    }

    private void setUpQuantityButtons() {
        ImageButton minusBtn1 = findViewById(R.id.minusbtn_1);
        ImageButton plusBtn1 = findViewById(R.id.plusbtn_1);
        ImageButton minusBtn2 = findViewById(R.id.minusbtn_2);
        ImageButton plusBtn2 = findViewById(R.id.plusbtn_2);
        ImageButton minusBtn3 = findViewById(R.id.minusbtn_3);
        ImageButton plusBtn3 = findViewById(R.id.plusbtn_3);

        minusBtn1.setOnClickListener(view -> {
            if (quantity1 > 1) {
                quantity1--;
                orderNumber1.setText(String.valueOf(quantity1));
                updateTotalPrice();
            }
        });

        plusBtn1.setOnClickListener(view -> {
            quantity1++;
            orderNumber1.setText(String.valueOf(quantity1));
            updateTotalPrice();
        });

        minusBtn2.setOnClickListener(view -> {
            if (quantity2 > 1) {
                quantity2--;
                orderNumber2.setText(String.valueOf(quantity2));
                updateTotalPrice();
            }
        });

        plusBtn2.setOnClickListener(view -> {
            quantity2++;
            orderNumber2.setText(String.valueOf(quantity2));
            updateTotalPrice();
        });

        minusBtn3.setOnClickListener(view -> {
            if (quantity3 > 1) {
                quantity3--;
                orderNumber3.setText(String.valueOf(quantity3));
                updateTotalPrice();
            }
        });

        plusBtn3.setOnClickListener(view -> {
            quantity3++;
            orderNumber3.setText(String.valueOf(quantity3));
            updateTotalPrice();
        });
    }

    private void updateTotalPrice() {
        int total = (price1 * quantity1) + (price2 * quantity2) + (price3 * quantity3);
        int shipping = 199; // Example shipping price
        int due = total + shipping;

        totalPrice.setText(String.format("₱%d", total));
        shippingPrice.setText(String.format("₱%d", shipping));
        amountDue.setText(String.format("₱%d", due));
    }
}