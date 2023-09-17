package com.codr.cleanbin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RewardsActivity extends AppCompatActivity {

    private EditText kgsInputEditText;
    private Button checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);

        kgsInputEditText = findViewById(R.id.editTextKgsInput);
        checkoutButton = findViewById(R.id.buttonCheckout);

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve the user's input for kgs of waste dumped
                String kgsDumpedStr = kgsInputEditText.getText().toString();

                if (!kgsDumpedStr.isEmpty()) {
                    // Construct the message
                    String message = "Thank you for your contribution to waste management. You have dumped " +
                            "a total of " + kgsDumpedStr + " kg of waste. To claim your reward, " +
                            "please send a photo of the waste you dumped along with your location details to " +
                            "our email address: rewards@cleanbin.com. Once we verify your contribution, we will " +
                            "send you the reward to your UPI ID: yourupiid@upi.com.";

                    // Create an Intent to start the ClaimRewardActivity
                    Intent intent = new Intent(RewardsActivity.this, ClaimRewardActivity.class);

                    // Pass the message as an extra to the ClaimRewardActivity
                    intent.putExtra("rewardMessage", message);

                    // Start the ClaimRewardActivity
                    startActivity(intent);
                }
            }
        });
    }
}