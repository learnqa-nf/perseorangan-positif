package RandomValue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenerateRandomDataApp {
public String timeStamp;
    public String nomorAplikasi() {

        String pattern = "HHmmss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String fdate = simpleDateFormat.format(new Date());
        timeStamp = fdate;
        String chars = "123ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int len = 4;
        Random rnd = new Random();
        StringBuilder nomoraplikasi = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            nomoraplikasi.append(chars.charAt(rnd.nextInt(chars.length())));
        return nomoraplikasi +timeStamp;
    }

    public String nik() {
        String chars = "01234567";
        int len = 1;
        Random rnd = new Random();
        StringBuilder nik = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            nik.append(chars.charAt(rnd.nextInt(chars.length())));
        return nik.toString();
    }
    public String nik2() {
        String chars = "123456789";
        int len = 4;
        Random rnd = new Random();
        StringBuilder nik = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            nik.append(chars.charAt(rnd.nextInt(chars.length())));
        return nik.toString();
    }

    public String npwp() {
        String chars = "1234567891111213141516171819234";
        int len = 15;
        Random rnd = new Random();
        StringBuilder npwp = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            npwp.append(chars.charAt(rnd.nextInt(chars.length())));
        return npwp.toString();

    }

    public String jenisDebiturP() {
        String chars = "P";
        int len = 1;
        Random rnd = new Random();
        StringBuilder jenisdebitur = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            jenisdebitur.append(chars.charAt(rnd.nextInt(chars.length())));
        return jenisdebitur.toString();
    }
    public String jenisDebiturB() {
        String chars = "B";
        int len = 1;
        Random rnd = new Random();
        StringBuilder jenisdebitur = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            jenisdebitur.append(chars.charAt(rnd.nextInt(chars.length())));
        return jenisdebitur.toString();
    }

    public String namaDebitur() {

//        String pattern = "HHmm";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String fdate = simpleDateFormat.format(new Date());

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int len = 4;
        Random rnd = new Random();
        StringBuilder namadebitur = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            namadebitur.append(chars.charAt(rnd.nextInt(chars.length())));
        return namadebitur + timeStamp;
    }

    public String jangkaWaktu(String v) {
        String jangkaWaktu;
        switch (v) {
            case "L000030":
            case "L000132":
            case "L000040":
            case "L000001":
                jangkaWaktu = "006";
                return jangkaWaktu;
            case "L000133":
            case "L000004":
                jangkaWaktu = "036";
                return jangkaWaktu;
        }
        return null;
    }

    public String interestRate(String v) {
        String interestRate;
        switch (v) {
            case "L000030":
            case "L000132":
            case "L000040":
            case "L000001":
                interestRate = "01475";
                return interestRate;
            case "L000133":


                interestRate = "01125";
                return interestRate;
            case "L000004":
                interestRate = "01025";
                return interestRate;
        }
        return null;
    }

    public String plafonKredit() {
        String chars = "56";
        int len = 1;
        Random rnd = new Random();
        StringBuilder plafonkredit = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            plafonkredit.append(chars.charAt(rnd.nextInt(chars.length())));
        return plafonkredit.toString();

    }

    public String phoneNumber() {
        String chars = "81998765432";
        int len = 10;
        Random rnd = new Random();
        StringBuilder phoneNumber = new StringBuilder(len);

        for (int i = 0; i < len; i++)
            phoneNumber.append(chars.charAt(rnd.nextInt(chars.length())));
        return phoneNumber.toString();
    }
}
