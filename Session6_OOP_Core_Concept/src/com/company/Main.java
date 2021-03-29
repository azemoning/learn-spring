package com.company;

public class Main {

    public static void main(String[] args) {

      Tesla tesla = new Tesla(0,0);

      /*Change gear*/
      tesla.changeGear(1);

      /*Add speed*/
      tesla.speedUp(10);

      /*Get current speed and gear*/
      System.out.println("Current tesla speed: " + tesla.getSpeed());
      System.out.println("Current tesla gear: " + tesla.getGear());

      /*Brake speed*/
      tesla.applyBrake(5);


    }
}
