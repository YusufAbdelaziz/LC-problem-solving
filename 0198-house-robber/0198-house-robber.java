class Solution {
    private int[] memo;
    public int rob(int[] nums) {
        int d1 = 0, d2 = 0;
        
        for(int i = nums.length - 1; i >= 0; i--) {
            int temp = d2;
            d2 = Math.max(d2, nums[i] + d1);
            d1 = temp;
        }

        return d2;
    }
    
    // Top-down approach with memo table
//     private int dp(int[] nums, int start) {
//         if(start >= nums.length) {
//             return 0;
//         }
        
//         if(memo[start] != -1) return memo[start];
        
//         int rob = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
        
//         memo[start] = rob;
        
//         return rob;
//     }
}