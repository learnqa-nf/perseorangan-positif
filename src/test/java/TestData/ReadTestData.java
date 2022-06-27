package TestData;

import Config.Constants;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTestData {
    public String[] cellDataValue;
    public String timeStamp;

    public String[] testData() {
        System.out.println("reading test data");
        try {
            ZipSecureFile.setMinInflateRatio(0);
            XSSFWorkbook workbook = new XSSFWorkbook(Constants.pthTestData);
            XSSFSheet sheet = workbook.getSheet(Constants.sheetTestData);

            String namaDebitur = sheet.getRow(1).getCell(0).getStringCellValue();
            String nomor_aplikasi = sheet.getRow(1).getCell(1).getStringCellValue();
            String kode_produk = sheet.getRow(1).getCell(2).getStringCellValue();
            String jumlahData = sheet.getRow(1).getCell(3).getStringCellValue();
            timeStamp = sheet.getRow(1).getCell(4).getStringCellValue();
            cellDataValue = new String[]{namaDebitur, nomor_aplikasi, kode_produk, jumlahData};

            workbook.close();
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return cellDataValue;
    }
}
