package com.example.shopping_hub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    CardView cloth,game,electro,beauty;
    private long pressedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cloth=findViewById(R.id.clothingCard);
        game=findViewById(R.id.gamescard);
        beauty=findViewById(R.id.beautycard);
        electro=findViewById(R.id.electrocard);
        fab = findViewById(R.id.fab);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextAppearance(this, R.style.topfont);
        String uname=getIntent().getStringExtra("username");
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home_btm);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemid = item.getItemId();
                if (itemid == R.id.home_btm) {
                    Toast.makeText(getApplicationContext(), "This Page is Running", Toast.LENGTH_SHORT).show();
                    return true;
                }
                if (itemid == R.id.user_btm) {
                    Intent i=new Intent(getApplicationContext(),userPage.class);
                    i.putExtra("username",uname);
                    startActivity(i);
                    overridePendingTransition(0,0);
                    return true;
                }
                if (itemid == R.id.payment_btm) {
                    Intent i=new Intent(getApplicationContext(),paymentPage.class);
                    i.putExtra("username",uname);
                    startActivity(i);
                    overridePendingTransition(0,0);
                    return true;
                }
                if (itemid == R.id.setting_btn) {
                    Intent i=new Intent(getApplicationContext(),settingPage.class);
                    i.putExtra("username",uname);
                    startActivity(i);
                    overridePendingTransition(0,0);
                    return true;
                }
                return false;
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),cartPage.class);
                i.putExtra("username",uname);
                startActivity(i);
                overridePendingTransition(0,0);
            }
        });
        cloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), clothing.class);
                i.putExtra("username",uname);
                startActivity(i);
                overridePendingTransition(0,0);
            }
        });
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), games.class);
                i.putExtra("username",uname);
                startActivity(i);
                overridePendingTransition(0,0);
            }
        });
        beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), beauty.class);
                i.putExtra("username",uname);
                startActivity(i);
                overridePendingTransition(0,0);
            }
        });
        electro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), electronics.class);
                i.putExtra("username",uname);
                startActivity(i);
                overridePendingTransition(0,0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id == R.id.not){
            Toast.makeText(getApplicationContext(),"No Notifications",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.updates){
            Toast.makeText(getApplicationContext(),"App is Up-To-Date",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.credit){
            Toast.makeText(getApplicationContext(),"@Created By Prince Solanki",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.support){
            Toast.makeText(getApplicationContext(),"No Comments",Toast.LENGTH_SHORT).show();
        }
        return true;
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