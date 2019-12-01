package com.interview.eBay.Config;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class ExcelDataProvider {


    public  String filepath=System.getProperty("user.dir")+"/DataSource/TestSheet.xls";
    public  FileInputStream fis = null;
    public  FileOutputStream fout =null;
    public static Workbook wb;
    private static Sheet sh;


    public ExcelDataProvider()
    {
        File datafile=new File(filepath);
        try {
            fis = new FileInputStream(datafile);

            String fileExtensionName = filepath.substring(filepath.indexOf("."));

            if(fileExtensionName.equalsIgnoreCase(".xls"))
            {
                wb=new HSSFWorkbook(fis);
            }

        } catch (Exception e) {
            
            System.out.println("Exception in dataprovider file"+e.getMessage());
        }
    }

   
 
    public String getCellData(int sheetindex,int row,int col){

        if(row <=0){
            return "";
        }
        else if(col<=0)
        {
            return "";
        }
        else{
            String data=wb.getSheetAt(sheetindex).getRow(row).getCell(col).getStringCellValue().trim();
            return data;
        }
    }

  

}


