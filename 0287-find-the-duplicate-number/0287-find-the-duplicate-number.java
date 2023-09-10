class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int sol = 0;
        for(int num : nums) {
            if(set.contains(num)) {
                sol = num;
                return sol;
            }
            set.add(num);
        }
        return sol;
        
    }
}