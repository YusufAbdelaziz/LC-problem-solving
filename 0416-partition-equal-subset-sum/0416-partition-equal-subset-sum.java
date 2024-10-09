class Solution {
    public boolean canPartition(int[] nums) {
        // If the sum is odd, then the array cannot be partitioned into two halves.
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 != 0) return false;
        
        int n = nums.length;
        HashSet<Integer> dp = new HashSet<>();

        dp.add(0);
        int singleSubsetSum = sum / 2;
        for(int i = n - 1; i >= 0; i--) {
            HashSet<Integer> newSums = new HashSet<>(dp);
            for(int num : dp) {
                int curSum = num + nums[i];
                if(curSum == singleSubsetSum) return true;
                newSums.add(curSum);
            }
            dp = newSums;
        }

        return dp.contains(singleSubsetSum);
    }
}