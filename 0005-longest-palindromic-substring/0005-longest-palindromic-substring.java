// The main idea is to use a middle pointer and move the middle and expand on each
// new mid pointer. You have to do it twice because you have two mids for even length
// palindromic substrings.

class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            String str1 = palindrome(s, i, i);
            // For even palindromes
            String str2 = palindrome(s, i, i + 1);

            res = res.length() > str1.length() ? res : str1;
            res = res.length() > str2.length() ? res : str2;
        }

        return res;
    }

    private String palindrome(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return s.substring(l + 1, r );
    }
}