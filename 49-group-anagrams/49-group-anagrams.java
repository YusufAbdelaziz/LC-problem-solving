class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            // eat
            // tea
            var sortedStr = sortString(str);
            // sortedStr -> aet
            // sortedStr -> aet
            var list = map.getOrDefault(sortedStr, new ArrayList<String>());
            // [eat]
            list.add(str);
            // (aet -> [eat, tea])
            map.put(sortedStr, list);
        }
        
        return new ArrayList<List<String>>(map.values());
        
    }
    
    
    private String sortString(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
        
}