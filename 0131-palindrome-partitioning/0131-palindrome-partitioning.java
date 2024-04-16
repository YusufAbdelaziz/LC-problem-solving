class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new LinkedList<>();
        LinkedList<String> track = new LinkedList<>();

        backtrack(s, 0, result, track);
        
        return result;
    }
    
    private void backtrack(String s, int index, List<List<String>> result, LinkedList<String> track) {
        if(index == s.length()) {
            result.add(new LinkedList<>(track));
            return;
        }
        
        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                track.add(s.substring(index, i + 1));
                backtrack(s, i + 1, result, track);
                track.removeLast();
            }
        }
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        
        return true;
    }
}