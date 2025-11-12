package me.oopdesign.parking;

public enum Size {

  SMALL("Small"), MEDIUM("Medium"), LARGE("Large");

  private final String displayName;

  Size(String displayName) {
    this.displayName = displayName;
  }

  @Override
  public String toString() {
    return this.displayName;
  }

  public static Size fromDisplayName(String displayName) {
    return switch (displayName) {
      case "Small" -> SMALL;
      case "Large" -> LARGE;
      default -> MEDIUM;
    };
  }
}
