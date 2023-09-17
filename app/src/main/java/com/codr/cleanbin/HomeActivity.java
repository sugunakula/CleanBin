package com.codr.cleanbin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    private Button rewardsButton;
    private EditText kgsInputEditText;
    private SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        Button typesOfWasteButton = findViewById(R.id.button);

        typesOfWasteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, WasteTypesInfoActivity.class);
                startActivity(intent);
            }
        });

        rewardsButton=findViewById(R.id.button2);
        rewardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, RewardsActivity.class);
                startActivity(intent);
            }
        });

        Button awarenessButton = findViewById(R.id.button3);

        awarenessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, NewsWebViewActivity.class);
                startActivity(intent);
            }
        });

        Button logoutButton = findViewById(R.id.button4);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the LoginActivity to log the user out
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);

                // Clear any previous activities from the back stack
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                // Start the LoginActivity
                startActivity(intent);

                // Finish the current HomeActivity
                finish();
            }
        });



    }
}