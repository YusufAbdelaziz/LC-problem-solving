class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i <= n; i++) sum += i;
        
        int arrSum = 0;
        
        for(int num : nums) arrSum += num;
        
        return sum - arrSum;
        
    }
}