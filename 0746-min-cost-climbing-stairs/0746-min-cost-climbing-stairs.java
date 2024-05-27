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
        
        // Same as first one but in reverse if you start from the floor.
        // int n = cost.length;
        // for(int i = n - 3; i >= 0; i--) {
        //      cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        // }
        // return Math.min(cost[0], cost[1]);
        
        int n = cost.length;
        
        int s1 = 0;
        int s2 = cost[n - 1];
        
        for(int i = n - 2; i >= 0; i--) {
            int temp = s2;
            s2 = cost[i] + Math.min(s2, s1);
            s1 = temp;
        }
        
        return Math.min(s1, s2);
    }
    
}