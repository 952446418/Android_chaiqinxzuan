package com.example.chaiqinxuan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.chaiqinxuan.util.SlideMenu;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.chaiqinxuan.database.MyDatabaseHelper;

import pl.com.salsoft.sqlitestudioremote.SQLiteStudioService;

//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
public class MainActivity extends AppCompatActivity{
    //声明控件
    private Button mBtnCheck;
    private Button mBtnAdd;

    private EditText mEtCustomername;
    private EditText mETPhonenumber;
    private EditText mETOther;
    private EditText mETCount;
    private EditText mETDiscount;

    private EditText mETName1;
    private EditText mETName2;
    private EditText mETName3;
    private EditText mETName4;
    private EditText mETName5;
    private EditText mETName6;
    private EditText mETName7;
    private EditText mETName8;
    private EditText mETName9;
    private EditText mETName10;
    private EditText mETName11;
    private EditText mETName12;
    private EditText mETName13;
    private EditText mETName14;
    private EditText mETName15;
    private EditText mETName16;
    private EditText mETName17;
    private EditText mETName18;
    private EditText mETName19;
    private EditText mETName20;
    private EditText mETName21;
    private EditText mETName22;
    private EditText mETName23;
    private EditText mETName24;
    private EditText mETName25;
    private EditText mETName26;
    private EditText mETName27;
    private EditText mETName28;
    private EditText mETName29;
    private EditText mETName30;





    private EditText mETDosage1;
    private EditText mETDosage2;
    private EditText mETDosage3;
    private EditText mETDosage4;
    private EditText mETDosage5;
    private EditText mETDosage6;
    private EditText mETDosage7;
    private EditText mETDosage8;
    private EditText mETDosage9;
    private EditText mETDosage10;
    private EditText mETDosage11;
    private EditText mETDosage12;
    private EditText mETDosage13;
    private EditText mETDosage14;
    private EditText mETDosage15;
    private EditText mETDosage16;
    private EditText mETDosage17;
    private EditText mETDosage18;
    private EditText mETDosage19;
    private EditText mETDosage20;
    private EditText mETDosage21;
    private EditText mETDosage22;
    private EditText mETDosage23;
    private EditText mETDosage24;
    private EditText mETDosage25;
    private EditText mETDosage26;
    private EditText mETDosage27;
    private EditText mETDosage28;
    private EditText mETDosage29;
    private EditText mETDosage30;
    
    private TextView mTVUnitprice1;
    private TextView mTVUnitprice2;
    private TextView mTVUnitprice3;
    private TextView mTVUnitprice4;
    private TextView mTVUnitprice5;
    private TextView mTVUnitprice6;
    private TextView mTVUnitprice7;
    private TextView mTVUnitprice8;
    private TextView mTVUnitprice9;
    private TextView mTVUnitprice10;
    private TextView mTVUnitprice11;
    private TextView mTVUnitprice12;
    private TextView mTVUnitprice13;
    private TextView mTVUnitprice14;
    private TextView mTVUnitprice15;
    private TextView mTVUnitprice16;
    private TextView mTVUnitprice17;
    private TextView mTVUnitprice18;
    private TextView mTVUnitprice19;
    private TextView mTVUnitprice20;
    private TextView mTVUnitprice21;
    private TextView mTVUnitprice22;
    private TextView mTVUnitprice23;
    private TextView mTVUnitprice24;
    private TextView mTVUnitprice25;
    private TextView mTVUnitprice26;
    private TextView mTVUnitprice27;
    private TextView mTVUnitprice28;
    private TextView mTVUnitprice29;
    private TextView mTVUnitprice30;

    private EditText mETNumber;

    private TextView mTVTotalprice;

    private MyDatabaseHelper dbHelper;

    private TextView mTvHead;
    private SlideMenu slideMenu;
    private Button mBtnSearch;
    private Button mBtnInsert;
    private Button mBtnDelete;
    private Button mBtnItem;
    private Button mBtnHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteStudioService.instance().start(this);


