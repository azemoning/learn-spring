package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Integer duration;

        duration = 2;
        duration += 3;
        duration += 5;

        System.out.println(duration);

//        Relational Operator
        String person = "JK Rowling";

        if (person == "JK Rowling") {
            System.out.println("Writer of Harry Potter");
        } else {
            System.out.println("Not writer of Harry Potter");
        }

        int tax = 10;

        if (tax > 10) {
            System.out.println("Bayar tax nya");
        } else {
            System.out.println("Gausah bayar bre");
        }

//        Increment & Decrement
        ++tax;
        --tax;
        System.out.println(tax);

//        Ternary operator
        Integer month = 12;
        String result;
        result = (month == 11) ? "One Year" : "Not One Year";

        System.out.println(result);

//        Switch Case

        int day = 5;
        String dayName;

        switch (day) {
            case 1:
                dayName = "Senin";
                break;
            case 2:
                dayName = "Selasa";
                break;
            case 3:
                dayName = "Rabu";
                break;
            case 4:
                dayName = "Kamis";
                break;
            case 5:
                dayName = "Jum'at";
                break;
            case 6:
                dayName = "Sabtu";
                break;
            case 7:
                dayName = "Minggu";
                break;
            default:
                dayName = "Not a day";
                break;
        }
        System.out.println(dayName);


//        For Loops

        for (int i = 0; i < 2; i++) {
            System.out.println("[For] Ini angka: " + i);
        }

//        While Loops
        int i = 0, n = 2;
        while (i < n) {
            System.out.println("[While] Ini angka: " + i);

            i++;
        }

//        Task 1

        int[] angka = {1, 2, 3, 4, 5, 6, 7, 8, 9 ,10};
        ArrayList<String> angkaRomawi = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            switch (angka[j]) {
                case 1:
                    angkaRomawi.add("I");
                    break;
                case 2:
                    angkaRomawi.add("II");
                    break;
                case 3:
                    angkaRomawi.add("III");
                    break;
                case 4:
                    angkaRomawi.add("IV");
                    break;
                case 5:
                    angkaRomawi.add("V");
                    break;
                case 6:
                    angkaRomawi.add("VI");
                    break;
                case 7:
                    angkaRomawi.add("VII");
                    break;
                case 8:
                    angkaRomawi.add("VIII");
                    break;
                case 9:
                    angkaRomawi.add("IX");
                    break;
                case 10:
                    angkaRomawi.add("X");
                    break;
            }
        }

//        Task 2
        String[] namaSiswa = {"Marry", "Jane", "Peter", "Parker", "Harry", "Osborn"};
        for (int j = 0; j < namaSiswa.length; j++) {
            switch (namaSiswa[j]) {
                case "Marry":
                    System.out.println("Marry Jane Watson");
                    break;
                case "Peter":
                    System.out.println("Peter Parker");
                    break;
                case "Osborn":
                    System.out.println("Harry Osborn");
                    break;
            }
        }

//        Tugas Sesi 4

//        Tugas 1

        ArrayList<Integer> angkaRandoms = new ArrayList<>();
        angkaRandoms.add(12);
        angkaRandoms.add(34);
        angkaRandoms.add(56);
        angkaRandoms.add(57);
        angkaRandoms.add(23);
        angkaRandoms.add(35);
        angkaRandoms.add(68);

        System.out.println("For classic");
        for (int j = 0; j < angkaRandoms.size(); j++) {
            System.out.println(angkaRandoms.get(j));
        }

        System.out.println("For each");
        for (int angkaRandom : angkaRandoms) {
            System.out.println(angkaRandom);
        }

//        Tugas 2

        String[] angkaBulan = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        for (int j = 0; j < angkaBulan.length; j++) {
            switch (angkaBulan[j]) {
                case "1":
                    angkaBulan[j] = "January";
                    break;
                case "2":
                    angkaBulan[j] = "February";
                    break;
                case "3":
                    angkaBulan[j] = "March";
                    break;
                case "4":
                    angkaBulan[j] = "April";
                    break;
                case "5":
                    angkaBulan[j] = "May";
                    break;
                case "6":
                    angkaBulan[j] = "June";
                    break;
                case "7":
                    angkaBulan[j] = "July";
                    break;
                case "8":
                    angkaBulan[j] = "August";
                    break;
                case "9":
                    angkaBulan[j] = "September";
                    break;
                case "10":
                    angkaBulan[j] = "October";
                    break;
                case "11":
                    angkaBulan[j] = "November";
                    break;
                case "12":
                    angkaBulan[j] = "December";
                    break;
            }
        }
    }
}
