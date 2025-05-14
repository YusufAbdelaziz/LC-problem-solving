public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // return Integer.reverse(n);

        int res = 0;
       for (int i = 0; i < 32; i++)  {
            res <<= 1; // Leave space for new LSB.
            res |= (n & 1); // Mask the LSB in the n and then insert it into the res via OR.
            n >>>= 1; // Now remove the LSB 
        }

        return res;
    }
}