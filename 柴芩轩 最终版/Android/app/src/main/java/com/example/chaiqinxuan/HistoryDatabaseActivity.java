package com.example.chaiqinxuan;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chaiqinxuan.Adapter.Adapter;
import com.example.chaiqinxuan.Adapter.name;
import com.example.chaiqinxuan.database.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HistoryDatabaseActivity extends AppCompatActivity {

//声明控件
private RecyclerView mRVitem2;

    private ArrayList <HashMap< String, String >> list = new ArrayList <HashMap< String, String >> ();
    List<name> personList1;
    List<name> personList2;
    List<name> personList3;
    List<name> personList4;
    List<name> personList5;

    private MyDatabaseHelper dbHelper1 = new MyDatabaseHelper(this,"cqx",null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historydatabase);

        //找到控件
        mRVitem2 = findViewById(R.id.rv_item2);

        //从数据库里面把数据取出来
        SQLiteDatabase db = dbHelper1.getWritableDatabase();
        personList1=new ArrayList<name>();
        personList2=new ArrayList<name>();
        personList3=new ArrayList<name>();
        personList4=new ArrayList<name>();
        personList5=new ArrayList<name>();

        Cursor cursor = db.query("history", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String customerName = cursor.getString(1);
            String phonenumber = cursor.getString(2);
            String other = cursor.getString(3);
            String sale = cursor.getString(4);

            name p1=new name(id);
            name p2=new name(customerName);
            name p3=new name(phonenumber);
            name p4=new name(other);
            name p5=new name(sale);

            personList1.add(p1);
            personList2.add(p2);
            personList3.add(p3);
            personList4.add(p4);
            personList5.add(p5);

        }
        String list1 = personList1.toString().substring(1,personList1.toString().length()-1);
        String list2 = personList2.toString().substring(1,personList2.toString().length()-1);
        String list3 = personList3.toString().substring(1,personList3.toString().length()-1);
        String list4 = personList4.toString().substring(1,personList4.toString().length()-1);
        String list5 = personList5.toString().substring(1,personList5.toString().length()-1);

        String[] array1 = list1.split(", ");
        String[] array2 = list2.split(", ");
        String[] array3 = list3.split(", ");
        String[] array4 = list4.split(", ");
        String[] array5 = list5.split(", ");

        //利用adapter实现item
        mRVitem2.setLayoutManager(new LinearLayoutManager(HistoryDatabaseActivity.this));
        //设置adapter
        //mRV_medicine.setAdapter(new Adapter(SlideActivity.this, pos -> Toast.makeText(SlideActivity.this,"click..." + pos,Toast.LENGTH_SHORT).show()));
        mRVitem2.setAdapter(new Adapter(HistoryDatabaseActivity.this, array1, array2, array3, array4, array5, new Adapter.OnItemClickListener(){
            @Override
            public void onClick(int pos) {
            }
        }));

    }
}