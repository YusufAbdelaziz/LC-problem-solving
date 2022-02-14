class NumArray {

    private int[] prefixSum;
    public NumArray(int[] nums) {
        if(nums.length == 0) throw new IllegalArgumentException("Array should have at 1 item");
        var arrLength = nums.length;
        prefixSum = new int[arrLength];
        for(int i = 0 ; i<arrLength ; i ++){
            prefixSum[i] = nums[i];
            if(i > 0) prefixSum[i] += prefixSum[i - 1];
        }
        
    }
    
    public int sumRange(int left, int right) {
        var sum = prefixSum[right];
        if(left > 0) sum -= prefixSum[left - 1];
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */