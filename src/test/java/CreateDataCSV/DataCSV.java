package CreateDataCSV;

import Config.Constants;
import RandomValue.GenerateRandomDataApp;
import RandomValue.GenerateRandomDataRea;
import TestData.ReadTestData;
import com.opencsv.CSVWriter;
import formatFile.CSVFileName;
import writeFile.WriteTestData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataCSV {
    ArrayList<String[]> arrayData = new ArrayList<>();

    public void dataDummy(String case1, String case2) throws IOException {

        String nama_debitur, code_company, kode_produk, tanggal, jumlahData;
        String resultDataDummyFile = Constants.resultDataDummyFile;

        // call class generate random data
        GenerateRandomDataApp generateRandomDataApp = new GenerateRandomDataApp();

        // call class read excel
        ReadTestData readTestData = new ReadTestData();
        readTestData.testData();

        //date now
        String pattern = Constants.glPattern;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String fdate = simpleDateFormat.format(new Date());

        nama_debitur = String.valueOf(readTestData.cellDataValue[0]);
        code_company = String.valueOf(readTestData.cellDataValue[1]);
        kode_produk = String.valueOf(readTestData.cellDataValue[2]);
        jumlahData = String.valueOf(readTestData.cellDataValue[3]);
        tanggal = fdate;

        // first create file object for file placed at location
        // specified by filepath
        File fileApp = new File(resultDataDummyFile + case1 + Constants.extCSV);
        File fileRea = new File(resultDataDummyFile + case2 + Constants.extCSV);

        try {
            // create FileWriter object with file as parameter
            FileWriter outputfileApp = new FileWriter(fileApp);
            FileWriter outputfileRea = new FileWriter(fileRea);

            // create CSVWriter with '|' as separator
            CSVWriter writerApp = new CSVWriter(outputfileApp, '|',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
            CSVWriter writerRea = new CSVWriter(outputfileRea, '|',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            // create a List which contains String array
            ArrayList<String[]> dataApp = new ArrayList<>();
            dataApp.add(new String[]{"Nomor_Aplikasi", "NIK", "NPWP", "Jenis_Debitur", "Nama_Debitur", "Jangka_Waktu_Kredit", "Interest_Rate", "Plafon_Kredit", "Phone_Number", "Remark"});

            List<String[]> dataRea = new ArrayList<>();
            dataRea.add(new String[]{"Nomor Aplikasi", "Nama Debitur", "Jenis Debitur", "Gender Code", "NIK ", "Nomor NPWP", "Alamat", "Alamat_Kelurahan",
                    "Alamat_Kecamatan", "Alamat_KodePos", "Alamat_KodeDATI II", "Province", "No Telepon ", "Mobile Phone Number", "Email", "Place Of Birth",
                    "Tanggal lahir debitur", "Last Education Code", "Employer", "Employer Address", "Mother Maiden Name", "Religion", "Penghasilan Kotor per Bulan",
                    "Marital Status", "Nama Pasangan", "Tanggal Lahir Pasangan", "Perjanjian Pisah Harta", "No Akte", "Tanggal Berdiri", "No Akte Terakhir",
                    "Tanggal Akte Terakhir", "Bidang Usaha", "Jangka Waktu", "Jenis Kredit", "Plafon", "Interest Rate", "Nomor PK", "Tanggal Akad",
                    "Tanggal Angsuran I", "Jenis Penggunaan", "Sektor Ekonomi", "Omzet", "Go Public", "Sandi Golongan Debitur", "Penghasilan Kotor per Tahun",
                    "Bentuk Badan Usaha", "Tempat berdiri badan usaha", "Original Loan Amount", "Disbursement Date", "Tenor", "Segmentasi Debitur", "Pekerjaan",
                    "Debtor Category", "Income Source", "Jumlah_Tanggungan"});

            GenerateRandomDataRea generateRandomDataRea = new GenerateRandomDataRea();
            // CONDITIONAL BADAN USAHA OR INDIVIDU
            if (nama_debitur.contains("CORP")) {
                // write data csv approval
                for (int idxApp = 1; idxApp <= Integer.parseInt(jumlahData); idxApp++) {
                    dataApp.add(new String[]{code_company + generateRandomDataApp.nomorAplikasi(), "", generateRandomDataApp.npwp()
                            , generateRandomDataApp.jenisDebiturB(), nama_debitur + " " + generateRandomDataApp.namaDebitur() +" PT", generateRandomDataApp.jangkaWaktu(code_company)
                            , generateRandomDataApp.interestRate(code_company), "00000" + generateRandomDataApp.plafonKredit() + "000000000", "628" + generateRandomDataApp.phoneNumber(), "Tanggal Akad: " + fdate});

                }
                // write data csv realisasi
                arrayData = dataApp;

                int ix = 1;
                for (String[] reaData : arrayData) {
                    String fs = String.format("%012d", ix);
                    String kPos = String.format("%04d", ix);
                    String noTlpn = String.format("%03d", ix);

                    //System.out.println(reaData[ix]);
                    if (reaData[0] != "Nomor_Aplikasi" && reaData[1] != "NIK" && reaData[2] != "NPWP" && reaData[3] != "Jenis_Debitur" && reaData[4] != "Nama_Debitur"
                            && reaData[5] != "Jangka_Waktu" && reaData[6] != "Interest_Rate" && reaData[7] != "Plafon_Kredit" && reaData[8] != "Phone_Number" && reaData[9] != "Remark") {

                        dataRea.add(new String[]{reaData[0], reaData[4], reaData[3], "", reaData[1], reaData[2], "Jln Bougenvile Raya " + ix, "Kelurahan Kemuning " + ix,
                                "Kecamatan Amarilis " + ix, "40614", "0191", "Jawa Barat", "02145" + generateRandomDataRea.noTelepon(), "628" + generateRandomDataRea.mobilePhoneNumber(), nama_debitur + ix + "@gmail.com", "",
                                "", "", "", "", "", "", "",
                                "", "", "", "", "NO AKTE 00000001111"+ ix, "17081980", "NO AKTE 00000001111"+ ix, "17081980", generateRandomDataRea.bidangUsaha() + "00000", reaData[5], "P0" + generateRandomDataRea.jenisKredit(), reaData[7], reaData[6], "PK0" + generateRandomDataRea.noPK(), fdate,
                                generateRandomDataRea.angsuranPertama(code_company), generateRandomDataRea.jenisPenggunaan(), "111" + generateRandomDataRea.sektorEkonomi() + "0", "0000001" + generateRandomDataRea.omzet() + "000000000", "1", "S14", "",
                                "99", "Bumi Putra " + ix, reaData[7], "22042022", reaData[5], "0" + generateRandomDataRea.segmentasiDebitur(), "",
                                "UM", "", generateRandomDataRea.jumlahTanggungan()});
                    }
                    ix++;
                }
            }else{
                // write data csv approval
                for (int idxApp = 1; idxApp <= Integer.parseInt(jumlahData); idxApp++) {
                    dataApp.add(new String[]{code_company + generateRandomDataApp.nomorAplikasi(), "32732517089" + generateRandomDataApp.nik() + generateRandomDataApp.nik2(), generateRandomDataApp.npwp()
                            , generateRandomDataApp.jenisDebiturP(), nama_debitur + " " + generateRandomDataApp.namaDebitur(), generateRandomDataApp.jangkaWaktu(code_company)
                            , generateRandomDataApp.interestRate(code_company), "00000" + generateRandomDataApp.plafonKredit() + "000000000", "628" + generateRandomDataApp.phoneNumber(), "Tanggal Akad: " + fdate});

                }
                // write data csv realisasi
                arrayData = dataApp;

                int ix = 1;
                for (String[] reaData : arrayData) {
                    String fs = String.format("%012d", ix);
                    String kPos = String.format("%04d", ix);
                    String noTlpn = String.format("%03d", ix);

                    //System.out.println(reaData[ix]);
                    if (reaData[0] != "Nomor_Aplikasi" && reaData[1] != "NIK" && reaData[2] != "NPWP" && reaData[3] != "Jenis_Debitur" && reaData[4] != "Nama_Debitur"
                            && reaData[5] != "Jangka_Waktu" && reaData[6] != "Interest_Rate" && reaData[7] != "Plafon_Kredit" && reaData[8] != "Phone_Number" && reaData[9] != "Remark") {

                        dataRea.add(new String[]{reaData[0], reaData[4], reaData[3], generateRandomDataRea.genderCode(), reaData[1], reaData[2], "Jln Bougenvile Raya " + ix, "Kelurahan Kemuning " + ix,
                                "Kecamatan Amarilis " + ix, "40614", "0191", "Jawa Barat", "08" + generateRandomDataRea.noTelepon(), "628" + generateRandomDataRea.mobilePhoneNumber(), nama_debitur + ix + "@gmail.com", "Bandung",
                                "17081995", "0" + generateRandomDataRea.lastEducation(), "Company " + generateRandomDataRea.employer(), "Jln Asoka " + ix, "Maharani " + generateRandomDataRea.motherMaiden(), generateRandomDataRea.religion(), "0000000" + generateRandomDataRea.penghasilanKotor() + "00000000",
                                "1", "Dharma putra " + generateRandomDataRea.namaPasangan(), "17081990", "1", "", "", "", "", generateRandomDataRea.bidangUsaha() + "00000", reaData[5], "P0" + generateRandomDataRea.jenisKredit(), reaData[7], reaData[6], "PK0" + generateRandomDataRea.noPK(), fdate,
                                generateRandomDataRea.angsuranPertama(code_company), generateRandomDataRea.jenisPenggunaan(), "111" + generateRandomDataRea.sektorEkonomi() + "0", "0000001" + generateRandomDataRea.omzet() + "000000000", "1", "S14", "0000001" + generateRandomDataRea.penghasilanKotorPertahun() + "0000000",
                                "99", "Bumi Putra " + ix, reaData[7], "22042022", reaData[5], "0" + generateRandomDataRea.segmentasiDebitur(), "00" + generateRandomDataRea.kodePekerjaan(),
                                "UM", generateRandomDataRea.incomeSource(), generateRandomDataRea.jumlahTanggungan()});
                    }
                    ix++;
                }
            }
            System.out.println("Angsuran Pertama :" + generateRandomDataRea.angsuranPertama(code_company));
            System.out.println("Interest Rate :" + generateRandomDataApp.interestRate(code_company));
            System.out.println("Jangka Waktu :" + generateRandomDataApp.jangkaWaktu(code_company));

            writerApp.writeAll(dataApp);
            writerRea.writeAll(dataRea);
            // closing writer connection
            writerApp.close();
            writerRea.close();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        if (generateRandomDataApp.timeStamp == null) {
            generateRandomDataApp.timeStamp = "0";
        }
        WriteTestData writeTestData = new WriteTestData();
        writeTestData.writeData(generateRandomDataApp.timeStamp);
        // call class format file
        CSVFileName csvFileName = new CSVFileName();
        csvFileName.parseData(case1, case2, code_company, kode_produk, tanggal);
    }
}


