 package com.example.chaiqinxuan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.chaiqinxuan.database.MyDatabaseHelper;

 public class RepassActivity extends AppCompatActivity {
     private EditText mETnum;
     private EditText mETnumber;
     private EditText mETinput;
     private MyDatabaseHelper dbHelper;
     private Button mBtnadd;

     private TextView mTVUnitprice;
     private TextView mTVTotalprice;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_repass);
         mETinput = findViewById(R.id.et_input);
         mETnum = findViewById(R.id.et_num);

         mTVUnitprice = findViewById(R.id.tv_unitprice);
         mTVTotalprice = findViewById(R.id.tv_totalprice);

         dbHelper = new MyDatabaseHelper(this, "cqx", null);

         mBtnadd.setOnClickListener(new View.OnClickListener( ) {
             @Override
             public void onClick(View v) {
                 String input = mETinput.getText( ).toString( );
                 String[] splitInput = input.split(";");
                 int num = Integer.parseInt(mETnum.getText( ).toString( ));

                 int number = Integer.parseInt(mETnumber.getText( ).toString( ));

                 SQLiteDatabase db = dbHelper.getWritableDatabase( );
                 ContentValues values = new ContentValues( );

                 for (int i = 0; i < num; i++) {
                     String[] split = splitInput[i].split(",");
                     String name = split[0];
                     int dosage = Integer.parseInt(split[1]);


                     Cursor c = db.query("item", null, "MedicineName=?", new String[]{split[1]}, null, null, null);
                     if (c.moveToFirst( )) {
                         float value = c.getFloat(c.getColumnIndex("Value"));
                         String unit = String.valueOf(value);
                         mTVUnitprice.setText(unit);

                         float total = dosage * value * number;
                         String Total = String.valueOf(total);
                         mTVTotalprice.setText(Total);

                     }
                 }

             }

         });
     }
 }