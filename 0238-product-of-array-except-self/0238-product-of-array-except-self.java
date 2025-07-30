class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];

        int[] pre = new int[n];

        int[] post = new int[n];

        pre[0] = nums[0];
        post[n - 1] = nums[n - 1];
        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }

        for(int i = n - 2; i > 0; i--) {
            post[i] = post[i + 1] * nums[i];
        }

        res[0] = post[1];
        res[n - 1] = pre[n - 2];
        for(int i = 1; i < n - 1; i++) {
            res[i] = post[i + 1] * pre[i - 1]; 
        }

        return res;
    }
} 