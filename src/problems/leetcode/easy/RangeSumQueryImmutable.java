package src.problems.leetcode.easy;

public class RangeSumQueryImmutable {
  class NumArray {

    private int[] prefixSum;

    public NumArray(int[] nums) {
      prefixSum = new int[nums.length];

      for (int i = 0; i < nums.length; i++) {
        prefixSum[i] = nums[i];
        if (i > 0) {
          prefixSum[i] += prefixSum[i - 1];
        }
      }
    }

    public int sumRange(int left, int right) {
      int sum = prefixSum[right];
      if (left > 0) {
        sum -= prefixSum[left - 1];
      }
      return sum;
    }
  }
}
