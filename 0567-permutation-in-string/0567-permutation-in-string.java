class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int n = s1.length(), m = s2.length();
        if(n > m) return false;
        
        // Note that this counts the number of character occurrences.
        int[] availablePool = new int[26];
        for(char c : s1.toCharArray()) availablePool[c - 'a']++;
        
        int i = 0;
        int matches = 0; // number of s1 window counted
        for(int j = 0; j < m; j++) {
            
            // When we encounter a character that exist in s1, we increment the # of matches
            // as well as decrement the number of occurrence to reflect that we 
            // have used one occurrence of this character from the 
            // available ones needed to form a permutation of s1.
            if(availablePool[s2.charAt(j) - 'a'] > 0) {
                matches++;
            }
            
            availablePool[s2.charAt(j) - 'a']--;
        
            // we found a permutation
            if(matches == n) return true;
            
            // check when we get a window equal to size of s1
            if(j - i + 1 == n) {
                
                // increment the count of the character at s2.charAt(i) in the availablePool array because we are 
                // effectively "giving back" the occurrence of this character to the available pool, as it is no 
                // longer part of the current window.
                if(availablePool[s2.charAt(i) - 'a'] >= 0) {
                    matches--;
                }
                availablePool[s2.charAt(i) - 'a']++;

                i++; // makes sure that our window size will be equal to s1 after we reach that size
            }
               
        }
        return false;
    }
}