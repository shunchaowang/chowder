package me.algorithm.string;

import java.util.Arrays;
// import static java.util.Arrays.*;

public class StringPermutation {

  public static void main(String[] args) {
    boolean permutated = testBySorting("aer", "rea");
    System.out.println(permutated);
  }

  private static boolean testBySorting(String str1, String str2) {
    char[] str1Array = str1.toCharArray(), str2Array = str2.toCharArray();
    Arrays.sort(str1Array);
    Arrays.sort(str2Array);
    return (Arrays.toString(str1Array)).equals(Arrays.toString(str2Array));
  }
}
