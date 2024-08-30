class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        int[] sortedSquares = new int[n];
        nums = Arrays.stream(nums).map(num -> num * num).toArray();
        for (int i = n - 1; i >= 0; i--) {
             if (nums[l] > nums[r]) {
                 sortedSquares[i] = nums[l];
                 l++;

             } else {
                sortedSquares[i] = nums[r];
                r--;
             }
          

        }

        return sortedSquares;
    }
}