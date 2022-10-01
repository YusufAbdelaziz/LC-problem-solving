class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        var sStack = new Stack<Character>();
        var tStack = new Stack<Character>();
        
        for(char c : sChars){
            if(c == '#' && !sStack.empty()){
                if(sStack.peek() != '#'){
                    sStack.pop();
                }
            } else if(c != '#') {
                sStack.push(c);
            }
        }
        
         for(char c : tChars){
            if(c == '#' && !tStack.empty()){
                 if(tStack.peek() != '#'){
                    tStack.pop();
                }
            } else if(c != '#'){
                tStack.push(c);
            }
        }

        return Arrays.equals(sStack.toArray(), tStack.toArray());
    }
}