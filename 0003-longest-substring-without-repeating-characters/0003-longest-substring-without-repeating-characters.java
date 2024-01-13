class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int maxLen = Integer.MIN_VALUE;
        
        HashMap<Character, Integer> window = new HashMap<>();
        
        int left = 0, right = 0;
        
        while(right < s.length()) {
            char rightChar = s.charAt(right);
            window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
            right++;
            
            while(window.get(rightChar) > 1) {
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}