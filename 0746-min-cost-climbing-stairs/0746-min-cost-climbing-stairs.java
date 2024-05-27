class Solution {
    public int minCostClimbingStairs(int[] cost) {
    
       
        // Top-down approach or in-place method.
        // int n = cost.length;
//         for(int i = 2; i < n; i++) {
//             cost[i] += Math.min(cost[i - 1], cost[i - 2]);
//         }
        
//         return Math.min(cost[n - 1], cost[n - 2]);
        
        // DP array solution.
//         int n = cost.length;
//         int[] dp = new int[n + 2];
//         dp[n] = 0; 
        
//         for(int i = n - 1; i >= 0; i--) {
            
//                 dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
            
//         }
        
//         return Math.min(dp[0], dp[1]);
        
        int n = cost.length;
        for(int i = n - 3; i >= 0; i--) {
             cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }
        return Math.min(cost[0], cost[1]);
    }
    
}