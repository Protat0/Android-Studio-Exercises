package com.shopphile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main ), (v, insets) -> {


//            CART LINK
            ImageButton Cart_Button;

            Cart_Button = (ImageButton)findViewById(R.id.cart_button);


            Cart_Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent MainIntent = new Intent(MainActivity.this, CartActivity.class);
                    startActivity(MainIntent);
                }
            });


//            NEW ARRIVAL LINK
            Button Shop_Now_Button;

            Shop_Now_Button = (Button)findViewById(R.id.shop_now_button);

            Shop_Now_Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent MainIntent2 = new Intent(MainActivity.this, NewArrivalActivity.class);
                    startActivity(MainIntent2);
                }
            });

            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}