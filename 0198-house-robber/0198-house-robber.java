class Solution {
    private int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }
    
    
    private int dp(int[] nums, int start) {
        if(start >= nums.length) {
            return 0;
        }
        
        if(memo[start] != -1) return memo[start];
        
        int rob = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
        
        memo[start] = rob;
        
        return rob;
    }
}