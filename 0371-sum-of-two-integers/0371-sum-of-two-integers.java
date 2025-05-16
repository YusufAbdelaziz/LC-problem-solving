class Solution {
    public int getSum(int a, int b) {
        while(b != 0) {
            int temp = a; // to ge the curry without using the new 'a' value.
            a ^= b;
            b = (temp & b) << 1; // carry is a result of ANDing two values.
        }

        return a;
    }
}