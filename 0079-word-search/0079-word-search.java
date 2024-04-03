class Solution {
    public boolean exist(char[][] board, String word) {
        boolean wordExists = false;
        char[] charArr = word.toCharArray();
        int rowsNum = board.length;
        int colsNum = board[0].length;
        
        for(int i = 0; i < rowsNum; i++) {
            for(int j = 0; j < colsNum; j++) {
                if(backtrack(board, rowsNum, colsNum, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean backtrack(char[][] board, int rowsNum, int colsNum, int i, int j, String word, int curCharIndex) {
        
        // Note that each time we recursively call backtrack on next char to be found, we increment 
        // the current char index and if it reaches or exceeds the word length then this means
        // we found the whole word in the grid.
        if(curCharIndex >= word.length()) return true;
        if(i >= rowsNum || j >= colsNum || i < 0 || j < 0 || board[i][j] != word.charAt(curCharIndex)) {
            return false;
        }
        
        boolean exists = false;
        
        if(board[i][j] == word.charAt(curCharIndex)) {
            board[i][j] += 100;
            exists = backtrack(board, rowsNum, colsNum, i + 1, j, word, curCharIndex + 1) ||
                     backtrack(board, rowsNum, colsNum, i - 1, j, word, curCharIndex + 1) ||
                     backtrack(board, rowsNum, colsNum, i, j + 1, word, curCharIndex + 1) ||
                     backtrack(board, rowsNum, colsNum, i, j - 1, word, curCharIndex + 1);
            board[i][j] -= 100;
        }
        
        return exists;
    }
}