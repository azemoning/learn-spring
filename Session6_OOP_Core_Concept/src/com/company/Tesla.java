package com.company;

public class Tesla implements Car {

  private int gear;
  private int speed;

  public Tesla(int gear, int speed) {
    this.gear = gear;
    this.speed = speed;
  }

  @Override
  public int changeGear(int gear) {
    return this.gear + gear;
  }

  @Override
  public int speedUp(int speed) {
    return this.speed + speed;
  }

  @Override
  public int applyBrake(int brakeSpeed) {
    return this.speed - brakeSpeed;
  }

  public int getGear() {
    return gear;
  }

  public void setGear(int gear) {
    this.gear = gear;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }
}
