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
        String combination = "";
        StringBuilder sb = new StringBuilder();
        backtrack(result, sb, 0, digits);
        return result;
        
    }
    
    private void backtrack(List<String> result, StringBuilder sb, int start, String digits) {
        if(sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        } else if(start >= digits.length()) {
            return;
        }
        
        String chars = map.get(digits.charAt(start));
        for(char c : chars.toCharArray()) {
            sb.append(c);
            backtrack(result, sb, start + 1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}