class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<>();
        if(strs.length == 0 || strs == null) return Collections.emptyList();
        // // Time -> O(m*nlogn) where m is the number of strings and n is the length of each string.
        // for(String s : strs) {
        //     char[] chars = s.toCharArray();
        //     Arrays.sort(chars);
        //     String sortedStr = new String(chars);
        //     var arr = map.get(sortedStr);
        //     if(arr == null) {
        //         map.put(sortedStr, new ArrayList<String>());
        //         var newArr = map.get(sortedStr);
        //         newArr.add(s);
        //     }  else {
        //         arr.add(s);
        //     }
        // }
        
        // Since the strings are lowercase English letters and of length that is less than 100,
        // we can use an array of chars to store the key of each string instead of sorting
        // the string to find the key.
        for(String s : strs) {
            // For larger strings, you can use byte (- 128 to 127), short (-32k to 32k), etc.
            char[] chars = new char[26];
            for(int i = 0 ; i < s.length() ; i ++) {
                chars[s.charAt(i) - 'a']++;
            }
            
            String key = new String(chars);
            
            var arr = map.getOrDefault(key, new ArrayList<String>());
            arr.add(s);
            map.put(key, arr);
        }
        
        return new ArrayList<>(map.values());
    }
}