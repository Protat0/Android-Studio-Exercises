package com.counterappintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {

            EditText edUser, edPass;
            Button loginBtn;


            edUser = (EditText)findViewById(R.id.eduser);
            edPass = (EditText)findViewById(R.id.edpass);
            loginBtn = (Button)findViewById(R.id.loginbtn);

            String user = "admin";
            String pass = "pass";


            loginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(edUser.getText().toString().equals(user) && edPass.getText().toString().equals(pass)) {
                        Toast.makeText(LoginPage.this, "Login Successful!", Toast.LENGTH_SHORT).show();

                        Intent mainIntent = new Intent(LoginPage.this, HomePage.class);
                        startActivity(mainIntent);


                    } else {
                        Toast.makeText(LoginPage.this, "Incorrect Details", Toast.LENGTH_SHORT).show();
                    }
                }
            });


            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}