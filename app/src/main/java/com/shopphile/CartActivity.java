package com.shopphile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private ArrayList<String> productNames;
    private ArrayList<String> productPrices;
    private ArrayList<Integer> quantities;
    private ArrayList<Integer> productImages; // To store image resource IDs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            ImageButton backButton = findViewById(R.id.backbtn);
            backButton.setOnClickListener(view -> {
                Intent mainIntent = new Intent(CartActivity.this, MainActivity.class);
                startActivity(mainIntent);
            });

            Button checkoutButton = findViewById(R.id.button2);
            checkoutButton.setOnClickListener(view -> {
                Intent checkoutIntent = new Intent(CartActivity.this, CheckoutActivity.class);
                // Pass any required data to checkout
                startActivity(checkoutIntent);
            });


            // Initialize product data
            initializeProductData();

            RecyclerView recyclerView = findViewById(R.id.cart_recyvlerview);
            CartRecyclerAdapter adapter = new CartRecyclerAdapter(productNames, productPrices, quantities, productImages);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);

            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




    }

    private void initializeProductData() {
        productNames = new ArrayList<>();
        productPrices = new ArrayList<>(); // Change to ArrayList<String>
        quantities = new ArrayList<>();
        productImages = new ArrayList<>();

        String[] names = getResources().getStringArray(R.array.product_names);
        String[] prices = getResources().getStringArray(R.array.product_prices);

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
        for (int i = 0; i < names.length; i++) {
            productNames.add(names[i]);
            productPrices.add(prices[i]); // Store as String
            quantities.add(1); // Default quantity is 1 for each product

            productImages.add(images[i]);
        }
    }


}
