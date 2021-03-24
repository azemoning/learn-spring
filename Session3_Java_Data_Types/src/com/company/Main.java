package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        Primitive data type
//        Boolean
        boolean status = true;
        System.out.println(status);

//        Char
        char initial = 'U';
        System.out.println(initial);

//        Integer
        int number = 12;
        System.out.println(number);

//        Byte
        byte byteNumber = 127;
        System.out.println(byteNumber);

//        Float
        float floatNumber = 1.045f;

//        Non-primitive data type
//        Boolean
        Boolean isChecked = true;
        System.out.println(isChecked);

//        String
        String nickname = "Upi";
        System.out.println(nickname);

//        Integer
        Integer numberOne = 15;
        System.out.println(numberOne);

//        Array
//        Static Array
        int[] arr = new int[5];
        arr[0] = 10;
        arr[1] = 15;

        System.out.println(arr[0]);
        System.out.println(arr[1]);

//        Dynamic Array
        ArrayList<Integer> dynamicArr = new ArrayList<Integer>();
        dynamicArr.add(1);
        dynamicArr.add(2);
        System.out.println(dynamicArr);

//        Task 1
        ArrayList<String> buah = new ArrayList<>();
        buah.add("Semangka");
        buah.add("Pisang");
        buah.add("Apel");
        buah.add("Jambu");

        System.out.println("Koleksi buah: " + buah);

//        Task 2
        String quote = "Belajar adalah mempelajari kehidupan";
        System.out.println(quote);

//        Task 3
        long tangki = 1490L;
        System.out.println(tangki);

//        Task 4
        float tangki2 = 14.9F;
        System.out.println(tangki2);

//        Task 5
        Integer umurAnak = 13;
        Double umurAyah = 20.0;
        System.out.println(umurAnak + umurAyah);

//        Task 6
        Integer exponensial = 12;
        Double divider = 25.0;
        System.out.println(exponensial / divider);

//        Task 7
//        String fullName = 'Saya guud looking bro';
        String fullName = "Saya guud looking bro";
        System.out.println(fullName);

//        Tugas Sesi 3

        System.out.println("Toko buku kota X");

        ArrayList<String> koleksiBuku = new ArrayList<>();
        koleksiBuku.add("Harry Potter");
        koleksiBuku.add("Telenovela");
        koleksiBuku.add("Pirate and The Carribean");
        koleksiBuku.add("Crows Zero");

        System.out.println("Koleksi Buku: " + koleksiBuku);
    }
}
