package com.company;

class Kucing {

    public String suara(String suara) {
        return suara;
    }

    public static void jalan() {
        System.out.println("Berjalan...");
    }

    public void tampilGunung() {
        lihatGunung();
    }

    protected void lihatGunung() {
        System.out.println("Hello Gunung Merapi");
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
//        non-static method
        Kucing kucing = new Kucing();
        System.out.println(kucing.suara("Meong meong"));
        kucing.tampilGunung();

//        static method
        Kucing.jalan();

//        Task 1
        Task1 task1 = new Task1();

        Task1.toLowerCase("UPI");
        System.out.println(task1.toUpperCase("upi"));

//        Task 2
        Task2 task2 = new Task2();

        System.out.println(task2.reverseText("upi"));

//        Task 3
        Task3 task3 = new Task3();
        System.out.println(task3.addToArray(5));
        System.out.println(task3.addToArray(10));
    }
}
