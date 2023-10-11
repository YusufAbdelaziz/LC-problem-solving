class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;

        if(len == 0) return new int[]{-1, -1};
        
        int[] result = new int[2];
        
        result[0] = findFirstIndex(nums, target);
        result[1] = findSecondIndex(nums, target);
        
        return result;
    }
    
    /// Finds the first occurrence of the target.
    private int findFirstIndex(int[] nums, int target) {
        int index = -1;
        int l = 0;
        int r = nums.length - 1;
        
        while(r >= l) {
            int middle = l + (((r - l) / 2) >>> 1);
            
            // Even if you find the target, keep going to the left so
            // you can find the first occurrence.
            if(nums[middle] >= target) {
                r = middle - 1;
            } else {
                l = middle + 1;
            }
            
            // While going to the left, store the index of the last
            // target you checked.
            if (nums[middle] == target) {
              index = middle;
            }
        }
        
        return index;
    }
    
     /// Finds the second occurrence of the target.
     private int findSecondIndex(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int index = -1;
         
        while(l <= r) {
            int middle = l + (((r - l) / 2) >>> 1);
            if(nums[middle] > target) {
                r = middle - 1;
            // Even if you find the target, keep going to the right so
            // you can find the last occurrence.
            } else if(nums[middle] <= target){
                l = middle + 1;
            }
            
            // While going to the right, store the index of the last
            // target you checked.
            if(nums[middle] == target) index = middle;

        }
        
        return index;
    }
}