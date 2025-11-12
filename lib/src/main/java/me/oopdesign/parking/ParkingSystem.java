package me.oopdesign.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingSystem {

  private Map<String, LotType> typeNameMap;

  /**
   * lot_type: The type of parking lot this is, whether it's "Regular" or "Unbounded". params: A
   * list of strings. The content is different depending on the type of parking lot this is.
   * "Regular" parking lot: A list of strings representing the size of the parking spots from spot 0
   * to n - 1. "Unbounded" parking lot: [n, a, b, c], integers defining the size of the parking lot,
   * small car, medium car, and large car, respectively. instructions: A string matrix representing
   * the instructions.
   */
  public List<String> operate(String lotType, List<String> params,
      List<List<String>> instructions) {

    IParkingLot parkingLot;
    if (lotType.equals("Regular")) {
      parkingLot = new RegularParkingLot(params);
    } else if (lotType.equals("Unbounded")) {
      parkingLot = new UnboundedParkingLot(params);
    } else {
      return List.of();
    }

    List<String> res = new ArrayList<>();

    for (List<String> i : instructions) {
      String comm = i.get(0);

      switch (comm) {
        case "park":
          parkingLot.park(Integer.parseInt(i.get(1)), new Car(i.get(2), i.get(3), i.get(4)));
          break;
        case "remove":
          parkingLot.remove(Integer.parseInt(i.get(1)));
          break;
        case "print":
          res.add(parkingLot.print(Integer.parseInt(i.get(1))));
          break;
        case "print_free_spots":
          res.add(String.valueOf(parkingLot.printFreeSpots()));
          break;
        default:
          break;

      }
    }
    return res;
  }
}
