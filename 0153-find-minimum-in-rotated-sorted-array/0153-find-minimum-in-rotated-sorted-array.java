class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        
        int min = Integer.MAX_VALUE;
        
        while(l <= r) {
            
            int mid = l + ((r - l) >>> 1);
            min = Math.min(min, nums[mid]);
            
            if(nums[mid] >= nums[l]) {
                // Note that since the left half is sorted, just check the
                // leftmost element which must be smaller than the middle element.
                // After that, go and conquer the right half.
                min = Math.min(min, nums[l]);
                l = mid + 1;
            }
            
            else {
                // In case the right half is sorted, then pick the smallest element, which is the
                // middle one and then conquer the left half.
                min = Math.min(min, nums[mid]);
                r = mid - 1;
            }
            
        }
        
        return min;
    }
}