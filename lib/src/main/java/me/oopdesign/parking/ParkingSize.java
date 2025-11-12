package me.oopdesign.parking;

public abstract class ParkingSize implements Comparable<ParkingSize> {

  public abstract int getValue();

  @Override
  public int compareTo(ParkingSize o) {
    return Integer.compare(this.getValue(), o.getValue());
  }

}