        //找到控件
        mBtnCheck = findViewById(R.id.btn_check);
        mBtnAdd = findViewById(R.id.btn_add);
        mEtCustomername= findViewById(R.id.et_customername);
        mETPhonenumber = findViewById(R.id.et_phonenumber);
        mETOther = findViewById(R.id.et_other);
        mETCount = findViewById(R.id.et_count);
        mETDiscount = findViewById(R.id.et_Discount);


        mETName1 = findViewById(R.id.et_name1);
        mETName2 = findViewById(R.id.et_name2);
        mETName3 = findViewById(R.id.et_name3);
        mETName4 = findViewById(R.id.et_name4);
        mETName5 = findViewById(R.id.et_name5);
        mETName6 = findViewById(R.id.et_name6);
        mETName7 = findViewById(R.id.et_name7);
        mETName8 = findViewById(R.id.et_name8);
        mETName9 = findViewById(R.id.et_name9);
        mETName10 = findViewById(R.id.et_name10);
        mETName11 = findViewById(R.id.et_name11);
        mETName12 = findViewById(R.id.et_name12);
        mETName13 = findViewById(R.id.et_name13);
        mETName14 = findViewById(R.id.et_name14);
        mETName15 = findViewById(R.id.et_name15);
        mETName16 = findViewById(R.id.et_name16);
        mETName17 = findViewById(R.id.et_name17);
        mETName18 = findViewById(R.id.et_name18);
        mETName19 = findViewById(R.id.et_name19);
        mETName20 = findViewById(R.id.et_name20);
        mETName21 = findViewById(R.id.et_name21);
        mETName22 = findViewById(R.id.et_name22);
        mETName23 = findViewById(R.id.et_name23);
        mETName24 = findViewById(R.id.et_name24);
        mETName25 = findViewById(R.id.et_name25);
        mETName26 = findViewById(R.id.et_name26);
        mETName27 = findViewById(R.id.et_name27);
        mETName28 = findViewById(R.id.et_name28);
        mETName29 = findViewById(R.id.et_name29);
        mETName30 = findViewById(R.id.et_name30);


        mETDosage1 = findViewById(R.id.et_dosage1);
        mETDosage2 = findViewById(R.id.et_dosage2);
        mETDosage3 = findViewById(R.id.et_dosage3);
        mETDosage4 = findViewById(R.id.et_dosage4);
        mETDosage5 = findViewById(R.id.et_dosage5);
        mETDosage6 = findViewById(R.id.et_dosage6);
        mETDosage7 = findViewById(R.id.et_dosage7);
        mETDosage8 = findViewById(R.id.et_dosage8);
        mETDosage9 = findViewById(R.id.et_dosage9);
        mETDosage10 = findViewById(R.id.et_dosage10);
        mETDosage11 = findViewById(R.id.et_dosage11);
        mETDosage12 = findViewById(R.id.et_dosage12);
        mETDosage13 = findViewById(R.id.et_dosage13);
        mETDosage14 = findViewById(R.id.et_dosage14);
        mETDosage15 = findViewById(R.id.et_dosage15);
        mETDosage16 = findViewById(R.id.et_dosage16);
        mETDosage17 = findViewById(R.id.et_dosage17);
        mETDosage18 = findViewById(R.id.et_dosage18);
        mETDosage19 = findViewById(R.id.et_dosage19);
        mETDosage20 = findViewById(R.id.et_dosage20);
        mETDosage21 = findViewById(R.id.et_dosage21);
        mETDosage22 = findViewById(R.id.et_dosage22);
        mETDosage23 = findViewById(R.id.et_dosage23);
        mETDosage24 = findViewById(R.id.et_dosage24);
        mETDosage25 = findViewById(R.id.et_dosage25);
        mETDosage26 = findViewById(R.id.et_dosage26);
        mETDosage27 = findViewById(R.id.et_dosage27);
        mETDosage28 = findViewById(R.id.et_dosage28);
        mETDosage29 = findViewById(R.id.et_dosage29);
        mETDosage30 = findViewById(R.id.et_dosage30);


