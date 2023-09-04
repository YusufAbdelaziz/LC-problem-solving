class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> map = new HashMap<>();
        if(strs.length == 0 || strs == null) return Collections.emptyList();
        // Time -> O(m*nlogn) where m is the number of strings and n is the length of each string.
        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            var arr = map.get(sortedStr);
            if(arr == null) {
                map.put(sortedStr, new ArrayList<String>());
                var newArr = map.get(sortedStr);
                newArr.add(s);
            }  else {
                arr.add(s);
            }
        }
        
        
        return new ArrayList<>(map.values());
    }
}