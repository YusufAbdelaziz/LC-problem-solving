class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int[] targetMatrix = findTargetMatrix(matrix, target);
        
        return innerBinarySearch(targetMatrix, target);
    }
    
    private int[] findTargetMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            int[] currentMatrix = matrix[i];
            if(currentMatrix[currentMatrix.length - 1] >= target) {
                return currentMatrix;
            }
        }
        
        return new int[]{};
    }
    
    private boolean innerBinarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r) {
            int mid = l + ((r - l) >>> 1);
            
            if(nums[mid] == target) return true;
            else if(nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        
        return false;
    } 
}