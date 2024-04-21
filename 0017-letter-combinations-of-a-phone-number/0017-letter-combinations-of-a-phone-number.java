class Solution {
    private static HashMap<Character, String> map;
    
    static {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new LinkedList<>();
        List<String> result = new LinkedList<>();
        LinkedList<Character> track = new LinkedList<>();
        backtrack(result, track, 0, digits);
        return result;
        
    }
    
    private void backtrack(List<String> result, LinkedList<Character> track, int start, String digits) {
        if(track.size() == digits.length()) {
            String cur = "";
            for(char c : track) {
                cur += c;
            }
            result.add(cur);
            return;
        } else if(start >= digits.length()) {
            return;
        }
        
        for(int i = start; i < digits.length(); i++) {
            String chars = map.get(digits.charAt(i));
            for(int j = 0; j < chars.length(); j++){
                track.add(chars.charAt(j));
                backtrack(result, track, i + 1, digits);
                track.removeLast();
            }
        }
    }
}