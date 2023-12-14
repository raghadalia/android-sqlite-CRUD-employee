package com.example.db;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private BottomNavigationView bottom;
    private  MenuItem add;
    private  MenuItem delete;
    private  MenuItem search;
    private  MenuItem modify;
    private  MenuItem display;
    private SQLiteDatabase db=null;
    private void addd() {
        Intent a = new Intent();
        a.setClass(this, add.class);
        startActivity(a);
    }
    private void search() {
        Intent a = new Intent();
        a.setClass(this, search.class);
        startActivity(a);
    }
    private void modifyy() {
        Intent a = new Intent();
        a.setClass(this, modify.class);
        startActivity(a);
    }
    private void Delete() {
        Intent a = new Intent();
        a.setClass(this,Delete.class);
        startActivity(a);
    }
    private void display() {
        Intent a = new Intent();
        a.setClass(this,display.class);
        startActivity(a);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Log.i("home"," onCreateOptionsMenu is called");
        MenuInflater  flat = getMenuInflater();


        flat.inflate(R.menu.mm,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

         add = menu.findItem(R.id.addd);
        delete=menu.findItem(R.id.delete);
        display=menu.findItem(R.id.displayy);
        search=menu.findItem(R.id.search);
        modify=menu.findItem(R.id.modify);
        return super.onPrepareOptionsMenu(menu);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=openOrCreateDatabase("emp",MODE_PRIVATE,null);
        ActionBar bar = getSupportActionBar();
        bar.setTitle(" Employee Management System ");

        bar.setDisplayHomeAsUpEnabled(true);

        bottom = findViewById(R.id.bottom);

        bottom.setItemIconTintList(null);

        bottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                System.out.println("MenuItem selected/clicked-->" + item.getTitle());
                if (item.getItemId() == R.id.addd) {
                     addd();

                }
                if (item.getItemId() == R.id.delete){
                    Delete();
                   }
                if (item.getItemId() == R.id.modify) {
                    modifyy();
                }
                if (item.getItemId() == R.id.search){
                    search();
                }
                if (item.getItemId() == R.id.displayy){

                     display();

                }
                    return true;
            }
        });


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onClick(View v) {

    }
}