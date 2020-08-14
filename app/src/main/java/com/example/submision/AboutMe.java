package com.example.submision;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class AboutMe extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_about_me);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setActionBar(String nama){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(nama);
        }
    }
    public boolean onOptionsItemSelected(MenuItem menuItem){
        if (menuItem.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }
    public void onBackPressed(){
        super.onBackPressed();
    }
}
