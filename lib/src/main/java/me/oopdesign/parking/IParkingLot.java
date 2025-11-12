package me.oopdesign.parking;

public interface IParkingLot {

  void park(int spot, Car car);

  void remove(int spot);

  String print(int spot);

  int printFreeSpots();
}
