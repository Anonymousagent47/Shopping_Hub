package com.example.shopping_hub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class signupPage extends AppCompatActivity {
    private long pressedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        EditText name=findViewById(R.id.name);
        EditText email=findViewById(R.id.mail);
        EditText pass=findViewById(R.id.pass);
        EditText cpass=findViewById(R.id.conpass);
        Button signup=findViewById(R.id.signupbtn);
        TextView login=findViewById(R.id.logintxt);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("")){
                    name.setError("Enter Name");
                    return;
                }
                if(email.getText().toString().equals("")){
                    email.setError("Enter Email");
                    return;
                }
                if(!email.getText().toString().endsWith("@gmail.com"))
                {
                    email.setError("Enter valid Mail");
                    return;
                }

                if(pass.getText().toString().equals("")){
                    pass.setError("Enter Password");
                    return;
                }
                if(pass.length()<6){
                    pass.setError("Password Must be Greater Than 6 Character");
                    return;
                }
                if(cpass.getText().toString().equals("")){
                    cpass.setError("Re-Enter Password");
                    return;
                }
                if(cpass.getText().toString().equals(pass.getText().toString()) && pass.length()>=6) {
                    Toast.makeText(getApplicationContext(),"User Created",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),loginPage.class);
                    intent.putExtra("username",name.getText().toString());
                    intent.putExtra("password",pass.getText().toString());
                    startActivity(intent);
                }
                if(!(cpass.getText().toString().equals(pass.getText().toString()))){
                    cpass.setError("Password Doesn't Match");
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), loginPage.class));
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