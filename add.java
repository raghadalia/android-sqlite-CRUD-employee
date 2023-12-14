package com.example.db;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add extends AppCompatActivity implements View.OnClickListener{
    private EditText ID;
   private EditText Name;
   private EditText Sex;
    private EditText Base_Sal;
    private EditText total;
    private EditText com ;
    private EditText Net;
    private Button insert;
    SQLiteDatabase db;
    //@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ID = findViewById(R.id.ID);
        Name = findViewById(R.id.Name);
        Sex = findViewById(R.id.Sex);
        Base_Sal = findViewById(R.id.Base_Sal);
        total=findViewById(R.id.TotalSal);
        com =findViewById(R.id.ComRate);
        Net=findViewById(R.id.NetSal);
        insert =findViewById(R.id.mod);
        insert.setOnClickListener(this);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Add Employee ");
                 bar.setDisplayHomeAsUpEnabled(true);
        db=openOrCreateDatabase("emp",MODE_PRIVATE,null);
        db.execSQL("create table if not exists emp(ID integer primary key, NAME char, sex char,Base_Salary float, Total_Sales float, Commission_Rate Float , Net_Salary  float) ");

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
        if(v==insert){
            if(ID.getText().toString().isEmpty()){
                Toast.makeText(this, "Please Enter The ID It's Required !!", Toast.LENGTH_LONG).show();


            }
            else{
            Cursor rs=db.rawQuery("select * from emp where ID= "+ID.getText(),null);

            if(rs.moveToNext()==true){
                insert.setEnabled(false);
                Toast.makeText(this,"This Id is Already Exist Pleas Re-enter another ID ",Toast.LENGTH_LONG).show();
                insert.setEnabled(true);
            }
            else{
                insert.setEnabled(true);
              //  SQLiteStatement statement = db.compileStatement("insert into  emp values(?,?,?,?,?,?,?)");
               // statement.bindAllArgsAsStrings(new String[]{ID.getText().toString(),Name.getText().toString(),Sex.getText().toString(),Base_Sal.getText().toString(),total.getText().toString(),com.getText().toString(),Net.getText().toString()});
               db.execSQL("insert into emp values(?,?,?,?,?,?,?)",new Object[]{ID.getText(),Name.getText(),Sex.getText(),Base_Sal.getText(),total.getText(),com.getText(),Net.getText()});
                Toast.makeText(this,"inserted",Toast.LENGTH_LONG).show();

            }

        }}
    }
}