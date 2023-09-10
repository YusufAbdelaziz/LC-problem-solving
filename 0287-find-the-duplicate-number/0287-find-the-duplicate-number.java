class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        // // Time -> O(N).
        // // Space -> O(N).
        // Set<Integer> set = new HashSet<>();
        // int sol = 0;
        // for(int num : nums) {
        //     if(set.contains(num)) {
        //         sol = num;
        //         return sol;
        //     }
        //     set.add(num);
        // }
        // return sol;
        
        int[] temp = new int[nums.length];
        for(int num : nums) {
            temp[num - 1] += 1;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(temp[i] >= 2) return i + 1;
        }
        
        return 0;
    }
}