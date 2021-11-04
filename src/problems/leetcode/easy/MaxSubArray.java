package src.problems.leetcode.easy;

public class MaxSubArray {
  // Kadane's algorithm.
  public int maxSubArray(int[] nums) {
    int currentMax, finalMax;
    currentMax = finalMax = nums[0];
    for (int i = 1; i < nums.length; i++) {
      currentMax = Math.max(nums[i], nums[i] + currentMax);
      if (currentMax > finalMax)
        finalMax = currentMax;
    }

    return finalMax;
  }
}
