class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<>();
        if(strs.length == 0) return result;
        
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
        
        for(List<String> arr : map.values()){
            result.add(arr);
        }
        
        return result;
    }
}