package me.oopdesign.parking;

import java.util.HashMap;
import java.util.Map;

public class Constants {

  public static Map<Size, Integer> SIZE_MAP = new HashMap<>();

  static {
    SIZE_MAP.put(Size.SMALL, 1);
    SIZE_MAP.put(Size.MEDIUM, 2);
    SIZE_MAP.put(Size.LARGE, 3);
  }
}
