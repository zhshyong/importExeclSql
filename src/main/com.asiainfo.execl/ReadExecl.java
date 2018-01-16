/**
 * Copyright 2018 asiainfo Inc.
 **/
package com.asiainfo.execl;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangshaoyong
 *         Created on 2018/1/11.
 */
public class ReadExecl {

  public static void main(String[] args) {
    int i;
    Sheet sheet;
    Workbook book;
    Cell cell1, cell2, cell3, cell4, cell5;
    try {
      //hello.xls为要读取的excel文件名
      book = Workbook.getWorkbook(new File("D://city1.xls"));

      //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
      sheet = book.getSheet(2);
      //获取左上角的单元格
      cell1 = sheet.getCell(0, 0);
      Map<String, Object> map = new HashMap();
      i = 1;
      do {
        //获取每一行的单元格
        cell1 = sheet.getCell(0, i);//（列，行）
        cell2 = sheet.getCell(1, i);
        cell3 = sheet.getCell(2, i);
        cell4 = sheet.getCell(3, i);
        String sql = "INSERT INTO td_s_city VALUES (\"" + cell3.getContents()+ "\",\"" + cell4.getContents() + "\"," +
            "\"" + cell1.getContents() + "\",\"zh\",now(),\"2099-12-31 23:59:59\",\"admin\",now(),null);";
        System.out.println(sql);
//        cell5 = sheet.getCell(4, i);
 //       System.out.println(cell1.getContents() + "\t" + cell2.getContents() + "\t" + cell3.getContents());
//        String sql = "INSERT INTO td_b_provider VALUES (\"" + cell1.getContents() + "\",\""
//            + cell2.getContents() + "\",\"" + countryCode + "\",\"" + cell3.getContents() + "\");";
//        String sql1 = "INSERT INTO td_b_provider_code VALUES (\"" + cell1.getContents() + "\",\""
//        + cell4.getContents().replace(" ", "") + "\",\"" +  cell5.getContents() + "\",\"\");";
//        String sql1 = "INSERT INTO td_s_country VALUES (\"" + cell1.getContents() + "\",\""
//            + cell4.getContents().replace(" ", "") + "\",\"" +  cell5.getContents() + "\",\"\");";
//        System.out.println(sql1);
        i++;
      } while (i < 368);
//      for (String key : map.keySet()) {
////        System.out.println(key + " = " + map.get(key));
//        if ("".equals(key)) {
//          continue;
//        }
//      String sql1 = "INSERT INTO td_s_country VALUES (\"" + key + "\",\""
//            + map.get(key) + "\",\"zh\",now(),\"2099-12-31 23:59:59\",\"admin\",now(),\"0\");";
//        System.out.println(sql1);
//      }
      book.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
