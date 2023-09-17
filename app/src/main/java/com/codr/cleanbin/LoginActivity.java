package com.codr.cleanbin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText EdUsername,Edpassword;
    Button btn;
    TextView tv;
    private SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EdUsername=findViewById(R.id.editTextLogEmail);
        Edpassword=findViewById(R.id.editTextLogPassword);
        btn=findViewById(R.id.buttonLogin);
        tv=findViewById(R.id.textRegister);
        sessionManager = new SessionManager(getApplicationContext());

        if (sessionManager.isLoggedIn()) {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish(); // Finish the LoginActivity to prevent going back to it
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=EdUsername.getText().toString();
                String password=Edpassword.getText().toString();
                Database db=new Database(getApplicationContext());
                if(username.equals("")||password.equals("")){
                    Toast.makeText(LoginActivity.this,"Please fill all the fields",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(db.login(username, password) == 1){
                        Toast.makeText(getApplicationContext(),"Login successful",Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences=getSharedPreferences("shared prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("username",username);
                        editor.apply();
                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    }else {
                        Toast.makeText(getApplicationContext(),"Inavalid Username and Password",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }

        });
    }
}