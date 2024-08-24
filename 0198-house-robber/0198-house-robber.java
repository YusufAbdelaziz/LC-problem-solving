class Solution {
    
    public int rob(int[] nums) {
        int n = nums.length;
        int dp1 = 0, dp2 = 0;
        // base case is dp[0] and dp[1] are 0.
        for(int i = 0; i < n; i++) {
            int temp = dp1;
            dp1 = Math.max(dp1, nums[i] +  dp2);
            dp2 = temp;
        }

        return dp1;
    }

}