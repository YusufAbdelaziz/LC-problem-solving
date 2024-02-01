class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int n = s1.length(), m = s2.length();
        if(n > m) return false;
        
        int[] count = new int[26];
        for(char c : s1.toCharArray()) count[c - 'a']++;
        
        int i = 0;
        int matches = 0; // number of s1 window counted
        for(int j = 0; j < m; j++) {
            
            // decrement each char we pass by, if it is a char we want, increment count
            if(count[s2.charAt(j) - 'a'] > 0) {
                matches++;
            }
            
            count[s2.charAt(j) - 'a']--;
        
            // we found a permutation
            if(matches == n) return true;
            
            // check when we get a window equal to size of s1
            if(j - i + 1 == n) {
                
                // for cases where window has chars we need but also includes other chars, we put the chars back                    into the map and decrement count so that we keep looking
                if(count[s2.charAt(i) - 'a'] >= 0) {
                    matches--;
                }
                count[s2.charAt(i) - 'a']++;

                i++; // makes sure that our window size will be equal to s1 after we reach that size
            }
               
        }
        return false;
    }
}