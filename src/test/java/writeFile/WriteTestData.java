package writeFile;

import Config.Constants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteTestData {
    String fileExcel = Constants.pthTestData;
    String sheetApp = Constants.sheetTestData;

    public void writeData(String timeStamp) throws IOException {

        String excelFilePath = fileExcel;
        File file = new File(excelFilePath);
        FileInputStream os = new FileInputStream(excelFilePath);
        XSSFWorkbook wb = new XSSFWorkbook(os);
        XSSFSheet sheet = wb.getSheet(sheetApp);
        int row = sheet.getLastRowNum();

        System.out.println(timeStamp);

        //insert new column data to excel
        sheet.getRow(1).createCell(4).setCellValue(timeStamp);

        //width autoSize
        FileOutputStream fout = new FileOutputStream(file);
        wb.write(fout);
        os.close();
        wb.close();
    }
}

