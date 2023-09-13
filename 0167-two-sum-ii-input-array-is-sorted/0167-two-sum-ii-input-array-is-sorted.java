class Solution {
    public int[] twoSum(int[] nums, int target) {
//         // Binary Search Approach.
//         // Time -> O(nlogn)
//         // Space -> O(1)
//         for(int i = 0; i < nums.length; i++){
//             int low = i + 1;
//             int high = nums.length - 1;
//             int mid;
//             int complement = target - nums[i];
            
//             while(low <= high){
//                 mid = low + (high - low) / 2;
//                 if(nums[mid] == complement && mid != i){
//                     return new int[]{i + 1, mid + 1};
//                 }
//                 else if(nums[mid] < complement){
//                     low = mid + 1;
//                 }
//                 else{
//                     high = mid - 1;
//                 }
//             }
//         }
        
        // Two pointers approach: Main idea is that when the sum increases when we move
        // towards the end of the array (since it's sorted) and decreases when we move
        // to the start of the array.
        
        // Time -> O(N)
        // Space -> O(1)
        int i = 0;
        int j = nums.length - 1;
        while(i != j) {
            int currentSum = nums[i] + nums[j];
            if(currentSum == target) {
                return new int[]{i + 1, j + 1};
            }
            else if(currentSum < target) i++;
            else if(currentSum > target) j--;
            
        }
        return null;
    }
}