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

import com.example.chaiqinxuan.database.MyDatabaseHelper;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class DeleteActivity extends AppCompatActivity {

    private Button mBtnDownloadItem;
    private Button mBtnFirst;
    private Button mBtnUploadItem;

    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

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

//        dbHelper = new MyDatabaseHelper(this, "cqx0", null);
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
                SQLiteDatabase db = dbHelper.getWritableDatabase( );
                Cursor c = db.rawQuery("select * from item", null);
                ExportToCSV(c, "item.csv");


//                SQLiteToExcel sqliteToExcel = new SQLiteToExcel(this, "helloworld.db");
//                sqliteToExcel.exportAllTables("table1.xls", new SQLiteToExcel.ExportListener() {
//                    @Override
//                    public void onStart() {
//
//                    }
//                    @Override
//                    public void onCompleted(String filePath) {
//
//                    }
//                    @Override
//                    public void onError(Exception e) {
//
//                    }
//                });
//
            }

            //导出表格的方法
            public void ExportToCSV(Cursor c, String fileName) {

                int rowCount = 0;
                int colCount = 0;
                FileWriter fw;
                BufferedWriter bfw;
                //获取sd卡根目录
                File sdCardDir = Environment.getExternalStorageDirectory();
                //保存文件目录
                File saveFile = new File(sdCardDir, fileName);
                try {

                    rowCount = c.getCount();
                    colCount = c.getColumnCount();
                    fw = new FileWriter(saveFile);
                    bfw = new BufferedWriter(fw);
                    if (rowCount > 0) {
                        c.moveToFirst();
                        // 写入表头
                        for (int i = 0; i < colCount; i++) {
                            if (i != colCount - 1)
                                bfw.write(c.getColumnName(i) + ',');
                            else
                                bfw.write(c.getColumnName(i));
                        }
                        // 写好表头后换行
                        bfw.newLine();
                        // 写入数据
                        for (int i = 0; i < rowCount; i++) {
                            c.moveToPosition(i);
                            // Toast.makeText(mContext, "正在导出第"+(i+1)+"条",
                            // Toast.LENGTH_SHORT).show();
                            Log.v("导出数据", "正在导出第" + (i + 1) + "条");
                            for (int j = 0; j < colCount; j++) {
                                if (j != colCount - 1)
                                    bfw.write(c.getString(j) + ',');
                                else
                                    bfw.write(c.getString(j));
                            }
                            // 写好每条记录后换行
                            bfw.newLine();
                        }
                    }
                    // 将缓存数据写入文件
                    bfw.flush();
                    // 释放缓存
                    bfw.close();
                    // Toast.makeText(mContext, "导出完毕！", Toast.LENGTH_SHORT).show();
                    Log.v("导出数据", "导出完毕！");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    c.close();
                }
            }


//            public void ExportToCSV(Cursor c, String fileName) {
//
//                int rowCount = 0;
//                int colCount = 0;
//                FileWriter fw;
//                BufferedWriter bfw;
//                File sdCardDir = Environment.getExternalStorageDirectory( );
//                File saveFile = new File(sdCardDir, fileName);
//                try {
//
//                    rowCount = c.getCount( );
//                    colCount = c.getColumnCount( );
//                    fw = new FileWriter(saveFile);
//                    bfw = new BufferedWriter(fw);
//                    if (rowCount > 0) {
//                        c.moveToFirst( );
//                        // 写入表头
//                        for (int i = 0; i < colCount; i++) {
//                            if (i != colCount - 1)
//                                bfw.write(c.getColumnName(i) + ',');
//                            else
//                                bfw.write(c.getColumnName(i));
//                        }
//                        // 写好表头后换行
//                        bfw.newLine( );
//                        // 写入数据
//                        for (int i = 0; i < rowCount; i++) {
//                            c.moveToPosition(i);
//                            // Toast.makeText(mContext, "正在导出第"+(i+1)+"条",
//                            // Toast.LENGTH_SHORT).show();
//                            Log.v("导出数据", "正在导出第" + (i + 1) + "条");
//                            for (int j = 0; j < colCount; j++) {
//                                if (j != colCount - 1)
//                                    bfw.write(c.getString(j) + ',');
//                                else
//                                    bfw.write(c.getString(j));
//                            }
//                            // 写好每条记录后换行
//                            bfw.newLine( );
//                        }
//                    }
//                    // 将缓存数据写入文件
//                    bfw.flush( );
//                    // 释放缓存
//                    bfw.close( );
//                    // Toast.makeText(mContext, "导出完毕！", Toast.LENGTH_SHORT).show();
//                    Log.v("导出数据", "导出完毕！");
//                } catch (IOException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace( );
//                } finally {
//                    c.close( );
//                }
//            }
        });

        mBtnDownloadItem.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
