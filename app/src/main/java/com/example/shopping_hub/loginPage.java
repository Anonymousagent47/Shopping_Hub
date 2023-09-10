package com.example.shopping_hub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class loginPage extends AppCompatActivity {
    private long pressedTime;
    int counter=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        EditText uname=findViewById(R.id.usernameLog);
        EditText passwd=findViewById(R.id.passLog);
        Button logbtn=findViewById(R.id.loginbtn);
        TextView signup=findViewById(R.id.signuptxt);
        String username=getIntent().getStringExtra("username");
        String password=getIntent().getStringExtra("password");

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uname.getText().toString().equals("")){
                    uname.setError("Enter Username");
                    return;
                }
                if(passwd.getText().toString().equals("")){
                    passwd.setError("Enter Password");
                    return;
                }
                if(counter>0) {
                    if (uname.getText().toString().equals(username) && passwd.getText().toString().equals(password)) {
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        i.putExtra("username",uname.getText().toString());
                        startActivity(i);
                    }else {
                        Toast.makeText(loginPage.this, "You Have "+counter+" Login Attempts Left", Toast.LENGTH_SHORT).show();
                        counter--;
                    }
                }else if(counter==0){
                    Toast.makeText(loginPage.this, "Login Limit Exceed", Toast.LENGTH_SHORT).show();
                    Toast.makeText(signup.getContext(), "Register Again", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), signupPage.class));
                }
                if(!(uname.getText().toString().equals(username))){
                    uname.setError("Enter Correct Username");
                }
                if (!(passwd.getText().toString().equals(password))) {
                    passwd.setError("Enter Correct Password");
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), signupPage.class));
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }
}