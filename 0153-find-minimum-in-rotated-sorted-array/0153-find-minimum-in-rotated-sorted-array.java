class Solution {
    public int findMin(int[] nums) {
        
        int minElement = Integer.MAX_VALUE;
        
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r) {
            if (nums[l] <= nums[r]) {
                return nums[l];
            }

            int mid = l + ((r - l) >>> 1);
            minElement = Math.min(nums[mid], minElement);
            if(nums[mid] >= nums[l]) l = mid + 1;
            else r = mid;
        }
        
        return minElement;
    }
} 