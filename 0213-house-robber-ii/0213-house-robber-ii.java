class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int n = nums.length;
       
        // The result is either robbing the first house and leaving the last
        // or doing the opposite. The maximum profit would determine that.
        return Math.max(robDp(0, n - 1, nums), robDp(1 , n, nums));
    }


    private int robDp(int start, int end, int[] nums) {

        int dp1 = 0, dp2 = 0;

        for(int i = start; i < end; i++) {
            int temp = dp2;
            dp2 = Math.max(dp2, dp1 + nums[i]);
            dp1 = temp;
        }

        return dp2;
    }
}