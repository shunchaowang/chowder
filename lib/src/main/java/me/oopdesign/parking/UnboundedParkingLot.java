package me.oopdesign.parking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UnboundedParkingLot implements IParkingLot {

  boolean[] occupied;
  TreeMap<Integer, Car> parkings; // map car with the start of the parking interval
  private int size;
  private final Map<Size, Integer> sizeIntervalMap;

  public UnboundedParkingLot(List<String> params) { // n a b c

    size = Integer.parseInt(params.getFirst()); // we need to add 1 for the arrays
    sizeIntervalMap = new HashMap<>();
    sizeIntervalMap.put(Size.SMALL, Integer.parseInt(params.get(1)));
    sizeIntervalMap.put(Size.MEDIUM, Integer.parseInt(params.get(2)));
    sizeIntervalMap.put(Size.LARGE, Integer.parseInt(params.get(3)));
    occupied = new boolean[size + 1]; // default all is not occupied, we always ignore the 0th index
    parkings = new TreeMap<>();
  }

  // find the [i>=spot, i+car.size) lot to park the car.
  // we need make sure i is not occupied
  // every time a car is parked, i want to sort the parkings based on the start slot
  // the parking space take 1 more interval than the car's size, if the
  // car is 2, parked at 1, it will take [1,2,3]
  // total lots is [0..10], but there are 10 intervals
  // | | | | | | | | | | |
  // 0 1 2 3 4 5 6 7 8 9 10
  @Override
  public void park(int spot, Car car) {
    if (spot > size) {
      return;
    }
    // we got the start, need to check if we have enough spot for the car
    int carLength = sizeIntervalMap.get(car.size);
    // use a 2 pointer from the start to find the available interval
    // when start is available, move the end forward, until we get enought interval
    // when start is not available, move the start forward until we meet an available
    int start = spot;

    boolean found = false;
    while (!found) {
      while (start <= size && occupied[start]) {
        start++;
      }

      // there is no enough interval available
      if (start + carLength > size) { // since we have size+1, size is usable
        break;
      }

      int end = start;
      while (end <= size && end - start < carLength && !occupied[end]) {
        end++;
      }

      // we found the carLength interval

      // end is size

      if (end > size) {
        break; // there is not enough interval
      } else if (occupied[end]) {
        start = end + 1; // we didn't find enough interval, shift start to the right of end
      } else {
        found = true; // car can be parked in [start,end)
      }
    }

    if (!found) {
      return;
    }

    for (int i = start; i <= start + carLength; i++) {
      occupied[i] = true;
    }

    parkings.put(start, car);
  }

  @Override
  public void remove(int spot) {
    if (spot > size) {
      return;
    }

    Map.Entry<Integer, Car> parkingEntry = parkings.floorEntry(spot);
    if (parkingEntry == null) {
      return; // no parking
    }
    if (parkingEntry.getKey() + sizeIntervalMap.get(parkingEntry.getValue().size) < spot) {
      return; // the car is not large enough to cover the spot which parks closest to the spot
    }
    for (int i = parkingEntry.getKey();
        i <= parkingEntry.getKey() + sizeIntervalMap.get(parkingEntry.getValue().size); i++) {
      occupied[i] = false;
    }
    parkings.remove(parkingEntry.getKey());
    // reset the spots
  }

  @Override
  public String print(int spot) {
    if (spot > size) {
      return "Empty";
    }

    Map.Entry<Integer, Car> parkingEntry = parkings.floorEntry(spot);
    if (parkingEntry == null) {
      return "Empty";
    }

    // if the spot is not occupied
    if (parkingEntry.getKey() + sizeIntervalMap.get(parkingEntry.getValue().size) < spot) {
      return "Empty";
    }

    return parkingEntry.getValue().toString();
  }

  @Override
  public int printFreeSpots() {
    int count = 0;
    // get the large size
    int largeSize = sizeIntervalMap.get(Size.LARGE);

    // iterate all the spots, find the available interval and count it
    int i = 0;
    while (i <= size - largeSize) {
      while (occupied[i]) {
        i++; // find the first available spot
      }
      int intervalLength = 0;
      while (i <= size && !occupied[i]) {
        i++;
        intervalLength++;

        if (intervalLength == largeSize) {
          count++;
          intervalLength = 0;
        }
      }
    }

    return count;
  }
}
