class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            int low = i+1;
            int high = nums.length -1;
            int mid;
            int complement = target - nums[i];
            
            while(low <= high){
                mid = low + (high - low) / 2;
                if(nums[mid] == complement && mid != i){
                    return new int[]{i+1, mid+1};
                }
                else if(nums[mid] < complement){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return null;
    }
}