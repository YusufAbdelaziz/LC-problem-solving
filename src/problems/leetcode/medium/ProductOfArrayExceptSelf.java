package problems.leetcode.medium;

// 238.
public class ProductOfArrayExceptSelf {
  class Solution {
    public int[] productExceptSelf(int[] nums) {
      // O(n) runtime.
      // O(n) space.
      // int n = nums.length;
      /*
       * Divide the products that are on the left and right of a specific item into
       * two separate arrays.
       */
      // int[] leftProducts = new int[n];
      // int[] rightProducts = new int[n];
      // int[] outputArr = new int[n];

      // leftProducts[0] = 1; // Since there's no element to the left of the first
      // element.
      // rightProducts[n - 1] = 1; // Since there's no element to the right of the
      // last element.

      // for(int i = 1; i < n ; i++){
      // leftProducts[i] = nums[i - 1] * leftProducts[i - 1];
      // }

      // for(int i = n - 2 ; i >= 0 ; i --){

      // rightProducts[i] = nums[i + 1] * rightProducts[i + 1];
      // }

      // for(int i = 0 ; i < n ;i++){
      // outputArr[i] = leftProducts[i] * rightProducts[i];
      // }

      // return outputArr;

      // O(n) runtime.
      // O(1) space (since the output array doesn't count as stated).
      int n = nums.length;
      int[] outputArr = new int[n];

      outputArr[0] = 1; // Here we'll do the same as we did in the left products.

      for (int i = 1; i < n; i++) {
        outputArr[i] = outputArr[i - 1] * nums[i - 1];
      }

      int postfix = 1;

      for (int i = n - 1; i >= 0; i--) {
        outputArr[i] = outputArr[i] * postfix;
        postfix *= nums[i];
      }

      return outputArr;
    }
  }
}
