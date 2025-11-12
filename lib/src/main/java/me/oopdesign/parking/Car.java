package me.oopdesign.parking;

public class Car extends ParkingSize {

  Size size;
  String color;
  String brand;

  public Car(String size, String color, String brand) {
    this.size = Size.fromDisplayName(size);
    this.color = color;
    this.brand = brand;
  }

  @Override
  public int getValue() {
    return Constants.SIZE_MAP.get(size);
  }

  @Override
  public String toString() {
    return String.format("%s %s %s", size.toString(), color, brand);
  }
}
