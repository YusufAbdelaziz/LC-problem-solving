class Solution {
    public boolean isAnagram(String s, String t) {
        
        // HashMap approach -> Time --> O(N), space --> O(s.length() + t.length())
        
        // A map for each character occurrences.
//         HashMap<Character, Integer> map = new HashMap<>();
        
//         for(char c : s.toCharArray()){
//             int count = map.getOrDefault(c, 0);
//             map.put(c, count + 1);
//         }
        
//          for(char c : t.toCharArray()){
//             int count = map.getOrDefault(c, 0);
//             if(count == 0) return false;
//             map.put(c, count - 1);

//         }
        
//         // Check if each character has removed.
        
//         for(int occurrence : map.values()){
//             if(occurrence != 0) return false;
//         }
        
//         return true;
    
//     }
        // Taking another look at the constraints, the strings consist of lowercase English letters.
        // So we can have an array of 26 slots (number of English letters) and store the occurrences
        // of each character in the first string by subtracting it from 'a' (ascii value 97).
        // So that the letter 'a' slot is 0 and 'b' is 1 and so forth.
        
        // Time -> O(N) where N = s.length() + t.length().
        // Space -> O(1)
        int[] charOccurrences = new int[26];
        
        for(char c : s.toCharArray()) {
            charOccurrences[c - 'a'] += 1;
        }
        
        for(char c : t.toCharArray()) {
            charOccurrences[c - 'a'] -= 1;
        }
        
        for(int occurrences : charOccurrences) {
            if(occurrences != 0) return false;
        }
        
        return true;
    }
}