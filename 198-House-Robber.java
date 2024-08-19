class Solution {
    
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        // base case is dp[0] and dp[1] are 0.
        for(int i = 2; i - 2 < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 2] +  dp[i - 2]);
        }

        return dp[n + 1];
    }

}