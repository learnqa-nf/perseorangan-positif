package readFile;

import Config.Constants;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Main class
public class ReadTextFile {
    private String pthFileValidation = Constants.pthFileValidation;
    private String txtApp = Constants.txtAppIDV;
    private String txtRea = Constants.txtReaIDV;
    public String st = "";

    List<String> listOfStrings = new ArrayList<>();
    File folder = new File(pthFileValidation);
    File[] listOfFiles = folder.listFiles();
    String fileExcel = null;

    public String txtApp() throws IOException {

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains(txtApp)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }

        {
            File file = new File(pthFileValidation + fileExcel);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {
                st = st + s;
            }
        }
        return st;
    }


    public String txtRea() throws IOException {

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains(txtRea)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }

        {
            File file = new File(pthFileValidation + fileExcel);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {
                st = st + s;
            }
        }
        return st;
    }
}