//                //fileChooser界面就省略了,直接调用系统的文件管理,触发事件
//
////导入格式为 .xls .xlsx
//                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                intent.setType("application/*");//设置类型
//                intent.addCategory(Intent.CATEGORY_OPENABLE);
//                startActivityForResult(intent, 1);
//
//
////然后进入系统的文件管理,选择文件后
//                @Override
//                protected void onActivityResult(int requestCode,int resultCode, Intent data) {
//                    if (resultCode == RESULT_OK && data != null) {
//                        LogUtil.e(TAG, "选择的文件Uri = " + data.toString());
//                        //通过Uri获取真实路径
//                        final String excelPath = getRealFilePath(this, data.getData());
//                        LogUtil.e(TAG, "excelPath = " + excelPath);//    /storage/emulated/0/test.xls
//                        if (excelPath.contains(".xls") || excelPath.contains(".xlsx")) {
//                            showSnack("正在加载Excel中...");
//                            //载入excel
//                            readExcel(excelPath);
//                        } else {
//                            showSnack("此文件不是excel格式");
//                        }
//                    }
//                }
//
//
////读取Excel表
//                private void readExcel(String excelPath) {
//                    try {
//                        InputStream input = new FileInputStream(new File(excelPath));
//                        POIFSFileSystem fs = new POIFSFileSystem(input);
//                        HSSFWorkbook wb = new HSSFWorkbook(fs);
//                        HSSFSheet sheet = wb.getSheetAt(0);
//                        // Iterate over each row in the sheet
//                        Iterator<Row> rows = sheet.rowIterator();
//                        while (rows.hasNext()) {
//                            HSSFRow row = (HSSFRow) rows.next();
//                            System.out.println("Row #" + row.getRowNum());
//                            //每一行 = 新建一个学生
//                            Student stu = new Student();
//                            // Iterate over each cell in the row and print out the cell"s
//                            // content
//                            Iterator<Cell> cells = row.cellIterator();
//                            while (cells.hasNext()) {
//                                HSSFCell cell = (HSSFCell) cells.next();
//                                switch (cell.getCellType()) {
//                                    case HSSFCell.CELL_TYPE_NUMERIC:
//                                        System.out.println("number= " + (int) (cell.getNumericCellValue()));
//                                        //自定操作,我这里写入学号
//                                        stu.setSno((int) (cell.getNumericCellValue()) + "");
//                                        break;
//                                    case HSSFCell.CELL_TYPE_STRING:
//                                        System.out.println("string= " + cell.getStringCellValue());
//                                        //自定操作,我这里写入姓名
//                                        stu.setName(cell.getStringCellValue());
//                                        break;
//                                    case HSSFCell.CELL_TYPE_BOOLEAN:
//                                        System.out.println("boolean= " + cell.getBooleanCellValue());
//                                        break;
//                                    case HSSFCell.CELL_TYPE_FORMULA:
//                                        System.out.println("formula= " + cell.getCellFormula());
//                                        break;
//                                    default:
//                                        System.out.println("unsuported sell type");
//                                        break;
//                                }
//                            }
//                            stu.save();
//                        }
//                    } catch (IOException ex) {
//                        ex.printStackTrace();
//                    }
//                    //刷新列表
//                    getAllStudent();
//                }
//
//
//
////查询所有学生
//                private void getAllStudent() {
//                    studentList = DataSupport.findAll(Student.class);
//                }
//
//
//
//                /**
//                 * 根据Uri获取真实图片路径
//                 * <p/>
//                 * 一个android文件的Uri地址一般如下：
//                 * content://media/external/images/media/62026
//                 *
//                 * @param context
//                 * @param uri
//                 * @return
//                 */
//                public static String getRealFilePath(final Context context, final Uri uri) {
//                    if (null == uri) return null;
//                    final String scheme = uri.getScheme();
//                    String data = null;
//                    if (scheme == null)
//                        data = uri.getPath();
//                    else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
//                        data = uri.getPath();
//                    } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
//                        Cursor cursor = context.getContentResolver().query(uri, new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
//                        if (null != cursor) {
//                            if (cursor.moveToFirst()) {
//                                int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
//                                if (index > -1) {
//                                    data = cursor.getString(index);
//                                }
//                            }
//                            cursor.close();
//                        }
//                    }
//                    return data;
//                }

            }
        });


    }
}