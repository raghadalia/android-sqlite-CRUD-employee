package com.example.db;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity implements View.OnClickListener {
    private EditText Idd;
    private Button Delete;
    SQLiteDatabase db;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
       Idd= findViewById(R.id.IDD);
      Delete =findViewById(R.id.DELETE);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Delete An Employee ");
        bar.setDisplayHomeAsUpEnabled(true);
        db=openOrCreateDatabase("emp",MODE_PRIVATE,null);
      Delete.setOnClickListener(this);    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onClick(View v) {
        if(v==Delete){
            if(Idd.getText().toString().isEmpty()){
                Toast.makeText(this, "Please Enter The ID It's Required !!", Toast.LENGTH_LONG).show();


            }
            else{
            Cursor rs=db.rawQuery("select * from emp where Id = "+Idd.getText(),null);
            if(rs.moveToNext()==true) {
                Toast.makeText(this, "Found it ", Toast.LENGTH_LONG).show();
                db.execSQL("delete from emp where ID = ?", new Object[]{Idd.getText()});

                Toast.makeText(this, "Deleted", Toast.LENGTH_LONG).show();
            }

          else{

                Toast.makeText(this, "Not Found an Employee with This ID ="+Idd.getText(), Toast.LENGTH_LONG).show();
            }}
        }
    }
}