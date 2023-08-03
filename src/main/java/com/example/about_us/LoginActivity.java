package com.example.about_us;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button suButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.usernameTxt);
        password = findViewById(R.id.passTxt);
        suButton = findViewById(R.id.signInButton);

        suButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login(){
        String username2 = username.getText().toString().trim();
        String password2 = password.getText().toString().trim();

        if(username2.isEmpty() || password2.isEmpty()){
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
        }
    }

}

