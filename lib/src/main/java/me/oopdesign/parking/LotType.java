package me.oopdesign.parking;

public enum LotType {
  REGULAR("Regular"),
  UNBOUNDED("Unbounded");

  private final String name;

  LotType(String name) {
    this.name = name;
  }

  public static LotType fromName(String name) {
    return switch (name) {
      case "Unbounded" -> UNBOUNDED;
      default -> REGULAR;
    };
  }

  @Override
  public String toString() {
    return this.name;
  }
}
