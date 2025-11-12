package me.oopdesign.parking;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
class ParkingSystemTest {

  ParkingSystem parkingSystem;

  @BeforeEach
  void setUp() {
    parkingSystem = new ParkingSystem();
  }

  @Test
  void testRegularParkingLot() {
    List<String> spots = List.of("Large", "Medium", "Small", "Large");
    List<List<String>> instructions = List.of(
        List.of("park", "1", "Small", "Silver", "BMW"),
        List.of("park", "1", "Large", "Black", "Nissan"),
        List.of("print", "1"),
        List.of("print", "2"),
        List.of("print", "3"),
        List.of("print_free_spots")
    );

    List<String> expected = List.of(
        "Small Silver BMW",
        "Empty",
        "Large Black Nissan",
        "2"
    );

    List<String> result = parkingSystem.operate("Regular", spots, instructions);

    assertArrayEquals(expected.toArray(), result.toArray());
  }

  @Test
  void testUnboundedParkingLot() {
    List<String> params = List.of("10", "2", "3", "4");
    List<List<String>> instructions = List.of(
        List.of("print_free_spots"),
        List.of("park", "3", "Large", "White", "BMW"),
        List.of("print_free_spots"),
        List.of("print", "6"),
        List.of("print", "8"),
        List.of("park", "6", "Medium", "Red", "Benz"),
        List.of("print_free_spots"),
        List.of("print", "8"),
        List.of("remove", "5"),
        List.of("print_free_spots")
    );

    List<String> expected = List.of(
        "2", "0", "Large White BMW", "Empty", "0", "Medium Red Benz", "1"
    );

    List<String> result = parkingSystem.operate("Unbounded", params, instructions);
    log.info("actual result is {}", result);

    for (int i = 0; i < result.size(); i++) {
      assertEquals(expected.get(i), result.get(i));
    }
//    assertArrayEquals(expected.toArray(), result.toArray());
  }
}