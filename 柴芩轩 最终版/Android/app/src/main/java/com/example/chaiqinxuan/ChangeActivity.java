//添加删除页面
package com.example.chaiqinxuan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chaiqinxuan.database.MyDatabaseHelper;

public class ChangeActivity extends AppCompatActivity {


    private EditText mETMedicinename;
    private TextView mETtotalnumber;
    private EditText mETValue;
    private EditText mETMin;
    private Button mBtnAddmedicine;

    private EditText mETDelmedicine;
    private EditText mETDelcustomer;
    private Button mBtnDelmedicine;
    private Button mBtnDelcustomer;

    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        mETMedicinename = findViewById(R.id.et_medicinename);
        mETtotalnumber = findViewById(R.id.et_totalnumber);
        mETValue = findViewById(R.id.et_value);
        mETMin = findViewById(R.id.et_min);
        mBtnAddmedicine = findViewById(R.id.btn_addmedicine);

        dbHelper = new MyDatabaseHelper(this, "cqx", null);

        mBtnAddmedicine.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String newmedicinename = mETMedicinename.getText( ).toString( );
                String Snewtotalnumber = mETtotalnumber.getText( ).toString( );
                String Snewvalue = mETValue.getText( ).toString( );
                String Snewmin = mETMin.getText( ).toString( );

                if (newmedicinename == null || Snewtotalnumber == null || Snewvalue == null || Snewmin == null) {
                    Toast.makeText(ChangeActivity.this, "请填写完整信息！", Toast.LENGTH_SHORT).show( );
                }else {
                    SQLiteDatabase db = dbHelper.getWritableDatabase( );
                    Cursor c = db.query("item", null, "MedicineName=?", new String[]{newmedicinename}, null, null, null);
                    if (c != null && c.getCount() >= 1) {
                        Toast.makeText(ChangeActivity.this, "该饮片数据已经存在！", Toast.LENGTH_SHORT).show( );
                    }else {
                        float newtotalnumber = Float.parseFloat(Snewtotalnumber);
                        float newvalue = Float.parseFloat(Snewvalue);
                        float newmin = Float.parseFloat(Snewmin);

                        ContentValues values1 = new ContentValues( );

                        values1.put("MedicineName", newmedicinename);
                        values1.put("TotalNumber", newtotalnumber);
                        values1.put("Value", newvalue);
                        values1.put("Min", newmin);

                        db.insert("item", null, values1);

                        Toast.makeText(ChangeActivity.this, "数据添加成功", Toast.LENGTH_SHORT).show( );
                    }
                }
            }
        });

        mETDelmedicine = findViewById(R.id.et_delmedicine);
        mETDelcustomer = findViewById(R.id.et_delcustomer);
        mBtnDelmedicine = findViewById(R.id.btn_delmedicine);
        mBtnDelcustomer = findViewById(R.id.btn_delcustomer);

        dbHelper = new MyDatabaseHelper(this, "cqx", null);

        mBtnDelmedicine.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String delmedicine = mETDelmedicine.getText( ).toString( );
                SQLiteDatabase db = dbHelper.getWritableDatabase( );

                Cursor c = db.query("item", null, "MedicineName=?", new String[]{delmedicine}, null, null, null);
                if (c == null) {
                    Toast.makeText(ChangeActivity.this, "饮片名输入错误，未查询到该饮片信息，请重新输入！", Toast.LENGTH_SHORT).show( );
                }else{
                new AlertDialog.Builder(ChangeActivity.this)
                        .setTitle("提示")
                        .setMessage("是否确定删除该饮片数据？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener( ) {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                setResult(RESULT_OK);
                                db.execSQL("delete from item where MedicineName=?", new Object[]{delmedicine});
                                db.close( );
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener( ) {
                            public void onClick(DialogInterface dialog, int whichButton) {
                            }
                        })
                        .show( );
                }
            }
        });

        mBtnDelcustomer.setOnClickListener(new View.OnClickListener( ) {
                @Override
                public void onClick(View v) {
                    String delcustomer = mETDelcustomer.getText( ).toString( );

                    SQLiteDatabase db = dbHelper.getWritableDatabase( );

                    Cursor c = db.query("history", null, "CustomerName=?", new String[]{delcustomer}, null, null, null);
                    if (c == null) {
                        Toast.makeText(ChangeActivity.this, "用户名输入错误，未查询到该用户信息，请重新输入！", Toast.LENGTH_SHORT).show( );
                    }else{
                        new AlertDialog.Builder(ChangeActivity.this)
                                .setTitle("提示")
                                .setMessage("是否确定删除该用户数据？")
                                .setPositiveButton("确定", new DialogInterface.OnClickListener( ) {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        setResult(RESULT_OK);
                                        db.execSQL("delete from history where CustomerName=?", new Object[] { delcustomer });
                                        db.close();
                                    }
                                })
                                .setNegativeButton("取消", new DialogInterface.OnClickListener( ) {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                    }
                                })
                                .show( );
                    }
                }
        });
    }
}