class Solution {
    public int hammingWeight(int n) {
        // Brain Kernighan for cleanring set bits.

        int count = 0;
        
        while(n != 0) {
            // ANDing with the preceeding number would result in
            // setting all bits to 0 on each iteration.
            n &= (n - 1);
            count++;
        }

        return count;
    }
}