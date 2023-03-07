class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> outputArr = new ArrayList();
        backtracking(outputArr, "", n, 0 , 0);
        return outputArr;
    }
    
    private void backtracking(List<String> outputArr, String currentStr, int max, int openCount, int closeCount) {
        if(currentStr.length() == 2 * max) {
            outputArr.add(currentStr);
            return; 
        }
        
        if(openCount < max) {
            backtracking(outputArr, currentStr + "(", max, openCount + 1, closeCount);
        }
        
        if(closeCount < openCount) {
            backtracking(outputArr, currentStr + ")", max, openCount, closeCount + 1);
        }
    }
}