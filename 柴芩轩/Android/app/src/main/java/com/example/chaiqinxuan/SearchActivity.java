//更新数据页面
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
import android.widget.Toast;

import com.example.chaiqinxuan.database.MyDatabaseHelper;

public class SearchActivity extends AppCompatActivity {

    private Button mBtnSearchmedicine;
    private EditText mETMedicinename;
    private TextView mTVTotalnumber;
    private EditText mETValue;
    private EditText mETAddnumber;
    private EditText mETMin;
    private Button mBtnChangemedicine;

    private Button mBtnSearchcustomer;
    private EditText mETCustomername;
    private EditText mETPhone;
    private EditText mETOther;
    private Button mBtnChangecustomer;

    private MyDatabaseHelper dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mBtnSearchmedicine = findViewById(R.id.btn_searchmedicine);
        mETMedicinename = findViewById(R.id.et_medicinename);
        mTVTotalnumber = findViewById(R.id.tv_Totalnumber);
        mETValue = findViewById(R.id.et_value);
        mETAddnumber = findViewById(R.id.et_addnumber);
        mETMin = findViewById(R.id.et_min);
        mBtnChangemedicine = findViewById(R.id.btn_changemedicine);

        mBtnSearchcustomer = findViewById(R.id.btn_searchcustomer);
        mETCustomername = findViewById(R.id.et_customername);
        mETPhone = findViewById(R.id.et_phone);
        mETOther = findViewById(R.id.et_Other);
        mBtnChangecustomer = findViewById(R.id.btn_changecustomer);

        dbHelper = new MyDatabaseHelper(this, "cqx", null);

        mBtnSearchmedicine.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String medicinename = mETMedicinename.getText( ).toString( );
                if (medicinename == null) {
                    Toast.makeText(SearchActivity.this, "请输入饮片名称！", Toast.LENGTH_SHORT).show( );
                } else {
                    SQLiteDatabase db = dbHelper.getWritableDatabase( );
                    Cursor c = db.query("item", null, "MedicineName=?", new String[]{medicinename}, null, null, null);
                    if (c == null) {
                        Toast.makeText(SearchActivity.this, "该饮片不存在，请重新输入！", Toast.LENGTH_SHORT).show( );
                    } else {
                        if (c.moveToFirst( )) {
                            float num = c.getFloat(c.getColumnIndex("TotalNumber"));
                            String unit1 = String.valueOf(num);
                            mTVTotalnumber.setText(unit1);

                            float value = c.getFloat(c.getColumnIndex("Value"));
                            String unit2 = String.valueOf(value);
                            mETValue.setText(unit2);

                            float min = c.getFloat(c.getColumnIndex("Min"));
                            String unit3 = String.valueOf(min);
                            mETMin.setText(unit3);
                        }
                    }
                }
            }
        });

        mBtnChangemedicine.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String medicinename = mETMedicinename.getText( ).toString( );
                String Svalue = mETValue.getText( ).toString( );
                String Sadd = mETAddnumber.getText( ).toString( );
                String Smin = mETMin.getText( ).toString( );

                SQLiteDatabase db = dbHelper.getWritableDatabase( );
                ContentValues values1 = new ContentValues( );

                if (medicinename == null) {
                    Toast.makeText(SearchActivity.this, "请先输入饮片名称后再点击此按钮！", Toast.LENGTH_SHORT).show( );
                } else {
                    Cursor c = db.query("item", null, "MedicineName=?", new String[]{medicinename}, null, null, null);
                    if (c == null) {
                        Toast.makeText(SearchActivity.this, "该饮片不存在，请重新输入！", Toast.LENGTH_SHORT).show( );
                    } else {
                        if (Sadd.equals("")) {}
                        else {
                            float add = Float.parseFloat(Sadd);
                            if (c.moveToFirst( )) {
                                float total = c.getFloat(c.getColumnIndex("TotalNumber"));
                                float newtotal = total + add;
                                values1.put("TotalNumber", newtotal);
                                String[] args1 = {medicinename};
                                db.update("item", values1, "MedicineName=?", args1);
                                String unit1 = String.valueOf(newtotal);
                                mTVTotalnumber.setText(unit1);

                                Toast.makeText(SearchActivity.this, "数据更新成功", Toast.LENGTH_SHORT).show( );
                            }
                        }

                        if (Svalue != null) {
                            float value = Float.parseFloat(Svalue);
                            values1.put("Value", value);
                            String[] args2 = {medicinename};
                            db.update("item", values1, "MedicineName=?", args2);
                            String unit2 = String.valueOf(value);
                            mETValue.setText(unit2);
                        }

                        if (Smin != null) {
                            float min = Float.parseFloat(Smin);
                            values1.put("Min", min);
                            String[] args3 = {medicinename};
                            db.update("item", values1, "MedicineName=?", args3);
                            String unit3 = String.valueOf(min);
                            mETMin.setText(unit3);
                        }
                    }
                }
            }
        });

        mBtnSearchcustomer.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String customerename = mETCustomername.getText( ).toString( );
                if (customerename == null) {
                    Toast.makeText(SearchActivity.this, "请先输入用户名称后再点击此按钮！", Toast.LENGTH_SHORT).show( );
                } else {
                    SQLiteDatabase db = dbHelper.getWritableDatabase( );
                    Cursor c = db.query("history", null, "CustomerName=?", new String[]{customerename}, null, null, null);
                    if (c == null) {
                        Toast.makeText(SearchActivity.this, "该用户不存在，请重新输入！", Toast.LENGTH_SHORT).show( );
                    } else {
                        if (c.moveToFirst( )) {
                            String num = c.getString(c.getColumnIndex("Phonenumber"));
                            mETPhone.setText(num);

                            String other = c.getString(c.getColumnIndex("Other"));
                            mETOther.setText(other);
                        }
                    }
                }
            }
        });

        mBtnChangecustomer.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String customername = mETCustomername.getText( ).toString( );
                String phone = mETPhone.getText( ).toString( );
                String other = mETOther.getText( ).toString( );


                SQLiteDatabase db = dbHelper.getWritableDatabase( );
                ContentValues values1 = new ContentValues( );

                String[] args = {customername};

                values1.put("Phonenumber", phone);
                db.update("history", values1, "CustomerName=?", args);
                String unit2 = String.valueOf(phone);
                mETPhone.setText(unit2);

                values1.put("Other", other);
                db.update("history", values1, "CustomerName=?", args);
                String unit1 = String.valueOf(other);
                mTVTotalnumber.setText(unit1);

                Toast.makeText(SearchActivity.this, "数据更新成功", Toast.LENGTH_SHORT).show( );
            }
        });




    }
}