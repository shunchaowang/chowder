package me.algorithm.dp.linearsequenceconstanttransition;

public final class Fibonacci {

  public static long fib(int n) {
    // fib(0) = 0, fib(1) = 1, fib(n) = fib(n-1) + fib(n-2)
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }

    long numPrev = 1;
    long numPPrev = 0;
    for (int i = 2; i <= n; i++) {
      long numCurr = numPrev + numPPrev;
      numPPrev = numPrev;
      numPrev = numCurr;
    }

    return numPrev;
  }

  public static void main(String[] args) {

    long f10 = fib(10);
    System.out.printf("Fib 10 should be 55, actual is %d\n", f10);
  }
}
