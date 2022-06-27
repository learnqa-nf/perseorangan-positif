package readFile;

import Config.Constants;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
    String namaDdebitur;
    String nomorAplikasi;
    String pthFileValidation = Constants.pthFileValidation;
    String txtRea = Constants.csvRea;
    String txtApp = Constants.csvApp;
    public String[] value2 = null;

    public String[] fileCSVApp(int idxNomorAplikasi) throws IOException {


        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(pthFileValidation);
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains(txtApp)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(pthFileValidation + fileExcel);
        // Created a string to store each character to form word
        String s = new String();
        char ch;

        // checking for EOF
        while (fr.ready()) {
            ch = (char) fr.read();
            // Used to specify the delimiters
            if (ch == '|' || ch == '\n') {
                // Storing each string in arraylist
                listOfStrings.add(s.toString());
                // clearing content in string
                s = new String();
            } else {
                // appending each character to string if the current character is not delimiter
                s += ch;
            }
        }
        if (s.length() > 0) {
            // appending last line of strings to list
            listOfStrings.add(s.toString());
        }
        // storing the data in arraylist to array
        String[] array = listOfStrings.toArray(new String[0]);
        // printing each line of file which is stored in array


        for (String ignored : array) {
//            if (idxNomorAplikasi < array.length) {
            nomorAplikasi = array[idxNomorAplikasi];

            String[] value = new String[2];
            value[0] = nomorAplikasi;
            value2 = value;

//            }
        }
        return value2;
    }

    public String[] fileCSVRea(int idxNomorAplikasi) throws IOException {


        List<String> listOfStrings = new ArrayList<>();
        File folder = new File(pthFileValidation);
        File[] listOfFiles = folder.listFiles();
        String fileExcel = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {

                if (listOfFiles[i].getName().contains(txtRea)) {
                    fileExcel = listOfFiles[i].getName();
                }
            }
        }
        FileReader fr = new FileReader(pthFileValidation + fileExcel);
        // Created a string to store each character to form word
        String s = new String();
        char ch;

        // checking for EOF
        while (fr.ready()) {
            ch = (char) fr.read();
            // Used to specify the delimiters
            if (ch == '|' || ch == '\n') {
                // Storing each string in arraylist
                listOfStrings.add(s.toString());
                // clearing content in string
                s = new String();
            } else {
                // appending each character to string if the current character is not delimiter
                s += ch;
            }
        }
        if (s.length() > 0) {
            // appending last line of strings to list
            listOfStrings.add(s.toString());
        }
        // storing the data in arraylist to array
        String[] array = listOfStrings.toArray(new String[0]);
        // printing each line of file which is stored in array


        for (String ignored : array) {
//            if (idxNomorAplikasi <= array.length) {
            nomorAplikasi = array[idxNomorAplikasi];

            String[] value = new String[2];
            value[0] = nomorAplikasi;
            value2 = value;

//            }
        }
        return value2;
    }
}


