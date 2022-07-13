class Solution {
    public int maximumProduct(int[] nums) {
        
        // Runtime : O(n log n)
        // Space : O(log n)
//         int length = nums.length;
        
//         Arrays.sort(nums);
        
//         return Math.max(nums[0] * nums[1] * nums[length - 1], nums[length - 1] * nums[length - 2] * nums[length - 3]);
         
   // }
        
    // Runtime : O(n).
    // Space : O(1).
    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
    int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    
    for (int n : nums){
        // Find the minimum value. if you find it, the old value would be the second minimum value.
        if(n <= min1){
            min2 = min1;
            min1 = n;
        // Find the second most minimum value;
        } else if(n <= min2){
            min2 = n;
        }
        
        if(n >= max1){
            max3 = max2;
            max2 = max1;
            max1 = n;
        } else if(n >= max2){
            max3 = max2;
            max2 = n;
        } else if(n >= max3){
            max3 = n;
        }
        
    }
    
    return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}