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
        
//         // Time -> O(N).
//         // Space -> O(N).
//         // Uses an array which is a little bit faster but same space complexity as the first approach.
//         int[] temp = new int[nums.length];
//         for(int num : nums) {
//             temp[num - 1] += 1;
//         }
        
//         for(int i = 0; i < nums.length; i++) {
//             if(temp[i] >= 2) return i + 1;
//         }
        
       int tortoise = nums[0];
       int hare = nums[0];
       
       do {
           tortoise = nums[tortoise];
           hare = nums[nums[hare]];
       } while (tortoise != hare);
       
       tortoise = nums[0];
       
       while(tortoise != hare) {
           tortoise = nums[tortoise];
           hare = nums[hare];
       }
        
       return tortoise;
    }
}