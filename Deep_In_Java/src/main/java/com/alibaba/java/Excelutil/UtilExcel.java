package com.alibaba.java.util;
import cn.hutool.poi.excel.sax.Excel07SaxReader;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


/**
 *
 * @param
 * @Auther linghu
 * 实现自动调整excel格式，首先读取整个excel(2007以后)，读取其中某两列，需要将整列数据进行格式梳理，最后生成一对一的两列新的excel文档。供人使用
 */
public class UtilExcel {
    public   static int startNum=0;
    public static List<Map<String,List<String>>> list = new ArrayList<>();
    //最终得到的bean集合 endlist
    public static List<TargetBean> endlist= new ArrayList<>();


    public static void main(String[] args) {
     RowHandler rowHandler = createRowHandler();
     Excel07SaxReader excel07SaxReader = new Excel07SaxReader(rowHandler);
     excel07SaxReader.read("C:\\Users\\ling\\Desktop\\ExcelUtil专用文件夹\\process.xlsx",1);

    }
/*
* 创建一个行级别的处理器
* 具体处理逻辑在这里，最后需要写到一个新的excel里
* */
    private static RowHandler createRowHandler() {
        //
        final int[] i = {0};
        final List<TargetBean> endlist = new ArrayList<>();
        return new RowHandler() {
            @Override
            public void handle(int sheetIndex, int rowIndex, List<Object> rowlist) {
                String hetongNum =   rowlist.get(3).toString();
                String fahuoNum  =   rowlist.get(4).toString();
                Map<String,List<String>> map  =   parseFahuoNum(hetongNum,fahuoNum,"/"," ");
               // System.out.println(map);
                ++i[0];
                List<TargetBean> list =  getKeyandValue(map);
                endlist.addAll(list);
                //i【0】是process的行数
                if (i[0]>=1480){
                    poiWriteExcel(endlist,"C:\\Users\\ling\\Desktop\\ExcelUtil专用文件夹\\end.xlsx");
                }
/*
                System.out.println("在写");*/
            }

            /**
             *
             * @param hetongNum 合同号
             * @param fahuoNum 发货号
             * @param preformat 最终剩下的格式
             * @param lastformat 首先需要被格式化的
             * @return
             */
            private Map<String,List<String>> parseFahuoNum(String hetongNum,String fahuoNum,String preformat,String lastformat){
                fahuoNum =  fahuoNum.trim().replace(lastformat,preformat);
                fahuoNum =  gettrimString(fahuoNum);
                Map<String ,List<String>> hashmap = new HashMap<>();
                List<String> list = new ArrayList<>();
                if(fahuoNum.trim().contains(preformat)){
                    String[] fahuoNums =  fahuoNum.split(preformat);
                    //先储存正常发货订单长度
                    int len = fahuoNums[0].trim().length();
                    list.add(fahuoNums[0].trim());
                    for(int a=1; a<fahuoNums.length ; a++){
                        //去空格
                        int errorlen =  fahuoNums[a].trim().length();
                        //第一步：先塞第一个数

                        String head  = fahuoNums[0].trim().substring(0,len-errorlen);

                        //拼接之后的发货订单
                        String newfahuoNum = head+fahuoNums[a].trim();
                        if (newfahuoNum.length()==len){
                            //第二步：再塞拼接之后的
                            list.add(newfahuoNum);
                        }
                        //判断带特殊字符的数据中含有“ ”的数据单独处理
                        if (newfahuoNum.contains(" ")){

                            String[] newfahuoNums = newfahuoNum.split(" ");
                            //第三步：处理 “ ” 数据
                            for (int i = 0;i<newfahuoNums.length;i++){
                                if( newfahuoNums[i].trim().length()==len){
                                    list.add(newfahuoNums[i].trim());
                                }
                            }
                        }
                    }
                    hashmap.put(hetongNum,list);
                }else {
                    List<String> singlelist = new ArrayList<>();
                    singlelist.add(fahuoNum);
                    hashmap.put(hetongNum,singlelist);
                }

                return  hashmap;
            }
        };

    }

    /**
     * 需要将字符串中多余的//删除
     * @param a
     * @return
     */
    private static String gettrimString(String a){
        if (a.contains("//")){
            a = a.replace("//","/");
            a = gettrimString(a);
        }
        return  a ;
    }

    /**
     * 解析 特定的Map集合
     * @param map
     * @return
     */
    private static List<TargetBean> getKeyandValue(Map<String,List<String>> map){
        List<TargetBean> list = new ArrayList<>();
       Set<Map.Entry<String, List<String>>> entries =  map.entrySet();
        for (Map.Entry<String,List<String>> entry:
            entries ) {
            String  hetongNum = entry.getKey();
            List<String> fahuoNums = entry.getValue();
            for (String fahuoNum:fahuoNums
            ) {
                TargetBean targetBean = new TargetBean();
                targetBean.setHetongNum(hetongNum);
                targetBean.setFahuoNum(fahuoNum);
                if (list==null){
                    System.out.println("list为空");
                }else{
                    list.add(targetBean);
                }
            }
        }
        return list;
    }

    /**
     * 原生poi api实现的写出到excel 文件
     * @param list
     */
    private static void poiWriteExcel(List<TargetBean> list,String path){

        //创建excel工作簿
        HSSFWorkbook workbook=new HSSFWorkbook();
        //创建工作表sheet
        HSSFSheet sheet=workbook.createSheet();
        //创建第一行
        HSSFRow row=sheet.createRow(0);

        //写入数据
        for (int i=0;i<list.size();i++){
            HSSFRow nrow=sheet.createRow(i);
            HSSFCell ncell=nrow.createCell(0);
            ncell.setCellValue(list.get(i).getFahuoNum());
            ncell=nrow.createCell(1);
            ncell.setCellValue(list.get(i).getHetongNum());
        }
            //创建excel文件
        File file=new File(path);

        try {
            file.createNewFile();
            FileOutputStream stream= FileUtils.openOutputStream(file);
            workbook.write(stream);
            startNum=startNum+list.size();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}