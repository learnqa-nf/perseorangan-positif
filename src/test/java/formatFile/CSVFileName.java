package formatFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import Config.Constants;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CSVFileName {
    public void parseData(String case1, String case2, String nomor_aplikasi, String kode_produk, String tanggal) {

        String resultDataDummyFile = Constants.resultDataDummyFile;

        try {
            File fileApp = new File(resultDataDummyFile + case1 + Constants.extCSV);
            File fileRea = new File(resultDataDummyFile + case2 + Constants.extCSV);

            fileApp.renameTo(new File(resultDataDummyFile + case1 + "_" + nomor_aplikasi + "_" + kode_produk + "_" + tanggal + Constants.extCSV));
            fileRea.renameTo(new File(resultDataDummyFile + case2 + "_"  + nomor_aplikasi + "_" + kode_produk + "_" + tanggal + Constants.extCSV));

        } catch (Exception ex) {
            System.out.println("gagal");
        }
    }
}
