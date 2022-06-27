package generateDefinitions;

import CreateDataCSV.DataCSV;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class CreateCSV {

    @Given("Create Scenario {string}{string}")
    public void create_scenario(String case1, String case2) throws IOException {

        System.out.println("APPFILE Generating");
        System.out.println("REAFILE Generating");

        DataCSV dataCSV = new DataCSV();
        dataCSV.dataDummy(case1, case2);
    }
}