        mTVUnitprice1 = findViewById(R.id.tv_unitprice1);
        mTVUnitprice2 = findViewById(R.id.tv_unitprice2);
        mTVUnitprice3 = findViewById(R.id.tv_unitprice3);
        mTVUnitprice4 = findViewById(R.id.tv_unitprice4);
        mTVUnitprice5 = findViewById(R.id.tv_unitprice5);
        mTVUnitprice6 = findViewById(R.id.tv_unitprice6);
        mTVUnitprice7 = findViewById(R.id.tv_unitprice7);
        mTVUnitprice8 = findViewById(R.id.tv_unitprice8);
        mTVUnitprice9 = findViewById(R.id.tv_unitprice9);
        mTVUnitprice10 = findViewById(R.id.tv_unitprice10);
        mTVUnitprice11 = findViewById(R.id.tv_unitprice11);
        mTVUnitprice12 = findViewById(R.id.tv_unitprice12);
        mTVUnitprice13 = findViewById(R.id.tv_unitprice13);
        mTVUnitprice14 = findViewById(R.id.tv_unitprice14);
        mTVUnitprice15 = findViewById(R.id.tv_unitprice15);
        mTVUnitprice16 = findViewById(R.id.tv_unitprice16);
        mTVUnitprice17 = findViewById(R.id.tv_unitprice17);
        mTVUnitprice18 = findViewById(R.id.tv_unitprice18);
        mTVUnitprice19 = findViewById(R.id.tv_unitprice19);
        mTVUnitprice20 = findViewById(R.id.tv_unitprice20);
        mTVUnitprice21 = findViewById(R.id.tv_unitprice21);
        mTVUnitprice22 = findViewById(R.id.tv_unitprice22);
        mTVUnitprice23 = findViewById(R.id.tv_unitprice23);
        mTVUnitprice24 = findViewById(R.id.tv_unitprice24);
        mTVUnitprice25 = findViewById(R.id.tv_unitprice25);
        mTVUnitprice26 = findViewById(R.id.tv_unitprice26);
        mTVUnitprice27 = findViewById(R.id.tv_unitprice27);
        mTVUnitprice28 = findViewById(R.id.tv_unitprice28);
        mTVUnitprice29 = findViewById(R.id.tv_unitprice29);
        mTVUnitprice30 = findViewById(R.id.tv_unitprice30);



        mETNumber = findViewById(R.id.et_number);

        mTVTotalprice = findViewById(R.id.tv_totalprice);

        //调用MyDatabaseHelper （cqx是创建的数据库的名称）
        dbHelper = new MyDatabaseHelper(this,"cqx",null);

        mTvHead = findViewById(R.id.tv_head);
        mBtnSearch = findViewById(R.id.btnSearch);
        mBtnInsert = findViewById(R.id.btnInsert);
        mBtnDelete = findViewById(R.id.btnDelete);
        mBtnItem = findViewById(R.id.btnItem);
        mBtnHistory = findViewById(R.id.btnHistory);

        mBtnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float total = 0;
                int[] warning = new int[30];
                int j = 0;

                String[] name = new String[30];
                name[0] = mETName1.getText().toString();
                name[1] = mETName2.getText().toString();
                name[2] = mETName3.getText().toString();
                name[3] = mETName4.getText().toString();
                name[4] = mETName5.getText().toString();
                name[5] = mETName6.getText().toString();
                name[6] = mETName7.getText().toString();
                name[7] = mETName8.getText().toString();
                name[8] = mETName9.getText().toString();
                name[9] = mETName10.getText().toString();
                name[10] = mETName11.getText().toString();
                name[11] = mETName12.getText().toString();
                name[12] = mETName13.getText().toString();
                name[13] = mETName14.getText().toString();
                name[14] = mETName15.getText().toString();
                name[15] = mETName16.getText().toString();
                name[16] = mETName17.getText().toString();
                name[17] = mETName18.getText().toString();
                name[18] = mETName19.getText().toString();
                name[19] = mETName20.getText().toString();
                name[20] = mETName21.getText().toString();
                name[21] = mETName22.getText().toString();
                name[22] = mETName23.getText().toString();
                name[23] = mETName24.getText().toString();
                name[24] = mETName25.getText().toString();
                name[25] = mETName26.getText().toString();
                name[26] = mETName27.getText().toString();
                name[27] = mETName28.getText().toString();
                name[28] = mETName29.getText().toString();
                name[29] = mETName30.getText().toString();


