class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> parens = new ArrayList<>();
        backTracking(0, 0, "", parens, n);
        return parens;
    }
    
    private void backTracking(int openCount, int closeCount, String str, List<String> result, int n) {
        if(openCount + closeCount == n * 2) {
            result.add(str);
            return;
        }
        
        if(openCount < n) {
            backTracking(openCount + 1, closeCount, str + "(", result, n);
        } 
        
        if(closeCount < openCount) {
            backTracking(openCount, closeCount + 1, str + ")", result, n);
        }
    }
}