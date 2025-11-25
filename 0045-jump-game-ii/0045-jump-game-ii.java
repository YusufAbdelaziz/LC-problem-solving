class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;

        int n = nums.length;

        int maxReach = 0;

        int jumps = 0;

        int end = 0;

        // [2, 3, 1, 1, 4]
        for(int i = 0; i < n - 1; i++) {
            int curJumpIndex = i + nums[i];
            if(maxReach < curJumpIndex) {
                maxReach = curJumpIndex;
            }

            if(i == end) {
                jumps++;
                end = maxReach;
            }
        }


        return jumps;
    }
}                     