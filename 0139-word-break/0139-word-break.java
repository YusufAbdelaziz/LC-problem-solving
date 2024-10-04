class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return recur(s, wordDict, 0, memo);
    }

    public boolean recur(String s, List<String> wordDict, int i, Boolean[] memo) {
        if(i == s.length()) return true;
        if(memo[i] != null) return memo[i];

        for(String word : wordDict) {
            int len = word.length();
            if(i + len <= s.length()) {
                String sub = s.substring(i, i + len);
                if(word.equals(sub)) {
                    if(recur(s, wordDict, i + len, memo)) {
                        return memo[i] = true;
                    }
                }
            }
        }
        return memo[i] = false;
    }
}