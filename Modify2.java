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

public class Modify2 extends AppCompatActivity implements View.OnClickListener {
    private EditText Name;
    private EditText Sex;
    private EditText Base_Sal;
    private EditText total;
    private EditText com ;
    private EditText Net;
    private EditText ID;
    private Button mod;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify2);
        Name = findViewById(R.id.Name);
        Sex = findViewById(R.id.Sex);
        Base_Sal = findViewById(R.id.Base_Sal);
        total=findViewById(R.id.TotalSal);
        com =findViewById(R.id.ComRate);
        Net=findViewById(R.id.NetSal);
        mod =findViewById(R.id.mod);
        ID =findViewById(R.id.ID);
        mod.setOnClickListener(this);

        ActionBar bar = getSupportActionBar();
        bar.setTitle("Modify Employee Information  ");
        bar.setDisplayHomeAsUpEnabled(true);
        db=openOrCreateDatabase("emp",MODE_PRIVATE,null);
        Intent f=getIntent();
        String x=f.getStringExtra("id");
        Cursor rs = db.rawQuery("select * from emp where ID = "+x,null);
        if (rs.moveToNext()) {
            ID.setText(rs.getString(0));
            Name.setText(rs.getString(1));
            Sex.setText(rs.getString(2));
            Base_Sal.setText(rs.getString(3));
            total.setText(rs.getString(4));
            com.setText(rs.getString(5));
            Net.setText(rs.getString(6));
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onClick(View v) {
        if(v==mod){
            Intent f=getIntent();
            String x=f.getStringExtra("id");
            db.execSQL("update  emp set NAME = ?,sex=?,Base_Salary=?,Total_Sales=?,Commission_Rate=?,Net_Salary=? where ID =  "+x,new Object[]{Name.getText(),Sex.getText(),Base_Sal.getText(),total.getText(),com.getText(),Net.getText()});
            Toast.makeText(this,"Modified the employee with number = "+x,Toast.LENGTH_LONG).show();

        }
    }
}