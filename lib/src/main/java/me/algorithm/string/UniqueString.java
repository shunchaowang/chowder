package me.algorithm.string;

public class UniqueString {

  public static void main(String[] args) {
    System.out.println(isStrUnique("abadhgfhde"));
  }

  private static boolean isStrUnique(String str) {
    if (str == null || str.length() == 0) {
      return true;
    }

    int[] charArray = new int[128];
    for (int i = 0; i < charArray.length; i++) {
      charArray[i] = 0;
    }

    for (int i = 0; i < str.length(); i++) {
      int c = str.charAt(i);
      if (++charArray[c] > 1) {
        return false;
      }
    }

    return true;
  }
}
