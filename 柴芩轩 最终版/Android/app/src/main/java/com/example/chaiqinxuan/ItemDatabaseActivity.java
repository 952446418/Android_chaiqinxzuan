package com.example.chaiqinxuan;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.chaiqinxuan.Adapter.Adapter;
import com.example.chaiqinxuan.Adapter.name;
import com.example.chaiqinxuan.database.MyDatabaseHelper;

import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDatabaseActivity extends AppCompatActivity {

    //声明控件
    private RecyclerView mRVitem;

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
        setContentView(R.layout.activity_itemdatabase);

        //找到控件
        mRVitem = findViewById(R.id.rv_item);

        //从数据库里面把数据取出来
        SQLiteDatabase db = dbHelper1.getWritableDatabase();
        personList1=new ArrayList<name>();
        personList2=new ArrayList<name>();
        personList3=new ArrayList<name>();
        personList4=new ArrayList<name>();
        personList5=new ArrayList<name>();

        Cursor cursor = db.query("item", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String medicineName = cursor.getString(1);
            String totalNumber = cursor.getString(2);
            String value = cursor.getString(3);
            String min = cursor.getString(4);

            name p1=new name(id);
            name p2=new name(medicineName);
            name p3=new name(totalNumber);
            name p4=new name(value);
            name p5=new name(min);

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
        mRVitem.setLayoutManager(new LinearLayoutManager(ItemDatabaseActivity.this));
        //设置adapter
        mRVitem.setAdapter(new Adapter(ItemDatabaseActivity.this, array1, array2, array3, array4, array5, new Adapter.OnItemClickListener(){
            @Override
            public void onClick(int pos) {
            }
        }));

    }

}