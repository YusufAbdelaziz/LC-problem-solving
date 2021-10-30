package src.problems.leetcode.easy;

public class DifferenceOfSumAndProduct {
  public int subtractProductAndSum(int n) {
    int copiedN = n;

    int sum = 0, product = 1;
    while (n > 0) {
      int digit = n % 10;
      sum += digit;
      n /= 10;
    }
    while (copiedN > 0) {
      int digit = copiedN % 10;
      product *= digit;
      copiedN /= 10;
    }

    return product - sum;
  }
}
