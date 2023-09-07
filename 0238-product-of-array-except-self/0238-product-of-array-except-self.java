class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arrLength = nums.length;
        int[] output = new int[arrLength];
        
        // Time -> O(N)
        // Complexity -> O(N)
        int[] prefixProduct = new int[arrLength];
        int[] postfixProduct = new int[arrLength];
        prefixProduct[0] = nums[0];
        for(int i = 1; i < arrLength ; i++){
            prefixProduct[i] = nums[i] * prefixProduct[i - 1];
        }
        
        postfixProduct[arrLength - 1] = nums[arrLength - 1];
        for(int i = arrLength - 2 ; i >= 0; i--){
            postfixProduct[i] = nums[i] * postfixProduct[i + 1];
        }
        
        output[0] = postfixProduct[1];
        for(int i = 1; i < arrLength - 1; i++){
            
            output[i] = prefixProduct[i - 1] * postfixProduct[i + 1];
        }
        output[arrLength - 1] = prefixProduct[arrLength - 2];
        
        return output;
    }
}