class Solution {
   enum Operation{
       ADD,
       SUB,
       DIV,
       MUL
    }
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(String token : tokens) {
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int secOp = stack.pop();
                int firstOp = stack.pop();
                stack.push(makeOperation(token, firstOp, secOp));
                continue;
            }
            
            stack.push(Integer.parseInt(token));
        }
        
        return stack.pop();
    }
    
    private int makeOperation(String token, int firstOp, int secondOp) {
        Operation op = null;
        switch(token) {
            case "/": 
                op = Operation.DIV;
                break;
            case "+": 
                op = Operation.ADD;
                break;
            case "-": 
                op = Operation.SUB;
                break;
            case "*": 
                op = Operation.MUL;
                break;
        }
        
        switch(op) {
            case ADD: return firstOp + secondOp;
            case SUB: return firstOp - secondOp; 
            case DIV: return firstOp / secondOp; 
            default: return firstOp * secondOp; 
        }
    }
}