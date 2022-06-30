package generateDefinitions;

import Config.Constants;
import io.cucumber.java.en.Given;
import readFile.ReadExcel;

public class Validation {

	@Given("Provide file Excel compare {string}")
	public void provide_file_excel_compare(String tCase) {

			if(tCase.contains(Constants.appFile)) {
				ReadExcel readExcelApp = new ReadExcel();
				readExcelApp.caseReadExcelApp();

			}else if (tCase.contains(Constants.reaFile)) {
				ReadExcel readExcelRea = new ReadExcel();
				readExcelRea.caseReadExcelRea();

			}
	}
}
