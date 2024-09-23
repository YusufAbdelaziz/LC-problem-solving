class Solution {
    private int count = 0;

    public int countSubstrings(String s) {
        backtrack(s, 0);
        return count;
    }

    private void backtrack(String s, int start) {
        for (int i = start + 1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (isPalindromic(sub)) {
                count++;
            }
        }
        if (start < s.length() - 1) {
            backtrack(s, start + 1);
        }
    }

    private boolean isPalindromic(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
