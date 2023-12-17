class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         if(matrix == null || matrix.length == 0) return false;
//         int[] targetMatrix = findTargetMatrix(matrix, target);
        
//         return innerBinarySearch(targetMatrix, target);
//     }
    
//     private int[] findTargetMatrix(int[][] matrix, int target) {
//         for(int i = 0; i < matrix.length; i++) {
//             int[] currentMatrix = matrix[i];
//             if(currentMatrix[currentMatrix.length - 1] >= target) {
//                 return currentMatrix;
//             }
//         }
        
//         return new int[]{};
//     }
    
//     private boolean innerBinarySearch(int[] nums, int target) {
//         int l = 0;
//         int r = nums.length - 1;
        
//         while(l <= r) {
//             int mid = l + ((r - l) >>> 1);
            
//             if(nums[mid] == target) return true;
//             else if(nums[mid] > target) r = mid - 1;
//             else l = mid + 1;
//         }
        
//         return false;
//     } 
    
    // 2nd approach -> Convert 2d matrix into 1d matrix.
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int l = 0;
        int r = n * m - 1;
        
        while(l <= r) {
            int midIndex = l + ((r - l) >>> 1);
            
            int midElement = matrix[midIndex / m][midIndex % m];
            
            if(midElement == target) return true;
            else if(midElement > target) r = midIndex - 1;
            else l = midIndex + 1;
        }
        
        return false;
    }
}