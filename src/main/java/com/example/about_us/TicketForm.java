package com.example.about_us;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.Toolbar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.PopupMenu;

import com.example.about_us.R;

public class TicketForm extends AppCompatActivity {
    EditText username;
    EditText quantity;
    Button submitButton;
    RadioButton radioButton;
    RadioGroup radioGroup;
    ImageView imageView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_form);

        username = findViewById(R.id.username);
        quantity = findViewById(R.id.quantity);
        submitButton = findViewById(R.id.submitButton);
        radioGroup = findViewById(R.id.radioGroup);
        btn = findViewById(R.id.backButton);

        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String usernameInput = username.getText().toString().trim();
                String quantityInput = quantity.getText().toString().trim();
                if (isValidUsername(usernameInput) && isValidQuantity(quantityInput) && radioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(TicketForm.this, "Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TicketForm.this, "Please enter valid username and quantity", Toast.LENGTH_SHORT).show();
                    int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                }

            }
        });

        imageView = findViewById(R.id.imageView);
        //ntar imageCoba diganti ama nama variabel image page baru

        Intent intent = getIntent();
        int imageResId = intent.getIntExtra("image", 0);
        imageView.setImageResource(imageResId);

        btn.setOnClickListener(view -> {
            Intent intent2 = new Intent(this, TicketViewActivity.class);
            startActivity(intent2);
        });
    }
    private boolean isValidUsername(String username) {
        return !username.isEmpty() && username.length() >= 6;
    }

    private boolean isValidQuantity(String quantity) {
        return !quantity.isEmpty() && isNumeric(quantity);
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }


}