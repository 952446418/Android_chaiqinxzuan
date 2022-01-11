//package com.example.chaiqinxuan.calculate;
//
//import android.content.Context;
//import android.os.Environment;
//import android.util.Log;
//import android.widget.Toast;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.List;
//
//import jxl.Workbook;
//import jxl.format.Alignment;
//import jxl.format.CellFormat;
//import jxl.format.Colour;
//import jxl.format.VerticalAlignment;
//import jxl.write.Label;
//import jxl.write.WritableCellFormat;
//import jxl.write.WritableFont;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;
//import jxl.write.biff.RowsExceededException;
//
///** * Created by joker on 2016/1/30. */
//public class ExcelUtils {
//    public static void writeExcel(Context context, List<order> exportOrder, String fileName) {
//        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
//            Toast.makeText(context, "SD卡不可用", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        String[] title = {"编号", "姓名", "电话", "地址"};
//        File file = new File("/data/data/com.joker.exceldemo/" + fileName + ".xls");
//        Log.d("zhanglinshu", "fileNameStr :" + file.getName());
//        //创建Excel工作表
//        WritableWorkbook wwb = null;
//        try {
//            OutputStream os = new FileOutputStream(file);
//            wwb = Workbook.createWorkbook(os);
//            //添加第一个工作表并设置第一个Sheet的名字
//            WritableSheet sheet = wwb.createSheet("订单", 0);
//            Label label;
//            for (int i = 0; i < title.length; i++) {
//                //Label(x,y,z)代表单元格的第x+1列，第y+1行，内容z
//                //在Label对象的子对象中指明单元格的位置和内容
//                label = new Label(i, 0, title[i], getHeader());
//                //将定义好的单元格添加到工作表中
//                sheet.addCell(label);
//            }
//            for (int i = 0; i < exportOrder.size(); i++) {
//                order order = exportOrder.get(i);
//                Label orderNum = new Label(0, i + 1, order.getId());
//                Label restaurant = new Label(1, i + 1, order.getRestName());
//                Label nameLabel = new Label(2, i + 1, order.getRestPhone());
//                Label address = new Label(3, i + 1, order.getReceiverAddr());
//                sheet.addCell(orderNum);
//                sheet.addCell(restaurant);
//                sheet.addCell(nameLabel);
//                sheet.addCell(address);
//                Toast.makeText(context, "写入成功", Toast.LENGTH_LONG).show();
//            }
//            wwb.write();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (RowsExceededException e) {
//            e.printStackTrace();
//        } catch (WriteException e) {
//            e.printStackTrace();
//        } finally {
//            //
//            if (wwb != null) {
//                try {
//                    wwb.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (WriteException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    private static CellFormat getHeader() {
//        WritableFont font = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD);
//        try {
//            font.setColour(Colour.BLUE);
//        } catch (WriteException e) {
//            e.printStackTrace();
//        }
//        WritableCellFormat format = new WritableCellFormat(font);
//        try {
//            format.setAlignment(Alignment.CENTRE); //左右居中
//            format.setVerticalAlignment(VerticalAlignment.CENTRE); //上下居中
//            format.setBackground(Colour.YELLOW);
//        } catch (WriteException e) {
//            e.printStackTrace();
//        }
//        return format;
//    }
//
//}