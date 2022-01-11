package com.example.chaiqinxuan;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

//import com.example.chaiqinxuan.calculate.ExcelUtils;
import com.example.chaiqinxuan.database.MyDatabaseHelper;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class updownActivity extends AppCompatActivity {

    private Button mBtnDownloadItem;
    private Button mBtnFirst;
    private Button mBtnUploadItem;

    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updown);

        mBtnFirst = findViewById(R.id.btn_first);
        mBtnDownloadItem = findViewById(R.id.btn_downloadItem);
        mBtnUploadItem = findViewById(R.id.btn_uploadItem);

//        SQLiteDatabase db = dbhelper.getWritableDatabase();
//        db.execSQL("delete from person where name=?", new Object[] { name });
//        db.close();

        if (Build.VERSION.SDK_INT >= 23) {
            int REQUEST_CODE_CONTACT = 101;
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};//验证是否许可权限
            for (String str : permissions) {
                if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) { //申请权限
                    this.requestPermissions(permissions, REQUEST_CODE_CONTACT); return; } } }

        dbHelper = new MyDatabaseHelper(this, "cqx", null);


        mBtnFirst.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase( );
                ContentValues values = new ContentValues( );

                values.put("CustomerName","zhangsan");
                values.put("Phonenumber","123");
                values.put("Sale","1");

                db.insert("history",null,values);

                values.clear();

                values.put("MedicineName","lisi");
                values.put("TotalNumber","123456");
                values.put("Value","123456");
                db.insert("item",null,values);

                values.clear();
                Log.i("MainActivity", "insert succeed！");
            }
        });


        mBtnDownloadItem.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
//                ExcelUtils.writeExcel(updownActivity.this, orders, "excel_joker");
            }




        });

        mBtnDownloadItem.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {

            }
        });


    }
}