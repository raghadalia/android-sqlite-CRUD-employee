package com.example.db;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class search extends AppCompatActivity implements View.OnClickListener {
private Button searchh;
private EditText id;
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        id= findViewById(R.id.ID2);
        searchh =findViewById(R.id.search);
        searchh.setOnClickListener(this);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Search About Employee ");
        bar.setDisplayHomeAsUpEnabled(true);
        db=openOrCreateDatabase("emp",MODE_PRIVATE,null);

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onClick(View v) {
if(v==searchh){
    if(id.getText().toString().isEmpty()){
        Toast.makeText(this, "Please Enter The ID It's Required !!", Toast.LENGTH_LONG).show();


    }
    else{
    Cursor rs=db.rawQuery("select * from emp where id= "+id.getText(),null);
    if(rs.moveToNext()==true){
        TextView c=findViewById(R.id.data);
        c.setText("It's Found \n"+"ID= "+rs.getInt(0)+"   Name="+rs.getString(1)+"    sex= "+rs.getString(2)+"    Base_Salary = "+rs.getFloat(3)+"    Total_sales = "+rs.getFloat(4)+"    Commission_Rate= "+rs.getFloat(5)+"     Net_Salary= "+rs.getFloat(6)
                +"\n");
    }
    else{
        Toast.makeText(this, "Not Found it ", Toast.LENGTH_LONG).show();

    }
}}
    }
}