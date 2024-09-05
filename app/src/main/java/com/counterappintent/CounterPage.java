package com.counterappintent;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CounterPage extends AppCompatActivity {

    Button backBtn, plusBtn, minusBtn;
    EditText edCounter;
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_counter_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {




            backBtn = (Button)findViewById(R.id.backbtn);
            plusBtn = (Button)findViewById(R.id.plusbtn);
            minusBtn = (Button)findViewById(R.id.minusbtn);
            edCounter = (EditText)findViewById(R.id.edcounter);




            backBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mainIntent = new Intent(CounterPage.this, HomePage.class);
                    startActivity(mainIntent);
                }
            });


            minusBtn.setEnabled(false);

            plusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    counter++;
                    edCounter.setText(String.valueOf(counter));

                    if(counter > 0 ) {
                        minusBtn.setEnabled(true);
                    }


                }
            });

            minusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(counter > 0) {
                        counter--;
                        edCounter.setText(String.valueOf(counter));
                    }

                    if(counter == 0) {
                        minusBtn.setEnabled(false);
                    }




                }
            });



            edCounter.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    String input = editable.toString();

                    // Check if the input is not empty and is a valid number
                    if (!input.isEmpty()) {
                        try {
                            int value = Integer.parseInt(input);

                            if (value < 0) {
                                // If the value is negative, reset it to 0
                                edCounter.setText(String.valueOf(0));
                                edCounter.setSelection(edCounter.getText().length());  // Move cursor to the end
                            } else {
                                counter = value;  // Update the counter variable
                                if (counter > 0) {
                                    minusBtn.setEnabled(true);  // Enable minus button
                                } else {
                                    minusBtn.setEnabled(false);  // Disable minus button
                                }
                            }
                        } catch (NumberFormatException e) {
                            // Handle invalid input, possibly reset to 0
                            edCounter.setText(String.valueOf(0));
                            edCounter.setSelection(edCounter.getText().length());
                        }
                    } else {
                        // If input is empty, reset to 0
                        edCounter.setText(String.valueOf(0));
                        edCounter.setSelection(edCounter.getText().length());
                        minusBtn.setEnabled(false);
                    }
                }
            });




            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}