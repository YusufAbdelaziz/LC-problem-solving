class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagramIndicies = new ArrayList<>();
        
        int left = 0, right = 0, match = 0;
        
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>();
        
        for(char c : p.toCharArray()) needs.put(c, needs.getOrDefault(c, 0) + 1);
        
        while(right < s.length()) {
            char rightChar = s.charAt(right);
            if(needs.containsKey(rightChar)) {
                window.put(rightChar, window.getOrDefault(rightChar, 0 ) + 1);
                if(window.get(rightChar).equals(needs.get(rightChar))) match++;
            }
            
            right++;
            
            while(match == needs.size()) {
                char leftChar = s.charAt(left);
                
                if(right - left == p.length()) anagramIndicies.add(left);

                if(needs.containsKey(leftChar)) {
                    window.put(leftChar, window.getOrDefault(leftChar, 1) - 1);
                    if(window.get(leftChar) < needs.get(leftChar)) match--;
                }
                
                left++;
            }
        }
        
        return anagramIndicies;
    }
}