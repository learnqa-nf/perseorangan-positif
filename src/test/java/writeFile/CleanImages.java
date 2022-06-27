package writeFile;

import Config.Constants;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

public class CleanImages {
    private String pthFileValidation = Constants.pthFileValidation + Constants.fileNMScenario;
    public void cleanAllImages() {
        //Create a Workbook object
        try {
            Workbook workbook = new Workbook();
            //Load an Excel file
            workbook.loadFromFile(pthFileValidation);
            Worksheet sheet = workbook.getWorksheets().get(Constants.sheetImages);

            if (sheet.getPictures().getCount() != 0) {
                for (int i = sheet.getPictures().getCount() - 1; i >= 0; i--) {
                    sheet.getPictures().get(i).remove();
                }
            }

            workbook.save();

        }catch (Exception e){
            e.getMessage();
        }
    }
}
