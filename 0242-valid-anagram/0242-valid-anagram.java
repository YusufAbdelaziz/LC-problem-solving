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