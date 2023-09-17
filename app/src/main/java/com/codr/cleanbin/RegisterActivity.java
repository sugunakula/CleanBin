package com.codr.cleanbin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {


    EditText eUsername,eEmail,eAddress,ePassword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eUsername=findViewById(R.id.editTextName);
        eEmail=findViewById(R.id.editTextTextEmail);
        eAddress=findViewById(R.id.editTextTextAdress);
        ePassword=findViewById(R.id.editTextTextPassword);
        btn=findViewById(R.id.buttonSignup);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String username=eUsername.getText().toString();
                String email=eEmail.getText().toString();
                String address=eAddress.getText().toString();
                String password=ePassword.getText().toString();
                Database db=new Database(getApplicationContext());
                if(username.isEmpty()||email.isEmpty()||address.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    db.register(username, email, address, password);
                    Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}