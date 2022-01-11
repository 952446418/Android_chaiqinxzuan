package com.example.chaiqinxuan;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.chaiqinxuan.Adapter.Adapter;
import com.example.chaiqinxuan.Adapter.name;
import com.example.chaiqinxuan.database.MyDatabaseHelper;

import android.content.Intent;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ItemDatabaseActivity extends AppCompatActivity {
//    List<name> personList;
//    private MyDatabaseHelper dbHelper;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_itemdatabase);

//        personList=new ArrayList<name>();
//
//        //调用MyDatabaseHelper （cqx是创建的数据库的名称）
//        dbHelper = new MyDatabaseHelper(this,"cqx",null);
//
//        //从数据库里面把数据取出来
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//        Cursor cursor = db.query("item", null, null, null, null, null, null);
//        while (cursor.moveToNext()) {
//            String id = cursor.getString(cursor.getColumnIndex("id"));
//            String name = cursor.getString(cursor.getColumnIndex("MedicineName"));
//            String total = cursor.getString(cursor.getColumnIndex("TotalNumber"));
//            String value = cursor.getString(cursor.getColumnIndex("Value"));
//            String min = cursor.getString(cursor.getColumnIndex("Min"));
//            name p=new name(id, name, total, value, min);
//
//            personList.add(p);
//        }
//        LinearLayout ll=(LinearLayout) findViewById(R.id.ll);
//        //把数据显示到屏幕
//        for(name p:personList)
//        {
//            //1.集合中每有一条数据，就new一个TextView
//            TextView tv=new TextView(this);
//            //2.把人物的信息设置为文本的内容
//            tv.setText(p.toString());
//            tv.setTextSize(25);
//            //3.把TextView设置成线性布局的子节点
//            ll.addView(tv);
//        }


    //声明控件
    private RecyclerView mRVitem;

    private ArrayList <HashMap< String, String >> list = new ArrayList <HashMap< String, String >> ();
    List<name> personList1;
    List<name> personList2;
    List<name> personList3;
    List<name> personList4;
    List<name> personList5;

//    private MyDatabaseHelper dbHelper1 = new MyDatabaseHelper(this,"cqx0",null);
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

//        Log.d("ItemDatabaseActivity", "==>" + list1);

        String[] array1 = list1.split(", ");
        String[] array2 = list2.split(", ");
        String[] array3 = list3.split(", ");
        String[] array4 = list4.split(", ");
        String[] array5 = list5.split(", ");

        //利用adapter实现item
        mRVitem.setLayoutManager(new LinearLayoutManager(ItemDatabaseActivity.this));
        //设置adapter
        //mRV_medicine.setAdapter(new Adapter(SlideActivity.this, pos -> Toast.makeText(SlideActivity.this,"click..." + pos,Toast.LENGTH_SHORT).show()));
        mRVitem.setAdapter(new Adapter(ItemDatabaseActivity.this, array1, array2, array3, array4, array5, new Adapter.OnItemClickListener(){
            @Override
            public void onClick(int pos) {
//                Toast.makeText(SearchActivity .this,"click..." + pos,Toast.LENGTH_SHORT).show();
//                String medicinename = array1[pos];
////                Log.d("SearchActivity", "药名" + medicinename);
            }
        }));

    }

}