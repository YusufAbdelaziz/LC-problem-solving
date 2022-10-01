class Solution {
    public boolean isValid(String s) {
        var stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        
        for(char c : chars){
            switch(c){
                case '(':
                    stack.push(c);
                    break;
                case '{':
                    stack.push(c);
                    break;
                case '[' :
                    stack.push(c);
                    break;
                case '}':
                    if(!stack.empty() && stack.peek() == '{') stack.pop();
                    else stack.push(c);
                    break;
                case ')':
                    if(!stack.empty() && stack.peek() == '(') stack.pop();
                    else stack.push(c);
                    break;
                case ']':
                    if(!stack.empty() && stack.peek() == '[') stack.pop();
                    else stack.push(c);
                    break;
                    
            }
        }
        return stack.empty();
    }
}