                String[] Sdosage = new String[30];
                Sdosage[0] = mETDosage1.getText( ).toString( );
                Sdosage[1] = mETDosage2.getText( ).toString( );
                Sdosage[2] = mETDosage3.getText( ).toString( );
                Sdosage[3] = mETDosage4.getText( ).toString( );
                Sdosage[4] = mETDosage5.getText( ).toString( );
                Sdosage[5] = mETDosage6.getText( ).toString( );
                Sdosage[6] = mETDosage7.getText( ).toString( );
                Sdosage[7] = mETDosage8.getText( ).toString( );
                Sdosage[8] = mETDosage9.getText( ).toString( );
                Sdosage[9] = mETDosage10.getText( ).toString( );
                Sdosage[10] = mETDosage11.getText( ).toString( );
                Sdosage[11] = mETDosage12.getText( ).toString( );
                Sdosage[12] = mETDosage13.getText( ).toString( );
                Sdosage[13] = mETDosage14.getText( ).toString( );
                Sdosage[14] = mETDosage15.getText( ).toString( );
                Sdosage[15] = mETDosage16.getText( ).toString( );
                Sdosage[16] = mETDosage17.getText( ).toString( );
                Sdosage[17] = mETDosage18.getText( ).toString( );
                Sdosage[18] = mETDosage19.getText( ).toString( );
                Sdosage[19] = mETDosage20.getText( ).toString( );
                Sdosage[20] = mETDosage21.getText( ).toString( );
                Sdosage[21] = mETDosage22.getText( ).toString( );
                Sdosage[22] = mETDosage23.getText( ).toString( );
                Sdosage[23] = mETDosage24.getText( ).toString( );
                Sdosage[24] = mETDosage25.getText( ).toString( );
                Sdosage[25] = mETDosage26.getText( ).toString( );
                Sdosage[26] = mETDosage27.getText( ).toString( );
                Sdosage[27] = mETDosage28.getText( ).toString( );
                Sdosage[28] = mETDosage29.getText( ).toString( );
                Sdosage[29] = mETDosage30.getText( ).toString( );

