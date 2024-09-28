class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] memo = new int[n];
        return n == 0 ? 0 : recursivelyDecode(0, s, memo);
    }

    private int recursivelyDecode(int p, String s, int[] memo) {
        int n = s.length();
        if(p == n) return 1;
        char c = s.charAt(p);
        if(c == '0') return 0;
        int res = recursivelyDecode(p + 1, s, memo);
        if(p < n - 1 && (c == '1' || c == '2') && s.charAt(p + 1) < '7') {
            res += recursivelyDecode(p + 2, s, memo);
        }
        return memo[p] = res;
    }
}