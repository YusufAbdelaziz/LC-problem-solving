class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 0) return 0;
        int count = 0;
        int n = nums.length;
        int windowProduct = 1;

        int i = 0;

        for(int j = 0; j < n; j++) {
            windowProduct *= nums[j];

            while(windowProduct >= k && i <= j) {
                windowProduct /= nums[i];
                i++;
            }

            count += j - i + 1;
        }

        return count;
    }
}