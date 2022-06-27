package writeFile;

import java.io.*;

import Config.Constants;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ValidationResult {
    String fileExcel = null;
    String[] sheetName = {Constants.scSheetApp, Constants.scSheetRea};
    String pthFileValidation = Constants.pthFileValidation;

    public void excelResultApp(int iCollect, String nomorAplikasi, String Status, boolean bStatus) throws IOException {

        int iRow = iCollect + 1;
        //get file name
        File folder = new File(pthFileValidation);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {

                    if (listOfFiles[i].getName().contains(Constants.pFileScenario)) {
                        fileExcel = listOfFiles[i].getName();
                        //System.out.println(fileExcel);
                    }

                } else if (listOfFiles[i].isDirectory()) {
                    //System.out.println("Directory " + listOfFiles[i].getName());
                }
            }
        }
        try {
            String excelFilePath = pthFileValidation + fileExcel;

            File file = new File(excelFilePath);
            FileInputStream os = new FileInputStream(excelFilePath);
            XSSFWorkbook wb = new XSSFWorkbook(os);
            XSSFSheet sheet = wb.getSheet(Constants.scSheetApp);
            XSSFRow row = sheet.getRow(0);

            XSSFCellStyle styleGreen = wb.createCellStyle();
            styleGreen.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            styleGreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            XSSFCellStyle styleRed = wb.createCellStyle();
            styleRed.setFillForegroundColor(IndexedColors.RED.getIndex());
            styleRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle topAligned = wb.createCellStyle();
            topAligned.setVerticalAlignment(VerticalAlignment.TOP);

            //insert new header column
            int cell = row.getLastCellNum();
            System.out.println(nomorAplikasi);
            System.out.println(Status);
            System.out.println("Row: " + iCollect);
            if (iRow == 2) {
                sheet.shiftRows(2, 20, 1, true, true);


            }
            CellStyle cs = wb.createCellStyle();
            cs.setWrapText(true);

            sheet.createRow(iRow);
            sheet.getRow(iRow).createCell(0).setCellValue(iCollect);
            sheet.getRow(iRow).getCell(0).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(1).setCellValue("Approval Process");
            sheet.getRow(iRow).getCell(1).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(2).setCellValue("POSITIF");
            sheet.getRow(iRow).getCell(2).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(3).setCellValue(
                    "Nomor_Aplikasi \n" +
                            "NIK \n" +
                            "NPWP \n" +
                            "Jenis_Debitur \n" +
                            "Nama_Debitur \n" +
                            "Jangka_Waktu_Kredit \n" +
                            "Interest_Rate \n" +
                            "Plafon_Kredit \n" +
                            "Phone_Number \n" +
                            "Remark");
            sheet.getRow(iRow).getCell(3).setCellStyle(topAligned);
            sheet.getRow(iRow).getCell(3).setCellStyle(cs);
            sheet.getRow(iRow).createCell(4).setCellValue("BERHASIL");
            sheet.getRow(iRow).getCell(4).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(5).setCellValue("Automation");
            sheet.getRow(iRow).getCell(5).setCellStyle(topAligned);

            //insert new column data to excel
            if (bStatus == true) {

                sheet.getRow(iRow).createCell(6).setCellValue(Status);
                sheet.getRow(iRow).getCell(6).setCellStyle(topAligned);

                sheet.getRow(iRow).createCell(7).setCellValue(Constants.tStatus);
                sheet.getRow(iRow).getCell(7).setCellStyle(styleGreen);
                sheet.getRow(iRow).getCell(7).setCellStyle(topAligned);
            } else {

                sheet.getRow(iRow).createCell(6).setCellValue(Constants.sNull);
                sheet.getRow(iRow).getCell(6).setCellStyle(topAligned);

                sheet.getRow(iRow).createCell(7).setCellValue(Constants.fStatus);
                sheet.getRow(iRow).getCell(7).setCellStyle(topAligned);
                sheet.getRow(iRow).getCell(7).setCellStyle(styleRed);
            }

            FileOutputStream fout = new FileOutputStream(file);
            HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
            wb.write(fout);
            os.close();
            wb.close();

        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void excelResultRea(int iCollect, String nomorAplikasi, String Status, boolean bStatus) throws IOException {

        File folder = new File(pthFileValidation);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {

                    if (listOfFiles[i].getName().contains(Constants.pFileScenario)) {
                        fileExcel = listOfFiles[i].getName();
                    }

                } else if (listOfFiles[i].isDirectory()) {
                    System.out.println("Directory " + listOfFiles[i].getName());
                }
            }
        }

        XSSFSheet sheet = null;
        XSSFWorkbook wb = null;
        int cell = 0;
        try {
            String excelFilePath = pthFileValidation + fileExcel;

            File file = new File(excelFilePath);
            FileInputStream os = new FileInputStream(excelFilePath);
            wb = new XSSFWorkbook(os);
            sheet = wb.getSheet(Constants.scSheetRea);
            XSSFRow row = sheet.getRow(0);

            XSSFCellStyle styleGreen = wb.createCellStyle();
            styleGreen.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            styleGreen.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            XSSFCellStyle styleRed = wb.createCellStyle();
            styleRed.setFillForegroundColor(IndexedColors.RED.getIndex());
            styleRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            CellStyle topAligned = wb.createCellStyle();
            topAligned.setVerticalAlignment(VerticalAlignment.TOP);

            //insert new header column
            cell = row.getLastCellNum();
            int iRow = iCollect + 1;
            System.out.println(nomorAplikasi);
            System.out.println(Status);
            System.out.println("Row: " + iCollect);
            if (iRow == 2) {
//            sheet.createRow(17);
                sheet.shiftRows(2, 20, 1, true, true);


            }
            CellStyle cs = wb.createCellStyle();
            cs.setWrapText(true);

            sheet.createRow(iRow);
            sheet.getRow(iRow).createCell(0).setCellValue(iCollect);
            sheet.getRow(iRow).getCell(0).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(1).setCellValue("Approval Process");
            sheet.getRow(iRow).getCell(1).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(2).setCellValue("POSITIF");
            sheet.getRow(iRow).getCell(2).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(3).setCellValue(
                    "Nomor Aplikasi \n" + "Nama Debitur \n" + "Jenis Debitur \n" + "Gender Code \n" + "NIK  \n" + "Nomor NPWP \n" +
                            "Alamat \n" + "Alamat_Kelurahan \n" + "Alamat_Kecamatan \n" + "Alamat_KodePos \n" +
                            "Alamat_KodeDATI II \n" + "Province \n" + "No Telepon  \n" + "Mobile Phone Number \n" + "Email \n" +
                            "Place Of Birth \n" + "Tanggal lahir debitur \n" + "Last Education Code \n" + "Employer \n" +
                            "Employer Address \n" + "Mother Maiden Name \n" + "Religion \n" + "Penghasilan Kotor per Bulan \n" +
                            "Marital Status \n" + "Nama Pasangan \n" + "Tanggal Lahir Pasangan \n" + "Perjanjian Pisah Harta \n" +
                            "No Akte \n" + "Tanggal Berdiri \n" + "No Akte Terakhir \n" + "Tanggal Akte Terakhir \n" +
                            "Bidang Usaha \n" + "Jangka Waktu \n" + "Jenis Kredit \n" + "Plafon \n" + "Interest Rate \n" +
                            "Nomor PK \n" + "Tanggal Akad \n" + "Tanggal Angsuran I \n" + "Jenis Penggunaan \n" +
                            "Sektor Ekonomi \n" + "Omzet \n" + "Go Public \n" + "Sandi Golongan Debitur \n" +
                            "Penghasilan Kotor per Tahun \n" + "Bentuk Badan Usaha \n" + "Tempat berdiri badan usaha \n" +
                            "Original Loan Amount \n" + "Disbursement Date \n" + "Tenor \n" + "Segmentasi Debitur \n" +
                            "Pekerjaan \n" + "Debtor Category \n" + "Income Source \n" + "Jumlah_Tanggungan");
            //sheet.getRow(iRow).getCell(3).setCellStyle(topAligned);
            sheet.getRow(iRow).getCell(3).setCellStyle(cs);
            sheet.getRow(iRow).createCell(4).setCellValue("BERHASIL");
            sheet.getRow(iRow).getCell(4).setCellStyle(topAligned);
            sheet.getRow(iRow).createCell(5).setCellValue("Automation");
            sheet.getRow(iRow).getCell(5).setCellStyle(topAligned);

            //insert new column data to excel
            if (bStatus == true) {

                sheet.getRow(iRow).createCell(6).setCellValue(Status);
                sheet.getRow(iRow).getCell(6).setCellStyle(topAligned);

                sheet.getRow(iRow).createCell(7).setCellValue(Constants.tStatus);
                sheet.getRow(iRow).getCell(7).setCellStyle(styleGreen);
                sheet.getRow(iRow).getCell(7).setCellStyle(topAligned);
            } else {

                sheet.getRow(iRow).createCell(6).setCellValue(Constants.sNull);
                sheet.getRow(iRow).getCell(6).setCellStyle(topAligned);

                sheet.getRow(iRow).createCell(7).setCellValue(Constants.fStatus);
                sheet.getRow(iRow).getCell(7).setCellStyle(topAligned);
                sheet.getRow(iRow).getCell(7).setCellStyle(styleRed);
            }

            //width autoSize
            FileOutputStream fout = new FileOutputStream(file);
            HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
            wb.write(fout);
            fout.close();
            os.close();
            wb.close();

        } catch (Exception e) {
            e.getMessage();
        }

        if (iCollect == sheet.getLastRowNum() - 1) {
            for (int colNum = 0; colNum < cell; colNum++) {
                sheet.autoSizeColumn(colNum);
            }
            // call class result percentage
            ScenarioResult scenarioResult = new ScenarioResult();
            scenarioResult.scenarioFile();

            //Clean content
            for (String nmSheet : sheetName) {
                XSSFSheet sheetAll = wb.getSheet(nmSheet);
                int lstRowNumberApp = sheetAll.getLastRowNum();
                for (int iClear = 2; iClear <= lstRowNumberApp; iClear++) {

                    String excelFilePath2 = pthFileValidation + fileExcel;
                    try {
                        File file2 = new File(excelFilePath2);
                        FileInputStream os2 = new FileInputStream(excelFilePath2);
                        XSSFWorkbook wb2 = new XSSFWorkbook(os2);
                        XSSFSheet sheet2 = wb2.getSheet(nmSheet);

                        XSSFCellStyle styleNoFill = wb2.createCellStyle();
                        styleNoFill.setFillPattern(FillPatternType.NO_FILL);
                        sheet2.getRow(iClear).getCell(0).setCellType(CellType.BLANK);
                        sheet2.getRow(iClear).getCell(1).setCellType(CellType.BLANK);
                        sheet2.getRow(iClear).getCell(2).setCellType(CellType.BLANK);
                        sheet2.getRow(iClear).getCell(3).setCellType(CellType.BLANK);
                        sheet2.getRow(iClear).getCell(4).setCellType(CellType.BLANK);
                        sheet2.getRow(iClear).getCell(5).setCellType(CellType.BLANK);
                        sheet2.getRow(iClear).getCell(6).setCellType(CellType.BLANK);
                        sheet2.getRow(iClear).getCell(6).setCellStyle(styleNoFill);
                        sheet2.getRow(iClear).getCell(7).setCellType(CellType.BLANK);
                        sheet2.getRow(iClear).getCell(7).setCellStyle(styleNoFill);

                        FileOutputStream fout2 = new FileOutputStream(file2);
                        HSSFFormulaEvaluator.evaluateAllFormulaCells(wb2);
                        wb2.write(fout2);
                        fout2.close();
                        os2.close();
                        wb2.close();
                    } catch (Exception e) {
                        e.getMessage();
                    }

                }

                if (nmSheet.contains("Realisasi")) {
                    CleanImages cleanImages = new CleanImages();

                    cleanImages.cleanAllImages();
                    scenarioResult.percentages();

                }
            }
        }
    }
}

