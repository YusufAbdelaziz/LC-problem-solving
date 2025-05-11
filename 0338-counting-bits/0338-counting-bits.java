class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            res[i] = numOfSetBits(i);
        }

        return res;
    }


    private int numOfSetBits(int n) {
        int count = 0;

        while(n != 0) {
            n &= (n - 1);
            count++;
        }

        return count;
    }
}