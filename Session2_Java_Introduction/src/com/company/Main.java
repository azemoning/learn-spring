package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task 1
        System.out.println("Task 1 - Print");
        System.out.println("Saya belajar Java di SYNRGY Academy");

        // Task 2
        System.out.println("Task 2 - Input Nama");
        System.out.println("Masukkan nama:");
        String nama = scanner.next();

        System.out.println(nama);

        // Task 3
        System.out.println("Task 3 - Penjumlahan");
        System.out.println("Masukkan angka pertama: ");
        int task3AngkaPertama = scanner.nextInt();

        System.out.println("Masukkan angka kedua: ");
        int task3AngkaKedua = scanner.nextInt();

        System.out.println(task3AngkaPertama + task3AngkaKedua);

        // Task 4
        System.out.println("Task 4 - Modulus");
        System.out.println("Masukkan angka pertama: ");
        int task4AngkaPertama = scanner.nextInt();

        System.out.println("Masukkan angka kedua: ");
        int task4AngkaKedua = scanner.nextInt();

        System.out.println(task4AngkaPertama % task4AngkaKedua);


        // Tugas
        // Tugas 1
        System.out.println("Tugas 1");
        System.out.println("Aku selama belajar di Synrgy Academy sangat menyenangkan");

        // Tugas 2
        System.out.println("Tugas 2");
        System.out.println("Masukkan angka pertama: ");
        int tugas2AngkaPertama = scanner.nextInt();

        System.out.println("Masukkan angka kedua: ");
        int tugas2AngkaKedua = scanner.nextInt();

        int pembagian = tugas2AngkaPertama / tugas2AngkaKedua;
        System.out.println("Operasi Pembagian: " + pembagian);

        int perkalian = tugas2AngkaPertama * tugas2AngkaKedua;
        System.out.println("Operasi Perkalian: " + perkalian);

        int modulo = tugas2AngkaPertama / tugas2AngkaKedua;
        System.out.println("Operasi Modulo: " + modulo);

    }
}
