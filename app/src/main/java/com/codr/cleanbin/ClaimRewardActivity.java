package com.codr.cleanbin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ClaimRewardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim_reward);

        // Retrieve the message from the intent (you can use Intent extras)
        String message = getIntent().getStringExtra("rewardMessage");

        // Find the TextView to display the message
        TextView textViewMessage = findViewById(R.id.textViewMessage);

        // Set the message
        textViewMessage.setText(message);
    }
}