package com.example.submision;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class listdata extends AppCompatActivity {
    TextView lisnamee, lisdataa;
    ImageView listImgg;
    public static final String EXTRA_TITLE = "extra_title";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata);

        lisnamee = findViewById(R.id.lisname);
        lisdataa = findViewById(R.id.lisdata);
        listImgg = findViewById(R.id.listImg);


        Intent intent = getIntent();
        String title = intent.getStringExtra(EXTRA_TITLE);
        setActionBar(title);

        String receivedNama = intent.getStringExtra("namaku");
        String receivedData = intent.getStringExtra("data");
        int receivedImage = intent.getIntExtra("poto", 0);

        lisnamee.setText(receivedNama);
        lisdataa.setText(receivedData);
        listImgg.setImageResource(receivedImage);
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
