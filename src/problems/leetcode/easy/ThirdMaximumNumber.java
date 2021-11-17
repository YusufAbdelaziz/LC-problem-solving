package problems.leetcode.easy;

public class ThirdMaximumNumber {
  public int thirdMax(int[] nums) {
    if (nums == null)
      throw new IllegalArgumentException("Pass a valid array");
    if (nums.length == 0)
      throw new RuntimeException("Pass an occupied array");
    Integer firstMax = null, secondMax = null, thirdMax = null;
    for (int num : nums) {
      if (firstMax == null || num > firstMax) {
        thirdMax = secondMax;
        secondMax = firstMax;
        firstMax = num;
      } else if (num == firstMax) {
        continue;
      } else if (secondMax == null || num > secondMax) {
        thirdMax = secondMax;
        secondMax = num;
      } else if (num == secondMax) {
        continue;
      } else if (thirdMax == null || num > thirdMax) {
        thirdMax = num;
      }

    }
    if (thirdMax != null)
      return thirdMax;
    return firstMax;
  }
}