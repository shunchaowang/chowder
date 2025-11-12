package me.oopdesign.parking;

public class Spot extends ParkingSize {

  int number;
  Size size;
  Car car;

  public Spot(int number, String size) {
    this.number = number;
    this.size = Size.fromDisplayName(size);
  }

  @Override
  public int getValue() {
    return Constants.SIZE_MAP.get(size);
  }

  public void parkCar(Car car) {
    this.car = car;
  }

  public Car getCar() {
    return car;
  }

  public void removeCar() {
    this.car = null;
  }

  public boolean isAvailable(Car carToPark) {
    return this.car == null && compareTo(carToPark) >= 0;
  }
}
