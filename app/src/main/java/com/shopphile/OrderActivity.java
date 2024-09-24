package com.shopphile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    private ArrayList<String> productNames;
    private ArrayList<String> productPrices;
    private ArrayList<Integer> quantities;
    private ArrayList<Integer> productImages;
    private ArrayList<String> orderNumbers; // Change to Integer
    private ArrayList<String> orderDates; // Change to String

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {

            ImageButton Back_Button = findViewById(R.id.backbtn);
            Back_Button.setOnClickListener(view -> {
                Intent MainIntent = new Intent(OrderActivity.this, MainActivity.class);
                startActivity(MainIntent);
            });

            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize product data and lists
        initializeProductData();

        // Setup RecyclerView
        RecyclerView recyclerView = findViewById(R.id.order_recyvlerview); // Ensure this ID matches your layout
        OrderRecyclerAdapter adapter = new OrderRecyclerAdapter(productNames, productPrices, quantities, productImages, orderNumbers, orderDates);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initializeProductData() {
        productNames = new ArrayList<>();
        productPrices = new ArrayList<>();
        quantities = new ArrayList<>();
        productImages = new ArrayList<>();
        orderNumbers = new ArrayList<>(); // Initialize the orderNumbers list
        orderDates = new ArrayList<>();   // Initialize the orderDates list

        String[] names = getResources().getStringArray(R.array.product_names);
        String[] prices = getResources().getStringArray(R.array.product_prices);
        String[] orderId = getResources().getStringArray(R.array.order_id);
        String[] dates = getResources().getStringArray(R.array.order_date);

        int[] images = {
                R.drawable.wireless_bluetooth_headphones,
                R.drawable.smartphone_amoled,
                R.drawable.fitness_smart_watch,
                R.drawable.laptop,
                R.drawable.power_bank,
                R.drawable.tv_55inch,
                R.drawable.mechanical_keyboard,
                R.drawable.noise_canceling_headphone,
                R.drawable.action_camera,
                R.drawable.wireless_charging_pad
        };

        // Populate product names, prices, quantities, and images
        productNames.add(names[4]);
        productPrices.add(prices[4]);
        productImages.add(images[4]);
        productNames.add(names[3]);
        productPrices.add(prices[3]);
        productImages.add(images[3]);
        productNames.add(names[7]);
        productPrices.add(prices[7]);
        productImages.add(images[7]);
        productNames.add(names[6]);
        productPrices.add(prices[6]);
        productImages.add(images[6]);
        orderNumbers.add(orderId[4]);
        orderNumbers.add(orderId[3]);
        orderNumbers.add(orderId[7]);
        orderNumbers.add(orderId[6]);
        quantities.add(1); // Default quantity
        orderDates.add(dates[4]);
        orderDates.add(dates[3]);
        orderDates.add(dates[7]);
        orderDates.add(dates[6]);
    }

    private String getCurrentDate() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMM dd, yyyy", java.util.Locale.getDefault());
        return sdf.format(new java.util.Date());
    }
}
