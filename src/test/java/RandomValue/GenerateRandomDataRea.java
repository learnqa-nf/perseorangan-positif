package RandomValue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

public class GenerateRandomDataRea {

    public String genderCode() {
        String chars = "PL";
        int len = 1;
        Random rnd = new Random();
        StringBuilder genderCode = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            genderCode.append(chars.charAt(rnd.nextInt(chars.length())));
        return genderCode.toString();
    }

    public String noTelepon() {
        String chars = "086253787466123456789";
        int len = 5;
        Random rnd = new Random();
        StringBuilder noTelepon = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            noTelepon.append(chars.charAt(rnd.nextInt(chars.length())));
        return noTelepon.toString();
    }

    public String mobilePhoneNumber() {
        String chars = "1234567890";
        int len = 10;
        Random rnd = new Random();
        StringBuilder mobilePhoneNumber = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            mobilePhoneNumber.append(chars.charAt(rnd.nextInt(chars.length())));
        return mobilePhoneNumber.toString();
    }

    public String employer() {
        String chars = "XYZABC";
        int len = 3;
        Random rnd = new Random();
        StringBuilder employer = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            employer.append(chars.charAt(rnd.nextInt(chars.length())));
        return employer.toString();
    }

    public String motherMaiden() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int len = 2;
        Random rnd = new Random();
        StringBuilder motherMaiden = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            motherMaiden.append(chars.charAt(rnd.nextInt(chars.length())));
        return motherMaiden.toString();
    }

    public String religion() {
        String chars = "12345";
        int len = 1;
        Random rnd = new Random();
        StringBuilder religion = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            religion.append(chars.charAt(rnd.nextInt(chars.length())));
        return religion.toString();

    }

    public String penghasilanKotor() {
        String chars = "6789";
        int len = 2;
        Random rnd = new Random();
        StringBuilder penghasilanKotor = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            penghasilanKotor.append(chars.charAt(rnd.nextInt(chars.length())));
        return penghasilanKotor.toString();
    }

    public String namaPasangan() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int len = 2;
        Random rnd = new Random();
        StringBuilder namaPasangan = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            namaPasangan.append(chars.charAt(rnd.nextInt(chars.length())));
        return namaPasangan.toString();
    }
    public String lastEducation() {
        String chars = "12345";
        int len = 1;
        Random rnd = new Random();
        StringBuilder lastEducation = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            lastEducation.append(chars.charAt(rnd.nextInt(chars.length())));
        return lastEducation.toString();
    }

    public String bidangUsaha() {
        String chars = "123456789";
        int len = 1;
        Random rnd = new Random();
        StringBuilder bidangUsaha = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            bidangUsaha.append(chars.charAt(rnd.nextInt(chars.length())));
        return bidangUsaha.toString();
    }

    public String jenisKredit() {
        String chars = "123456789";
        int len = 1;
        Random rnd = new Random();
        StringBuilder jenisKredit = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            jenisKredit.append(chars.charAt(rnd.nextInt(chars.length())));
        return jenisKredit.toString();
    }
    public String noAkteB() {
        String chars = "123456789";
        int len = 5;
        Random rnd = new Random();
        StringBuilder jenisKredit = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            jenisKredit.append(chars.charAt(rnd.nextInt(chars.length())));
        return jenisKredit.toString();
    }

    public String noPK() {
        String chars = "123456789";
        int len = 5;
        Random rnd = new Random();
        StringBuilder noPK = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            noPK.append(chars.charAt(rnd.nextInt(chars.length())));
        return noPK.toString();
    }

    public String angsuranPertama(String v) {

        if (v.equals("L000030") || v.equals("L000132") || v.equals("L000040") || v.equals("L000001")) {
            String[] date1 = {"01", "02", "03", "04"};
            String[] date2 = {"05", "06", "07", "08", "09", "10", "11"};
            String[] date3 = {"12", "13", "14", "15", "16", "17", "18"};
            String[] date4 = {"19", "20", "21", "22", "23", "24", "25"};
            String[] date5 = {"26", "27", "28", "29", "30", "31"};

            String angsurCond1 = "26", angsurCond2 = "05", angsurCond3 = "12", angsurCond4 = "19", angsurCond5 = "26";

            LocalDate dt = LocalDate.now();
            String dtNow = dt.format(DateTimeFormatter.ofPattern("dd"));
//            String dtNow = "20";

            LocalDate today = LocalDate.now();
            String formattedToday = today.format(DateTimeFormatter.ofPattern("MMyyyy"));

            LocalDate nextMonth = today.plusMonths(1);
            String fnextMonth = nextMonth.format(DateTimeFormatter.ofPattern("MMyyyy"));


            if (Arrays.deepToString(date1).contains(dtNow)) {
                return angsurCond1 + formattedToday;

            } else if (Arrays.deepToString(date2).contains(dtNow)) {
                return angsurCond2 + fnextMonth;

            } else if (Arrays.deepToString(date3).contains(dtNow)) {
                return angsurCond3 + fnextMonth;

            } else if (Arrays.deepToString(date4).contains(dtNow)) {
                return angsurCond4 + fnextMonth;

            } else if (Arrays.deepToString(date5).contains(dtNow)) {
                return angsurCond5 + fnextMonth;

            }

        }else {
            LocalDate today = LocalDate.now();
            LocalDate nextMonth = today.plusMonths(1);
            String fnextMonth = nextMonth.format(DateTimeFormatter.ofPattern("MMyyyy"));
            return "25"+fnextMonth;
        }
        return "null";
    }

    public String jenisPenggunaan() {
        String chars = "123";
        int len = 1;
        Random rnd = new Random();
        StringBuilder jenisPenggunaan = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            jenisPenggunaan.append(chars.charAt(rnd.nextInt(chars.length())));
        return jenisPenggunaan.toString();
    }
    public String sektorEkonomi() {
        String chars = "134";
        int len = 1;
        Random rnd = new Random();
        StringBuilder sektorEkonomi = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            sektorEkonomi.append(chars.charAt(rnd.nextInt(chars.length())));
        return sektorEkonomi.toString();
    }
    public String omzet() {
        String chars = "23456789";
        int len = 1;
        Random rnd = new Random();
        StringBuilder omzet = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            omzet.append(chars.charAt(rnd.nextInt(chars.length())));
        return omzet.toString();
    }
    public String penghasilanKotorPertahun() {
        String chars = "23456789";
        int len = 1;
        Random rnd = new Random();
        StringBuilder penghasilanKotorPertahun = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            penghasilanKotorPertahun.append(chars.charAt(rnd.nextInt(chars.length())));
        return penghasilanKotorPertahun.toString();
    }
    public String segmentasiDebitur() {
        String chars = "1234";
        int len = 1;
        Random rnd = new Random();
        StringBuilder segmentasiDebitur = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            segmentasiDebitur.append(chars.charAt(rnd.nextInt(chars.length())));
        return segmentasiDebitur.toString();
    }
    public String kodePekerjaan() {
        String chars = "123456789";
        int len = 1;
        Random rnd = new Random();
        StringBuilder kodePekerjaan = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            kodePekerjaan.append(chars.charAt(rnd.nextInt(chars.length())));
        return kodePekerjaan.toString();
    }
    public String incomeSource() {
        String chars = "12";
        int len = 1;
        Random rnd = new Random();
        StringBuilder incomeSource = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            incomeSource.append(chars.charAt(rnd.nextInt(chars.length())));
        return incomeSource.toString();
    }
    public String jumlahTanggungan() {
        String chars = "12345";
        int len = 1;
        Random rnd = new Random();
        StringBuilder jumlahTanggungan = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            jumlahTanggungan.append(chars.charAt(rnd.nextInt(chars.length())));
        return jumlahTanggungan.toString();
    }
}
