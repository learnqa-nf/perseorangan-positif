package Capture;

import Config.Constants;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class ImageExcel {
    public void insertImages(String image, int i) {

        String fileExcel = Constants.pthFileValidation + Constants.fileNMScenario;
        String sheetImages = Constants.sheetImages;

        try {

            String excelFilePath = fileExcel;
            File file = new File(excelFilePath);
            FileInputStream os = new FileInputStream(excelFilePath);
            XSSFWorkbook wb = new XSSFWorkbook(os);
            XSSFSheet sheet = wb.getSheet(sheetImages);

            //FileInputStream obtains input bytes from the image file
            InputStream inputStream = new FileInputStream(image);
            //Get the contents of an InputStream as a byte[].
            byte[] bytes = IOUtils.toByteArray(inputStream);
            //Adds a picture to the workbook
            int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            //close the input stream
            inputStream.close();

            //Returns an object that handles instantiating concrete classes
            CreationHelper helper = wb.getCreationHelper();

            //Creates the top-level drawing patriarch.
            Drawing drawing = sheet.createDrawingPatriarch();

            //Create an anchor that is attached to the worksheet
            ClientAnchor anchor = helper.createClientAnchor();
            //set top-left corner for the image
            anchor.setCol1(1);
            anchor.setRow1(i);

            //Creates a picture
            Picture pict = drawing.createPicture(anchor, pictureIdx);
            //Reset the image to the original size
            pict.resize();

            //Write the Excel file
            FileOutputStream fileOut = new FileOutputStream(file);
            wb.write(fileOut);

            fileOut.close();
            fileOut.close();

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
