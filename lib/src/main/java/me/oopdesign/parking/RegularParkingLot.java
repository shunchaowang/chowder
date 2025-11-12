package me.oopdesign.parking;

import java.util.ArrayList;
import java.util.List;

public class RegularParkingLot implements IParkingLot {

  private final List<Spot> spots;
  private int available;

  public RegularParkingLot(List<String> sizes) {
    available = sizes.size();
    this.spots = new ArrayList<>();
    // match all the sizes with the Spot
    for (int i = 0; i < sizes.size(); i++) {
      spots.add(new Spot(i, sizes.get(i)));
    }
  }

  public void park(int spot, Car car) {
    if (spot < 0 || spot >= spots.size() || available == 0) {
      return;
    }

    // find the available spot after the spot, return if no spot available
    int location = spot;
    while (!spots.get(location).isAvailable(car)) {
      location = (location + 1) % spots.size();

      if (location == spot) {
        return;
      }
    }

    spots.get(location).parkCar(car);
    available--;
  }

  public void remove(int spot) {
    if (spot < 0 || spot >= spots.size()) {
      return;
    }
    spots.get(spot).removeCar();
    available++;
  }

  public String print(int spot) {
    if (spot < 0 || spot >= spots.size()) {
      return "Empty";
    }
    Car car = spots.get(spot).getCar();
    return car == null ? "Empty" : car.toString();
  }

  public int printFreeSpots() {
    return available;
  }
}
