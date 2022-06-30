package readFile;

import Config.Constants;
import TestData.ReadTestData;
import writeFile.ValidationResult;

import java.io.File;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
    String[] collectDataApp;
    String[] collectDataRea;
    ReadTestData readTestData = new ReadTestData();

    public void caseReadExcelApp() {

        int csvINoAplikasi = 10;
        int idxNomorAplikasi = 0;
        int idxStatus = 2;
        int iCollect = 1;
        boolean bStatus = true;

        try {
            ZipSecureFile.setMinInflateRatio(0);
            readTestData.testData();
            for (int i = 1; i <= Integer.parseInt(readTestData.jumlahData); i++) {

                //read csv datadummy
                ReadCSV readCSV = new ReadCSV();
                readCSV.fileCSVApp(csvINoAplikasi);

                // read all text file as string
                ReadTextFile readTextFile = new ReadTextFile();
                readTextFile.txtApp();

                if (readTextFile.st.contains(readCSV.value2[0])) {
                    // Call Class Read text file
                    ReadAppTXT toTXT = new ReadAppTXT();
                    toTXT.textFile(idxNomorAplikasi, idxStatus);
                    this.collectDataApp = toTXT.value2;

                    idxNomorAplikasi = idxNomorAplikasi + 3;
                    idxStatus = idxStatus + 3;

                    bStatus = true;
                    //call class insert to excel scenario
                    ValidationResult inDataExcel = new ValidationResult();
                    inDataExcel.excelResultApp(iCollect, this.collectDataApp[0], this.collectDataApp[1], bStatus);
                } else {

                    bStatus = false;
                    //call class insert to excel scenario
                    ValidationResult inDataExcel = new ValidationResult();
                    inDataExcel.excelResultApp(iCollect, Constants.sNull, Constants.sNull, bStatus);
                }
                iCollect = iCollect + 1;
                csvINoAplikasi = csvINoAplikasi + 10;
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public void caseReadExcelRea() {
        int csvINoAplikasi = 55;
        int idxNomorAplikasi = 0;
        int idxStatus = 2;
        int iCollect = 1;
        boolean bStatus = true;

        try {
            ZipSecureFile.setMinInflateRatio(0);
            readTestData.testData();
            for (int i = 1; i <= Integer.parseInt(readTestData.jumlahData); i++) {

                //read csv datadummy
                ReadCSV readCSV = new ReadCSV();
                readCSV.fileCSVRea(csvINoAplikasi);

                // read all text file as string
                ReadTextFile readTextFile = new ReadTextFile();
                readTextFile.txtRea();

                if (readTextFile.st.contains(readCSV.value2[0])) {
                    // Call Class Read text file
                    ReadReaTXT toTXT = new ReadReaTXT();
                    toTXT.textFile(idxNomorAplikasi, idxStatus);
                    this.collectDataRea = toTXT.value2;

                    idxNomorAplikasi = idxNomorAplikasi + 3;
                    idxStatus = idxStatus + 3;

                    bStatus = true;
                    //call class insert to excel scenario
                    ValidationResult inDataExcel = new ValidationResult();
                    inDataExcel.excelResultRea(iCollect, this.collectDataRea[0], this.collectDataRea[1], bStatus);
                } else {
                    bStatus = false;
                    //call class insert to excel scenario
                    ValidationResult inDataExcel = new ValidationResult();
                    inDataExcel.excelResultRea(iCollect, "null", "null", bStatus);
                }

                iCollect = iCollect + 1;
                csvINoAplikasi = csvINoAplikasi + 55;
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}