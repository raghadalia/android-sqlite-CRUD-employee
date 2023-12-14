package com.example.db;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class modify extends AppCompatActivity implements View.OnClickListener {
    private EditText Idd;
    private Button Modify;
    SQLiteDatabase db;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        Idd= findViewById(R.id.ID2);
        Modify =findViewById(R.id.Modify);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Modify Employee Information ");
        bar.setDisplayHomeAsUpEnabled(true);
        db=openOrCreateDatabase("emp",MODE_PRIVATE,null);
        Modify.setOnClickListener(this);    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onClick(View v) {
        if(v==Modify){
            if(Idd.getText().toString().isEmpty()){
                Toast.makeText(this, "Please Enter The ID It's Required !!", Toast.LENGTH_LONG).show();


            }
            else{
            Cursor rs=db.rawQuery("select * from emp where id= "+Idd.getText(),null);
            if(rs.moveToNext()==true){
                Toast.makeText(this, "Found it  ", Toast.LENGTH_LONG).show();
                Intent a = new Intent();
                a.setClass(this, Modify2.class);
                String s=Idd.getText()+"";
                a.putExtra("id",s);
                startActivity(a);
            }
            else{
                Toast.makeText(this, "Not Found it ", Toast.LENGTH_LONG).show();

            }

        }}
    }
}