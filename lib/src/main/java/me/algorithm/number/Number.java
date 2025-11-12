package me.algorithm.number;

public class Number {

  /*
   * a * b = lcm * gcd
   * */
  public static long lcm(long a, long b) {
    return (a * b) / gcd(a, b);
  }

  /**
   * base on the princial that two numbers have the same gcm with the smaller number and bigger
   * number module smaller we keep calculate the module of the bigger to smaller until we reach a 0
   */
  public static long gcd(long a, long b) {
    long min = Math.min(a, b);
    long max = Math.max(a, b);
    while (min > 0) {
      long t = min;
      min = max % min;
      max = t;
    }
    return max;
  }

  public static void main(String[] args) {
    long a = 15, b = 20;

    System.out.printf("the gcd of %d and %d should be %d, actual is %d\n", a, b, 5, gcd(15, 20));
    System.out.printf("the lcm of %d and %d should be %d, actual is %d\n", a, b, 60, lcm(15, 20));

  }
}
