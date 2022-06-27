package readFile;

import Config.Constants;
import writeFile.ValidationResult;

import java.io.File;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcel {
    // AppFile Case
    String[] collectDataApp;
    private String pthFileValidation = Constants.pthFileValidation;
    private String sheetApp = Constants.scSheetApp;
    private String sheetRea = Constants.scSheetRea;
    private String fileScenario = Constants.pFileScenario;

    public void caseReadExcelApp() {

        int csvINoAplikasi = 10;
        int idxNamaDebitur = 11;
        int idxNomorAplikasi = 0;
        int idxStatus = 2;
        int iCollect = 1;
        boolean bStatus = true;

        try {
            ZipSecureFile.setMinInflateRatio(0);
            //get file name
            String fileExcel = null;
            File folder = new File(pthFileValidation);
            File[] listOfFiles = folder.listFiles();

            if (listOfFiles != null) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile()) {

                        if (listOfFiles[i].getName().contains(fileScenario)) {
                            fileExcel = listOfFiles[i].getName();
                        }

                    } else if (listOfFiles[i].isDirectory()) {
                        System.out.println("Directory " + listOfFiles[i].getName());
                    }
                }
            }
            XSSFWorkbook workbook = new XSSFWorkbook(pthFileValidation + fileExcel);
            XSSFSheet sheet = workbook.getSheet(sheetApp);

            int rowCount = sheet.getPhysicalNumberOfRows();

            String jumlahData = sheet.getRow(1).getCell(3).getStringCellValue();
            for (int i = 1; i < 21; i++) {

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
                idxNamaDebitur = idxNamaDebitur + 11;
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    // ReaFile Case
    String[] collectDataRea;
    public void caseReadExcelRea() {
        int csvINoAplikasi = 55;
        int idxNomorAplikasi = 0;
        int idxNamaDebitur = 1;
        int idxStatus = 2;
        int iCollect = 1;
        boolean bStatus = true;

        try {
            ZipSecureFile.setMinInflateRatio(0);
            //get file name
            String fileExcel = null;
            File folder = new File(pthFileValidation);
            File[] listOfFiles = folder.listFiles();

            if (listOfFiles != null) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile()) {

                        if (listOfFiles[i].getName().contains(fileScenario)) {
                            fileExcel = listOfFiles[i].getName();
                        }

                    } else if (listOfFiles[i].isDirectory()) {
                        System.out.println("Directory " + listOfFiles[i].getName());
                    }
                }
            }
            XSSFWorkbook workbook = new XSSFWorkbook(pthFileValidation + fileExcel);
            XSSFSheet sheet = workbook.getSheet(sheetRea);

            int rowCount = sheet.getPhysicalNumberOfRows();
            for (int i = 1; i < 21; i++) {

                //read csv datadummy
                ReadCSV readCSV = new ReadCSV();
                readCSV.fileCSVRea(csvINoAplikasi);

                // read all text file as string
                ReadTextFile readTextFile = new ReadTextFile();
                readTextFile.txtRea();

                if (readTextFile.st.contains(readCSV.value2[0])) {
                    // Call Class Read text file
                    ReadReaTXT toTXT = new ReadReaTXT();
                    toTXT.textFile(idxNomorAplikasi, idxNamaDebitur, idxStatus);
                    this.collectDataRea = toTXT.value2;

                    idxNomorAplikasi = idxNomorAplikasi + 3;
                    idxNamaDebitur = idxNamaDebitur + 3;
                    idxStatus = idxStatus + 3;

                    bStatus = true;
                    //call class insert to excel scenario
                    ValidationResult inDataExcel = new ValidationResult();
                    inDataExcel.excelResultRea(iCollect, this.collectDataRea[0], this.collectDataRea[1], bStatus);
                } else{
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