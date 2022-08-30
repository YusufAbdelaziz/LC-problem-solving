class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            var sortedStr = sortString(str);
            var list = map.getOrDefault(sortedStr, new ArrayList<String>());
            list.add(str);
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