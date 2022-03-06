class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        
        int n = nums.length;
        boolean hasOne = false;
        // Step 1 : Flip all negative values or greater than the range [1, n+1] to 1.
        // Make sure to not overwriting an existing 1 value in your array.
        for(int i = 0 ; i < n ; i ++){
            if(nums[i] == 1) hasOne = true;
            else if(nums[i] > n || nums[i] <= 0) nums[i] = 1;
        }
        
       
        if(!hasOne) return 1;
        
        // Step 2 : Change all the numbers and make them negative.
        for(int i = 0 ; i < n ; i ++){
            // Absolute value is used as you may encounter a negative number, but
            // we're using index variable as an index obviously.
            // Subtracting one is necessary to make the index 0-based.
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) nums[index] = -1 * nums[index];
        }
        
        // Step 3 : Find the first number that is a positive number.
        
        for(int i = 0 ; i < n ; i ++){
            if(nums[i] > 0) return i + 1;
        }
        
        // In case you have [1, 2, 3], the first missing positive is 4.
        return n + 1;
    }
}