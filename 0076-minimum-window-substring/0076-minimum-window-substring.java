class Solution {
    public String minWindow(String s, String t) {
        int right = 0, left = 0, minLen = Integer.MAX_VALUE;
        
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>();
        
        int match = 0;
        int start = 0;
        
        for(char c : t.toCharArray()) needs.put(c, needs.getOrDefault(c, 0) + 1);
        
        while(right < s.length()) {
            char rightChar = s.charAt(right);
            if(needs.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                if(window.get(rightChar).equals(needs.get(rightChar))) match++;
            }
            
            right++;
            
            while(match == needs.size()) {
                if(right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                
                char leftChar = s.charAt(left);
                
                if(needs.containsKey(leftChar)) {
                    window.put(leftChar, window.getOrDefault(leftChar, 1) - 1);
                    if(window.get(leftChar) < needs.get(leftChar)) match--;
                }
                
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);

    }
}