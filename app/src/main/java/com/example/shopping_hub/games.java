package com.example.shopping_hub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class games extends AppCompatActivity {
    FloatingActionButton fab;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        Window window=this.getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.blue));
        username=getIntent().getStringExtra("username");
        fab = findViewById(R.id.fab);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextAppearance(this, R.style.topfont);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home_btm);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemid = item.getItemId();
                if (itemid == R.id.home_btm) {
                    Intent i=new Intent(getApplicationContext(), MainActivity.class);
                    i.putExtra("username",username);
                    startActivity(i);
                    overridePendingTransition(0,0);
                    return true;
                }
                if (itemid == R.id.user_btm) {
                    Intent i=new Intent(getApplicationContext(), userPage.class);
                    i.putExtra("username",username);
                    startActivity(i);
                    overridePendingTransition(0,0);
                    return true;
                }
                if (itemid == R.id.payment_btm) {
                    Intent i=new Intent(getApplicationContext(), paymentPage.class);
                    i.putExtra("username",username);
                    startActivity(i);
                    overridePendingTransition(0,0);
                    return true;
                }
                if (itemid == R.id.setting_btn) {
                    Intent i=new Intent(getApplicationContext(), settingPage.class);
                    i.putExtra("username",username);
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
                Intent i=new Intent(getApplicationContext(), cartPage.class);
                i.putExtra("username",username);
                startActivity(i);
                overridePendingTransition(0,0);
                return;
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
            Intent i=new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://youtube.com/shorts/SXHMnicI6Pg?si=ltLwn9G0UGnxHjvO"));
            startActivity(i);
        }
        if(id==R.id.credit){
            Toast.makeText(getApplicationContext(),"@Created By Prince Solanki",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.support){
            Intent i=new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:8780705662"));
            startActivity(i);
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent i=new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("username",username);
        startActivity(i);
        overridePendingTransition(0,0);
    }
}