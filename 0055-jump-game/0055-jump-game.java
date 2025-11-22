class Solution {
    public boolean canJump(int[] nums) {
        
        int maxReach = 0;

        for(int i = 0; i <= maxReach; i++) {
            int curMaxJump = i + nums[i];
            if(maxReach < curMaxJump) {
                maxReach = curMaxJump;
            }

            if(maxReach >= nums.length - 1) return true;
        }


        return false;
    }
}