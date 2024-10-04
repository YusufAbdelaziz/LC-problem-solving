class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        // Our base DP case is that if the last character of the string
        // is reach, this means that we've find strings that exist in the dict.
        dp[n] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (String word : wordDict) {
                int wordLen = word.length();
                if ((i + wordLen <= s.length()) && (word.equals(s.substring(i, i + wordLen)))) {
                    dp[i] = dp[i + wordLen];        
                }
                if(dp[i]) break;
            }
        }

        return dp[0];
    }
}