                String Count = mETCount.getText().toString();
                String Number = mETNumber.getText( ).toString( );
                if(Count.equals("") || Number.equals("")){
                    Toast.makeText(MainActivity.this, "饮片数量或副数没有输入，请填写！", Toast.LENGTH_SHORT).show( );
                }else {
                    int count = Integer.parseInt(Count);
                    int number = Integer.parseInt(Number);
                    int False = 0;
                    float[] dosage = new float[30];
                    for (int k = 0; k < count; k++) {
                        if (Sdosage[k].equals("")){
                            Toast.makeText(MainActivity.this, "饮片数量与实际填写信息不符，请重新填写！", Toast.LENGTH_SHORT).show( );
                            False = 1;
                        }else {
                        dosage[k] = Float.parseFloat(Sdosage[k]);
                        }
                    }
                    for (int k = 0; k < count; k++) {
                        if (name[k].equals("")) {
                            Toast.makeText(MainActivity.this, "饮片数量与实际填写信息不符，请重新填写！", Toast.LENGTH_SHORT).show( );
                            False = 1;
                        }
                    }

                    SQLiteDatabase db = dbHelper.getWritableDatabase( );

                    String Discount = mETDiscount.getText().toString();
                    if(Discount.equals("")){
                        Discount = "1";
                    }
                    float discount = 1;
                    discount= Float.parseFloat(Discount);
                    if (False == 0){
                        for (int i = 0; i < count; i++) {
                            //根据画面上输入的账号/密码去数据库中进行查询（user是表名）
                            Cursor c = db.query("item", null, "MedicineName=?", new String[]{name[i]}, null, null, null);
                            if (c == null) {
                                Toast.makeText(MainActivity.this, "未查询到第" + i + "个饮片！", Toast.LENGTH_SHORT).show( );
                                False = 1;
                            } else if (c.moveToFirst( )) {
                                float[] value = new float[30];
                                value[i] = c.getFloat(c.getColumnIndex("Value"));
                                String unit = String.valueOf(value[i]);
                                switch (i) {
                                    case 0: {
                                        mTVUnitprice1.setText(unit);
                                        break;
                                    }
                                    case 1: {
                                        mTVUnitprice2.setText(unit);
                                        break;
                                    }
                                    case 2: {
                                        mTVUnitprice3.setText(unit);
                                        break;
                                    }
                                    case 3: {
                                        mTVUnitprice4.setText(unit);
                                        break;
                                    }
                                    case 4: {
                                        mTVUnitprice5.setText(unit);
                                        break;
                                    }
                                    case 5: {
                                        mTVUnitprice6.setText(unit);
                                        break;
                                    }
                                    case 6: {
                                        mTVUnitprice7.setText(unit);
                                        break;
                                    }
                                    case 7: {
                                        mTVUnitprice8.setText(unit);
                                        break;
                                    }
                                    case 8: {
                                        mTVUnitprice9.setText(unit);
                                        break;
                                    }
                                    case 9: {
                                        mTVUnitprice10.setText(unit);
                                        break;
                                    }
                                    case 10: {
                                        mTVUnitprice11.setText(unit);
                                        break;
                                    }
                                    case 11: {
                                        mTVUnitprice12.setText(unit);
                                        break;
                                    }
                                    case 12: {
                                        mTVUnitprice13.setText(unit);
                                        break;
                                    }
                                    case 13: {
                                        mTVUnitprice14.setText(unit);
                                        break;
                                    }
                                    case 14: {
                                        mTVUnitprice15.setText(unit);
                                        break;
                                    }
                                    case 15: {
                                        mTVUnitprice16.setText(unit);
                                        break;
                                    }
                                    case 16: {
                                        mTVUnitprice17.setText(unit);
                                        break;
                                    }
                                    case 17: {
                                        mTVUnitprice18.setText(unit);
                                        break;
                                    }
                                    case 18: {
                                        mTVUnitprice19.setText(unit);
                                        break;
                                    }
                                    case 19: {
                                        mTVUnitprice20.setText(unit);
                                        break;
                                    }
                                    case 20: {
                                        mTVUnitprice21.setText(unit);
                                        break;
                                    }
                                    case 21: {
                                        mTVUnitprice22.setText(unit);
                                        break;
                                    }
                                    case 22: {
                                        mTVUnitprice23.setText(unit);
                                        break;
                                    }
                                    case 23: {
                                        mTVUnitprice24.setText(unit);
                                        break;
                                    }
                                    case 24: {
                                        mTVUnitprice25.setText(unit);
                                        break;
                                    }
                                    case 25: {
                                        mTVUnitprice26.setText(unit);
                                        break;
                                    }
                                    case 26: {
                                        mTVUnitprice27.setText(unit);
                                        break;
                                    }
                                    case 27: {
                                        mTVUnitprice28.setText(unit);
                                        break;
                                    }
                                    case 28: {
                                        mTVUnitprice29.setText(unit);
                                        break;
                                    }
                                    case 29: {
                                        mTVUnitprice30.setText(unit);
                                        break;
                                    }
                                }

                                total = total + dosage[i] * value[i] * number * discount;
                            }
                            total = (float) (total / 0.01) /100;
                            String Total = String.valueOf(total);
                            mTVTotalprice.setText(Total);
//                        Log.i("MainActivity", "-->>" + Total);
                        }//for i循环结束

                        if(False == 0) {
                            float finalDiscount = discount;
                            new AlertDialog.Builder(MainActivity.this)
                                    .setTitle("提示")
                                    .setMessage("是否确定保存数据？")
                                    .setPositiveButton("确定", new DialogInterface.OnClickListener( ) {
                                        public void onClick(DialogInterface dialog, int whichButton) {
                                            setResult(RESULT_OK);

                                            for (int m = 0; m < count; m++) {
                                                Cursor c = db.query("item", null, "MedicineName=?", new String[]{name[m]}, null, null, null);
                                                if (c.moveToFirst( )) {
                                                    float totalnumber = c.getFloat(c.getColumnIndex("TotalNumber"));
                                                    float min = c.getFloat(c.getColumnIndex("Min"));
                                                    float consume = totalnumber - dosage[m] * number;
                                                    if (consume <= min) {
//                                      warning[j] = i;
                                                        int n = m + 1;
                                                        int finalM = m;
                                                        new AlertDialog.Builder(MainActivity.this)
                                                                .setTitle("警告")
                                                                .setMessage("第" + n + "个饮片已低于设定数量，请及时补足药品！")
                                                                .setPositiveButton("确定", new DialogInterface.OnClickListener( ) {
                                                                    public void onClick(DialogInterface dialog, int whichButton) {
                                                                        setResult(RESULT_OK);

                                                                        ContentValues values = new ContentValues( );
                                                                        values.put("TotalNumber", consume);
                                                                        String[] args = {name[finalM]};
                                                                        db.update("item", values, "MedicineName=?", args);
                                                                    }
                                                                })
                                                                .setNegativeButton("取消", new DialogInterface.OnClickListener( ) {
                                                                    public void onClick(DialogInterface dialog, int whichButton) {
                                                                    }
                                                                })
                                                                .show( );
                                                    }else {
                                                        int finalM = m;
                                                        ContentValues values = new ContentValues( );
                                                        values.put("TotalNumber", consume);
                                                        String[] args = {name[finalM]};
                                                        db.update("item", values, "MedicineName=?", args);

                                                    }
                                                }
                                            }//for m 循环结束

                                        }
                                    })
                                    .setNegativeButton("取消", new DialogInterface.OnClickListener( ) {
                                        public void onClick(DialogInterface dialog, int whichButton) {
                                        }
                                    })
                                    .show( );
                        }
                    }
                }
            }
        });

        mBtnAdd.setOnClickListener(v -> {

            String customername = mEtCustomername.getText().toString();
            if(customername.equals("")){
                customername = "null";
            }

            String phonenumber = mETPhonenumber.getText().toString();
            if(phonenumber.equals("")){
                phonenumber = "000";
            }
            String other = mETOther.getText().toString();
            if(other.equals("")){
                other = "无";
            }
//            String name = mETName.getText().toString();
            String Ssale = mTVTotalprice.getText( ).toString( );
            if (Ssale.equals("")) {
                Toast.makeText(MainActivity.this, "请在输入信息后先点击查询按钮！", Toast.LENGTH_SHORT).show( );
            }else {
                float sale = Float.parseFloat(Ssale);
//            float dosage = Float.parseFloat(mETDosage.getText( ).toString( ));

                SQLiteDatabase db = dbHelper.getWritableDatabase( );
                ContentValues values = new ContentValues( );

                values.put("CustomerName", customername);
                values.put("Phonenumber", phonenumber);
                values.put("Other", other);
                values.put("Sale", sale);

                db.insert("history", null, values);

                values.clear( );
                Toast.makeText(MainActivity.this, "数据上传成功", Toast.LENGTH_SHORT).show( );
//                Log.i("MainActivity", "-->>" +consume +"=" + totalnumber +"-"+ dosage +"*" +number);
//            }
            }


        });




        //实现侧滑的部分，点击加侧滑
        mTvHead.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                slideMenu.switchMenu();
            }
        });

        setListener();

    }

    private  void  setListener(){
        OnClick onClick = new OnClick();

        //对每一个按钮进行setOnClickListener
        mBtnSearch.setOnClickListener(onClick);
        mBtnInsert.setOnClickListener(onClick);
        mBtnDelete.setOnClickListener(onClick);
        mBtnItem.setOnClickListener(onClick);
        mBtnHistory.setOnClickListener(onClick);

    }

    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case  R.id.btnSearch:
                    intent = new Intent(MainActivity.this,SearchActivity.class);
                    break;
                case  R.id.btnInsert:
                    intent = new Intent(MainActivity.this,ChangeActivity.class);
                    break;
                case  R.id.btnDelete:
                    intent = new Intent(MainActivity.this,DeleteActivity.class);
                    break;
                case  R.id.btnItem:
                    intent = new Intent(MainActivity.this,ItemDatabaseActivity.class);
                    break;
                case  R.id.btnHistory:
                    intent = new Intent(MainActivity.this,HistoryDatabaseActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}