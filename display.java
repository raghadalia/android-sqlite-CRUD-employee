package com.example.db;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class display extends AppCompatActivity {
private TextView dis;
SQLiteDatabase db=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        dis= findViewById(R.id.data);

        ActionBar bar = getSupportActionBar();
        bar.setTitle("Display All Employees In The Company ");
        bar.setDisplayHomeAsUpEnabled(true);
        db=openOrCreateDatabase("emp",MODE_PRIVATE,null);
       // db.execSQL("create table if not exists emp(ID integer primary key, NAME char, sex char,Base_Salary float, Total_Sales float, Commission_Rate Float , Net_Salary  float) ");
        Cursor rs=db.rawQuery("select * from emp  ",null);
       while(rs.moveToNext()){
            dis.append("ID= "+rs.getInt(0)+"   Name="+rs.getString(1)+"    sex= "+rs.getString(2)+"    Base_Salary = "+rs.getFloat(3)+"    Total_sales = "+rs.getFloat(4)+"    Commission_Rate= "+rs.getFloat(5)+"     Net_Salary= "+rs.getFloat(6)
                    +"\n"+"------------------------------------------------------------------------------\n");

        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}